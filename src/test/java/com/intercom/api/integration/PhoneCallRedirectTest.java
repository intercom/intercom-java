package com.intercom.api.integration;

import com.intercom.api.Intercom;
import com.intercom.api.resources.phonecallredirects.requests.CreatePhoneCallRedirectRequest;
import com.intercom.api.utils.TestClientFactory;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled("Configure Twilio Settings")
public class PhoneCallRedirectTest {

    private Intercom client;

    @BeforeEach
    public void before() {
        client = TestClientFactory.create();
    }

    @Test
    public void testCreate() {
        // arrange
        Map<String, Object> customAttributes = new HashMap<>();
        customAttributes.put("issue_type", "Billing");
        customAttributes.put("priority", "High");

        // assert
        client.phoneCallRedirects()
                .create(CreatePhoneCallRedirectRequest.builder()
                        .phone("+353832345678")
                        .customAttributes(customAttributes)
                        .build());
    }
}
