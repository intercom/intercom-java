/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.intercom.api.resources.companies;

import com.intercom.api.core.ClientOptions;
import com.intercom.api.core.RequestOptions;
import com.intercom.api.core.pagination.SyncPagingIterable;
import com.intercom.api.resources.companies.requests.AttachContactToCompanyRequest;
import com.intercom.api.resources.companies.requests.CreateOrUpdateCompanyRequest;
import com.intercom.api.resources.companies.requests.DeleteCompanyRequest;
import com.intercom.api.resources.companies.requests.DetachContactFromCompanyRequest;
import com.intercom.api.resources.companies.requests.FindCompanyRequest;
import com.intercom.api.resources.companies.requests.ListAttachedContactsRequest;
import com.intercom.api.resources.companies.requests.ListCompaniesRequest;
import com.intercom.api.resources.companies.requests.ListSegmentsAttachedToCompanyRequest;
import com.intercom.api.resources.companies.requests.RetrieveCompanyRequest;
import com.intercom.api.resources.companies.requests.ScrollCompaniesRequest;
import com.intercom.api.resources.companies.requests.UpdateCompanyRequest;
import com.intercom.api.resources.companies.types.CompaniesRetrieveResponse;
import com.intercom.api.resources.companies.types.Company;
import com.intercom.api.types.CompanyAttachedContacts;
import com.intercom.api.types.CompanyAttachedSegments;
import com.intercom.api.types.DeletedCompanyObject;
import java.util.concurrent.CompletableFuture;

public class AsyncCompaniesClient {
    protected final ClientOptions clientOptions;

    private final AsyncRawCompaniesClient rawClient;

