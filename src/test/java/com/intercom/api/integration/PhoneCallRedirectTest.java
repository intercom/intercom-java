package com.intercom.api.integration;

import com.intercom.api.Intercom;
import com.intercom.api.types.CreatePhoneSwitchRequest;
import com.intercom.api.utils.TestClientFactory;
import java.util.Optional;
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
        // act - CreatePhoneSwitchRequest doesn't support customAttributes as Map<String, Object>
        client.phoneCallRedirects()
                .create(Optional.of(CreatePhoneSwitchRequest.builder()
                        .phone("+353832345678")
                        .build()));
    }
}
