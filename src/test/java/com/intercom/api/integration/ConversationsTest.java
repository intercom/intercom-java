package com.intercom.api.integration;

import com.intercom.api.Intercom;
import com.intercom.api.core.ApiVersion;
import com.intercom.api.core.pagination.SyncPage;
import com.intercom.api.core.pagination.SyncPagingIterable;
import com.intercom.api.resources.admins.types.Admin;
import com.intercom.api.resources.contacts.requests.DeleteContactRequest;
import com.intercom.api.resources.contacts.types.ContactsCreateResponse;
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
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ConversationsTest {

    private Intercom client;
    private String adminId;
    private String secondAdminId;
    private ContactsCreateResponse user;
    private ContactsCreateResponse secondUser;
    private ContactsCreateResponse lead;
    private String userId;
    private String secondUserId;
    private String leadId;
    private Conversation conversation;
    private String conversationId;

    @BeforeEach
    @SuppressWarnings("CallToPrintStackTrace")
    public void before() {
        // arrange
        client = TestClientFactory.create();

        List<Admin> admins =
                client
                        .admins()
                        .list()
                        .getAdmins()
                        .orElseThrow(() -> new RuntimeException("Admins list is required"))
                        .stream()
                        .filter(opt -> opt.isPresent())
                        .map(opt -> opt.get())
                        .filter(Admin::getHasInboxSeat)
                        .collect(Collectors.toList());
        adminId = admins.get(0).getId();
        secondAdminId = admins.get(1).getId();

        user = client.contacts()
                .create(CreateContactRequest.of(CreateContactRequest.WithExternalId.builder()
                        .externalId(Utils.randomString())
                        .name("Baba Booey")
                        .build()));
        userId = user.getId().orElseThrow(() -> new RuntimeException("User ID is required"));
        secondUser = client.contacts()
                .create(CreateContactRequest.of(CreateContactRequest.WithExternalId.builder()
                        .externalId(Utils.randomString())
                        .name("Babusha Boy")
                        .build()));
        secondUserId = secondUser.getId().orElseThrow(() -> new RuntimeException("Second user ID is required"));
        lead = client.contacts()
                .create(CreateContactRequest.of(CreateContactRequest.WithExternalId.builder()
                        .externalId(Utils.randomString())
                        .name("Babushka Lead")
                        .build()));
        leadId = lead.getId().orElseThrow(() -> new RuntimeException("Lead ID is required"));

        Message conversationMessage = client.conversations()
                .create(CreateConversationRequest.builder()
                        .from(CreateConversationRequest.builder()
                                .from(CreateConversationRequest.From.builder()
                                        .type(CreateConversationRequest.From.Type.USER)
                                        .id(userId)
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

        String msgConversationId = conversationMessage
                .getConversationId()
                .orElseThrow(() -> new RuntimeException("Conversation ID is required"));
        conversation = client.conversations()
                .find(FindConversationRequest.builder()
                        .conversationId(msgConversationId)
                        .build());
        conversationId = conversation.getId().orElseThrow(() -> new RuntimeException("Conversation ID is required"));
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
                                        .id(leadId)
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
                        .conversationId(conversationId)
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
                        .conversationId(conversationId)
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
                        .conversationId(conversationId)
                        .body(ReplyConversationRequest.of(
                                ContactReplyConversationRequest.of(ContactReplyIntercomUserIdRequest.builder()
                                        .body("*click* Nice!")
                                        .intercomUserId(userId)
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
                        .conversationId(conversationId)
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
        Intercom legacyServiceClient = TestClientFactory.create(ApiVersion._2_11);
        // act - runAssignmentRules returns void
        legacyServiceClient
                .conversations()
                .runAssignmentRules(AutoAssignConversationRequest.builder()
                        .conversationId(conversationId)
                        .build());

        // assert - if no exception was thrown, the test passed
        Assertions.assertTrue(true);
    }

    @Test
    public void testSnooze() {
        // act
        Conversation response = client.conversations()
                .manage(ManageConversationPartsRequest.builder()
                        .conversationId(conversationId)
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
                        .conversationId(conversationId)
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
                        .conversationId(conversationId)
                        .customer(AttachContactToConversationRequest.Customer.of(
                                AttachContactToConversationRequest.Customer.IntercomUserId.builder()
                                        .intercomUserId(secondUserId)
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
                        .conversationId(conversationId)
                        .customer(AttachContactToConversationRequest.Customer.of(
                                AttachContactToConversationRequest.Customer.IntercomUserId.builder()
                                        .intercomUserId(secondUserId)
                                        .build()))
                        .adminId(adminId)
                        .build());
        Conversation response = client.conversations()
                .detachContactAsAdmin(DetachContactFromConversationRequest.builder()
                        .conversationId(conversationId)
                        .contactId(secondUserId)
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
                                .conversationId(conversationId)
                                .conversationPartId(conversation
                                        .getConversationParts()
                                        .flatMap(parts -> parts.getConversationParts())
                                        .map(list -> list.get(2))
                                        .flatMap(part -> part.getId())
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
                        .conversationId(conversationId)
                        .body(ConversationsManageRequestBody.close(CloseConversationRequest.builder()
                                .adminId(adminId)
                                .body("Hasta la vista, baby")
                                .build()))
                        .build());

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    @Disabled("API spec defines snoozedUntil as integer, but timestamps beyond 2038 overflow int. "
            + "Skipping until spec is updated to use long for Unix timestamps.")
    public void testSearch() {
        // act
        List<SingleFilterSearchRequest> value = new ArrayList<>();
        SingleFilterSearchRequest query = SingleFilterSearchRequest.builder()
                .operator(SingleFilterSearchRequest.Operator.NOT_EQUALS)
                .field("id")
                .value(SingleFilterSearchRequest.Value.of("123"))
                .build();
        value.add(query);

        SyncPagingIterable<Conversation> response = client.conversations()
                .search(SearchRequest.builder()
                        .query(SearchRequest.Query.of(MultipleFilterSearchRequest.builder()
                                .operator(MultipleFilterSearchRequest.Operator.AND)
                                .value(MultipleFilterSearchRequest.Value.ofListOfSingleFilterSearchRequest(value))
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
                    .delete(DeleteContactRequest.builder().contactId(userId).build());
            client.contacts()
                    .delete(DeleteContactRequest.builder()
                            .contactId(secondUserId)
                            .build());
            client.contacts()
                    .delete(DeleteContactRequest.builder().contactId(leadId).build());
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete contacts.", e);
        }
    }
}
