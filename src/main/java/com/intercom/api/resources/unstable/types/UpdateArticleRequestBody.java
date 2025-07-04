/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.intercom.api.resources.unstable.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.intercom.api.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = UpdateArticleRequestBody.Builder.class)
public final class UpdateArticleRequestBody {
    private final Optional<String> title;

    private final Optional<String> description;

    private final Optional<String> body;

    private final Optional<Integer> authorId;

    private final Optional<State> state;

    private final Optional<String> parentId;

    private final Optional<String> parentType;

    private final Optional<ArticleTranslatedContent> translatedContent;

    private final Map<String, Object> additionalProperties;

    private UpdateArticleRequestBody(
            Optional<String> title,
            Optional<String> description,
            Optional<String> body,
            Optional<Integer> authorId,
            Optional<State> state,
            Optional<String> parentId,
            Optional<String> parentType,
            Optional<ArticleTranslatedContent> translatedContent,
            Map<String, Object> additionalProperties) {
        this.title = title;
        this.description = description;
        this.body = body;
        this.authorId = authorId;
        this.state = state;
        this.parentId = parentId;
        this.parentType = parentType;
        this.translatedContent = translatedContent;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The title of the article.For multilingual articles, this will be the title of the default language's content.
     */
    @JsonProperty("title")
    public Optional<String> getTitle() {
        return title;
    }

    /**
     * @return The description of the article. For multilingual articles, this will be the description of the default language's content.
     */
    @JsonProperty("description")
    public Optional<String> getDescription() {
        return description;
    }

    /**
     * @return The content of the article. For multilingual articles, this will be the body of the default language's content.
     */
    @JsonProperty("body")
    public Optional<String> getBody() {
        return body;
    }

    /**
     * @return The id of the author of the article. For multilingual articles, this will be the id of the author of the default language's content. Must be a teammate on the help center's workspace.
     */
    @JsonProperty("author_id")
    public Optional<Integer> getAuthorId() {
        return authorId;
    }

    /**
     * @return Whether the article will be <code>published</code> or will be a <code>draft</code>. Defaults to draft. For multilingual articles, this will be the state of the default language's content.
     */
    @JsonProperty("state")
    public Optional<State> getState() {
        return state;
    }

    /**
     * @return The id of the article's parent collection or section. An article without this field stands alone.
     */
    @JsonProperty("parent_id")
    public Optional<String> getParentId() {
        return parentId;
    }

    /**
     * @return The type of parent, which can either be a <code>collection</code> or <code>section</code>.
     */
    @JsonProperty("parent_type")
    public Optional<String> getParentType() {
        return parentType;
    }

    @JsonProperty("translated_content")
    public Optional<ArticleTranslatedContent> getTranslatedContent() {
        return translatedContent;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UpdateArticleRequestBody && equalTo((UpdateArticleRequestBody) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(UpdateArticleRequestBody other) {
        return title.equals(other.title)
                && description.equals(other.description)
                && body.equals(other.body)
                && authorId.equals(other.authorId)
                && state.equals(other.state)
                && parentId.equals(other.parentId)
                && parentType.equals(other.parentType)
                && translatedContent.equals(other.translatedContent);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.title,
                this.description,
                this.body,
                this.authorId,
                this.state,
                this.parentId,
                this.parentType,
                this.translatedContent);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> title = Optional.empty();

        private Optional<String> description = Optional.empty();

        private Optional<String> body = Optional.empty();

        private Optional<Integer> authorId = Optional.empty();

        private Optional<State> state = Optional.empty();

        private Optional<String> parentId = Optional.empty();

        private Optional<String> parentType = Optional.empty();

        private Optional<ArticleTranslatedContent> translatedContent = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(UpdateArticleRequestBody other) {
            title(other.getTitle());
            description(other.getDescription());
            body(other.getBody());
            authorId(other.getAuthorId());
            state(other.getState());
            parentId(other.getParentId());
            parentType(other.getParentType());
            translatedContent(other.getTranslatedContent());
            return this;
        }

        /**
         * <p>The title of the article.For multilingual articles, this will be the title of the default language's content.</p>
         */
        @JsonSetter(value = "title", nulls = Nulls.SKIP)
        public Builder title(Optional<String> title) {
            this.title = title;
            return this;
        }

        public Builder title(String title) {
            this.title = Optional.ofNullable(title);
            return this;
        }

        /**
         * <p>The description of the article. For multilingual articles, this will be the description of the default language's content.</p>
         */
        @JsonSetter(value = "description", nulls = Nulls.SKIP)
        public Builder description(Optional<String> description) {
            this.description = description;
            return this;
        }

        public Builder description(String description) {
            this.description = Optional.ofNullable(description);
            return this;
        }

        /**
         * <p>The content of the article. For multilingual articles, this will be the body of the default language's content.</p>
         */
        @JsonSetter(value = "body", nulls = Nulls.SKIP)
        public Builder body(Optional<String> body) {
            this.body = body;
            return this;
        }

        public Builder body(String body) {
            this.body = Optional.ofNullable(body);
            return this;
        }

        /**
         * <p>The id of the author of the article. For multilingual articles, this will be the id of the author of the default language's content. Must be a teammate on the help center's workspace.</p>
         */
        @JsonSetter(value = "author_id", nulls = Nulls.SKIP)
        public Builder authorId(Optional<Integer> authorId) {
            this.authorId = authorId;
            return this;
        }

        public Builder authorId(Integer authorId) {
            this.authorId = Optional.ofNullable(authorId);
            return this;
        }

        /**
         * <p>Whether the article will be <code>published</code> or will be a <code>draft</code>. Defaults to draft. For multilingual articles, this will be the state of the default language's content.</p>
         */
        @JsonSetter(value = "state", nulls = Nulls.SKIP)
        public Builder state(Optional<State> state) {
            this.state = state;
            return this;
        }

        public Builder state(State state) {
            this.state = Optional.ofNullable(state);
            return this;
        }

        /**
         * <p>The id of the article's parent collection or section. An article without this field stands alone.</p>
         */
        @JsonSetter(value = "parent_id", nulls = Nulls.SKIP)
        public Builder parentId(Optional<String> parentId) {
            this.parentId = parentId;
            return this;
        }

        public Builder parentId(String parentId) {
            this.parentId = Optional.ofNullable(parentId);
            return this;
        }

        /**
         * <p>The type of parent, which can either be a <code>collection</code> or <code>section</code>.</p>
         */
        @JsonSetter(value = "parent_type", nulls = Nulls.SKIP)
        public Builder parentType(Optional<String> parentType) {
            this.parentType = parentType;
            return this;
        }

        public Builder parentType(String parentType) {
            this.parentType = Optional.ofNullable(parentType);
            return this;
        }

        @JsonSetter(value = "translated_content", nulls = Nulls.SKIP)
        public Builder translatedContent(Optional<ArticleTranslatedContent> translatedContent) {
            this.translatedContent = translatedContent;
            return this;
        }

        public Builder translatedContent(ArticleTranslatedContent translatedContent) {
            this.translatedContent = Optional.ofNullable(translatedContent);
            return this;
        }

        public UpdateArticleRequestBody build() {
            return new UpdateArticleRequestBody(
                    title,
                    description,
                    body,
                    authorId,
                    state,
                    parentId,
                    parentType,
                    translatedContent,
                    additionalProperties);
        }
    }

    public static final class State {
        public static final State PUBLISHED = new State(Value.PUBLISHED, "published");

        public static final State DRAFT = new State(Value.DRAFT, "draft");

        private final Value value;

        private final String string;

        State(Value value, String string) {
            this.value = value;
            this.string = string;
        }

        public Value getEnumValue() {
            return value;
        }

        @java.lang.Override
        @JsonValue
        public String toString() {
            return this.string;
        }

        @java.lang.Override
        public boolean equals(Object other) {
            return (this == other) || (other instanceof State && this.string.equals(((State) other).string));
        }

        @java.lang.Override
        public int hashCode() {
            return this.string.hashCode();
        }

        public <T> T visit(Visitor<T> visitor) {
            switch (value) {
                case PUBLISHED:
                    return visitor.visitPublished();
                case DRAFT:
                    return visitor.visitDraft();
                case UNKNOWN:
                default:
                    return visitor.visitUnknown(string);
            }
        }

        @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
        public static State valueOf(String value) {
            switch (value) {
                case "published":
                    return PUBLISHED;
                case "draft":
                    return DRAFT;
                default:
                    return new State(Value.UNKNOWN, value);
            }
        }

        public enum Value {
            PUBLISHED,

            DRAFT,

            UNKNOWN
        }

        public interface Visitor<T> {
            T visitPublished();

            T visitDraft();

            T visitUnknown(String unknownType);
        }
    }
}
