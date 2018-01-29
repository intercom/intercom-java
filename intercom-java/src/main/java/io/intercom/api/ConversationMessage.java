package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConversationMessage extends TypedData {

    @SuppressWarnings("FieldCanBeLocal")
    @JsonProperty("type")
    private final String type = "conversation_message";

    @JsonProperty
    private String id;

    @JsonProperty
    private String subject;

    @JsonProperty
    private String body;

    @JsonProperty
    private Author author;

    @JsonProperty
    private String url;

    @JsonProperty("attachments")
    private List<Attachment> attachments;

    public ConversationMessage() {
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public Author getAuthor() {
        return author;
    }

    public String getUrl() {
        return url;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    @Override
    public int hashCode() {
        int result = subject != null ? subject.hashCode() : 0;
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (attachments != null ? attachments.hashCode() : 0);

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConversationMessage that = (ConversationMessage) o;

        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        if (body != null ? !body.equals(that.body) : that.body != null) return false;
        //noinspection RedundantIfStatement
        if (subject != null ? !subject.equals(that.subject) : that.subject != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (attachments != null ? !attachments.equals(that.attachments) : that.attachments != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "ConversationMessage{" +
            "type='" + type + '\'' +
            ", id='" + id + '\'' +
            ", subject='" + subject + '\'' +
            ", body='" + body + '\'' +
            ", author=" + author +
            ", url=" + url +
            ", attachments=" + attachments +
            "} " + super.toString();
    }
}
