package io.intercom.api;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.io.CharStreams;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

class HttpClient {

    private static final Logger logger = LoggerFactory.getLogger("intercom-java");

    private static final String CLIENT_AGENT_DETAILS = clientAgentDetails();

    private static final String USER_AGENT = Intercom.USER_AGENT;

    private static final String UTF_8 = "UTF-8";

    private static final String APPLICATION_JSON = "application/json";

    public static final String RATE_LIMIT_HEADER = "X-RateLimit-Limit";
    public static final String RATE_LIMIT_REMAINING_HEADER = "X-RateLimit-Remaining";
    public static final String RATE_LIMIT_RESET_HEADER = "X-RateLimit-Reset";

    private static String clientAgentDetails() {
        final HashMap<String, String> map = Maps.newHashMap();
        final ArrayList<String> propKeys = Lists.newArrayList(
            "os.arch", "os.name", "os.version",
            "user.language", "user.timezone",
            "java.class.version", "java.runtime.version", "java.version",
            "java.vm.name", "java.vm.vendor", "java.vm.version");
        for (String propKey : propKeys) {
            map.put(propKey, System.getProperty(propKey));
        }
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            MapperSupport.objectMapper().disable(SerializationFeature.INDENT_OUTPUT).writeValue(baos, map);
        } catch (IOException e) {
            logger.warn(String.format("could not serialize client agent details [%s]", e.getMessage()), e);
        }
        return baos.toString();
    }

    private final ObjectMapper objectMapper;

    private final URI uri;

    private final Map<String, String> headers;

    private final HttpConnectorSupplier connection = Intercom.getHttpConnectorSupplier();

    public HttpClient(URI uri) {
        this(uri, Maps.<String, String>newHashMap());
    }

    private HttpClient(URI uri, Map<String, String> headers) {
        this.uri = uri;
        this.headers = headers;
        this.objectMapper = MapperSupport.objectMapper();
    }

    public <T> T get(Class<T> reqres) throws IntercomException {
        return get(getJavaType(reqres));
    }

    <T> T get(JavaType responseType) throws IntercomException {
        return executeHttpMethod("GET", null, responseType);
    }

    public <T> T delete(Class<T> reqres) {
        return executeHttpMethod("DELETE", null, getJavaType(reqres));
    }

    public <T, E> T delete(Class<T> reqres, E entity) {
        headers.put("Content-Type", APPLICATION_JSON);
        return executeHttpMethod("DELETE", entity, getJavaType(reqres));
    }

    public <T, E> T put(Class<T> reqres, E entity) {
        headers.put("Content-Type", APPLICATION_JSON);
        return executeHttpMethod("PUT", (E) entity, getJavaType(reqres));
    }

    public <T, E> T post(Class<T> reqres, E entity) {
        headers.put("Content-Type", APPLICATION_JSON);
        return executeHttpMethod("POST", entity, getJavaType(reqres));
    }

    private <T, E> T executeHttpMethod(String method, E entity, JavaType responseType) {
        HttpURLConnection conn = null;
        try {
            conn = initializeConnection(uri, method);
            if(entity != null) {
                prepareRequestEntity(entity, conn);
            }
            return runRequest(uri, responseType, conn);
        } catch (IOException e) {
            return throwLocalException(e);
        } finally {
            IOUtils.disconnectQuietly(conn);
        }
    }

    private <T> JavaType getJavaType(Class<T> reqres) {
        return objectMapper.getTypeFactory().constructType(reqres);
    }

    // trick java with a dummy return
    private <T> T throwLocalException(IOException e) {
        throw new IntercomException(String.format("Local exception calling [%s]. Check connectivity and settings. [%s]", uri.toASCIIString(), e.getMessage()), e);
    }

    private void prepareRequestEntity(Object entity, HttpURLConnection conn) throws IOException {
        conn.setDoOutput(true);
        OutputStream stream = null;
        try {
            stream = conn.getOutputStream();
            if (logger.isDebugEnabled()) {
                logger.info(String.format("api server request --\n%s\n-- ", objectMapper.writeValueAsString(entity)));
            }
            objectMapper.writeValue(stream, entity);
        } finally {
            IOUtils.closeQuietly(stream);
        }
    }

    private HttpURLConnection initializeConnection(URI uri, String method) throws IOException {
        HttpURLConnection conn = connection.connect(uri);
        conn.setRequestMethod(method);
        conn = prepareConnection(conn);
        conn = applyHeaders(conn);
        return conn;
    }

    private <T> T runRequest(URI uri, JavaType javaType, HttpURLConnection conn) throws IOException {
        conn.connect();
        final int responseCode = conn.getResponseCode();
        if (responseCode >= 200 && responseCode < 300) {
            return handleSuccess(javaType, conn, responseCode);
        } else {
            return handleError(uri, conn, responseCode);
        }
    }

    private <T> T handleError(URI uri, HttpURLConnection conn, int responseCode) throws IOException {
        ErrorCollection errors;
        try {
            errors = objectMapper.readValue(conn.getErrorStream(), ErrorCollection.class);
        } catch (IOException e) {
            errors = createUnprocessableErrorResponse(e);
        }
        if (logger.isDebugEnabled()) {
            logger.debug("error json follows --\n{}\n-- ", objectMapper.writeValueAsString(errors));
        }
        return throwException(responseCode, errors, conn);
    }

    private <T> T handleSuccess(JavaType javaType, HttpURLConnection conn, int responseCode) throws IOException {
        if (shouldSkipResponseEntity(javaType, conn, responseCode)) {
            return null;
        } else {
            return readEntity(conn, responseCode, javaType);
        }
    }

    private boolean shouldSkipResponseEntity(JavaType javaType, HttpURLConnection conn, int responseCode) {
        return responseCode == 204 || Void.class.equals(javaType.getRawClass());
    }

    private <T> T readEntity(HttpURLConnection conn, int responseCode, JavaType javaType) throws IOException {
        final InputStream entityStream = conn.getInputStream();
        try {
            final String text = CharStreams.toString(new InputStreamReader(entityStream));
            if (logger.isDebugEnabled()) {
                logger.debug("api server response status[{}] --\n{}\n-- ", responseCode, text);
            }
            if (text.isEmpty()) return null;
            return objectMapper.readValue(text, javaType);
        } finally {
            IOUtils.closeQuietly(entityStream);
        }
    }

    private <T> T throwException(int responseCode, ErrorCollection errors, HttpURLConnection conn) {
        // bind some well known response codes to exceptions
        if (responseCode == 403 || responseCode == 401) {
            throw new AuthorizationException(errors);
        } else if (responseCode == 429) {
            throw new RateLimitException(errors, Ints.tryParse(conn.getHeaderField(RATE_LIMIT_HEADER)),
                    Ints.tryParse(conn.getHeaderField(RATE_LIMIT_REMAINING_HEADER)),
                    Longs.tryParse(conn.getHeaderField(RATE_LIMIT_RESET_HEADER)));
        } else if (responseCode == 404) {
            throw new NotFoundException(errors);
        } else if (responseCode == 422) {
            throw new InvalidException(errors);
        } else if (responseCode == 400 || responseCode == 405 || responseCode == 406) {
            throw new ClientException(errors);
        } else if (responseCode == 500 || responseCode == 503) {
            throw new ServerException(errors);
        } else {
            throw new IntercomException(errors);
        }
    }

    private HttpURLConnection applyHeaders(HttpURLConnection conn) {
        for (Map.Entry<String, String> entry : createHeaders().entrySet()) {
            conn.setRequestProperty(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, String> entry : createAuthorizationHeaders().entrySet()) {
            conn.setRequestProperty(entry.getKey(), entry.getValue());
        }
        return conn;
    }

    // todo: expose this config
    private HttpURLConnection prepareConnection(HttpURLConnection conn) {
        conn.setConnectTimeout(Intercom.getConnectionTimeout());
        conn.setReadTimeout(Intercom.getRequestTimeout());
        conn.setUseCaches(Intercom.isRequestUsingCaches());
        return conn;
    }

    private Map<String, String> createAuthorizationHeaders() {
        headers.put("Authorization", "Basic " + generateAuthString(Intercom.getToken(),""));
        return headers;
    }

    private String generateAuthString(String username, String password) {
        return Base64.encodeBase64String((username + ":" + password).getBytes());
    }

    private Map<String, String> createHeaders() {
        headers.put("User-Agent", USER_AGENT);
        headers.put("X-Client-Platform-Details", CLIENT_AGENT_DETAILS);
        headers.put("Accept-Charset", UTF_8);
        headers.put("Accept", APPLICATION_JSON);
        return headers;
    }

    private ErrorCollection createUnprocessableErrorResponse(IOException e) {
        ErrorCollection errors;
        final long grepCode = getGrepCode();
        final String msg = String.format("could not parse error response: [%s]", e.getLocalizedMessage());
        logger.error(String.format("[%016x] %s", grepCode, msg), e);
        Error err = new Error("unprocessable_entity", String.format("%s logged with code [%016x]", msg, grepCode));
        errors = new ErrorCollection(Lists.newArrayList(err));
        return errors;
    }

    private long getGrepCode() {
        return ThreadLocalRandom.current().nextLong();
    }

}
