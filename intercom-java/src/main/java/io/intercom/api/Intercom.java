package io.intercom.api;

import java.net.URI;

public class Intercom {

    private static final URI API_BASE_URI = URI.create("https://api.intercom.io/");

    private static volatile URI apiBaseURI = API_BASE_URI;

    private static volatile AuthKeyType authKeyType = AuthKeyType.API_KEY;

    enum AuthKeyType {
        API_KEY,
        TOKEN
    }

    private static final String VERSION = "2.2.3";

    public static final String USER_AGENT = "intercom-java/" + Intercom.VERSION;

    private static volatile String apiKey;

    private static volatile String token;

    private static volatile String appID;

    private static volatile int connectionTimeout = 3 * 1000;

    private static volatile int requestTimeout = 60 * 1000;

    private static volatile boolean requestUsingCaches = false;

    private static volatile HttpConnectorSupplier httpConnectorSupplier = HttpConnectorSupplier.defaultSupplier;

    public static long currentTimestamp() {
        return System.currentTimeMillis()/1000;
    }

    public static int getConnectionTimeout() {
        return connectionTimeout;
    }

    @SuppressWarnings("UnusedDeclaration")
    public static void setConnectionTimeout(int connectionTimeout) {
        Intercom.connectionTimeout = connectionTimeout;
    }

    public static int getRequestTimeout() {
        return requestTimeout;
    }

    @SuppressWarnings("UnusedDeclaration")
    public static void setRequestTimeout(int requestTimeout) {
        Intercom.requestTimeout = requestTimeout;
    }

    public static boolean isRequestUsingCaches() {
        return requestUsingCaches;
    }

    public static void setRequestUsingCaches(boolean requestUsingCaches) {
        Intercom.requestUsingCaches = requestUsingCaches;
    }

    public static HttpConnectorSupplier getHttpConnectorSupplier() {
        return httpConnectorSupplier;
    }

    public static void setHttpConnectorSupplier(HttpConnectorSupplier supplier) {
        Intercom.httpConnectorSupplier = supplier;
    }

    public static String getAppID() {
        return appID;
    }

    public static void setAppID(String appID) {
        Intercom.appID = appID;
    }

    public static void setToken(String token) {
        authKeyType = AuthKeyType.TOKEN;
        Intercom.token = token;
    }

    public static String getApiKey() {
        return Intercom.apiKey;
    }

    public static void setApiKey(String apiKey) {
        authKeyType = AuthKeyType.API_KEY;
        Intercom.apiKey = apiKey;
    }

    public static URI getApiBaseURI() {
        return Intercom.apiBaseURI;
    }

    public static void setApiBaseURI(URI apiBaseURI) {
        Intercom.apiBaseURI = apiBaseURI;
    }

    static AuthKeyType getAuthKeyType() {
        return authKeyType;
    }

    public static String getToken() {
        return token;
    }


}
