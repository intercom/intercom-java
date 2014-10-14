package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConversationMessage extends TypedData {

    @SuppressWarnings("FieldCanBeLocal")
    @JsonProperty("type")
    private final String type = "conversation_message";

    @JsonProperty
    private String subject;

    @JsonProperty
    private String body;

    @JsonProperty
    private Author author;

    public ConversationMessage() {
    }

    public String getType() {
        return type;
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

    @Override
    public int hashCode() {
        int result = subject != null ? subject.hashCode() : 0;
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
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

        return true;
    }

    @Override
    public String toString() {
        return "ConversationMessage{" +
            "type='" + type + '\'' +
            ", subject='" + subject + '\'' +
            ", body='" + body + '\'' +
            ", author=" + author +
            "} " + super.toString();
    }
}
