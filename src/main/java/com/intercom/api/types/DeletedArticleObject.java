/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.intercom.api.types;

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
@JsonDeserialize(builder = DeletedArticleObject.Builder.class)
public final class DeletedArticleObject {
    private final String id;

    private final boolean deleted;

    private final Map<String, Object> additionalProperties;

    private DeletedArticleObject(String id, boolean deleted, Map<String, Object> additionalProperties) {
        this.id = id;
        this.deleted = deleted;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The unique identifier for the article which you provided in the URL.
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * @return The type of object which was deleted. - article
     */
    @JsonProperty("object")
    public String getObject() {
        return "article";
    }

    /**
     * @return Whether the article was deleted successfully or not.
     */
    @JsonProperty("deleted")
    public boolean getDeleted() {
        return deleted;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof DeletedArticleObject && equalTo((DeletedArticleObject) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(DeletedArticleObject other) {
        return id.equals(other.id) && deleted == other.deleted;
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.id, this.deleted);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IdStage builder() {
        return new Builder();
    }

    public interface IdStage {
        DeletedStage id(@NotNull String id);

        Builder from(DeletedArticleObject other);
    }

    public interface DeletedStage {
        _FinalStage deleted(boolean deleted);
    }

    public interface _FinalStage {
        DeletedArticleObject build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements IdStage, DeletedStage, _FinalStage {
        private String id;

        private boolean deleted;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(DeletedArticleObject other) {
            id(other.getId());
            deleted(other.getDeleted());
            return this;
        }

        /**
         * <p>The unique identifier for the article which you provided in the URL.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("id")
        public DeletedStage id(@NotNull String id) {
            this.id = Objects.requireNonNull(id, "id must not be null");
            return this;
        }

        /**
         * <p>Whether the article was deleted successfully or not.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("deleted")
        public _FinalStage deleted(boolean deleted) {
            this.deleted = deleted;
            return this;
        }

        @java.lang.Override
        public DeletedArticleObject build() {
            return new DeletedArticleObject(id, deleted, additionalProperties);
        }
    }
}
