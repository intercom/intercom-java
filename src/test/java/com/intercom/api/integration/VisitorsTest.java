package com.intercom.api.integration;

import com.intercom.api.Intercom;
import com.intercom.api.resources.contacts.types.Contact;
import com.intercom.api.resources.visitors.requests.FindVisitorRequest;
import com.intercom.api.resources.visitors.requests.MergeVisitorToContactRequest;
import com.intercom.api.types.UpdateVisitorRequest;
import com.intercom.api.types.Visitor;
import com.intercom.api.utils.TestClientFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled("Skip by default, because there is no automation yet")
public class VisitorsTest {
    // Info: should be set manually. Find a way to automate it.
    // Tip: headless browser to visit test application and get visitorId from ping request.
    private static final String VISITOR_ID = "0";
    private static final String USER_ID = "0";

    private Intercom client;

    @BeforeEach
    public void before() {
        client = TestClientFactory.create();
    }

    @Test
    public void testFindById() {
        // act
        Visitor response = client.visitors()
                .find(FindVisitorRequest.builder().userId(VISITOR_ID).build())
                .orElseThrow(() -> new RuntimeException("Visitor not found"));

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testFindByUserId() {
        // act
        Visitor response = client.visitors()
                .find(FindVisitorRequest.builder().userId(USER_ID).build())
                .orElseThrow(() -> new RuntimeException("Visitor not found"));

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testUpdate() {
        // act
        Visitor response = client.visitors()
                .update(UpdateVisitorRequest.of(UpdateVisitorRequest.WithUserId.builder()
                        .userId(USER_ID)
                        .name("Winston Smith")
                        .build()))
                .orElseThrow(() -> new RuntimeException("Visitor not found"));

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testMergeToContact() {
        // act
        Contact response = client.visitors()
                .mergeToContact(MergeVisitorToContactRequest.builder()
                        .type("user")
                        .user(MergeVisitorToContactRequest.User.of(
                                MergeVisitorToContactRequest.User.UserWithUserId.builder()
                                        .userId(VISITOR_ID)
                                        .build()))
                        .visitor(MergeVisitorToContactRequest.Visitor.of(
                                MergeVisitorToContactRequest.Visitor.VisitorWithEmail.builder()
                                        .email("mcboxford@intercom-test.com")
                                        .build()))
                        .build());

        // assert
        Assertions.assertNotNull(response);
    }
}
