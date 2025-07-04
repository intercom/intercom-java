/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.intercom.api.resources.contacts.requests;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.intercom.api.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = DetachSubscriptionFromContactRequest.Builder.class)
public final class DetachSubscriptionFromContactRequest {
    private final String contactId;

    private final String subscriptionId;

    private final Map<String, Object> additionalProperties;

    private DetachSubscriptionFromContactRequest(
            String contactId, String subscriptionId, Map<String, Object> additionalProperties) {
        this.contactId = contactId;
        this.subscriptionId = subscriptionId;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The unique identifier for the contact which is given by Intercom
     */
    @JsonProperty("contact_id")
    public String getContactId() {
        return contactId;
    }

    /**
     * @return The unique identifier for the subscription type which is given by Intercom
     */
    @JsonProperty("subscription_id")
    public String getSubscriptionId() {
        return subscriptionId;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof DetachSubscriptionFromContactRequest
                && equalTo((DetachSubscriptionFromContactRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(DetachSubscriptionFromContactRequest other) {
        return contactId.equals(other.contactId) && subscriptionId.equals(other.subscriptionId);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.contactId, this.subscriptionId);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ContactIdStage builder() {
        return new Builder();
    }

    public interface ContactIdStage {
        /**
         * The unique identifier for the contact which is given by Intercom
         */
        SubscriptionIdStage contactId(@NotNull String contactId);

        Builder from(DetachSubscriptionFromContactRequest other);
    }

    public interface SubscriptionIdStage {
        /**
         * The unique identifier for the subscription type which is given by Intercom
         */
        _FinalStage subscriptionId(@NotNull String subscriptionId);
    }

    public interface _FinalStage {
        DetachSubscriptionFromContactRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ContactIdStage, SubscriptionIdStage, _FinalStage {
        private String contactId;

        private String subscriptionId;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(DetachSubscriptionFromContactRequest other) {
            contactId(other.getContactId());
            subscriptionId(other.getSubscriptionId());
            return this;
        }

        /**
         * The unique identifier for the contact which is given by Intercom<p>The unique identifier for the contact which is given by Intercom</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("contact_id")
        public SubscriptionIdStage contactId(@NotNull String contactId) {
            this.contactId = Objects.requireNonNull(contactId, "contactId must not be null");
            return this;
        }

        /**
         * The unique identifier for the subscription type which is given by Intercom<p>The unique identifier for the subscription type which is given by Intercom</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("subscription_id")
        public _FinalStage subscriptionId(@NotNull String subscriptionId) {
            this.subscriptionId = Objects.requireNonNull(subscriptionId, "subscriptionId must not be null");
            return this;
        }

        @java.lang.Override
        public DetachSubscriptionFromContactRequest build() {
            return new DetachSubscriptionFromContactRequest(contactId, subscriptionId, additionalProperties);
        }
    }
}
