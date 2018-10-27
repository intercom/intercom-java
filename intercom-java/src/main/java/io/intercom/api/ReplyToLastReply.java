package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ReplyToLastReply {

    @JsonProperty("message_type")
    private String messageType;

    @JsonProperty("body")
    private String body;

    @JsonProperty("attachment_urls")
    private String[] attachmentUrls;

    @JsonProperty("type")
    private String type;

    @JsonProperty("admin_id")
    private String adminId;

    @JsonProperty("intercom_user_id")
    public String intercomUserId;

    @JsonProperty("user_id")
    public String userId;

    @JsonProperty("email")
    public String email;


    public String getMessageType() {
        return this.messageType;
    }
    public ReplyToLastReply setMessageType(String messageType) {
        this.messageType = messageType;
        return this;
    }

    public String getBody() {
        return this.body ;
    }
    public ReplyToLastReply setBody(String body) {
        this.body = body;
        return this;
    }

    public String getType() {
        return this.type;
    }

    public ReplyToLastReply setType(String type) {
        this.type = type;
        return this;
    }

    public String getAdminId() {
        return this.adminId;
    }

    public ReplyToLastReply setAdminId(String adminId) {
        this.adminId = adminId;
        return this;
    }

    public String getIntercomUserID(){
        return this.intercomUserId;
    }

    public ReplyToLastReply setIntercomUserID(String intercomUserId){
        this.intercomUserId = intercomUserId;
        return this;
    }

    public String getUserID() {
        return this.userId;
    }

    public ReplyToLastReply setUserID(String userId) {
        this.userId = userId;
        return this;
    }
    public String getEmail(){
        return this.email;
    }

    public ReplyToLastReply setEmail(String email){
        this.email = email;
        return this;
    }

    public String[] getAttachmentUrls() {
        return this.attachmentUrls;
    }

    public ReplyToLastReply setAttachmentUrls(String[] attachmentUrls) {
        this.attachmentUrls = attachmentUrls;
        return this;
    }

    @Override
    public String toString() {
        return "ReplyToLast{ " +
                " messageType='" + messageType + '\'' +
                ", body='" + body + '\'' +
                ", attachmentUrls='" + (attachmentUrls == null ? attachmentUrls : attachmentUrls.toString()) + '\'' +
                ", type='" + type + '\'' +
                ", adminId='" + adminId + '\'' +
                ", intercomUserId='" + intercomUserId + '\'' +
                ", userId='" + userId + '\'' +
                ", email='" + email + '\'' +
                "} " + super.toString();

    }
}
