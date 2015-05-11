package io.intercom.api;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
abstract class TypedMessage<F, T extends TypedMessage> extends TypedData {

    @SuppressWarnings("FieldCanBeLocal")
    @JsonProperty("type")
    protected final String type = "user_message";

    @JsonProperty("message_type")
    protected String messageType;

    @JsonProperty("id")
    protected String id;

    @JsonProperty("body")
    protected String body;

    @JsonProperty("created_at")
    protected long createdAt;

    protected F from;

    public TypedMessage() {
    }

    public String getType() {
        return type;
    }

    public F getFrom() {
        return from;
    }

    public T setFrom(F from) {
        this.from = from;
        return (T)this;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public T setBody(String body) {
        this.body = body;
        return (T)this;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public T setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
        return (T)this;
    }

    @Override
    public String toString() {
        return "TypedMessage{" +
                "type='" + type + '\'' +
                ", messageType='" + messageType + '\'' +
                ", id='" + id + '\'' +
                ", body='" + body + '\'' +
                ", createdAt=" + createdAt +
                ", from=" + from +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypedMessage<?, ?> that = (TypedMessage<?, ?>) o;

        if (createdAt != that.createdAt) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (messageType != null ? !messageType.equals(that.messageType) : that.messageType != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (body != null ? !body.equals(that.body) : that.body != null) return false;
        return !(from != null ? !from.equals(that.from) : that.from != null);

    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (messageType != null ? messageType.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (int) (createdAt ^ (createdAt >>> 32));
        result = 31 * result + (from != null ? from.hashCode() : 0);
        return result;
    }
}
