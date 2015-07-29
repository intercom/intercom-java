package io.intercom.api;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Conversation extends TypedData {

    private static final HashMap<String, String> SENTINEL = Maps.newHashMap();
    private static final List<String> DISPLAY_AS_FORMATS = Lists.newArrayList("plaintext", "html");
    static final String MESSAGE_TYPE_ASSIGNMENT = "assignment";
    static final String MESSAGE_TYPE_COMMENT = "comment";
    static final String MESSAGE_TYPE_NOTE = "note";
    static final String MESSAGE_TYPE_CLOSE = "close";
    static final String MESSAGE_TYPE_OPEN = "open";
    static final List<String> MESSAGE_TYPES = Lists.newArrayList(
        MESSAGE_TYPE_ASSIGNMENT,
        MESSAGE_TYPE_COMMENT,
        MESSAGE_TYPE_NOTE,
        MESSAGE_TYPE_CLOSE,
        MESSAGE_TYPE_OPEN
        );

    public static Conversation find(String id) throws InvalidException, AuthorizationException {
        final HttpClient resource = new HttpClient(UriBuilder.newBuilder().path("conversations").path(id).build());
        return resource.get(Conversation.class);
    }

    public static ConversationCollection list() throws InvalidException, AuthorizationException {
        return DataResource.list(SENTINEL, "conversations", ConversationCollection.class);
    }

    public static ConversationCollection list(Map<String, String> params) throws InvalidException, AuthorizationException {
        validateListRequest(params);

        return DataResource.list(params, "conversations", ConversationCollection.class);
    }

    public static Conversation reply(String id, UserReply reply) {
        validateUserReplyRequest(reply);

        final URI uri = UriBuilder.newBuilder()
            .path("conversations")
            .path(id)
            .path("reply")
            .build();
        return new HttpClient(uri)
            .post(Conversation.class, new UserReply.UserStringReply(reply));
    }

    public static Conversation reply(String id, AdminReply reply) {
        validateAdminReplyRequest(reply);

        final URI uri = UriBuilder.newBuilder()
            .path("conversations")
            .path(id)
            .path("reply")
            .build();
        return new HttpClient(uri)
            .post(Conversation.class, new AdminReply.AdminStringReply(reply));
    }

    public static UserMessage create(UserMessage message) {
        return DataResource.create(message, "messages", UserMessage.class);
    }

    public static ContactMessage create(ContactMessage message) {
        return DataResource.create(message, "messages", ContactMessage.class);
    }

    public static AdminMessage create(AdminMessage message) throws InvalidException {
        if ((!message.getTemplate().equals("plain")) && (!message.getTemplate().equals("personal"))) {
            throw new InvalidException("The template must be either personal or plain");
        }
        if ((!message.getMessageType().equals("email")) && (!message.getMessageType().equals("inapp"))) {
            throw new InvalidException("The message type must be either email or inapp");
        }
        /*
        the message api is asymmetric because reasons. this wraps the response
        type so we only expose AdminMessage in the client surface
         */
        final AdminMessageResponse adminMessageResponse =
            DataResource.create(message, "messages", AdminMessageResponse.class);
        AdminMessage response = new AdminMessage();
        response.setAdmin(adminMessageResponse.getAdmin());
        response.setBody(adminMessageResponse.getBody());
        response.setCreatedAt(adminMessageResponse.getCreatedAt());
        response.setId(adminMessageResponse.getId());
        response.setMessageType(adminMessageResponse.getMessageType());
        response.setSubject(adminMessageResponse.getSubject());
        response.setTemplate(adminMessageResponse.getTemplate());
        // user returns null
        // response.setUser(adminMessageResponse.getFrom());
        return response;
    }

    static void validateAdminReplyRequest(AdminReply reply) {

        validateMessageType(reply);

        if (reply.getAssigneeID() != null
            && !"assignment".equals(reply.getMessageType())) {
            throw new InvalidException("an assignee id can be set only for a message type of assignment");
        }

        if (("note".equals(reply.getMessageType()) || "comment".equals(reply.getMessageType()))
            && (isNullOrBlank(reply.getBody()))
            ) {
            throw new InvalidException("a comment or note reply must have a body");
        }
    }

    static boolean isNullOrBlank(String s) {
        return s == null || s.trim().length() == 0;

    }

    static void validateUserReplyRequest(UserReply reply) {
        if (! "comment".equals(reply.getMessageType())) {
            throw new InvalidException("a user reply must have a message type of comment");
        }
    }

    static void validateMessageType(Reply reply) {
        if(! MESSAGE_TYPES.contains(reply.getMessageType())) {
            throw new InvalidException(
                "A reply message type must be one of "
                + Joiner.on(", ").join(MESSAGE_TYPES));
        }
    }

    static void validateListRequest(Map<String, String> params) {
        if (!params.containsKey("type")) {
            throw new InvalidException("a user or admin type must be supplied for a conversation query");
        }

        if (isAdminQuery(params)
                && !(params.containsKey("admin_id"))) {
            throw new InvalidException("an admin_id must be supplied for an admin conversation query");
        }

        if (params.containsKey("display_as")) {
            if (!DISPLAY_AS_FORMATS.contains(params.get("display_as"))) {
                throw new InvalidException(
                    "A display_as parameter must have one of the values "
                        + Joiner.on(", ").join(DISPLAY_AS_FORMATS));
            }
        }

        if (isUserQuery(params)
                && (!params.containsKey("intercom_user_id")
                && !params.containsKey("user_id")
                && !params.containsKey("email"))) {
            throw new InvalidException(
                    "One of intercom_user_id, user_id or email must be supplied for a user conversation query");
        }
    }

    private static boolean isUserQuery(Map<String, String> params) {
        return params.containsKey("type") && params.get("type").equals("user");
    }

    private static boolean isAdminQuery(Map<String, String> params) {
        return params.containsKey("type") && params.get("type").equals("admin");
    }

    @JsonProperty("type")
    private final String type = "conversation";

    @JsonProperty("id")
    private String id;

    @JsonProperty("conversation_message")
    private ConversationMessage conversationMessage;

    @JsonProperty("user")
    private User user;

    @JsonProperty("assignee")
    private Admin assignee;

    @JsonProperty("created_at")
    private long createdAt;

    @JsonProperty("updated_at")
    private long updatedAt;

    @JsonProperty("conversation_parts")
    private ConversationPartCollection conversationPartCollection;

    @JsonProperty("open")
    private boolean open;

    @JsonProperty("read")
    private boolean read;

    @JsonProperty("links")
    private Map<String, URI> links;

    public Conversation() {
    }

    public String getType() {
        return type;
    }

    public Admin getCurrentAssignee() {
        Admin assignee = null;
        if (getAssignee() != null) {
            assignee = getAssignee();
        } else if (getMostRecentConversationPart() != null && getMostRecentConversationPart().getAssignedTo() != null) {
            assignee = getMostRecentConversationPart().getAssignedTo();
        }

        return assignee;
    }

    public Optional<ConversationPart> getFirstConversationPart() {
        return Optional.fromNullable(getConversationPartCollection().getPage().get(0));
    }

    public ConversationPart getMostRecentConversationPart() {
        final ConversationPartCollection conversationParts = getConversationPartCollection();
        final List<ConversationPart> items = conversationParts.getPage();
        if (items.isEmpty()) {
            return null;
        } else {
            return items.get(items.size() - 1);
        }
    }

    public String getId() {
        return id;
    }

    public ConversationMessage getConversationMessage() {
        return conversationMessage;
    }

    public User getUser() {
        return user;
    }

    public Admin getAssignee() {
        return assignee;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public ConversationPartCollection getConversationPartCollection() {
        return conversationPartCollection;
    }

    public boolean getOpen() {
        return open;
    }

    public boolean getRead() {
        return read;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Conversation that = (Conversation) o;

        if (createdAt != that.createdAt) return false;
        if (open != that.open) return false;
        if (read != that.read) return false;
        if (updatedAt != that.updatedAt) return false;
        if (assignee != null ? !assignee.equals(that.assignee) : that.assignee != null) return false;
        if (conversationMessage != null ? !conversationMessage.equals(that.conversationMessage) : that.conversationMessage != null)
            return false;
        if (conversationPartCollection != null ? !conversationPartCollection.equals(that.conversationPartCollection) : that.conversationPartCollection != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (links != null ? !links.equals(that.links) : that.links != null) return false;
        if (!type.equals(that.type)) return false;
        //noinspection RedundantIfStatement
        if (user != null ? !user.equals(that.user) : that.user != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (conversationMessage != null ? conversationMessage.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (assignee != null ? assignee.hashCode() : 0);
        result = 31 * result + (int) (createdAt ^ (createdAt >>> 32));
        result = 31 * result + (int) (updatedAt ^ (updatedAt >>> 32));
        result = 31 * result + (conversationPartCollection != null ? conversationPartCollection.hashCode() : 0);
        result = 31 * result + (open ? 1 : 0);
        result = 31 * result + (read ? 1 : 0);
        result = 31 * result + (links != null ? links.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Conversation{" +
            "type='" + type + '\'' +
            ", id='" + id + '\'' +
            ", conversationMessage=" + conversationMessage +
            ", user=" + user +
            ", assignee=" + assignee +
            ", createdAt=" + createdAt +
            ", updatedAt=" + updatedAt +
            ", conversationPartCollection=" + conversationPartCollection +
            ", open=" + open +
            ", read=" + read +
            ", links=" + links +
            "} " + super.toString();
    }
}