    public AsyncCompaniesClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.rawClient = new AsyncRawCompaniesClient(clientOptions);
    }

    /**
     * Get responses with HTTP metadata like headers
     */
    public AsyncRawCompaniesClient withRawResponse() {
        return this.rawClient;
    }

    /**
     * You can fetch a single company by passing in <code>company_id</code> or <code>name</code>.
     * <p><code>https://api.intercom.io/companies?name={name}</code></p>
     * <p><code>https://api.intercom.io/companies?company_id={company_id}</code></p>
     * <p>You can fetch all companies and filter by <code>segment_id</code> or <code>tag_id</code> as a query parameter.</p>
     * <p><code>https://api.intercom.io/companies?tag_id={tag_id}</code></p>
     * <p><code>https://api.intercom.io/companies?segment_id={segment_id}</code></p>
     */
    public CompletableFuture<CompaniesRetrieveResponse> retrieve() {
        return this.rawClient.retrieve().thenApply(response -> response.body());
    }

    /**
     * You can fetch a single company by passing in <code>company_id</code> or <code>name</code>.
     * <p><code>https://api.intercom.io/companies?name={name}</code></p>
     * <p><code>https://api.intercom.io/companies?company_id={company_id}</code></p>
     * <p>You can fetch all companies and filter by <code>segment_id</code> or <code>tag_id</code> as a query parameter.</p>
     * <p><code>https://api.intercom.io/companies?tag_id={tag_id}</code></p>
     * <p><code>https://api.intercom.io/companies?segment_id={segment_id}</code></p>
     */
    public CompletableFuture<CompaniesRetrieveResponse> retrieve(RetrieveCompanyRequest request) {
        return this.rawClient.retrieve(request).thenApply(response -> response.body());
    }

    /**
     * You can fetch a single company by passing in <code>company_id</code> or <code>name</code>.
     * <p><code>https://api.intercom.io/companies?name={name}</code></p>
     * <p><code>https://api.intercom.io/companies?company_id={company_id}</code></p>
     * <p>You can fetch all companies and filter by <code>segment_id</code> or <code>tag_id</code> as a query parameter.</p>
     * <p><code>https://api.intercom.io/companies?tag_id={tag_id}</code></p>
     * <p><code>https://api.intercom.io/companies?segment_id={segment_id}</code></p>
     */
    public CompletableFuture<CompaniesRetrieveResponse> retrieve(
            RetrieveCompanyRequest request, RequestOptions requestOptions) {
        return this.rawClient.retrieve(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * You can create or update a company.
     * <p>Companies will be only visible in Intercom when there is at least one associated user.</p>
     * <p>Companies are looked up via <code>company_id</code> in a <code>POST</code> request, if not found via <code>company_id</code>, the new company will be created, if found, that company will be updated.</p>
     * <p>{% admonition type=&quot;warning&quot; name=&quot;Using <code>company_id</code>&quot; %}
     * You can set a unique <code>company_id</code> value when creating a company. However, it is not possible to update <code>company_id</code>. Be sure to set a unique value once upon creation of the company.
     * {% /admonition %}</p>
     */
    public CompletableFuture<Company> createOrUpdate() {
        return this.rawClient.createOrUpdate().thenApply(response -> response.body());
    }

    /**
     * You can create or update a company.
     * <p>Companies will be only visible in Intercom when there is at least one associated user.</p>
     * <p>Companies are looked up via <code>company_id</code> in a <code>POST</code> request, if not found via <code>company_id</code>, the new company will be created, if found, that company will be updated.</p>
     * <p>{% admonition type=&quot;warning&quot; name=&quot;Using <code>company_id</code>&quot; %}
     * You can set a unique <code>company_id</code> value when creating a company. However, it is not possible to update <code>company_id</code>. Be sure to set a unique value once upon creation of the company.
     * {% /admonition %}</p>
     */
    public CompletableFuture<Company> createOrUpdate(CreateOrUpdateCompanyRequest request) {
        return this.rawClient.createOrUpdate(request).thenApply(response -> response.body());
    }

    /**
     * You can create or update a company.
     * <p>Companies will be only visible in Intercom when there is at least one associated user.</p>
     * <p>Companies are looked up via <code>company_id</code> in a <code>POST</code> request, if not found via <code>company_id</code>, the new company will be created, if found, that company will be updated.</p>
     * <p>{% admonition type=&quot;warning&quot; name=&quot;Using <code>company_id</code>&quot; %}
     * You can set a unique <code>company_id</code> value when creating a company. However, it is not possible to update <code>company_id</code>. Be sure to set a unique value once upon creation of the company.
     * {% /admonition %}</p>
     */
    public CompletableFuture<Company> createOrUpdate(
            CreateOrUpdateCompanyRequest request, RequestOptions requestOptions) {
        return this.rawClient.createOrUpdate(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * You can fetch a single company.
     */
    public CompletableFuture<Company> find(FindCompanyRequest request) {
        return this.rawClient.find(request).thenApply(response -> response.body());
    }

    /**
     * You can fetch a single company.
     */
    public CompletableFuture<Company> find(FindCompanyRequest request, RequestOptions requestOptions) {
        return this.rawClient.find(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * You can update a single company using the Intercom provisioned <code>id</code>.
     * <p>{% admonition type=&quot;warning&quot; name=&quot;Using <code>company_id</code>&quot; %}
     * When updating a company it is not possible to update <code>company_id</code>. This can only be set once upon creation of the company.
     * {% /admonition %}</p>
     */
    public CompletableFuture<Company> update(UpdateCompanyRequest request) {
        return this.rawClient.update(request).thenApply(response -> response.body());
    }

    /**
     * You can update a single company using the Intercom provisioned <code>id</code>.
     * <p>{% admonition type=&quot;warning&quot; name=&quot;Using <code>company_id</code>&quot; %}
     * When updating a company it is not possible to update <code>company_id</code>. This can only be set once upon creation of the company.
     * {% /admonition %}</p>
     */
    public CompletableFuture<Company> update(UpdateCompanyRequest request, RequestOptions requestOptions) {
        return this.rawClient.update(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * You can delete a single company.
     */
    public CompletableFuture<DeletedCompanyObject> delete(DeleteCompanyRequest request) {
        return this.rawClient.delete(request).thenApply(response -> response.body());
    }

    /**
     * You can delete a single company.
     */
    public CompletableFuture<DeletedCompanyObject> delete(DeleteCompanyRequest request, RequestOptions requestOptions) {
        return this.rawClient.delete(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * You can fetch a list of all contacts that belong to a company.
     */
    public CompletableFuture<CompanyAttachedContacts> listAttachedContacts(ListAttachedContactsRequest request) {
        return this.rawClient.listAttachedContacts(request).thenApply(response -> response.body());
    }

    /**
     * You can fetch a list of all contacts that belong to a company.
     */
    public CompletableFuture<CompanyAttachedContacts> listAttachedContacts(
            ListAttachedContactsRequest request, RequestOptions requestOptions) {
        return this.rawClient.listAttachedContacts(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * You can fetch a list of all segments that belong to a company.
     */
    public CompletableFuture<CompanyAttachedSegments> listAttachedSegments(
            ListSegmentsAttachedToCompanyRequest request) {
        return this.rawClient.listAttachedSegments(request).thenApply(response -> response.body());
    }

    /**
     * You can fetch a list of all segments that belong to a company.
     */
    public CompletableFuture<CompanyAttachedSegments> listAttachedSegments(
            ListSegmentsAttachedToCompanyRequest request, RequestOptions requestOptions) {
        return this.rawClient.listAttachedSegments(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * You can list companies. The company list is sorted by the <code>last_request_at</code> field and by default is ordered descending, most recently requested first.
     * <p>Note that the API does not include companies who have no associated users in list responses.</p>
     * <p>When using the Companies endpoint and the pages object to iterate through the returned companies, there is a limit of 10,000 Companies that can be returned. If you need to list or iterate on more than 10,000 Companies, please use the <a href="https://developers.intercom.com/reference#iterating-over-all-companies">Scroll API</a>.
     * {% admonition type=&quot;warning&quot; name=&quot;Pagination&quot; %}
     * You can use pagination to limit the number of results returned. The default is <code>20</code> results per page.
     * See the <a href="https://developers.intercom.com/docs/build-an-integration/learn-more/rest-apis/pagination/#pagination-for-list-apis">pagination section</a> for more details on how to use the <code>starting_after</code> param.
     * {% /admonition %}</p>
     */
    public CompletableFuture<SyncPagingIterable<Company>> list() {
        return this.rawClient.list().thenApply(response -> response.body());
    }

    /**
     * You can list companies. The company list is sorted by the <code>last_request_at</code> field and by default is ordered descending, most recently requested first.
     * <p>Note that the API does not include companies who have no associated users in list responses.</p>
     * <p>When using the Companies endpoint and the pages object to iterate through the returned companies, there is a limit of 10,000 Companies that can be returned. If you need to list or iterate on more than 10,000 Companies, please use the <a href="https://developers.intercom.com/reference#iterating-over-all-companies">Scroll API</a>.
     * {% admonition type=&quot;warning&quot; name=&quot;Pagination&quot; %}
     * You can use pagination to limit the number of results returned. The default is <code>20</code> results per page.
     * See the <a href="https://developers.intercom.com/docs/build-an-integration/learn-more/rest-apis/pagination/#pagination-for-list-apis">pagination section</a> for more details on how to use the <code>starting_after</code> param.
     * {% /admonition %}</p>
     */
    public CompletableFuture<SyncPagingIterable<Company>> list(ListCompaniesRequest request) {
        return this.rawClient.list(request).thenApply(response -> response.body());
    }

    /**
     * You can list companies. The company list is sorted by the <code>last_request_at</code> field and by default is ordered descending, most recently requested first.
     * <p>Note that the API does not include companies who have no associated users in list responses.</p>
     * <p>When using the Companies endpoint and the pages object to iterate through the returned companies, there is a limit of 10,000 Companies that can be returned. If you need to list or iterate on more than 10,000 Companies, please use the <a href="https://developers.intercom.com/reference#iterating-over-all-companies">Scroll API</a>.
     * {% admonition type=&quot;warning&quot; name=&quot;Pagination&quot; %}
     * You can use pagination to limit the number of results returned. The default is <code>20</code> results per page.
     * See the <a href="https://developers.intercom.com/docs/build-an-integration/learn-more/rest-apis/pagination/#pagination-for-list-apis">pagination section</a> for more details on how to use the <code>starting_after</code> param.
     * {% /admonition %}</p>
     */
    public CompletableFuture<SyncPagingIterable<Company>> list(
            ListCompaniesRequest request, RequestOptions requestOptions) {
        return this.rawClient.list(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * The <code>list all companies</code> functionality does not work well for huge datasets, and can result in errors and performance problems when paging deeply. The Scroll API provides an efficient mechanism for iterating over all companies in a dataset.
     * <ul>
     * <li>Each app can only have 1 scroll open at a time. You'll get an error message if you try to have more than one open per app.</li>
     * <li>If the scroll isn't used for 1 minute, it expires and calls with that scroll param will fail</li>
     * <li>If the end of the scroll is reached, &quot;companies&quot; will be empty and the scroll parameter will expire</li>
     * </ul>
     * <p>{% admonition type=&quot;info&quot; name=&quot;Scroll Parameter&quot; %}
     * You can get the first page of companies by simply sending a GET request to the scroll endpoint.
     * For subsequent requests you will need to use the scroll parameter from the response.
     * {% /admonition %}
     * {% admonition type=&quot;danger&quot; name=&quot;Scroll network timeouts&quot; %}
     * Since scroll is often used on large datasets network errors such as timeouts can be encountered. When this occurs you will see a HTTP 500 error with the following message:
     * &quot;Request failed due to an internal network error. Please restart the scroll operation.&quot;
     * If this happens, you will need to restart your scroll query: It is not possible to continue from a specific point when using scroll.
     * {% /admonition %}</p>
     */
    public CompletableFuture<SyncPagingIterable<Company>> scroll() {
        return this.rawClient.scroll().thenApply(response -> response.body());
    }

    /**
     * The <code>list all companies</code> functionality does not work well for huge datasets, and can result in errors and performance problems when paging deeply. The Scroll API provides an efficient mechanism for iterating over all companies in a dataset.
     * <ul>
     * <li>Each app can only have 1 scroll open at a time. You'll get an error message if you try to have more than one open per app.</li>
     * <li>If the scroll isn't used for 1 minute, it expires and calls with that scroll param will fail</li>
     * <li>If the end of the scroll is reached, &quot;companies&quot; will be empty and the scroll parameter will expire</li>
     * </ul>
     * <p>{% admonition type=&quot;info&quot; name=&quot;Scroll Parameter&quot; %}
     * You can get the first page of companies by simply sending a GET request to the scroll endpoint.
     * For subsequent requests you will need to use the scroll parameter from the response.
     * {% /admonition %}
     * {% admonition type=&quot;danger&quot; name=&quot;Scroll network timeouts&quot; %}
     * Since scroll is often used on large datasets network errors such as timeouts can be encountered. When this occurs you will see a HTTP 500 error with the following message:
     * &quot;Request failed due to an internal network error. Please restart the scroll operation.&quot;
     * If this happens, you will need to restart your scroll query: It is not possible to continue from a specific point when using scroll.
     * {% /admonition %}</p>
     */
    public CompletableFuture<SyncPagingIterable<Company>> scroll(ScrollCompaniesRequest request) {
        return this.rawClient.scroll(request).thenApply(response -> response.body());
    }

    /**
     * The <code>list all companies</code> functionality does not work well for huge datasets, and can result in errors and performance problems when paging deeply. The Scroll API provides an efficient mechanism for iterating over all companies in a dataset.
     * <ul>
     * <li>Each app can only have 1 scroll open at a time. You'll get an error message if you try to have more than one open per app.</li>
     * <li>If the scroll isn't used for 1 minute, it expires and calls with that scroll param will fail</li>
     * <li>If the end of the scroll is reached, &quot;companies&quot; will be empty and the scroll parameter will expire</li>
     * </ul>
     * <p>{% admonition type=&quot;info&quot; name=&quot;Scroll Parameter&quot; %}
     * You can get the first page of companies by simply sending a GET request to the scroll endpoint.
     * For subsequent requests you will need to use the scroll parameter from the response.
     * {% /admonition %}
     * {% admonition type=&quot;danger&quot; name=&quot;Scroll network timeouts&quot; %}
     * Since scroll is often used on large datasets network errors such as timeouts can be encountered. When this occurs you will see a HTTP 500 error with the following message:
     * &quot;Request failed due to an internal network error. Please restart the scroll operation.&quot;
     * If this happens, you will need to restart your scroll query: It is not possible to continue from a specific point when using scroll.
     * {% /admonition %}</p>
     */
    public CompletableFuture<SyncPagingIterable<Company>> scroll(
            ScrollCompaniesRequest request, RequestOptions requestOptions) {
        return this.rawClient.scroll(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * You can attach a company to a single contact.
     */
    public CompletableFuture<Company> attachContact(AttachContactToCompanyRequest request) {
        return this.rawClient.attachContact(request).thenApply(response -> response.body());
    }

    /**
     * You can attach a company to a single contact.
     */
    public CompletableFuture<Company> attachContact(
            AttachContactToCompanyRequest request, RequestOptions requestOptions) {
        return this.rawClient.attachContact(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * You can detach a company from a single contact.
     */
    public CompletableFuture<Company> detachContact(DetachContactFromCompanyRequest request) {
        return this.rawClient.detachContact(request).thenApply(response -> response.body());
    }

    /**
     * You can detach a company from a single contact.
     */
    public CompletableFuture<Company> detachContact(
            DetachContactFromCompanyRequest request, RequestOptions requestOptions) {
        return this.rawClient.detachContact(request, requestOptions).thenApply(response -> response.body());
    }
}
