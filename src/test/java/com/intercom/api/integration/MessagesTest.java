package com.intercom.api.integration;

import com.intercom.api.Intercom;
import com.intercom.api.core.pagination.SyncPagingIterable;
import com.intercom.api.resources.contacts.requests.DeleteContactRequest;
import com.intercom.api.resources.contacts.types.Contact;
import com.intercom.api.resources.conversations.types.Conversation;
import com.intercom.api.resources.messages.types.Message;
import com.intercom.api.types.CreateContactRequest;
import com.intercom.api.types.CreateMessageRequest;
import com.intercom.api.types.SearchRequest;
import com.intercom.api.types.SingleFilterSearchRequest;
import com.intercom.api.utils.TestClientFactory;
import com.intercom.api.utils.Utils;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MessagesTest {

    private Intercom client;
    private String adminId;
    private Contact user;

    @BeforeEach
    public void before() {
        // arrange
        client = TestClientFactory.create();

        adminId = client.admins().list().getAdmins().get(0).getId();
        user = client.contacts()
                .create(CreateContactRequest.of(CreateContactRequest.WithExternalId.builder()
                        .externalId(Utils.randomString())
                        .name("Message Test User")
                        .build()));
    }

    @AfterEach
    public void after() {
        // cleanup
        tryDeleteContact();
    }

    @Test
    @SuppressWarnings("CallToPrintStackTrace")
    public void testMessageThatCreatesAConversation() {
        // act
        Message message = client.messages()
                .create(CreateMessageRequest.inapp(CreateMessageRequest.Inapp.builder()
                        .body("Hey, look at me! I am the conversations creator now!")
                        .from(CreateMessageRequest.Inapp.From.builder()
                                .id(Integer.parseInt(adminId))
                                .build())
                        .to(CreateMessageRequest.Inapp.To.builder()
                                .type(CreateMessageRequest.Inapp.To.Type.USER)
                                .id(user.getId())
                                .build())
                        .createConversationWithoutContactReply(true)
                        .build()));

        // Allow for some time to index the conversation
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            System.out.println("Test execution interrupted: ");
            e.printStackTrace();
            after();
        }

        SyncPagingIterable<Conversation> searchResults = client.conversations()
                .search(SearchRequest.builder()
                        .query(SearchRequest.Query.of(SingleFilterSearchRequest.builder()
                                .field("source.id")
                                .operator(SingleFilterSearchRequest.Operator.EQUALS)
                                .value(SingleFilterSearchRequest.Value.of(message.getId()))
                                .build()))
                        .build());

        // assert
        Assertions.assertFalse(searchResults.getItems().isEmpty());
    }

    @Test
    public void testCreateMessageNoConversation() {
        // act
        Message response = client.messages()
                .create(CreateMessageRequest.inapp(CreateMessageRequest.Inapp.builder()
                        .body("Message without creating conversation")
                        .from(CreateMessageRequest.Inapp.From.builder()
                                .id(Integer.parseInt(adminId))
                                .build())
                        .to(CreateMessageRequest.Inapp.To.builder()
                                .type(CreateMessageRequest.Inapp.To.Type.USER)
                                .id(user.getId())
                                .build())
                        .build()));

        // assert
        Assertions.assertNotNull(response);
    }

    private void tryDeleteContact() {
        try {
            client.contacts()
                    .delete(DeleteContactRequest.builder()
                            .contactId(user.getId())
                            .build());
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete contact.", e);
        }
    }
}
