/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.intercom.api.resources.unstable.helpcenter.requests;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.intercom.api.core.ObjectMappers;
import com.intercom.api.resources.unstable.types.GroupTranslatedContent;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = UpdateCollectionRequest.Builder.class)
public final class UpdateCollectionRequest {
    private final int id;

    private final Optional<String> name;

    private final Optional<String> description;

    private final Optional<GroupTranslatedContent> translatedContent;

    private final Optional<String> parentId;

    private final Map<String, Object> additionalProperties;

    private UpdateCollectionRequest(
            int id,
            Optional<String> name,
            Optional<String> description,
            Optional<GroupTranslatedContent> translatedContent,
            Optional<String> parentId,
            Map<String, Object> additionalProperties) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.translatedContent = translatedContent;
        this.parentId = parentId;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The unique identifier for the collection which is given by Intercom.
     */
    @JsonProperty("id")
    public int getId() {
        return id;
    }

    /**
     * @return The name of the collection. For multilingual collections, this will be the name of the default language's content.
     */
    @JsonProperty("name")
    public Optional<String> getName() {
        return name;
    }

    /**
     * @return The description of the collection. For multilingual collections, this will be the description of the default language's content.
     */
    @JsonProperty("description")
    public Optional<String> getDescription() {
        return description;
    }

    @JsonProperty("translated_content")
    public Optional<GroupTranslatedContent> getTranslatedContent() {
        return translatedContent;
    }

    /**
     * @return The id of the parent collection. If <code>null</code> then it will be updated as the first level collection.
     */
    @JsonProperty("parent_id")
    public Optional<String> getParentId() {
        return parentId;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UpdateCollectionRequest && equalTo((UpdateCollectionRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(UpdateCollectionRequest other) {
        return id == other.id
                && name.equals(other.name)
                && description.equals(other.description)
                && translatedContent.equals(other.translatedContent)
                && parentId.equals(other.parentId);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.description, this.translatedContent, this.parentId);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IdStage builder() {
        return new Builder();
    }

    public interface IdStage {
        /**
         * The unique identifier for the collection which is given by Intercom.
         */
        _FinalStage id(int id);

        Builder from(UpdateCollectionRequest other);
    }

    public interface _FinalStage {
        UpdateCollectionRequest build();

        /**
         * <p>The name of the collection. For multilingual collections, this will be the name of the default language's content.</p>
         */
        _FinalStage name(Optional<String> name);

        _FinalStage name(String name);

        /**
         * <p>The description of the collection. For multilingual collections, this will be the description of the default language's content.</p>
         */
        _FinalStage description(Optional<String> description);

        _FinalStage description(String description);

        _FinalStage translatedContent(Optional<GroupTranslatedContent> translatedContent);

        _FinalStage translatedContent(GroupTranslatedContent translatedContent);

        /**
         * <p>The id of the parent collection. If <code>null</code> then it will be updated as the first level collection.</p>
         */
        _FinalStage parentId(Optional<String> parentId);

        _FinalStage parentId(String parentId);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements IdStage, _FinalStage {
        private int id;

        private Optional<String> parentId = Optional.empty();

        private Optional<GroupTranslatedContent> translatedContent = Optional.empty();

        private Optional<String> description = Optional.empty();

        private Optional<String> name = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(UpdateCollectionRequest other) {
            id(other.getId());
            name(other.getName());
            description(other.getDescription());
            translatedContent(other.getTranslatedContent());
            parentId(other.getParentId());
            return this;
        }

        /**
         * The unique identifier for the collection which is given by Intercom.<p>The unique identifier for the collection which is given by Intercom.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("id")
        public _FinalStage id(int id) {
            this.id = id;
            return this;
        }

        /**
         * <p>The id of the parent collection. If <code>null</code> then it will be updated as the first level collection.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage parentId(String parentId) {
            this.parentId = Optional.ofNullable(parentId);
            return this;
        }

        /**
         * <p>The id of the parent collection. If <code>null</code> then it will be updated as the first level collection.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "parent_id", nulls = Nulls.SKIP)
        public _FinalStage parentId(Optional<String> parentId) {
            this.parentId = parentId;
            return this;
        }

        @java.lang.Override
        public _FinalStage translatedContent(GroupTranslatedContent translatedContent) {
            this.translatedContent = Optional.ofNullable(translatedContent);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "translated_content", nulls = Nulls.SKIP)
        public _FinalStage translatedContent(Optional<GroupTranslatedContent> translatedContent) {
            this.translatedContent = translatedContent;
            return this;
        }

        /**
         * <p>The description of the collection. For multilingual collections, this will be the description of the default language's content.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage description(String description) {
            this.description = Optional.ofNullable(description);
            return this;
        }

        /**
         * <p>The description of the collection. For multilingual collections, this will be the description of the default language's content.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "description", nulls = Nulls.SKIP)
        public _FinalStage description(Optional<String> description) {
            this.description = description;
            return this;
        }

        /**
         * <p>The name of the collection. For multilingual collections, this will be the name of the default language's content.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage name(String name) {
            this.name = Optional.ofNullable(name);
            return this;
        }

        /**
         * <p>The name of the collection. For multilingual collections, this will be the name of the default language's content.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "name", nulls = Nulls.SKIP)
        public _FinalStage name(Optional<String> name) {
            this.name = name;
            return this;
        }

        @java.lang.Override
        public UpdateCollectionRequest build() {
            return new UpdateCollectionRequest(
                    id, name, description, translatedContent, parentId, additionalProperties);
        }
    }
}
