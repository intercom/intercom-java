package io.intercom.api;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AdminReply extends Reply<Admin> {

    @SuppressWarnings("UnusedDeclaration")
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    static class AdminStringReply {

        private AdminReply reply;

        public AdminStringReply(AdminReply reply) {
            this.reply = reply;
        }

        @JsonProperty("type")
        public String getType() {
            return reply.getType();
        }

        @JsonProperty("message_type")
        public String getMessageType() {
            return reply.getMessageType();
        }

        @JsonProperty("body")
        public String getBody() {
            return reply.getBody();
        }

        @JsonProperty("admin_id")
        public String getAdminID() {
            return reply.getFrom().getId();
        }

        @JsonProperty("assignee_id")
        public String getAssigneeID() {
            return reply.getAssigneeID();
        }
    }

    @JsonProperty("assignee_id")
    private String assigneeID;

    public AdminReply(Admin admin) {
        this.from = admin;
    }

    public Reply<Admin> setMessageType(String messageType) {
        return setMessageReplyType(messageType);
    }

    public String getAssigneeID() {
        return assigneeID;
    }

    public Reply<Admin> setAssigneeID(String assigneeID) {
        this.assigneeID = assigneeID;
        this.setMessageType(Conversation.MESSAGE_TYPE_ASSIGNMENT);
        return this;
    }

    @Override
    public String toString() {
        return "AdminReply{} " + super.toString();
    }
}
