/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.intercom.api.resources.articles.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.intercom.api.core.ObjectMappers;
import com.intercom.api.types.ArticleTranslatedContent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = ArticleListItem.Builder.class)
public final class ArticleListItem implements IArticleListItem {
    private final Optional<String> type;

    private final String id;

    private final String workspaceId;

    private final String title;

    private final Optional<String> description;

    private final Optional<String> body;

    private final int authorId;

    private final State state;

    private final int createdAt;

    private final int updatedAt;

    private final Optional<String> url;

    private final Optional<Integer> parentId;

    private final Optional<List<Integer>> parentIds;

    private final Optional<String> parentType;

    private final String defaultLocale;

    private final ArticleTranslatedContent translatedContent;

    private final Map<String, Object> additionalProperties;

    private ArticleListItem(
            Optional<String> type,
            String id,
            String workspaceId,
            String title,
            Optional<String> description,
            Optional<String> body,
            int authorId,
            State state,
            int createdAt,
            int updatedAt,
            Optional<String> url,
            Optional<Integer> parentId,
            Optional<List<Integer>> parentIds,
            Optional<String> parentType,
            String defaultLocale,
            ArticleTranslatedContent translatedContent,
            Map<String, Object> additionalProperties) {
        this.type = type;
        this.id = id;
        this.workspaceId = workspaceId;
        this.title = title;
        this.description = description;
        this.body = body;
        this.authorId = authorId;
        this.state = state;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.url = url;
        this.parentId = parentId;
        this.parentIds = parentIds;
        this.parentType = parentType;
        this.defaultLocale = defaultLocale;
        this.translatedContent = translatedContent;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The type of object - <code>article</code>.
     */
    @JsonProperty("type")
    public Optional<String> getType() {
        return type;
    }

    /**
     * @return The unique identifier for the article which is given by Intercom.
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * @return The id of the workspace which the article belongs to.
     */
    @JsonProperty("workspace_id")
    public String getWorkspaceId() {
        return workspaceId;
    }

    /**
     * @return The title of the article. For multilingual articles, this will be the title of the default language's content.
     */
    @JsonProperty("title")
    public String getTitle() {
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
     * @return The body of the article in HTML. For multilingual articles, this will be the body of the default language's content.
     */
    @JsonProperty("body")
    public Optional<String> getBody() {
        return body;
    }

    /**
     * @return The id of the author of the article. For multilingual articles, this will be the id of the author of the default language's content. Must be a teammate on the help center's workspace.
     */
    @JsonProperty("author_id")
    public int getAuthorId() {
        return authorId;
    }

    /**
     * @return Whether the article is <code>published</code> or is a <code>draft</code>. For multilingual articles, this will be the state of the default language's content.
     */
    @JsonProperty("state")
    public State getState() {
        return state;
    }

    /**
     * @return The time when the article was created. For multilingual articles, this will be the timestamp of creation of the default language's content in seconds.
     */
    @JsonProperty("created_at")
    public int getCreatedAt() {
        return createdAt;
    }

    /**
     * @return The time when the article was last updated. For multilingual articles, this will be the timestamp of last update of the default language's content in seconds.
     */
    @JsonProperty("updated_at")
    public int getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @return The URL of the article. For multilingual articles, this will be the URL of the default language's content.
     */
    @JsonProperty("url")
    public Optional<String> getUrl() {
        return url;
    }

    /**
     * @return The id of the article's parent collection or section. An article without this field stands alone.
     */
    @JsonProperty("parent_id")
    public Optional<Integer> getParentId() {
        return parentId;
    }

    /**
     * @return The ids of the article's parent collections or sections. An article without this field stands alone.
     */
    @JsonProperty("parent_ids")
    public Optional<List<Integer>> getParentIds() {
        return parentIds;
    }

    /**
     * @return The type of parent, which can either be a <code>collection</code> or <code>section</code>.
     */
    @JsonProperty("parent_type")
    public Optional<String> getParentType() {
        return parentType;
    }

    /**
     * @return The default locale of the help center. This field is only returned for multilingual help centers.
     */
    @JsonProperty("default_locale")
    public String getDefaultLocale() {
        return defaultLocale;
    }

    @JsonProperty("translated_content")
    public ArticleTranslatedContent getTranslatedContent() {
        return translatedContent;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ArticleListItem && equalTo((ArticleListItem) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ArticleListItem other) {
        return type.equals(other.type)
                && id.equals(other.id)
                && workspaceId.equals(other.workspaceId)
                && title.equals(other.title)
                && description.equals(other.description)
                && body.equals(other.body)
                && authorId == other.authorId
                && state.equals(other.state)
                && createdAt == other.createdAt
                && updatedAt == other.updatedAt
                && url.equals(other.url)
                && parentId.equals(other.parentId)
                && parentIds.equals(other.parentIds)
                && parentType.equals(other.parentType)
                && defaultLocale.equals(other.defaultLocale)
                && translatedContent.equals(other.translatedContent);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.type,
                this.id,
                this.workspaceId,
                this.title,
                this.description,
                this.body,
                this.authorId,
                this.state,
                this.createdAt,
                this.updatedAt,
                this.url,
                this.parentId,
                this.parentIds,
                this.parentType,
                this.defaultLocale,
                this.translatedContent);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IdStage builder() {
        return new Builder();
    }

    public interface IdStage {
        WorkspaceIdStage id(@NotNull String id);

        Builder from(ArticleListItem other);
    }

    public interface WorkspaceIdStage {
        TitleStage workspaceId(@NotNull String workspaceId);
    }

    public interface TitleStage {
        AuthorIdStage title(@NotNull String title);
    }

    public interface AuthorIdStage {
        StateStage authorId(int authorId);
    }

    public interface StateStage {
        CreatedAtStage state(@NotNull State state);
    }

    public interface CreatedAtStage {
        UpdatedAtStage createdAt(int createdAt);
    }

    public interface UpdatedAtStage {
        DefaultLocaleStage updatedAt(int updatedAt);
    }

    public interface DefaultLocaleStage {
        TranslatedContentStage defaultLocale(@NotNull String defaultLocale);
    }

    public interface TranslatedContentStage {
        _FinalStage translatedContent(@NotNull ArticleTranslatedContent translatedContent);
    }

    public interface _FinalStage {
        ArticleListItem build();

        _FinalStage type(Optional<String> type);

        _FinalStage type(String type);

        _FinalStage description(Optional<String> description);

        _FinalStage description(String description);

        _FinalStage body(Optional<String> body);

        _FinalStage body(String body);

        _FinalStage url(Optional<String> url);

        _FinalStage url(String url);

        _FinalStage parentId(Optional<Integer> parentId);

        _FinalStage parentId(Integer parentId);

        _FinalStage parentIds(Optional<List<Integer>> parentIds);

        _FinalStage parentIds(List<Integer> parentIds);

        _FinalStage parentType(Optional<String> parentType);

        _FinalStage parentType(String parentType);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements IdStage,
                    WorkspaceIdStage,
                    TitleStage,
                    AuthorIdStage,
                    StateStage,
                    CreatedAtStage,
                    UpdatedAtStage,
                    DefaultLocaleStage,
                    TranslatedContentStage,
                    _FinalStage {
        private String id;

        private String workspaceId;

        private String title;

        private int authorId;

        private State state;

        private int createdAt;

        private int updatedAt;

        private String defaultLocale;

        private ArticleTranslatedContent translatedContent;

        private Optional<String> parentType = Optional.empty();

        private Optional<List<Integer>> parentIds = Optional.empty();

        private Optional<Integer> parentId = Optional.empty();

        private Optional<String> url = Optional.empty();

        private Optional<String> body = Optional.empty();

        private Optional<String> description = Optional.empty();

        private Optional<String> type = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(ArticleListItem other) {
            type(other.getType());
            id(other.getId());
            workspaceId(other.getWorkspaceId());
            title(other.getTitle());
            description(other.getDescription());
            body(other.getBody());
            authorId(other.getAuthorId());
            state(other.getState());
            createdAt(other.getCreatedAt());
            updatedAt(other.getUpdatedAt());
            url(other.getUrl());
            parentId(other.getParentId());
            parentIds(other.getParentIds());
            parentType(other.getParentType());
            defaultLocale(other.getDefaultLocale());
            translatedContent(other.getTranslatedContent());
            return this;
        }

        /**
         * <p>The unique identifier for the article which is given by Intercom.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("id")
        public WorkspaceIdStage id(@NotNull String id) {
            this.id = Objects.requireNonNull(id, "id must not be null");
            return this;
        }

        /**
         * <p>The id of the workspace which the article belongs to.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("workspace_id")
        public TitleStage workspaceId(@NotNull String workspaceId) {
            this.workspaceId = Objects.requireNonNull(workspaceId, "workspaceId must not be null");
            return this;
        }

        /**
         * <p>The title of the article. For multilingual articles, this will be the title of the default language's content.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("title")
        public AuthorIdStage title(@NotNull String title) {
            this.title = Objects.requireNonNull(title, "title must not be null");
            return this;
        }

        /**
         * <p>The id of the author of the article. For multilingual articles, this will be the id of the author of the default language's content. Must be a teammate on the help center's workspace.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("author_id")
        public StateStage authorId(int authorId) {
            this.authorId = authorId;
            return this;
        }

        /**
         * <p>Whether the article is <code>published</code> or is a <code>draft</code>. For multilingual articles, this will be the state of the default language's content.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("state")
        public CreatedAtStage state(@NotNull State state) {
            this.state = Objects.requireNonNull(state, "state must not be null");
            return this;
        }

        /**
         * <p>The time when the article was created. For multilingual articles, this will be the timestamp of creation of the default language's content in seconds.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("created_at")
        public UpdatedAtStage createdAt(int createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * <p>The time when the article was last updated. For multilingual articles, this will be the timestamp of last update of the default language's content in seconds.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("updated_at")
        public DefaultLocaleStage updatedAt(int updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        /**
         * <p>The default locale of the help center. This field is only returned for multilingual help centers.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("default_locale")
        public TranslatedContentStage defaultLocale(@NotNull String defaultLocale) {
            this.defaultLocale = Objects.requireNonNull(defaultLocale, "defaultLocale must not be null");
            return this;
        }

        @java.lang.Override
        @JsonSetter("translated_content")
        public _FinalStage translatedContent(@NotNull ArticleTranslatedContent translatedContent) {
            this.translatedContent = Objects.requireNonNull(translatedContent, "translatedContent must not be null");
            return this;
        }

        /**
         * <p>The type of parent, which can either be a <code>collection</code> or <code>section</code>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage parentType(String parentType) {
            this.parentType = Optional.ofNullable(parentType);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "parent_type", nulls = Nulls.SKIP)
        public _FinalStage parentType(Optional<String> parentType) {
            this.parentType = parentType;
            return this;
        }

        /**
         * <p>The ids of the article's parent collections or sections. An article without this field stands alone.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage parentIds(List<Integer> parentIds) {
            this.parentIds = Optional.ofNullable(parentIds);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "parent_ids", nulls = Nulls.SKIP)
        public _FinalStage parentIds(Optional<List<Integer>> parentIds) {
            this.parentIds = parentIds;
            return this;
        }

        /**
         * <p>The id of the article's parent collection or section. An article without this field stands alone.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage parentId(Integer parentId) {
            this.parentId = Optional.ofNullable(parentId);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "parent_id", nulls = Nulls.SKIP)
        public _FinalStage parentId(Optional<Integer> parentId) {
            this.parentId = parentId;
            return this;
        }

        /**
         * <p>The URL of the article. For multilingual articles, this will be the URL of the default language's content.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage url(String url) {
            this.url = Optional.ofNullable(url);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "url", nulls = Nulls.SKIP)
        public _FinalStage url(Optional<String> url) {
            this.url = url;
            return this;
        }

        /**
         * <p>The body of the article in HTML. For multilingual articles, this will be the body of the default language's content.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage body(String body) {
            this.body = Optional.ofNullable(body);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "body", nulls = Nulls.SKIP)
        public _FinalStage body(Optional<String> body) {
            this.body = body;
            return this;
        }

        /**
         * <p>The description of the article. For multilingual articles, this will be the description of the default language's content.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage description(String description) {
            this.description = Optional.ofNullable(description);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "description", nulls = Nulls.SKIP)
        public _FinalStage description(Optional<String> description) {
            this.description = description;
            return this;
        }

        /**
         * <p>The type of object - <code>article</code>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage type(String type) {
            this.type = Optional.ofNullable(type);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "type", nulls = Nulls.SKIP)
        public _FinalStage type(Optional<String> type) {
            this.type = type;
            return this;
        }

        @java.lang.Override
        public ArticleListItem build() {
            return new ArticleListItem(
                    type,
                    id,
                    workspaceId,
                    title,
                    description,
                    body,
                    authorId,
                    state,
                    createdAt,
                    updatedAt,
                    url,
                    parentId,
                    parentIds,
                    parentType,
                    defaultLocale,
                    translatedContent,
                    additionalProperties);
        }
    }

    public enum State {
        PUBLISHED("published"),

        DRAFT("draft");

        private final String value;

        State(String value) {
            this.value = value;
        }

        @JsonValue
        @java.lang.Override
        public String toString() {
            return this.value;
        }
    }
}
