package com.intercom.api.integration;

import com.intercom.api.Intercom;
import com.intercom.api.resources.companies.requests.DeleteCompanyRequest;
import com.intercom.api.resources.companies.types.Company;
import com.intercom.api.resources.contacts.requests.DeleteContactRequest;
import com.intercom.api.resources.contacts.types.ContactsCreateResponse;
import com.intercom.api.resources.conversations.requests.CreateConversationRequest;
import com.intercom.api.resources.conversations.requests.FindConversationRequest;
import com.intercom.api.resources.conversations.types.Conversation;
import com.intercom.api.resources.messages.types.Message;
import com.intercom.api.resources.tags.requests.DeleteTagRequest;
import com.intercom.api.resources.tags.requests.FindTagRequest;
import com.intercom.api.resources.tags.requests.TagContactRequest;
import com.intercom.api.resources.tags.requests.TagConversationRequest;
import com.intercom.api.resources.tags.requests.UntagContactRequest;
import com.intercom.api.resources.tags.requests.UntagConversationRequest;
import com.intercom.api.resources.tags.types.Tag;
import com.intercom.api.resources.tags.types.TagsCreateRequestBody;
import com.intercom.api.types.CreateContactRequest;
import com.intercom.api.types.CreateOrUpdateCompanyRequest;
import com.intercom.api.types.CreateOrUpdateTagRequest;
import com.intercom.api.types.TagCompanyRequest;
import com.intercom.api.types.TagList;
import com.intercom.api.utils.TestClientFactory;
import com.intercom.api.utils.Utils;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TagsTest {

    private Intercom client;
    private String adminId;
    private Tag tag;

    @BeforeEach
    public void before() {
        // arrange
        client = TestClientFactory.create();

        adminId = client.admins()
                .list()
                .getAdmins()
                .orElseThrow(() -> new RuntimeException("Admins list is required"))
                .get(0)
                .orElseThrow(() -> new RuntimeException("Admin is required"))
                .getId();

        tag = client.tags()
                .create(TagsCreateRequestBody.of(CreateOrUpdateTagRequest.builder()
                        .name(Utils.randomString())
                        .build()));
    }

    @AfterEach
    public void after() {
        // cleanup
        tryDeleteTag();
    }

    @Test
    public void testCreate() {
        // assert
        Assertions.assertNotNull(tag);
    }

    @Test
    public void testUpdate() {
        // act
        Tag response = client.tags()
                .create(TagsCreateRequestBody.of(CreateOrUpdateTagRequest.builder()
                        .name(Utils.randomString())
                        .id(tag.getId())
                        .build()));

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testFind() {
        // act
        Tag response =
                client.tags().find(FindTagRequest.builder().tagId(tag.getId()).build());

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testList() {
        // act
        TagList response = client.tags().list();

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testDelete() {
        // arrange
        Tag newTag = client.tags()
                .create(TagsCreateRequestBody.of(CreateOrUpdateTagRequest.builder()
                        .name(Utils.randomString())
                        .build()));

        // act
        Assertions.assertDoesNotThrow(() -> client.tags()
                .delete(DeleteTagRequest.builder().tagId(newTag.getId()).build()));
    }

    @Test
    public void testTagContact() {
        // arrange
        ContactsCreateResponse contact = client.contacts()
                .create(CreateContactRequest.of(CreateContactRequest.WithExternalId.builder()
                        .externalId(Utils.randomString())
                        .build()));
        String contactId = contact.getId().orElseThrow(() -> new RuntimeException("Contact ID is required"));

        // act
        Tag response = client.tags()
                .tagContact(TagContactRequest.builder()
                        .contactId(contactId)
                        .tagId(tag.getId())
                        .build());

        // assert
        Assertions.assertNotNull(response);

        // cleanup
        try {
            client.tags()
                    .untagContact(UntagContactRequest.builder()
                            .contactId(contactId)
                            .tagId(tag.getId())
                            .build());
        } catch (Exception e) {
            throw new RuntimeException("Failed to untag contact.", e);
        }

        try {
            client.contacts()
                    .delete(DeleteContactRequest.builder().contactId(contactId).build());
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete contact.", e);
        }
    }

    @Test
    public void testTagCompany() {
        // arrange
        Company company = client.companies()
                .createOrUpdate(Optional.of(CreateOrUpdateCompanyRequest.builder()
                        .companyId(Utils.randomString())
                        .build()));

        // act
        Tag response = client.tags()
                .create(TagsCreateRequestBody.of(TagCompanyRequest.builder()
                        .name("Poor")
                        .companies(List.of(TagCompanyRequest.CompaniesItem.builder()
                                .companyId(company.getCompanyId())
                                .build()))
                        .build()));

        // assert
        Assertions.assertNotNull(response);

        // cleanup
        try {
            client.tags()
                    .create(TagsCreateRequestBody.of(TagCompanyRequest.builder()
                            .name("Poor")
                            .companies(List.of(TagCompanyRequest.CompaniesItem.builder()
                                    .id(company.getId())
                                    .companyId(company.getCompanyId())
                                    .build()))
                            .build()));
        } catch (Exception e) {
            throw new RuntimeException("Failed to untag company.");
        }

        try {
            client.companies()
                    .delete(DeleteCompanyRequest.builder()
                            .companyId(company.getId())
                            .build());
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete company.", e);
        }
    }

    @Test
    public void testTagConversation() {
        // arrange
        ContactsCreateResponse contact = client.contacts()
                .create(CreateContactRequest.of(CreateContactRequest.WithExternalId.builder()
                        .externalId(Utils.randomString())
                        .name("John Smith")
                        .build()));
        String contactId = contact.getId().orElseThrow(() -> new RuntimeException("Contact ID is required"));

        Message conversationMessage = client.conversations()
                .create(CreateConversationRequest.builder()
                        .from(CreateConversationRequest.builder()
                                .from(CreateConversationRequest.From.builder()
                                        .type(CreateConversationRequest.From.Type.USER)
                                        .id(contactId)
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

        Conversation conversation = client.conversations()
                .find(FindConversationRequest.builder()
                        .conversationId(conversationMessage
                                .getConversationId()
                                .orElseThrow(() -> new RuntimeException("Conversation ID is required")))
                        .build());
        String conversationId =
                conversation.getId().orElseThrow(() -> new RuntimeException("Conversation ID is required"));

        // act
        Tag response = client.tags()
                .tagConversation(TagConversationRequest.builder()
                        .conversationId(conversationId)
                        .tagId(tag.getId())
                        .adminId(adminId)
                        .build());

        // assert
        Assertions.assertNotNull(response);

        // cleanup
        try {
            client.tags()
                    .untagConversation(UntagConversationRequest.builder()
                            .conversationId(conversationId)
                            .tagId(tag.getId())
                            .adminId(adminId)
                            .build());
        } catch (Exception e) {
            throw new RuntimeException("Failed to untag conversation.", e);
        }

        try {
            client.contacts()
                    .delete(DeleteContactRequest.builder().contactId(contactId).build());
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete contact.", e);
        }
    }

    private void tryDeleteTag() {
        try {
            client.tags().delete(DeleteTagRequest.builder().tagId(tag.getId()).build());
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete tag.", e);
        }
    }
}
