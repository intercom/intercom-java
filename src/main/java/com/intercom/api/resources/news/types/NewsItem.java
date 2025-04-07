/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.intercom.api.resources.news.types;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = NewsItem.Builder.class)
public final class NewsItem {
    private final String id;

    private final String workspaceId;

    private final String title;

    private final String body;

    private final int senderId;

    private final State state;

    private final Optional<List<NewsfeedAssignment>> newsfeedAssignments;

    private final Optional<List<Optional<String>>> labels;

    private final Optional<String> coverImageUrl;

    private final Optional<List<Optional<String>>> reactions;

    private final Optional<Boolean> deliverSilently;

    private final int createdAt;

    private final Optional<Integer> updatedAt;

    private final Map<String, Object> additionalProperties;

    private NewsItem(
            String id,
            String workspaceId,
            String title,
            String body,
            int senderId,
            State state,
            Optional<List<NewsfeedAssignment>> newsfeedAssignments,
            Optional<List<Optional<String>>> labels,
            Optional<String> coverImageUrl,
            Optional<List<Optional<String>>> reactions,
            Optional<Boolean> deliverSilently,
            int createdAt,
            Optional<Integer> updatedAt,
            Map<String, Object> additionalProperties) {
        this.id = id;
        this.workspaceId = workspaceId;
        this.title = title;
        this.body = body;
        this.senderId = senderId;
        this.state = state;
        this.newsfeedAssignments = newsfeedAssignments;
        this.labels = labels;
        this.coverImageUrl = coverImageUrl;
        this.reactions = reactions;
        this.deliverSilently = deliverSilently;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The type of object.
     */
    @JsonProperty("type")
    public String getType() {
        return "news-item";
    }

    /**
     * @return The unique identifier for the news item which is given by Intercom.
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * @return The id of the workspace which the news item belongs to.
     */
    @JsonProperty("workspace_id")
    public String getWorkspaceId() {
        return workspaceId;
    }

    /**
     * @return The title of the news item.
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * @return The news item body, which may contain HTML.
     */
    @JsonProperty("body")
    public String getBody() {
        return body;
    }

    /**
     * @return The id of the sender of the news item. Must be a teammate on the workspace.
     */
    @JsonProperty("sender_id")
    public int getSenderId() {
        return senderId;
    }

    /**
     * @return News items will not be visible to your users in the assigned newsfeeds until they are set live.
     */
    @JsonProperty("state")
    public State getState() {
        return state;
    }

    /**
     * @return A list of newsfeed_assignments to assign to the specified newsfeed.
     */
    @JsonProperty("newsfeed_assignments")
    public Optional<List<NewsfeedAssignment>> getNewsfeedAssignments() {
        return newsfeedAssignments;
    }

    /**
     * @return Label names displayed to users to categorize the news item.
     */
    @JsonProperty("labels")
    public Optional<List<Optional<String>>> getLabels() {
        return labels;
    }

    /**
     * @return URL of the image used as cover. Must have .jpg or .png extension.
     */
    @JsonProperty("cover_image_url")
    public Optional<String> getCoverImageUrl() {
        return coverImageUrl;
    }

    /**
     * @return Ordered list of emoji reactions to the news item. When empty, reactions are disabled.
     */
    @JsonProperty("reactions")
    public Optional<List<Optional<String>>> getReactions() {
        return reactions;
    }

    /**
     * @return When set to true, the news item will appear in the messenger newsfeed without showing a notification badge.
     */
    @JsonProperty("deliver_silently")
    public Optional<Boolean> getDeliverSilently() {
        return deliverSilently;
    }

    /**
     * @return Timestamp for when the news item was created.
     */
    @JsonProperty("created_at")
    public int getCreatedAt() {
        return createdAt;
    }

    /**
     * @return Timestamp for when the news item was last updated.
     */
    @JsonProperty("updated_at")
    public Optional<Integer> getUpdatedAt() {
        return updatedAt;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof NewsItem && equalTo((NewsItem) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(NewsItem other) {
        return id.equals(other.id)
                && workspaceId.equals(other.workspaceId)
                && title.equals(other.title)
                && body.equals(other.body)
                && senderId == other.senderId
                && state.equals(other.state)
                && newsfeedAssignments.equals(other.newsfeedAssignments)
                && labels.equals(other.labels)
                && coverImageUrl.equals(other.coverImageUrl)
                && reactions.equals(other.reactions)
                && deliverSilently.equals(other.deliverSilently)
                && createdAt == other.createdAt
                && updatedAt.equals(other.updatedAt);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.workspaceId,
                this.title,
                this.body,
                this.senderId,
                this.state,
                this.newsfeedAssignments,
                this.labels,
                this.coverImageUrl,
                this.reactions,
                this.deliverSilently,
                this.createdAt,
                this.updatedAt);
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

        Builder from(NewsItem other);
    }

    public interface WorkspaceIdStage {
        TitleStage workspaceId(@NotNull String workspaceId);
    }

    public interface TitleStage {
        BodyStage title(@NotNull String title);
    }

    public interface BodyStage {
        SenderIdStage body(@NotNull String body);
    }

    public interface SenderIdStage {
        StateStage senderId(int senderId);
    }

    public interface StateStage {
        CreatedAtStage state(@NotNull State state);
    }

    public interface CreatedAtStage {
        _FinalStage createdAt(int createdAt);
    }

    public interface _FinalStage {
        NewsItem build();

        _FinalStage newsfeedAssignments(Optional<List<NewsfeedAssignment>> newsfeedAssignments);

        _FinalStage newsfeedAssignments(List<NewsfeedAssignment> newsfeedAssignments);

        _FinalStage labels(Optional<List<Optional<String>>> labels);

        _FinalStage labels(List<Optional<String>> labels);

        _FinalStage coverImageUrl(Optional<String> coverImageUrl);

        _FinalStage coverImageUrl(String coverImageUrl);

        _FinalStage reactions(Optional<List<Optional<String>>> reactions);

        _FinalStage reactions(List<Optional<String>> reactions);

        _FinalStage deliverSilently(Optional<Boolean> deliverSilently);

        _FinalStage deliverSilently(Boolean deliverSilently);

        _FinalStage updatedAt(Optional<Integer> updatedAt);

        _FinalStage updatedAt(Integer updatedAt);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements IdStage,
                    WorkspaceIdStage,
                    TitleStage,
                    BodyStage,
                    SenderIdStage,
                    StateStage,
                    CreatedAtStage,
                    _FinalStage {
        private String id;

        private String workspaceId;

        private String title;

        private String body;

        private int senderId;

        private State state;

        private int createdAt;

        private Optional<Integer> updatedAt = Optional.empty();

        private Optional<Boolean> deliverSilently = Optional.empty();

        private Optional<List<Optional<String>>> reactions = Optional.empty();

        private Optional<String> coverImageUrl = Optional.empty();

        private Optional<List<Optional<String>>> labels = Optional.empty();

        private Optional<List<NewsfeedAssignment>> newsfeedAssignments = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(NewsItem other) {
            id(other.getId());
            workspaceId(other.getWorkspaceId());
            title(other.getTitle());
            body(other.getBody());
            senderId(other.getSenderId());
            state(other.getState());
            newsfeedAssignments(other.getNewsfeedAssignments());
            labels(other.getLabels());
            coverImageUrl(other.getCoverImageUrl());
            reactions(other.getReactions());
            deliverSilently(other.getDeliverSilently());
            createdAt(other.getCreatedAt());
            updatedAt(other.getUpdatedAt());
            return this;
        }

        /**
         * <p>The unique identifier for the news item which is given by Intercom.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("id")
        public WorkspaceIdStage id(@NotNull String id) {
            this.id = Objects.requireNonNull(id, "id must not be null");
            return this;
        }

        /**
         * <p>The id of the workspace which the news item belongs to.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("workspace_id")
        public TitleStage workspaceId(@NotNull String workspaceId) {
            this.workspaceId = Objects.requireNonNull(workspaceId, "workspaceId must not be null");
            return this;
        }

        /**
         * <p>The title of the news item.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("title")
        public BodyStage title(@NotNull String title) {
            this.title = Objects.requireNonNull(title, "title must not be null");
            return this;
        }

        /**
         * <p>The news item body, which may contain HTML.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("body")
        public SenderIdStage body(@NotNull String body) {
            this.body = Objects.requireNonNull(body, "body must not be null");
            return this;
        }

        /**
         * <p>The id of the sender of the news item. Must be a teammate on the workspace.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("sender_id")
        public StateStage senderId(int senderId) {
            this.senderId = senderId;
            return this;
        }

        /**
         * <p>News items will not be visible to your users in the assigned newsfeeds until they are set live.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("state")
        public CreatedAtStage state(@NotNull State state) {
            this.state = Objects.requireNonNull(state, "state must not be null");
            return this;
        }

        /**
         * <p>Timestamp for when the news item was created.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("created_at")
        public _FinalStage createdAt(int createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * <p>Timestamp for when the news item was last updated.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage updatedAt(Integer updatedAt) {
            this.updatedAt = Optional.ofNullable(updatedAt);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "updated_at", nulls = Nulls.SKIP)
        public _FinalStage updatedAt(Optional<Integer> updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        /**
         * <p>When set to true, the news item will appear in the messenger newsfeed without showing a notification badge.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage deliverSilently(Boolean deliverSilently) {
            this.deliverSilently = Optional.ofNullable(deliverSilently);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "deliver_silently", nulls = Nulls.SKIP)
        public _FinalStage deliverSilently(Optional<Boolean> deliverSilently) {
            this.deliverSilently = deliverSilently;
            return this;
        }

        /**
         * <p>Ordered list of emoji reactions to the news item. When empty, reactions are disabled.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage reactions(List<Optional<String>> reactions) {
            this.reactions = Optional.ofNullable(reactions);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "reactions", nulls = Nulls.SKIP)
        public _FinalStage reactions(Optional<List<Optional<String>>> reactions) {
            this.reactions = reactions;
            return this;
        }

        /**
         * <p>URL of the image used as cover. Must have .jpg or .png extension.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage coverImageUrl(String coverImageUrl) {
            this.coverImageUrl = Optional.ofNullable(coverImageUrl);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "cover_image_url", nulls = Nulls.SKIP)
        public _FinalStage coverImageUrl(Optional<String> coverImageUrl) {
            this.coverImageUrl = coverImageUrl;
            return this;
        }

        /**
         * <p>Label names displayed to users to categorize the news item.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage labels(List<Optional<String>> labels) {
            this.labels = Optional.ofNullable(labels);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "labels", nulls = Nulls.SKIP)
        public _FinalStage labels(Optional<List<Optional<String>>> labels) {
            this.labels = labels;
            return this;
        }

        /**
         * <p>A list of newsfeed_assignments to assign to the specified newsfeed.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage newsfeedAssignments(List<NewsfeedAssignment> newsfeedAssignments) {
            this.newsfeedAssignments = Optional.ofNullable(newsfeedAssignments);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "newsfeed_assignments", nulls = Nulls.SKIP)
        public _FinalStage newsfeedAssignments(Optional<List<NewsfeedAssignment>> newsfeedAssignments) {
            this.newsfeedAssignments = newsfeedAssignments;
            return this;
        }

        @java.lang.Override
        public NewsItem build() {
            return new NewsItem(
                    id,
                    workspaceId,
                    title,
                    body,
                    senderId,
                    state,
                    newsfeedAssignments,
                    labels,
                    coverImageUrl,
                    reactions,
                    deliverSilently,
                    createdAt,
                    updatedAt,
                    additionalProperties);
        }
    }

    public enum State {
        DRAFT("draft"),

        LIVE("live");

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
