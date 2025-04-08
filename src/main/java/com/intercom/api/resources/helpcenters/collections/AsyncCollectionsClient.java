/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.intercom.api.resources.helpcenters.collections;

import com.intercom.api.core.ClientOptions;
import com.intercom.api.core.RequestOptions;
import com.intercom.api.core.pagination.SyncPagingIterable;
import com.intercom.api.resources.helpcenter.types.Collection;
import com.intercom.api.resources.helpcenters.collections.requests.CreateCollectionRequest;
import com.intercom.api.resources.helpcenters.collections.requests.DeleteCollectionRequest;
import com.intercom.api.resources.helpcenters.collections.requests.FindCollectionRequest;
import com.intercom.api.resources.helpcenters.collections.requests.ListCollectionsRequest;
import com.intercom.api.resources.helpcenters.collections.requests.UpdateCollectionRequest;
import com.intercom.api.types.DeletedCollectionObject;
import java.util.concurrent.CompletableFuture;

public class AsyncCollectionsClient {
    protected final ClientOptions clientOptions;

    private final AsyncRawCollectionsClient rawClient;

    public AsyncCollectionsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.rawClient = new AsyncRawCollectionsClient(clientOptions);
    }

    /**
     * Get responses with HTTP metadata like headers
     */
    public AsyncRawCollectionsClient withRawResponse() {
        return this.rawClient;
    }

    /**
     * You can fetch a list of all collections by making a GET request to <code>https://api.intercom.io/help_center/collections</code>.
     * <p>Collections will be returned in descending order on the <code>updated_at</code> attribute. This means if you need to iterate through results then we'll show the most recently updated collections first.</p>
     */
    public CompletableFuture<SyncPagingIterable<Collection>> list() {
        return this.rawClient.list().thenApply(response -> response.body());
    }

    /**
     * You can fetch a list of all collections by making a GET request to <code>https://api.intercom.io/help_center/collections</code>.
     * <p>Collections will be returned in descending order on the <code>updated_at</code> attribute. This means if you need to iterate through results then we'll show the most recently updated collections first.</p>
     */
    public CompletableFuture<SyncPagingIterable<Collection>> list(ListCollectionsRequest request) {
        return this.rawClient.list(request).thenApply(response -> response.body());
    }

    /**
     * You can fetch a list of all collections by making a GET request to <code>https://api.intercom.io/help_center/collections</code>.
     * <p>Collections will be returned in descending order on the <code>updated_at</code> attribute. This means if you need to iterate through results then we'll show the most recently updated collections first.</p>
     */
    public CompletableFuture<SyncPagingIterable<Collection>> list(
            ListCollectionsRequest request, RequestOptions requestOptions) {
        return this.rawClient.list(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * You can create a new collection by making a POST request to <code>https://api.intercom.io/help_center/collections.</code>
     */
    public CompletableFuture<Collection> create(CreateCollectionRequest request) {
        return this.rawClient.create(request).thenApply(response -> response.body());
    }

    /**
     * You can create a new collection by making a POST request to <code>https://api.intercom.io/help_center/collections.</code>
     */
    public CompletableFuture<Collection> create(CreateCollectionRequest request, RequestOptions requestOptions) {
        return this.rawClient.create(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * You can fetch the details of a single collection by making a GET request to <code>https://api.intercom.io/help_center/collections/&lt;id&gt;</code>.
     */
    public CompletableFuture<Collection> find(FindCollectionRequest request) {
        return this.rawClient.find(request).thenApply(response -> response.body());
    }

    /**
     * You can fetch the details of a single collection by making a GET request to <code>https://api.intercom.io/help_center/collections/&lt;id&gt;</code>.
     */
    public CompletableFuture<Collection> find(FindCollectionRequest request, RequestOptions requestOptions) {
        return this.rawClient.find(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * You can update the details of a single collection by making a PUT request to <code>https://api.intercom.io/collections/&lt;id&gt;</code>.
     */
    public CompletableFuture<Collection> update(UpdateCollectionRequest request) {
        return this.rawClient.update(request).thenApply(response -> response.body());
    }

    /**
     * You can update the details of a single collection by making a PUT request to <code>https://api.intercom.io/collections/&lt;id&gt;</code>.
     */
    public CompletableFuture<Collection> update(UpdateCollectionRequest request, RequestOptions requestOptions) {
        return this.rawClient.update(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * You can delete a single collection by making a DELETE request to <code>https://api.intercom.io/collections/&lt;id&gt;</code>.
     */
    public CompletableFuture<DeletedCollectionObject> delete(DeleteCollectionRequest request) {
        return this.rawClient.delete(request).thenApply(response -> response.body());
    }

    /**
     * You can delete a single collection by making a DELETE request to <code>https://api.intercom.io/collections/&lt;id&gt;</code>.
     */
    public CompletableFuture<DeletedCollectionObject> delete(
            DeleteCollectionRequest request, RequestOptions requestOptions) {
        return this.rawClient.delete(request, requestOptions).thenApply(response -> response.body());
    }
}
