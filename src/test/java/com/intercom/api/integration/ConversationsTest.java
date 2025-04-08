package com.intercom.api.integration;

import com.intercom.api.Intercom;
import com.intercom.api.core.pagination.SyncPage;
import com.intercom.api.core.pagination.SyncPagingIterable;
import com.intercom.api.resources.admins.types.Admin;
import com.intercom.api.resources.contacts.requests.DeleteContactRequest;
import com.intercom.api.resources.contacts.types.Contact;
import com.intercom.api.resources.conversations.requests.AttachContactToConversationRequest;
import com.intercom.api.resources.conversations.requests.AutoAssignConversationRequest;
import com.intercom.api.resources.conversations.requests.CreateConversationRequest;
import com.intercom.api.resources.conversations.requests.DetachContactFromConversationRequest;
import com.intercom.api.resources.conversations.requests.FindConversationRequest;
import com.intercom.api.resources.conversations.requests.ListConversationsRequest;
import com.intercom.api.resources.conversations.requests.ManageConversationPartsRequest;
import com.intercom.api.resources.conversations.requests.ReplyToConversationRequest;
import com.intercom.api.resources.conversations.requests.UpdateConversationRequest;
import com.intercom.api.resources.conversations.types.Conversation;
import com.intercom.api.resources.conversations.types.ConversationsManageRequestBody;
import com.intercom.api.resources.messages.types.Message;
import com.intercom.api.types.AdminReplyConversationRequest;
import com.intercom.api.types.AssignConversationRequest;
import com.intercom.api.types.CloseConversationRequest;
import com.intercom.api.types.ContactReplyConversationRequest;
import com.intercom.api.types.ContactReplyIntercomUserIdRequest;
import com.intercom.api.types.CreateContactRequest;
import com.intercom.api.types.MultipleFilterSearchRequest;
import com.intercom.api.types.MultipleOrSingleFilterSearchRequest;
import com.intercom.api.types.OpenConversationRequest;
import com.intercom.api.types.RedactConversationRequest;
import com.intercom.api.types.ReplyConversationRequest;
import com.intercom.api.types.SearchRequest;
import com.intercom.api.types.SingleFilterSearchRequest;
import com.intercom.api.types.SnoozeConversationRequest;
import com.intercom.api.utils.TestClientFactory;
import com.intercom.api.utils.Utils;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConversationsTest {

    private Intercom client;
    private String adminId;
    private String secondAdminId;
    private Contact user;
    private Contact secondUser;
    private Contact lead;
    private Conversation conversation;

    @BeforeEach
    @SuppressWarnings("CallToPrintStackTrace")
    public void before() {
        // arrange
        client = TestClientFactory.create();

        List<Admin> admins = client.admins().list().getAdmins().stream()
                .filter(Admin::getHasInboxSeat)
                .collect(Collectors.toList());
        adminId = admins.get(0).getId();
        secondAdminId = admins.get(1).getId();

        user = client.contacts()
                .create(CreateContactRequest.of(CreateContactRequest.WithExternalId.builder()
                        .externalId(Utils.randomString())
                        .name("Baba Booey")
                        .build()));
        secondUser = client.contacts()
                .create(CreateContactRequest.of(CreateContactRequest.WithExternalId.builder()
                        .externalId(Utils.randomString())
                        .name("Babusha Boy")
                        .build()));
        lead = client.contacts()
                .create(CreateContactRequest.of(CreateContactRequest.WithExternalId.builder()
                        .externalId(Utils.randomString())
                        .name("Babushka Lead")
                        .build()));

        Message conversationMessage = client.conversations()
                .create(CreateConversationRequest.builder()
                        .from(CreateConversationRequest.builder()
                                .from(CreateConversationRequest.From.builder()
                                        .type(CreateConversationRequest.From.Type.USER)
                                        .id(user.getId())
                                        .build())
                                .body("Raz-dwa-try kalyna, czorniawaja diwczyna")
                                .build())
                        .build());

        // Allow for some time to index the conversation
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            System.out.println("Test execution interrupted: ");
            e.printStackTrace();
            after();
        }

        conversation = client.conversations()
                .find(FindConversationRequest.builder()
                        .conversationId(conversationMessage.getConversationId())
                        .build());
    }

    @AfterEach
    public void after() {
        // cleanup
        tryDeleteContacts();
    }

    @Test
    public void testCreateConversationWithUserAndFindById() {
        // assert
        Assertions.assertNotNull(conversation);
    }

    @Test
    public void testCreateConversationWithLead() {
        // act
        Message response = client.conversations()
                .create(CreateConversationRequest.builder()
                        .from(CreateConversationRequest.builder()
                                .from(CreateConversationRequest.From.builder()
                                        .type(CreateConversationRequest.From.Type.USER)
                                        .id(lead.getId())
                                        .build())
                                .body("Raz-dwa-try kalyna, czorniawaja diwczyna")
                                .build())
                        .build());

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testUpdate() {
        // act
        Conversation response = client.conversations()
                .update(UpdateConversationRequest.builder()
                        .conversationId(conversation.getId())
                        .read(false)
                        .build());

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testReplyByIdAsAdmin() {
        // act
        Conversation response = client.conversations()
                .reply(ReplyToConversationRequest.builder()
                        .conversationId(conversation.getId())
                        .body(ReplyConversationRequest.of(AdminReplyConversationRequest.builder()
                                .messageType(AdminReplyConversationRequest.MessageType.COMMENT)
                                .adminId(adminId)
                                .body("test")
                                .build()))
                        .build());

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testReplyByIdAsUser() {
        // act
        Conversation response = client.conversations()
                .reply(ReplyToConversationRequest.builder()
                        .conversationId(conversation.getId())
                        .body(ReplyConversationRequest.of(
                                ContactReplyConversationRequest.of(ContactReplyIntercomUserIdRequest.builder()
                                        .body("*click* Nice!")
                                        .intercomUserId(user.getId())
                                        .build())))
                        .build());

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testAssign() {
        // act
        Conversation response = client.conversations()
                .manage(ManageConversationPartsRequest.builder()
                        .conversationId(conversation.getId())
                        .body(ConversationsManageRequestBody.assignment(AssignConversationRequest.builder()
                                .type(AssignConversationRequest.Type.ADMIN)
                                .adminId(adminId)
                                .assigneeId(secondAdminId)
                                .build()))
                        .build());

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testRunAssignmentRules() {
        // act
        Conversation response = client.conversations()
                .runAssignmentRules(AutoAssignConversationRequest.builder()
                        .conversationId(conversation.getId())
                        .build());

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testSnooze() {
        // act
        Conversation response = client.conversations()
                .manage(ManageConversationPartsRequest.builder()
                        .conversationId(conversation.getId())
                        .body(ConversationsManageRequestBody.snoozed(SnoozeConversationRequest.builder()
                                .adminId(adminId)
                                .snoozedUntil((int)
                                        (Instant.now().plus(30, ChronoUnit.DAYS).getEpochSecond()))
                                .build()))
                        .build());

        // asssert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testOpen() {
        // act
        Conversation response = client.conversations()
                .manage(ManageConversationPartsRequest.builder()
                        .conversationId(conversation.getId())
                        .body(ConversationsManageRequestBody.open(OpenConversationRequest.builder()
                                .adminId(adminId)
                                .build()))
                        .build());

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testAttachContactAsAdmin() {
        // act
        Conversation response = client.conversations()
                .attachContactAsAdmin(AttachContactToConversationRequest.builder()
                        .conversationId(conversation.getId())
                        .customer(AttachContactToConversationRequest.Customer.of(
                                AttachContactToConversationRequest.Customer.IntercomUserId.builder()
                                        .intercomUserId(secondUser.getId())
                                        .build()))
                        .adminId(adminId)
                        .build());

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testDetachContactAsAdmin() {
        // act
        client.conversations()
                .attachContactAsAdmin(AttachContactToConversationRequest.builder()
                        .conversationId(conversation.getId())
                        .customer(AttachContactToConversationRequest.Customer.of(
                                AttachContactToConversationRequest.Customer.IntercomUserId.builder()
                                        .intercomUserId(secondUser.getId())
                                        .build()))
                        .adminId(adminId)
                        .build());
        Conversation response = client.conversations()
                .detachContactAsAdmin(DetachContactFromConversationRequest.builder()
                        .conversationId(conversation.getId())
                        .contactId(secondUser.getId())
                        .adminId(adminId)
                        .build());

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testRedactConversationPart() {
        // act
        Conversation response = client.conversations()
                .redactConversationPart(
                        RedactConversationRequest.conversationPart(RedactConversationRequest.ConversationPart.builder()
                                .conversationId(conversation.getId())
                                .conversationPartId(conversation
                                        .getConversationParts()
                                        .map(conv -> conv.getConversationParts()
                                                .get(2)
                                                .getId())
                                        .orElse(""))
                                .build()));

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testClose() {
        // act
        Conversation response = client.conversations()
                .manage(ManageConversationPartsRequest.builder()
                        .conversationId(conversation.getId())
                        .body(ConversationsManageRequestBody.close(CloseConversationRequest.builder()
                                .adminId(adminId)
                                .body("Hasta la vista, baby")
                                .build()))
                        .build());

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testSearch() {
        // act
        List<MultipleOrSingleFilterSearchRequest> value = new ArrayList<>();
        SingleFilterSearchRequest query = SingleFilterSearchRequest.builder()
                .operator(SingleFilterSearchRequest.Operator.NOT_EQUALS)
                .field("id")
                .value(SingleFilterSearchRequest.Value.of("123"))
                .build();
        value.add(MultipleOrSingleFilterSearchRequest.of(query));

        SyncPagingIterable<Conversation> response = client.conversations()
                .search(SearchRequest.builder()
                        .query(SearchRequest.Query.of(MultipleFilterSearchRequest.builder()
                                .operator(MultipleFilterSearchRequest.Operator.AND)
                                .value(value)
                                .build()))
                        .build());

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testPaginationIterator() {
        // arrange
        int limit = 2;

        // act
        Iterator<Conversation> iterator = client.conversations()
                .list(ListConversationsRequest.builder().perPage(1).build())
                .iterator();

        // assert
        Assertions.assertNotNull(iterator);

        int count = 0;
        while (iterator.hasNext()) {
            Conversation item = iterator.next();

            Assertions.assertNotNull(item);
            Assertions.assertNotNull(item.getId());

            count++;

            if (count >= limit) {
                break;
            }
        }

        Assertions.assertTrue(count >= 1);
    }

    @Test
    public void testPaginationPager() {
        // arrange
        int limit = 2;

        // act
        SyncPagingIterable<Conversation> pager = client.conversations()
                .list(ListConversationsRequest.builder().perPage(1).build());

        // assert
        Assertions.assertNotNull(pager);

        int count = 0;
        while (pager.hasNext()) {
            SyncPage<Conversation> page = pager.nextPage();
            count += page.getItems().size();

            if (count >= limit) {
                break;
            }
        }

        Assertions.assertTrue(count >= 1);
    }

    private void tryDeleteContacts() {
        try {
            client.contacts()
                    .delete(DeleteContactRequest.builder()
                            .contactId(user.getId())
                            .build());
            client.contacts()
                    .delete(DeleteContactRequest.builder()
                            .contactId(secondUser.getId())
                            .build());
            client.contacts()
                    .delete(DeleteContactRequest.builder()
                            .contactId(lead.getId())
                            .build());
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete contacts.", e);
        }
    }
}
