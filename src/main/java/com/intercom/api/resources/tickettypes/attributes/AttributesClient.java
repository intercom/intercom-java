/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.intercom.api.resources.tickettypes.attributes;

import com.intercom.api.core.ClientOptions;
import com.intercom.api.core.RequestOptions;
import com.intercom.api.resources.tickettypes.attributes.requests.CreateTicketTypeAttributeRequest;
import com.intercom.api.resources.tickettypes.attributes.requests.UpdateTicketTypeAttributeRequest;
import com.intercom.api.types.TicketTypeAttribute;

public class AttributesClient {
    protected final ClientOptions clientOptions;

    private final RawAttributesClient rawClient;

    public AttributesClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.rawClient = new RawAttributesClient(clientOptions);
    }

    /**
     * Get responses with HTTP metadata like headers
     */
    public RawAttributesClient withRawResponse() {
        return this.rawClient;
    }

    /**
     * You can create a new attribute for a ticket type.
     */
    public TicketTypeAttribute create(CreateTicketTypeAttributeRequest request) {
        return this.rawClient.create(request).body();
    }

    /**
     * You can create a new attribute for a ticket type.
     */
    public TicketTypeAttribute create(CreateTicketTypeAttributeRequest request, RequestOptions requestOptions) {
        return this.rawClient.create(request, requestOptions).body();
    }

    /**
     * You can update an existing attribute for a ticket type.
     */
    public TicketTypeAttribute update(UpdateTicketTypeAttributeRequest request) {
        return this.rawClient.update(request).body();
    }

    /**
     * You can update an existing attribute for a ticket type.
     */
    public TicketTypeAttribute update(UpdateTicketTypeAttributeRequest request, RequestOptions requestOptions) {
        return this.rawClient.update(request, requestOptions).body();
    }
}
