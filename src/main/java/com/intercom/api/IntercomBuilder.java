/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.intercom.api;

import com.intercom.api.core.ClientOptions;
import com.intercom.api.core.Environment;
import okhttp3.OkHttpClient;

public final class IntercomBuilder {
    private ClientOptions.Builder clientOptionsBuilder = ClientOptions.builder();

    private String token = System.getenv("INTERCOM_API_KEY");

    private Environment environment = Environment.US_PRODUCTION;

    /**
     * Sets token.
     * Defaults to the INTERCOM_API_KEY environment variable.
     */
    public IntercomBuilder token(String token) {
        this.token = token;
        return this;
    }

    public IntercomBuilder environment(Environment environment) {
        this.environment = environment;
        return this;
    }

    public IntercomBuilder url(String url) {
        this.environment = Environment.custom(url);
        return this;
    }

    /**
     * Sets the timeout (in seconds) for the client
     */
    public IntercomBuilder timeout(int timeout) {
        this.clientOptionsBuilder.timeout(timeout);
        return this;
    }

    /**
     * Sets the underlying OkHttp client
     */
    public IntercomBuilder httpClient(OkHttpClient httpClient) {
        this.clientOptionsBuilder.httpClient(httpClient);
        return this;
    }

    public Intercom build() {
        if (token == null) {
            throw new RuntimeException("Please provide token or set the INTERCOM_API_KEY environment variable.");
        }
        this.clientOptionsBuilder.addHeader("Authorization", "Bearer " + this.token);
        clientOptionsBuilder.environment(this.environment);
        return new Intercom(clientOptionsBuilder.build());
    }
}
