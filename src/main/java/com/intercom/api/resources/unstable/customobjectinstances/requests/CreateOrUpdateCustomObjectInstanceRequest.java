/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.intercom.api.resources.unstable.customobjectinstances.requests;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.intercom.api.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CreateOrUpdateCustomObjectInstanceRequest.Builder.class)
public final class CreateOrUpdateCustomObjectInstanceRequest {
    private final String customObjectTypeIdentifier;

    private final Optional<String> externalId;

    private final Optional<Integer> externalCreatedAt;

    private final Optional<Integer> externalUpdatedAt;

    private final Optional<Map<String, Optional<String>>> customAttributes;

    private final Map<String, Object> additionalProperties;

    private CreateOrUpdateCustomObjectInstanceRequest(
            String customObjectTypeIdentifier,
            Optional<String> externalId,
            Optional<Integer> externalCreatedAt,
            Optional<Integer> externalUpdatedAt,
            Optional<Map<String, Optional<String>>> customAttributes,
            Map<String, Object> additionalProperties) {
        this.customObjectTypeIdentifier = customObjectTypeIdentifier;
        this.externalId = externalId;
        this.externalCreatedAt = externalCreatedAt;
        this.externalUpdatedAt = externalUpdatedAt;
        this.customAttributes = customAttributes;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The unique identifier of the custom object type that defines the structure of the custom object instance.
     */
    @JsonProperty("custom_object_type_identifier")
    public String getCustomObjectTypeIdentifier() {
        return customObjectTypeIdentifier;
    }

    /**
     * @return A unique identifier for the Custom Object instance in the external system it originated from.
     */
    @JsonProperty("external_id")
    public Optional<String> getExternalId() {
        return externalId;
    }

    /**
     * @return The time when the Custom Object instance was created in the external system it originated from.
     */
    @JsonProperty("external_created_at")
    public Optional<Integer> getExternalCreatedAt() {
        return externalCreatedAt;
    }

    /**
     * @return The time when the Custom Object instance was last updated in the external system it originated from.
     */
    @JsonProperty("external_updated_at")
    public Optional<Integer> getExternalUpdatedAt() {
        return externalUpdatedAt;
    }

    /**
     * @return The custom attributes which are set for the Custom Object instance.
     */
    @JsonProperty("custom_attributes")
    public Optional<Map<String, Optional<String>>> getCustomAttributes() {
        return customAttributes;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CreateOrUpdateCustomObjectInstanceRequest
                && equalTo((CreateOrUpdateCustomObjectInstanceRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CreateOrUpdateCustomObjectInstanceRequest other) {
        return customObjectTypeIdentifier.equals(other.customObjectTypeIdentifier)
                && externalId.equals(other.externalId)
                && externalCreatedAt.equals(other.externalCreatedAt)
                && externalUpdatedAt.equals(other.externalUpdatedAt)
                && customAttributes.equals(other.customAttributes);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.customObjectTypeIdentifier,
                this.externalId,
                this.externalCreatedAt,
                this.externalUpdatedAt,
                this.customAttributes);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static CustomObjectTypeIdentifierStage builder() {
        return new Builder();
    }

    public interface CustomObjectTypeIdentifierStage {
        /**
         * The unique identifier of the custom object type that defines the structure of the custom object instance.
         */
        _FinalStage customObjectTypeIdentifier(@NotNull String customObjectTypeIdentifier);

        Builder from(CreateOrUpdateCustomObjectInstanceRequest other);
    }

    public interface _FinalStage {
        CreateOrUpdateCustomObjectInstanceRequest build();

        /**
         * <p>A unique identifier for the Custom Object instance in the external system it originated from.</p>
         */
        _FinalStage externalId(Optional<String> externalId);

        _FinalStage externalId(String externalId);

        /**
         * <p>The time when the Custom Object instance was created in the external system it originated from.</p>
         */
        _FinalStage externalCreatedAt(Optional<Integer> externalCreatedAt);

        _FinalStage externalCreatedAt(Integer externalCreatedAt);

        /**
         * <p>The time when the Custom Object instance was last updated in the external system it originated from.</p>
         */
        _FinalStage externalUpdatedAt(Optional<Integer> externalUpdatedAt);

        _FinalStage externalUpdatedAt(Integer externalUpdatedAt);

        /**
         * <p>The custom attributes which are set for the Custom Object instance.</p>
         */
        _FinalStage customAttributes(Optional<Map<String, Optional<String>>> customAttributes);

        _FinalStage customAttributes(Map<String, Optional<String>> customAttributes);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements CustomObjectTypeIdentifierStage, _FinalStage {
        private String customObjectTypeIdentifier;

        private Optional<Map<String, Optional<String>>> customAttributes = Optional.empty();

        private Optional<Integer> externalUpdatedAt = Optional.empty();

        private Optional<Integer> externalCreatedAt = Optional.empty();

        private Optional<String> externalId = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(CreateOrUpdateCustomObjectInstanceRequest other) {
            customObjectTypeIdentifier(other.getCustomObjectTypeIdentifier());
            externalId(other.getExternalId());
            externalCreatedAt(other.getExternalCreatedAt());
            externalUpdatedAt(other.getExternalUpdatedAt());
            customAttributes(other.getCustomAttributes());
            return this;
        }

        /**
         * The unique identifier of the custom object type that defines the structure of the custom object instance.<p>The unique identifier of the custom object type that defines the structure of the custom object instance.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("custom_object_type_identifier")
        public _FinalStage customObjectTypeIdentifier(@NotNull String customObjectTypeIdentifier) {
            this.customObjectTypeIdentifier =
                    Objects.requireNonNull(customObjectTypeIdentifier, "customObjectTypeIdentifier must not be null");
            return this;
        }

        /**
         * <p>The custom attributes which are set for the Custom Object instance.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage customAttributes(Map<String, Optional<String>> customAttributes) {
            this.customAttributes = Optional.ofNullable(customAttributes);
            return this;
        }

        /**
         * <p>The custom attributes which are set for the Custom Object instance.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "custom_attributes", nulls = Nulls.SKIP)
        public _FinalStage customAttributes(Optional<Map<String, Optional<String>>> customAttributes) {
            this.customAttributes = customAttributes;
            return this;
        }

        /**
         * <p>The time when the Custom Object instance was last updated in the external system it originated from.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage externalUpdatedAt(Integer externalUpdatedAt) {
            this.externalUpdatedAt = Optional.ofNullable(externalUpdatedAt);
            return this;
        }

        /**
         * <p>The time when the Custom Object instance was last updated in the external system it originated from.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "external_updated_at", nulls = Nulls.SKIP)
        public _FinalStage externalUpdatedAt(Optional<Integer> externalUpdatedAt) {
            this.externalUpdatedAt = externalUpdatedAt;
            return this;
        }

        /**
         * <p>The time when the Custom Object instance was created in the external system it originated from.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage externalCreatedAt(Integer externalCreatedAt) {
            this.externalCreatedAt = Optional.ofNullable(externalCreatedAt);
            return this;
        }

        /**
         * <p>The time when the Custom Object instance was created in the external system it originated from.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "external_created_at", nulls = Nulls.SKIP)
        public _FinalStage externalCreatedAt(Optional<Integer> externalCreatedAt) {
            this.externalCreatedAt = externalCreatedAt;
            return this;
        }

        /**
         * <p>A unique identifier for the Custom Object instance in the external system it originated from.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage externalId(String externalId) {
            this.externalId = Optional.ofNullable(externalId);
            return this;
        }

        /**
         * <p>A unique identifier for the Custom Object instance in the external system it originated from.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "external_id", nulls = Nulls.SKIP)
        public _FinalStage externalId(Optional<String> externalId) {
            this.externalId = externalId;
            return this;
        }

        @java.lang.Override
        public CreateOrUpdateCustomObjectInstanceRequest build() {
            return new CreateOrUpdateCustomObjectInstanceRequest(
                    customObjectTypeIdentifier,
                    externalId,
                    externalCreatedAt,
                    externalUpdatedAt,
                    customAttributes,
                    additionalProperties);
        }
    }
}
