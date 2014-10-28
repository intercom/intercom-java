package io.intercom.api;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserReply extends Reply<User> {

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    static class UserStringReply {

        private UserReply reply;

        public UserStringReply(UserReply reply) {
            this.reply = reply;
        }

        @JsonProperty("type")
        public String getType() {
            return reply.getType();
        }

        @SuppressWarnings("SameReturnValue")
        @JsonProperty("message_type")
        public String getMessageType() {
            return "comment";
        }

        @JsonProperty("body")
        public String getBody() {
            return reply.getBody();
        }

        @JsonProperty("intercom_user_id")
        public String getIntercomUserID() {
            return reply.getFrom().getId();
        }

        @JsonProperty("user_id")
        public String getUserID() {
            return reply.getFrom().getUserId();
        }

        @JsonProperty("email")
        public String getEmail() {
            return reply.getFrom().getEmail();
        }
    }

    public UserReply(User user) {
        this.from = user;
    }

    @Override
    public String toString() {
        return "UserReply{} " + super.toString();
    }
}
