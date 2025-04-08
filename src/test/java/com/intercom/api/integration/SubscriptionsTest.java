package com.intercom.api.integration;

import com.intercom.api.Intercom;
import com.intercom.api.types.SubscriptionTypeList;
import com.intercom.api.utils.TestClientFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SubscriptionsTest {

    private Intercom client;

    @BeforeEach
    public void before() {
        client = TestClientFactory.create();
    }

    @Test
    public void testListTypes() {
        // act
        SubscriptionTypeList response = client.subscriptionTypes().list();

        // assert
        Assertions.assertNotNull(response);
    }
}
