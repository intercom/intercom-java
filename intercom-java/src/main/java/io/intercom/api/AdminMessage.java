package io.intercom.api;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.annotations.VisibleForTesting;


@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AdminMessage extends TypedData {

    @JsonProperty("type")
    private final String type = "admin_message";

    @JsonProperty("id")
    private String id;

    @JsonProperty("message_type")
    private String messageType;

    @JsonProperty("subject")
    private String subject;

    @JsonProperty("body")
    private String body;

    @JsonProperty("template")
    private String template;

    @JsonProperty("created_at")
    private long createdAt;

    @JsonProperty("from")
    private Admin admin;

    @JsonProperty("to")
    private User user;

    public AdminMessage() {
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    @SuppressWarnings("UnusedReturnValue")
    @VisibleForTesting
    AdminMessage setId(String id) {
        this.id = id;
        return this;
    }

    public String getMessageType() {
        return messageType;
    }

    public AdminMessage setMessageType(String messageType) {
        this.messageType = messageType;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public AdminMessage setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getBody() {
        return body;
    }

    public AdminMessage setBody(String body) {
        this.body = body;
        return this;
    }

    public String getTemplate() {
        return template;
    }

    public AdminMessage setTemplate(String template) {
        this.template = template;
        return this;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    @SuppressWarnings("UnusedReturnValue")
    public AdminMessage setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Admin getAdmin() {
        return admin;
    }

    public AdminMessage setAdmin(Admin admin) {
        this.admin = admin;
        return this;
    }

    public User getUser() {
        return user;
    }

    public AdminMessage setUser(User user) {
        this.user = user;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdminMessage message = (AdminMessage) o;

        if (createdAt != message.createdAt) return false;
        if (admin != null ? !admin.equals(message.admin) : message.admin != null) return false;
        if (body != null ? !body.equals(message.body) : message.body != null) return false;
        if (id != null ? !id.equals(message.id) : message.id != null) return false;
        if (messageType != null ? !messageType.equals(message.messageType) : message.messageType != null) return false;
        if (subject != null ? !subject.equals(message.subject) : message.subject != null) return false;
        if (template != null ? !template.equals(message.template) : message.template != null) return false;
        if (!type.equals(message.type)) return false;
        //noinspection RedundantIfStatement
        if (user != null ? !user.equals(message.user) : message.user != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (messageType != null ? messageType.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (template != null ? template.hashCode() : 0);
        result = 31 * result + (int) (createdAt ^ (createdAt >>> 32));
        result = 31 * result + (admin != null ? admin.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AdminMessage{" +
            "id='" + id + '\'' +
            ", messageType='" + messageType + '\'' +
            ", subject='" + subject + '\'' +
            ", body='" + body + '\'' +
            ", template='" + template + '\'' +
            ", createdAt=" + createdAt +
            ", admin=" + admin +
            ", user=" + user +
            "} " + super.toString();
    }

}
