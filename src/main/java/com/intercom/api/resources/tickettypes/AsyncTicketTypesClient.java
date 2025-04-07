/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.intercom.api.resources.tickettypes;

import com.intercom.api.core.ClientOptions;
import com.intercom.api.core.RequestOptions;
import com.intercom.api.core.Suppliers;
import com.intercom.api.resources.tickets.types.TicketType;
import com.intercom.api.resources.tickettypes.attributes.AsyncAttributesClient;
import com.intercom.api.resources.tickettypes.requests.CreateTicketTypeRequest;
import com.intercom.api.resources.tickettypes.requests.FindTicketTypeRequest;
import com.intercom.api.resources.tickettypes.requests.UpdateTicketTypeRequest;
import com.intercom.api.types.TicketTypeList;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class AsyncTicketTypesClient {
    protected final ClientOptions clientOptions;

    private final AsyncRawTicketTypesClient rawClient;

    protected final Supplier<AsyncAttributesClient> attributesClient;

    public AsyncTicketTypesClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.rawClient = new AsyncRawTicketTypesClient(clientOptions);
        this.attributesClient = Suppliers.memoize(() -> new AsyncAttributesClient(clientOptions));
    }

    /**
     * Get responses with HTTP metadata like headers
     */
    public AsyncRawTicketTypesClient withRawResponse() {
        return this.rawClient;
    }

    /**
     * You can get a list of all ticket types for a workspace.
     */
    public CompletableFuture<TicketTypeList> list() {
        return this.rawClient.list().thenApply(response -> response.body());
    }

    /**
     * You can get a list of all ticket types for a workspace.
     */
    public CompletableFuture<TicketTypeList> list(RequestOptions requestOptions) {
        return this.rawClient.list(requestOptions).thenApply(response -> response.body());
    }

    /**
     * You can create a new ticket type.
     * <blockquote>
     * <p>📘 Creating ticket types.</p>
     * <p>Every ticket type will be created with two default attributes: <em>default_title</em> and <em>default_description</em>.
     * For the <code>icon</code> propery, use an emoji from <a href="https://twemoji-cheatsheet.vercel.app/">Twemoji Cheatsheet</a></p>
     * </blockquote>
     */
    public CompletableFuture<TicketType> create(CreateTicketTypeRequest request) {
        return this.rawClient.create(request).thenApply(response -> response.body());
    }

    /**
     * You can create a new ticket type.
     * <blockquote>
     * <p>📘 Creating ticket types.</p>
     * <p>Every ticket type will be created with two default attributes: <em>default_title</em> and <em>default_description</em>.
     * For the <code>icon</code> propery, use an emoji from <a href="https://twemoji-cheatsheet.vercel.app/">Twemoji Cheatsheet</a></p>
     * </blockquote>
     */
    public CompletableFuture<TicketType> create(CreateTicketTypeRequest request, RequestOptions requestOptions) {
        return this.rawClient.create(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * You can fetch the details of a single ticket type.
     */
    public CompletableFuture<TicketType> get(FindTicketTypeRequest request) {
        return this.rawClient.get(request).thenApply(response -> response.body());
    }

    /**
     * You can fetch the details of a single ticket type.
     */
    public CompletableFuture<TicketType> get(FindTicketTypeRequest request, RequestOptions requestOptions) {
        return this.rawClient.get(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * You can update a ticket type.
     * <blockquote>
     * <p>📘 Updating a ticket type.</p>
     * <p>For the <code>icon</code> propery, use an emoji from <a href="https://twemoji-cheatsheet.vercel.app/">Twemoji Cheatsheet</a></p>
     * </blockquote>
     */
    public CompletableFuture<TicketType> update(UpdateTicketTypeRequest request) {
        return this.rawClient.update(request).thenApply(response -> response.body());
    }

    /**
     * You can update a ticket type.
     * <blockquote>
     * <p>📘 Updating a ticket type.</p>
     * <p>For the <code>icon</code> propery, use an emoji from <a href="https://twemoji-cheatsheet.vercel.app/">Twemoji Cheatsheet</a></p>
     * </blockquote>
     */
    public CompletableFuture<TicketType> update(UpdateTicketTypeRequest request, RequestOptions requestOptions) {
        return this.rawClient.update(request, requestOptions).thenApply(response -> response.body());
    }

    public AsyncAttributesClient attributes() {
        return this.attributesClient.get();
    }
}
