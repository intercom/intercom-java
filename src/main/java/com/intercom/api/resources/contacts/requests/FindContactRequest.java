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
@JsonDeserialize(builder = FindContactRequest.Builder.class)
public final class FindContactRequest {
    private final String contactId;

    private final Map<String, Object> additionalProperties;

    private FindContactRequest(String contactId, Map<String, Object> additionalProperties) {
        this.contactId = contactId;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return id
     */
    @JsonProperty("contact_id")
    public String getContactId() {
        return contactId;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof FindContactRequest && equalTo((FindContactRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(FindContactRequest other) {
        return contactId.equals(other.contactId);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.contactId);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ContactIdStage builder() {
        return new Builder();
    }

    public interface ContactIdStage {
        _FinalStage contactId(@NotNull String contactId);

        Builder from(FindContactRequest other);
    }

    public interface _FinalStage {
        FindContactRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ContactIdStage, _FinalStage {
        private String contactId;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(FindContactRequest other) {
            contactId(other.getContactId());
            return this;
        }

        /**
         * <p>id</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("contact_id")
        public _FinalStage contactId(@NotNull String contactId) {
            this.contactId = Objects.requireNonNull(contactId, "contactId must not be null");
            return this;
        }

        @java.lang.Override
        public FindContactRequest build() {
            return new FindContactRequest(contactId, additionalProperties);
        }
    }
}
