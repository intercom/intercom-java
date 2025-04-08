package com.intercom.api.utils;

import com.intercom.api.Intercom;

public class TestClientFactory {
    public static Intercom create() {
        String token = System.getenv("INTERCOM_API_KEY");

        if (token == null || token.isEmpty()) {
            throw new IllegalArgumentException("Please provide an API key to run tests");
        }

        return Intercom.builder().build();
    }
}
