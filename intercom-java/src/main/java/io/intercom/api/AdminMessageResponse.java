package io.intercom.api;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
class AdminMessageResponse extends TypedData {

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

    @JsonProperty("updated_at")
    private long updatedAt;

    @JsonProperty("owner")
    private Admin admin;

    @JsonProperty("to")
    private User user;

    public AdminMessageResponse() {
    }

    public String getType() {
        return "admin_message";
    }

    public String getId() {
        return id;
    }

    public AdminMessageResponse setId(String id) {
        this.id = id;
        return this;
    }

    public String getMessageType() {
        return messageType;
    }

    public AdminMessageResponse setMessageType(String messageType) {
        this.messageType = messageType;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public AdminMessageResponse setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getBody() {
        return body;
    }

    public AdminMessageResponse setBody(String body) {
        this.body = body;
        return this;
    }

    public String getTemplate() {
        return template;
    }

    public AdminMessageResponse setTemplate(String template) {
        this.template = template;
        return this;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public AdminMessageResponse setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public AdminMessageResponse setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public Admin getAdmin() {
        return admin;
    }

    public AdminMessageResponse setAdmin(Admin admin) {
        this.admin = admin;
        return this;
    }

    public User getUser() {
        return user;
    }

    public AdminMessageResponse setUser(User user) {
        this.user = user;
        return this;
    }

}
