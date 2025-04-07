/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.intercom.api.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.Response;

/**
 * This exception type will be thrown for any non-2XX API responses.
 */
public class IntercomApiException extends IntercomException {
    /**
     * The error code of the response that triggered the exception.
     */
    private final int statusCode;

    /**
     * The body of the response that triggered the exception.
     */
    private final Object body;

    private final Map<String, List<String>> headers;

    public IntercomApiException(String message, int statusCode, Object body) {
        super(message);
        this.statusCode = statusCode;
        this.body = body;
        this.headers = new HashMap<>();
    }

    public IntercomApiException(String message, int statusCode, Object body, Response rawResponse) {
        super(message);
        this.statusCode = statusCode;
        this.body = body;
        this.headers = new HashMap<>();
        rawResponse.headers().forEach(header -> {
            String key = header.component1();
            String value = header.component2();
            this.headers.computeIfAbsent(key, _str -> new ArrayList<>()).add(value);
        });
    }

    /**
     * @return the statusCode
     */
    public int statusCode() {
        return this.statusCode;
    }

    /**
     * @return the body
     */
    public Object body() {
        return this.body;
    }

    /**
     * @return the headers
     */
    public Map<String, List<String>> headers() {
        return this.headers;
    }

    @java.lang.Override
    public String toString() {
        return "IntercomApiException{" + "message: " + getMessage() + ", statusCode: " + statusCode + ", body: " + body
                + "}";
    }
}
