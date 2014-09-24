package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableMap;

import java.net.URI;
import java.util.Map;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RequestResponseCapture {

    @JsonProperty("request_method")
    private String requestMethod;

    @JsonProperty("request_uri")
    private URI requestURI;

    @JsonProperty("request_headers")
    private Map<String, String> requestHeaders;

    @JsonProperty("response_status_code")
    private int responseStatusCode;

    @JsonProperty("response_headers")
    private Map<String, String> responseHeaders;

    @JsonProperty("response_entity")
    private String responseEntity;

    @JsonProperty("request_entity")
    private String requestEntity;

    public RequestResponseCapture() {
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public URI getRequestURI() {
        return requestURI;
    }

    public Map<String, String> getRequestHeaders() {
        return ImmutableMap.<String, String>builder().putAll(requestHeaders).build();
    }

    public int getResponseStatusCode() {
        return responseStatusCode;
    }

    public Map<String, String> getResponseHeaders() {
        return ImmutableMap.<String, String>builder().putAll(responseHeaders).build();
    }

    public String getResponseEntity() {
        return responseEntity;
    }

    public String getRequestEntity() {
        return requestEntity;
    }

}