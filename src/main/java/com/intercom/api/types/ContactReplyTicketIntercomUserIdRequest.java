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
@JsonDeserialize(builder = ContactReplyTicketIntercomUserIdRequest.Builder.class)
public final class ContactReplyTicketIntercomUserIdRequest implements IContactReplyBaseRequest {
    private final String body;

    private final Optional<Integer> createdAt;

    private final Optional<List<String>> attachmentUrls;

    private final String intercomUserId;

    private final Map<String, Object> additionalProperties;

    private ContactReplyTicketIntercomUserIdRequest(
            String body,
            Optional<Integer> createdAt,
            Optional<List<String>> attachmentUrls,
            String intercomUserId,
            Map<String, Object> additionalProperties) {
        this.body = body;
        this.createdAt = createdAt;
        this.attachmentUrls = attachmentUrls;
        this.intercomUserId = intercomUserId;
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
     * @return The identifier for the contact as given by Intercom.
     */
    @JsonProperty("intercom_user_id")
    public String getIntercomUserId() {
        return intercomUserId;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ContactReplyTicketIntercomUserIdRequest
                && equalTo((ContactReplyTicketIntercomUserIdRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ContactReplyTicketIntercomUserIdRequest other) {
        return body.equals(other.body)
                && createdAt.equals(other.createdAt)
                && attachmentUrls.equals(other.attachmentUrls)
                && intercomUserId.equals(other.intercomUserId);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.body, this.createdAt, this.attachmentUrls, this.intercomUserId);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static BodyStage builder() {
        return new Builder();
    }

    public interface BodyStage {
        IntercomUserIdStage body(@NotNull String body);

        Builder from(ContactReplyTicketIntercomUserIdRequest other);
    }

    public interface IntercomUserIdStage {
        _FinalStage intercomUserId(@NotNull String intercomUserId);
    }

    public interface _FinalStage {
        ContactReplyTicketIntercomUserIdRequest build();

        _FinalStage createdAt(Optional<Integer> createdAt);

        _FinalStage createdAt(Integer createdAt);

        _FinalStage attachmentUrls(Optional<List<String>> attachmentUrls);

        _FinalStage attachmentUrls(List<String> attachmentUrls);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements BodyStage, IntercomUserIdStage, _FinalStage {
        private String body;

        private String intercomUserId;

        private Optional<List<String>> attachmentUrls = Optional.empty();

        private Optional<Integer> createdAt = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(ContactReplyTicketIntercomUserIdRequest other) {
            body(other.getBody());
            createdAt(other.getCreatedAt());
            attachmentUrls(other.getAttachmentUrls());
            intercomUserId(other.getIntercomUserId());
            return this;
        }

        /**
         * <p>The text body of the comment.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("body")
        public IntercomUserIdStage body(@NotNull String body) {
            this.body = Objects.requireNonNull(body, "body must not be null");
            return this;
        }

        /**
         * <p>The identifier for the contact as given by Intercom.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("intercom_user_id")
        public _FinalStage intercomUserId(@NotNull String intercomUserId) {
            this.intercomUserId = Objects.requireNonNull(intercomUserId, "intercomUserId must not be null");
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
        public ContactReplyTicketIntercomUserIdRequest build() {
            return new ContactReplyTicketIntercomUserIdRequest(
                    body, createdAt, attachmentUrls, intercomUserId, additionalProperties);
        }
    }
}
