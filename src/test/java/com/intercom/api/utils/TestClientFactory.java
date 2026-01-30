package com.intercom.api.utils;

import com.intercom.api.Intercom;
import com.intercom.api.core.ApiVersion;
import com.intercom.api.core.ClientOptions;
import com.intercom.api.core.Environment;

public class TestClientFactory {
    public static Intercom create() {
        String token = System.getenv("INTERCOM_API_KEY");

        if (token == null || token.isEmpty()) {
            throw new IllegalArgumentException("Please provide an API key to run tests");
        }

        return Intercom.builder().build();
    }

    public static Intercom create(ApiVersion apiVersion) {
        String token = System.getenv("INTERCOM_API_KEY");

        if (token == null || token.isEmpty()) {
            throw new IllegalArgumentException("Please provide an API key to run tests");
        }

        return new Intercom(ClientOptions.builder()
                .version(apiVersion)
                .environment(Environment.US_PRODUCTION)
                .addHeader("Authorization", "Bearer " + token)
                .build());
    }
}
