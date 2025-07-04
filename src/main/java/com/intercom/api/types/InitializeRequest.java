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
import com.intercom.api.resources.admins.types.Admin;
import com.intercom.api.resources.contacts.types.Contact;
import com.intercom.api.resources.conversations.types.Conversation;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = InitializeRequest.Builder.class)
public final class InitializeRequest {
    private final String workspaceId;

    private final String workspaceRegion;

    private final Admin admin;

    private final Map<String, Object> cardCreationOptions;

    private final Context context;

    private final Conversation conversation;

    private final Contact contact;

    private final Map<String, Object> additionalProperties;

    private InitializeRequest(
            String workspaceId,
            String workspaceRegion,
            Admin admin,
            Map<String, Object> cardCreationOptions,
            Context context,
            Conversation conversation,
            Contact contact,
            Map<String, Object> additionalProperties) {
        this.workspaceId = workspaceId;
        this.workspaceRegion = workspaceRegion;
        this.admin = admin;
        this.cardCreationOptions = cardCreationOptions;
        this.context = context;
        this.conversation = conversation;
        this.contact = contact;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The workspace ID of the teammate. Attribute is <code>app_id</code> for V1.2 and below.
     */
    @JsonProperty("workspace_id")
    public String getWorkspaceId() {
        return workspaceId;
    }

    /**
     * @return The Intercom hosted region that this app is located in.
     */
    @JsonProperty("workspace_region")
    public String getWorkspaceRegion() {
        return workspaceRegion;
    }

    /**
     * @return The Intercom teammate viewing the conversation.
     */
    @JsonProperty("admin")
    public Admin getAdmin() {
        return admin;
    }

    /**
     * @return Key-value pairs which were given as results in response to the Configure request.
     */
    @JsonProperty("card_creation_options")
    public Map<String, Object> getCardCreationOptions() {
        return cardCreationOptions;
    }

    /**
     * @return The context of where the app is added, where the user last visited, and information on the Messenger settings.
     */
    @JsonProperty("context")
    public Context getContext() {
        return context;
    }

    /**
     * @return The conversation your app is being shown for.
     */
    @JsonProperty("conversation")
    public Conversation getConversation() {
        return conversation;
    }

    /**
     * @return The contact which is currently being viewed by the teammate in the conversation details panel. We send an individual initialize request for each customer when it's a group conversation.
     */
    @JsonProperty("contact")
    public Contact getContact() {
        return contact;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof InitializeRequest && equalTo((InitializeRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(InitializeRequest other) {
        return workspaceId.equals(other.workspaceId)
                && workspaceRegion.equals(other.workspaceRegion)
                && admin.equals(other.admin)
                && cardCreationOptions.equals(other.cardCreationOptions)
                && context.equals(other.context)
                && conversation.equals(other.conversation)
                && contact.equals(other.contact);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.workspaceId,
                this.workspaceRegion,
                this.admin,
                this.cardCreationOptions,
                this.context,
                this.conversation,
                this.contact);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static WorkspaceIdStage builder() {
        return new Builder();
    }

    public interface WorkspaceIdStage {
        /**
         * The workspace ID of the teammate. Attribute is `app_id` for V1.2 and below.
         */
        WorkspaceRegionStage workspaceId(@NotNull String workspaceId);

        Builder from(InitializeRequest other);
    }

    public interface WorkspaceRegionStage {
        /**
         * The Intercom hosted region that this app is located in.
         */
        AdminStage workspaceRegion(@NotNull String workspaceRegion);
    }

    public interface AdminStage {
        /**
         * The Intercom teammate viewing the conversation.
         */
        ContextStage admin(@NotNull Admin admin);
    }

    public interface ContextStage {
        /**
         * The context of where the app is added, where the user last visited, and information on the Messenger settings.
         */
        ConversationStage context(@NotNull Context context);
    }

    public interface ConversationStage {
        /**
         * The conversation your app is being shown for.
         */
        ContactStage conversation(@NotNull Conversation conversation);
    }

    public interface ContactStage {
        /**
         * The contact which is currently being viewed by the teammate in the conversation details panel. We send an individual initialize request for each customer when it's a group conversation.
         */
        _FinalStage contact(@NotNull Contact contact);
    }

    public interface _FinalStage {
        InitializeRequest build();

        /**
         * <p>Key-value pairs which were given as results in response to the Configure request.</p>
         */
        _FinalStage cardCreationOptions(Map<String, Object> cardCreationOptions);

        _FinalStage putAllCardCreationOptions(Map<String, Object> cardCreationOptions);

        _FinalStage cardCreationOptions(String key, Object value);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements WorkspaceIdStage,
                    WorkspaceRegionStage,
                    AdminStage,
                    ContextStage,
                    ConversationStage,
                    ContactStage,
                    _FinalStage {
        private String workspaceId;

        private String workspaceRegion;

        private Admin admin;

        private Context context;

        private Conversation conversation;

        private Contact contact;

        private Map<String, Object> cardCreationOptions = new LinkedHashMap<>();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(InitializeRequest other) {
            workspaceId(other.getWorkspaceId());
            workspaceRegion(other.getWorkspaceRegion());
            admin(other.getAdmin());
            cardCreationOptions(other.getCardCreationOptions());
            context(other.getContext());
            conversation(other.getConversation());
            contact(other.getContact());
            return this;
        }

        /**
         * The workspace ID of the teammate. Attribute is `app_id` for V1.2 and below.<p>The workspace ID of the teammate. Attribute is <code>app_id</code> for V1.2 and below.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("workspace_id")
        public WorkspaceRegionStage workspaceId(@NotNull String workspaceId) {
            this.workspaceId = Objects.requireNonNull(workspaceId, "workspaceId must not be null");
            return this;
        }

        /**
         * The Intercom hosted region that this app is located in.<p>The Intercom hosted region that this app is located in.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("workspace_region")
        public AdminStage workspaceRegion(@NotNull String workspaceRegion) {
            this.workspaceRegion = Objects.requireNonNull(workspaceRegion, "workspaceRegion must not be null");
            return this;
        }

        /**
         * The Intercom teammate viewing the conversation.<p>The Intercom teammate viewing the conversation.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("admin")
        public ContextStage admin(@NotNull Admin admin) {
            this.admin = Objects.requireNonNull(admin, "admin must not be null");
            return this;
        }

        /**
         * The context of where the app is added, where the user last visited, and information on the Messenger settings.<p>The context of where the app is added, where the user last visited, and information on the Messenger settings.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("context")
        public ConversationStage context(@NotNull Context context) {
            this.context = Objects.requireNonNull(context, "context must not be null");
            return this;
        }

        /**
         * The conversation your app is being shown for.<p>The conversation your app is being shown for.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("conversation")
        public ContactStage conversation(@NotNull Conversation conversation) {
            this.conversation = Objects.requireNonNull(conversation, "conversation must not be null");
            return this;
        }

        /**
         * The contact which is currently being viewed by the teammate in the conversation details panel. We send an individual initialize request for each customer when it's a group conversation.<p>The contact which is currently being viewed by the teammate in the conversation details panel. We send an individual initialize request for each customer when it's a group conversation.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("contact")
        public _FinalStage contact(@NotNull Contact contact) {
            this.contact = Objects.requireNonNull(contact, "contact must not be null");
            return this;
        }

        /**
         * <p>Key-value pairs which were given as results in response to the Configure request.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage cardCreationOptions(String key, Object value) {
            this.cardCreationOptions.put(key, value);
            return this;
        }

        /**
         * <p>Key-value pairs which were given as results in response to the Configure request.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage putAllCardCreationOptions(Map<String, Object> cardCreationOptions) {
            this.cardCreationOptions.putAll(cardCreationOptions);
            return this;
        }

        /**
         * <p>Key-value pairs which were given as results in response to the Configure request.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "card_creation_options", nulls = Nulls.SKIP)
        public _FinalStage cardCreationOptions(Map<String, Object> cardCreationOptions) {
            this.cardCreationOptions.clear();
            this.cardCreationOptions.putAll(cardCreationOptions);
            return this;
        }

        @java.lang.Override
        public InitializeRequest build() {
            return new InitializeRequest(
                    workspaceId,
                    workspaceRegion,
                    admin,
                    cardCreationOptions,
                    context,
                    conversation,
                    contact,
                    additionalProperties);
        }
    }
}
