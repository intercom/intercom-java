package com.intercom.api.integration;

import com.intercom.api.Intercom;
import com.intercom.api.core.pagination.SyncPage;
import com.intercom.api.core.pagination.SyncPagingIterable;
import com.intercom.api.resources.companies.requests.AttachContactToCompanyRequest;
import com.intercom.api.types.CreateOrUpdateCompanyRequest;
import com.intercom.api.resources.companies.requests.DeleteCompanyRequest;
import com.intercom.api.resources.companies.requests.DetachContactFromCompanyRequest;
import com.intercom.api.resources.companies.requests.FindCompanyRequest;
import com.intercom.api.resources.companies.requests.ListAttachedContactsRequest;
import com.intercom.api.resources.companies.requests.ListCompaniesRequest;
import com.intercom.api.resources.companies.requests.ListSegmentsAttachedToCompanyRequest;
import com.intercom.api.resources.companies.types.Company;
import com.intercom.api.resources.contacts.requests.ListContactsRequest;
import com.intercom.api.resources.contacts.types.Contact;
import com.intercom.api.types.CompanyAttachedContacts;
import com.intercom.api.types.CompanyAttachedSegments;
import com.intercom.api.types.DeletedCompanyObject;
import com.intercom.api.utils.TestClientFactory;
import com.intercom.api.utils.Utils;
import java.util.Date;
import java.util.Iterator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CompaniesTest {

    private Intercom client;
    private Company company;
    private String companyId;
    private String contactId;
    private boolean deleteAfter;

    @BeforeEach
    public void before() {
        // arrange
        client = TestClientFactory.create();
        SyncPagingIterable<Contact> randomContacts =
                client.contacts().list(ListContactsRequest.builder().perPage(1).build());

        // act
        contactId = randomContacts.getItems().get(0).getId().orElseThrow(() -> new RuntimeException("Contact ID is required"));
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
        companyId = company.getId();

        deleteAfter = true;
    }

    @AfterEach
    public void after() {
        if (deleteAfter) {
            // cleanup
            tryDeleteCompany(companyId);
        }
    }

    @Test
    public void testCreate() {
        // assert
        Assertions.assertNotNull(company);
    }

    @Test
    public void testUpdate() {
        // act
        Company response = client.companies()
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

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testFindById() {
        // act
        Company response = client.companies()
                .find(FindCompanyRequest.builder().companyId(companyId).build());

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testList() {
        // act
        SyncPagingIterable<Company> response = client.companies()
                .list(ListCompaniesRequest.builder()
                        .page(1)
                        .perPage(35)
                        .order("desc")
                        .build());

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testDelete() {
        // act
        DeletedCompanyObject response = client.companies()
                .delete(DeleteCompanyRequest.builder().companyId(companyId).build());
        deleteAfter = false;

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testAttachContact() {
        // act
        Company response = client.companies()
                .attachContact(AttachContactToCompanyRequest.builder()
                        .contactId(contactId)
                        .companyId(companyId)
                        .build());

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testDetachContact() {
        // act
        client.companies()
                .attachContact(AttachContactToCompanyRequest.builder()
                        .contactId(contactId)
                        .companyId(companyId)
                        .build());
        Company response = client.companies()
                .detachContact(DetachContactFromCompanyRequest.builder()
                        .contactId(contactId)
                        .companyId(companyId)
                        .build());

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testListAttachedContacts() {
        // act
        CompanyAttachedContacts response = client.companies()
                .listAttachedContacts(ListAttachedContactsRequest.builder()
                        .companyId(companyId)
                        .build());

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testListAttachedSegments() {
        // act
        CompanyAttachedSegments response = client.companies()
                .listAttachedSegments(ListSegmentsAttachedToCompanyRequest.builder()
                        .companyId(companyId)
                        .build());

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testPaginationIterator() {
        // arrange
        int limit = 10;

        // act
        Iterator<Company> iterator = client.companies()
                .list(ListCompaniesRequest.builder().perPage(1).build())
                .iterator();

        // assert
        Assertions.assertNotNull(iterator);

        int count = 0;
        while (iterator.hasNext()) {
            Company item = iterator.next();

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
        int limit = 10;

        // act
        SyncPagingIterable<Company> pager = client.companies()
                .list(ListCompaniesRequest.builder().perPage(1).build());

        // assert
        Assertions.assertNotNull(pager);

        int count = 0;
        while (pager.hasNext()) {
            SyncPage<Company> page = pager.nextPage();
            count += page.getItems().size();

            if (count >= limit) {
                break;
            }
        }

        Assertions.assertTrue(count >= 0);
    }

    private void tryDeleteCompany(String companyId) {
        try {
            client.companies()
                    .delete(DeleteCompanyRequest.builder().companyId(companyId).build());
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete company.", e);
        }
    }
}
