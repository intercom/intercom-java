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
@JsonDeserialize(builder = ContactReplyUserIdRequest.Builder.class)
public final class ContactReplyUserIdRequest implements IContactReplyBaseRequest {
    private final String body;

    private final Optional<Integer> createdAt;

    private final Optional<List<String>> attachmentUrls;

    private final String userId;

    private final Optional<List<ConversationAttachmentFiles>> attachmentFiles;

    private final Map<String, Object> additionalProperties;

    private ContactReplyUserIdRequest(
            String body,
            Optional<Integer> createdAt,
            Optional<List<String>> attachmentUrls,
            String userId,
            Optional<List<ConversationAttachmentFiles>> attachmentFiles,
            Map<String, Object> additionalProperties) {
        this.body = body;
        this.createdAt = createdAt;
        this.attachmentUrls = attachmentUrls;
        this.userId = userId;
        this.attachmentFiles = attachmentFiles;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("message_type")
    public String getMessageType() {
        return "comment";
    }

    @JsonProperty("type")
    public String getType() {
        return "user";
    }

    /**
     * @return The text body of the comment.
     */
    @JsonProperty("body")
    public String getBody() {
        return body;
    }

    /**
     * @return The time the reply was created. If not provided, the current time will be used.
     */
    @JsonProperty("created_at")
    public Optional<Integer> getCreatedAt() {
        return createdAt;
    }

    /**
     * @return A list of image URLs that will be added as attachments. You can include up to 10 URLs.
     */
    @JsonProperty("attachment_urls")
    public Optional<List<String>> getAttachmentUrls() {
        return attachmentUrls;
    }

    /**
     * @return The external_id you have defined for the contact.
     */
    @JsonProperty("user_id")
    public String getUserId() {
        return userId;
    }

    /**
     * @return A list of files that will be added as attachments. You can include up to 10 files.
     */
    @JsonProperty("attachment_files")
    public Optional<List<ConversationAttachmentFiles>> getAttachmentFiles() {
        return attachmentFiles;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ContactReplyUserIdRequest && equalTo((ContactReplyUserIdRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ContactReplyUserIdRequest other) {
        return body.equals(other.body)
                && createdAt.equals(other.createdAt)
                && attachmentUrls.equals(other.attachmentUrls)
                && userId.equals(other.userId)
                && attachmentFiles.equals(other.attachmentFiles);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.body, this.createdAt, this.attachmentUrls, this.userId, this.attachmentFiles);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static BodyStage builder() {
        return new Builder();
    }

    public interface BodyStage {
        UserIdStage body(@NotNull String body);

        Builder from(ContactReplyUserIdRequest other);
    }

    public interface UserIdStage {
        _FinalStage userId(@NotNull String userId);
    }

    public interface _FinalStage {
        ContactReplyUserIdRequest build();

        _FinalStage createdAt(Optional<Integer> createdAt);

        _FinalStage createdAt(Integer createdAt);

        _FinalStage attachmentUrls(Optional<List<String>> attachmentUrls);

        _FinalStage attachmentUrls(List<String> attachmentUrls);

        _FinalStage attachmentFiles(Optional<List<ConversationAttachmentFiles>> attachmentFiles);

        _FinalStage attachmentFiles(List<ConversationAttachmentFiles> attachmentFiles);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements BodyStage, UserIdStage, _FinalStage {
        private String body;

        private String userId;

        private Optional<List<ConversationAttachmentFiles>> attachmentFiles = Optional.empty();

        private Optional<List<String>> attachmentUrls = Optional.empty();

        private Optional<Integer> createdAt = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(ContactReplyUserIdRequest other) {
            body(other.getBody());
            createdAt(other.getCreatedAt());
            attachmentUrls(other.getAttachmentUrls());
            userId(other.getUserId());
            attachmentFiles(other.getAttachmentFiles());
            return this;
        }

        /**
         * <p>The text body of the comment.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("body")
        public UserIdStage body(@NotNull String body) {
            this.body = Objects.requireNonNull(body, "body must not be null");
            return this;
        }

        /**
         * <p>The external_id you have defined for the contact.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("user_id")
        public _FinalStage userId(@NotNull String userId) {
            this.userId = Objects.requireNonNull(userId, "userId must not be null");
            return this;
        }

        /**
         * <p>A list of files that will be added as attachments. You can include up to 10 files.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage attachmentFiles(List<ConversationAttachmentFiles> attachmentFiles) {
            this.attachmentFiles = Optional.ofNullable(attachmentFiles);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "attachment_files", nulls = Nulls.SKIP)
        public _FinalStage attachmentFiles(Optional<List<ConversationAttachmentFiles>> attachmentFiles) {
            this.attachmentFiles = attachmentFiles;
            return this;
        }

        /**
         * <p>A list of image URLs that will be added as attachments. You can include up to 10 URLs.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage attachmentUrls(List<String> attachmentUrls) {
            this.attachmentUrls = Optional.ofNullable(attachmentUrls);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "attachment_urls", nulls = Nulls.SKIP)
        public _FinalStage attachmentUrls(Optional<List<String>> attachmentUrls) {
            this.attachmentUrls = attachmentUrls;
            return this;
        }

        /**
         * <p>The time the reply was created. If not provided, the current time will be used.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage createdAt(Integer createdAt) {
            this.createdAt = Optional.ofNullable(createdAt);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "created_at", nulls = Nulls.SKIP)
        public _FinalStage createdAt(Optional<Integer> createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        @java.lang.Override
        public ContactReplyUserIdRequest build() {
            return new ContactReplyUserIdRequest(
                    body, createdAt, attachmentUrls, userId, attachmentFiles, additionalProperties);
        }
    }
}
