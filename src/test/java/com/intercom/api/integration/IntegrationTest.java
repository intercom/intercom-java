package com.intercom.api.integration;

import com.intercom.api.Intercom;
import com.intercom.api.resources.companies.requests.AttachContactToCompanyRequest;
import com.intercom.api.resources.companies.requests.CreateOrUpdateCompanyRequest;
import com.intercom.api.resources.companies.requests.DeleteCompanyRequest;
import com.intercom.api.resources.companies.types.Company;
import com.intercom.api.resources.contacts.requests.DeleteContactRequest;
import com.intercom.api.resources.contacts.types.Contact;
import com.intercom.api.resources.conversations.requests.CreateConversationRequest;
import com.intercom.api.resources.messages.types.Message;
import com.intercom.api.resources.tags.requests.DeleteTagRequest;
import com.intercom.api.resources.tags.requests.TagConversationRequest;
import com.intercom.api.resources.tags.types.Tag;
import com.intercom.api.resources.tags.types.TagsCreateRequestBody;
import com.intercom.api.types.CreateContactRequest;
import com.intercom.api.types.CreateOrUpdateTagRequest;
import com.intercom.api.utils.TestClientFactory;
import com.intercom.api.utils.Utils;
import java.util.Date;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntegrationTest {

    private Intercom client;
    private String adminId;
    private Company company;
    private Contact user;
    private Contact lead;
    private Tag tag;

    @BeforeEach
    public void before() {
        // arrange
        client = TestClientFactory.create();
        adminId = client.admins().list().getAdmins().get(0).getId();

        company = client.companies()
                .createOrUpdate(CreateOrUpdateCompanyRequest.builder()
                        .name(Utils.randomString())
                        .companyId(Utils.randomString())
                        .plan("1. Get pizzaid")
                        .size(62049)
                        .website("http://the-best.one")
                        .industry("The Best One")
                        .remoteCreatedAt((int) (new Date().toInstant().toEpochMilli() / 1000L))
                        .monthlySpend(9001)
                        .build());
        user = client.contacts()
                .create(CreateContactRequest.of(CreateContactRequest.WithExternalId.builder()
                        .externalId(Utils.randomString())
                        .build()));
        lead = client.contacts()
                .create(CreateContactRequest.of(CreateContactRequest.WithRole.builder()
                        .role("lead")
                        .name("Marek Barek")
                        .build()));
        tag = client.tags()
                .create(TagsCreateRequestBody.of(CreateOrUpdateTagRequest.builder()
                        .name(Utils.randomString())
                        .build()));
    }

    @AfterEach
    public void after() {
        // cleanup
        tryDeleteContacts();
        tryDeleteCompany();
        tryDeleteTag();
    }

    @Test
    public void testAddContactToCompany() {
        // act
        Company response = client.companies()
                .attachContact(AttachContactToCompanyRequest.builder()
                        .contactId(user.getId())
                        .companyId(company.getId())
                        .build());

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testCreateConversationWithContact() {
        // act
        Message response = client.conversations()
                .create(CreateConversationRequest.builder()
                        .from(CreateConversationRequest.From.builder()
                                .type(CreateConversationRequest.From.Type.USER)
                                .id(user.getId())
                                .build())
                        .body("Welcome to the club, buddy!")
                        .build());

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testTagConversation() {
        // arrange
        Message message = client.conversations()
                .create(CreateConversationRequest.builder()
                        .from(CreateConversationRequest.From.builder()
                                .type(CreateConversationRequest.From.Type.USER)
                                .id(user.getId())
                                .build())
                        .body("Welcome to the club, buddy!")
                        .build());

        // act
        Tag response = client.tags()
                .tagConversation(TagConversationRequest.builder()
                        .conversationId(message.getConversationId())
                        .tagId(tag.getId())
                        .adminId(adminId)
                        .build());

        // assert
        Assertions.assertNotNull(response);
    }

    private void tryDeleteContacts() {
        try {
            client.contacts()
                    .delete(DeleteContactRequest.builder()
                            .contactId(user.getId())
                            .build());
            client.contacts()
                    .delete(DeleteContactRequest.builder()
                            .contactId(lead.getId())
                            .build());
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete contacts.", e);
        }
    }

    private void tryDeleteCompany() {
        try {
            client.companies()
                    .delete(DeleteCompanyRequest.builder()
                            .companyId(company.getId())
                            .build());
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete company.", e);
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
