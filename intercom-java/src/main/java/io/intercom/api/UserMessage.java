package io.intercom.api;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserMessage extends TypedData {

    @SuppressWarnings("FieldCanBeLocal")
    @JsonProperty("type")
    private final String type = "user_message";

    @JsonProperty("message_type")
    private String messageType;

    @JsonProperty("id")
    private String id;

    @JsonProperty("body")
    private String body;

    @JsonProperty("created_at")
    private long createdAt;

    @JsonProperty("from")
    private User user;

    public UserMessage() {
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    UserMessage setId(String id) {
        this.id = id;
        return this;
    }

    public String getBody() {
        return body;
    }

    public UserMessage setBody(String body) {
        this.body = body;
        return this;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public UserMessage setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public User getUser() {
        return user;
    }

    public UserMessage setUser(User user) {
        this.user = user;
        return this;
    }

    public String getMessageType() {
        return messageType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserMessage that = (UserMessage) o;

        if (createdAt != that.createdAt) return false;
        if (body != null ? !body.equals(that.body) : that.body != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (!messageType.equals(that.messageType)) return false;
        if (!type.equals(that.type)) return false;
        //noinspection RedundantIfStatement
        if (user != null ? !user.equals(that.user) : that.user != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + (messageType.hashCode());
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (int) (createdAt ^ (createdAt >>> 32));
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserMessage{" +
            "id='" + id + '\'' +
            ", body='" + body + '\'' +
            ", messageType='" + messageType + '\'' +
            ", createdAt=" + createdAt +
            ", user=" + user +
            "} " + super.toString();
    }

}
