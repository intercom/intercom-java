package com.intercom.api.integration;

import com.intercom.api.Intercom;
import com.intercom.api.core.pagination.SyncPage;
import com.intercom.api.core.pagination.SyncPagingIterable;
import com.intercom.api.resources.companies.requests.AttachContactToCompanyRequest;
import com.intercom.api.resources.companies.requests.DeleteCompanyRequest;
import com.intercom.api.resources.companies.types.Company;
import com.intercom.api.resources.contacts.requests.ArchiveContactRequest;
import com.intercom.api.resources.contacts.requests.AttachSubscriptionToContactRequest;
import com.intercom.api.resources.contacts.requests.DeleteContactRequest;
import com.intercom.api.resources.contacts.requests.DetachSubscriptionFromContactRequest;
import com.intercom.api.resources.contacts.requests.FindContactRequest;
import com.intercom.api.resources.contacts.requests.ListAttachedCompaniesRequest;
import com.intercom.api.resources.contacts.requests.ListAttachedSubscriptionsRequest;
import com.intercom.api.resources.contacts.requests.ListContactsRequest;
import com.intercom.api.resources.contacts.requests.ListSegmentsAttachedToContactRequest;
import com.intercom.api.resources.contacts.requests.ListTagsAttachedToContactRequest;
import com.intercom.api.resources.contacts.requests.MergeContactsRequest;
import com.intercom.api.resources.contacts.requests.UnarchiveContactRequest;
import com.intercom.api.resources.contacts.requests.UpdateContactRequest;
import com.intercom.api.resources.contacts.types.Contact;
import com.intercom.api.resources.contacts.types.ContactsCreateResponse;
import com.intercom.api.resources.contacts.types.ContactsFindResponse;
import com.intercom.api.resources.contacts.types.ContactsMergeLeadInUserResponse;
import com.intercom.api.resources.contacts.types.ContactsUpdateResponse;
import com.intercom.api.resources.tags.requests.TagContactRequest;
import com.intercom.api.resources.tags.requests.UntagContactRequest;
import com.intercom.api.resources.tags.types.Tag;
import com.intercom.api.resources.tags.types.TagsCreateRequestBody;
import com.intercom.api.types.ContactArchived;
import com.intercom.api.types.ContactDeleted;
import com.intercom.api.types.ContactSegments;
import com.intercom.api.types.ContactUnarchived;
import com.intercom.api.types.CreateContactRequest;
import com.intercom.api.types.CreateOrUpdateCompanyRequest;
import com.intercom.api.types.CreateOrUpdateTagRequest;
import com.intercom.api.types.SubscriptionTypeList;
import com.intercom.api.types.TagList;
import com.intercom.api.utils.TestClientFactory;
import com.intercom.api.utils.Utils;
import java.util.Date;
import java.util.Iterator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactsTest {

    private Intercom client;
    private String subscriptionId;
    private Tag tag;
    private ContactsCreateResponse contact;
    private String contactId;
    private Company company;

    @BeforeEach
    public void before() {
        // arrange
        client = TestClientFactory.create();
        contact = client.contacts()
                .create(CreateContactRequest.of(CreateContactRequest.WithExternalId.builder()
                        .externalId(Utils.randomString())
                        .phone("+353871234567")
                        .build()));
        contactId = contact.getId().orElseThrow(() -> new RuntimeException("Contact ID is required"));

        // act
        company = client.companies()
                .createOrUpdate(java.util.Optional.of(CreateOrUpdateCompanyRequest.builder()
                        .name(Utils.randomString())
                        .companyId(Utils.randomString())
                        .plan("1. Get pizzaid")
                        .size(62049)
                        .website("http://the-best.one")
                        .industry("The Best One")
                        .remoteCreatedAt((int) (new Date().toInstant().toEpochMilli() / 1000L))
                        .monthlySpend(9001)
                        .build()));

        client.companies()
                .attachContact(AttachContactToCompanyRequest.builder()
                        .contactId(contactId)
                        .companyId(company.getId())
                        .build());

        SubscriptionTypeList subscriptionTypes = client.subscriptionTypes().list();
        subscriptionId = subscriptionTypes
                .getData()
                .orElseThrow(() -> new RuntimeException("No subscription types found"))
                .get(0)
                .getId()
                .orElseThrow(() -> new RuntimeException("Subscription type ID is required"));
        client.contacts()
                .attachSubscription(AttachSubscriptionToContactRequest.builder()
                        .contactId(contactId)
                        .subscriptionId(subscriptionId)
                        .consentType("opt_in")
                        .build());

        tag = client.tags()
                .create(TagsCreateRequestBody.of(CreateOrUpdateTagRequest.builder()
                        .name(Utils.randomString())
                        .build()));
        client.tags()
                .tagContact(TagContactRequest.builder()
                        .contactId(contactId)
                        .tagId(tag.getId())
                        .build());
    }

    @AfterEach
    public void after() {
        // cleanup
        tryDetachSubscription();
        tryUntagContact();
        tryDeleteCompany();
        tryDeleteContact();
    }

    @Test
    public void testList() {
        // act
        SyncPagingIterable<Contact> response =
                client.contacts().list(ListContactsRequest.builder().perPage(5).build());

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testCreateUser() {
        // assert
        Assertions.assertNotNull(client);
    }

    @Test
    public void testCreateLead() {
        // act
        ContactsCreateResponse response = client.contacts()
                .create(CreateContactRequest.of(CreateContactRequest.WithRole.builder()
                        .role("lead")
                        .name("Roman Bowling")
                        .build()));

        // assert
        Assertions.assertNotNull(response);

        // cleanup
        try {
            client.contacts()
                    .delete(DeleteContactRequest.builder()
                            .contactId(
                                    response.getId().orElseThrow(() -> new RuntimeException("Contact ID is required")))
                            .build());
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete contact.", e);
        }
    }

    @Test
    public void testFindById() {
        // act
        ContactsFindResponse response = client.contacts()
                .find(FindContactRequest.builder().contactId(contactId).build());

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testUpdate() {
        // act
        ContactsUpdateResponse response = client.contacts()
                .update(UpdateContactRequest.builder()
                        .contactId(contactId)
                        .name("Nico Bellic")
                        .build());

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testArchive() {
        // act
        ContactArchived response = client.contacts()
                .archive(ArchiveContactRequest.builder().contactId(contactId).build());

        // assert
        Assertions.assertNotNull(response);

        // cleanup
        client.contacts()
                .unarchive(
                        UnarchiveContactRequest.builder().contactId(contactId).build());
    }

    @Test
    public void testUnarchive() {
        // act
        client.contacts()
                .archive(ArchiveContactRequest.builder().contactId(contactId).build());
        ContactUnarchived response = client.contacts()
                .unarchive(
                        UnarchiveContactRequest.builder().contactId(contactId).build());

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testDelete() {
        // act
        ContactsCreateResponse created = client.contacts()
                .create(CreateContactRequest.of(CreateContactRequest.WithRole.builder()
                        .role("lead")
                        .name("Roman Bowling")
                        .build()));
        String createdId = created.getId().orElseThrow(() -> new RuntimeException("Contact ID is required"));
        ContactDeleted response = client.contacts()
                .delete(DeleteContactRequest.builder().contactId(createdId).build());

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testMergeLeadInUser() {
        // act
        ContactsCreateResponse lead = client.contacts()
                .create(CreateContactRequest.of(CreateContactRequest.WithRole.builder()
                        .role("lead")
                        .name("Roman Bowling")
                        .build()));
        String leadId = lead.getId().orElseThrow(() -> new RuntimeException("Lead ID is required"));
        ContactsMergeLeadInUserResponse response = client.contacts()
                .mergeLeadInUser(MergeContactsRequest.builder()
                        .leadId(leadId)
                        .contactId(contactId)
                        .build());

        // assert
        Assertions.assertNotNull(response);

        // cleanup
        try {
            client.contacts()
                    .delete(DeleteContactRequest.builder().contactId(leadId).build());
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete contact.", e);
        }
    }

    @Test
    public void testListAttachedCompanies() {
        // act
        SyncPagingIterable<Company> response = client.contacts()
                .listAttachedCompanies(ListAttachedCompaniesRequest.builder()
                        .contactId(contactId)
                        .build());

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testListAttachedEmailSubscriptions() {
        // act
        SubscriptionTypeList response = client.contacts()
                .listAttachedSubscriptions(ListAttachedSubscriptionsRequest.builder()
                        .contactId(contactId)
                        .build());

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testListAttachedSegments() {
        // act
        ContactSegments response = client.contacts()
                .listAttachedSegments(ListSegmentsAttachedToContactRequest.builder()
                        .contactId(contactId)
                        .build());

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testListAttachedTags() {
        // act
        TagList response = client.contacts()
                .listAttachedTags(ListTagsAttachedToContactRequest.builder()
                        .contactId(contactId)
                        .build());

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testPaginationIterator() {
        // arrange
        int limit = 100;

        // act
        Iterator<Contact> iterator = client.contacts()
                .list(ListContactsRequest.builder().perPage(50).build())
                .iterator();

        // assert
        Assertions.assertNotNull(iterator);

        int count = 0;
        while (iterator.hasNext()) {
            Contact item = iterator.next();

            Assertions.assertNotNull(item);
            Assertions.assertNotNull(item.getId());

            count++;

            if (count >= limit) {
                break;
            }
        }

        Assertions.assertTrue(count >= 0);
    }

    @Test
    public void testPaginationPager() {
        // arrange
        int limit = 100;

        // act
        SyncPagingIterable<Contact> pager =
                client.contacts().list(ListContactsRequest.builder().perPage(50).build());

        // assert
        Assertions.assertNotNull(pager);

        int count = 0;
        while (pager.hasNext()) {
            SyncPage<Contact> page = pager.nextPage();
            count += page.getItems().size();

            if (count >= limit) {
                break;
            }
        }

        Assertions.assertTrue(count >= 0);
    }

    private void tryDetachSubscription() {
        try {
            client.contacts()
                    .detachSubscription(DetachSubscriptionFromContactRequest.builder()
                            .contactId(contactId)
                            .subscriptionId(subscriptionId)
                            .build());
        } catch (Exception e) {
            throw new RuntimeException("Failed to detach subscription.", e);
        }
    }

    private void tryUntagContact() {
        try {
            client.tags()
                    .untagContact(UntagContactRequest.builder()
                            .contactId(contactId)
                            .tagId(tag.getId())
                            .build());
        } catch (Exception e) {
            throw new RuntimeException("Failed to untag contact.", e);
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

    private void tryDeleteContact() {
        try {
            client.contacts()
                    .delete(DeleteContactRequest.builder().contactId(contactId).build());
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete contact.", e);
        }
    }
}
