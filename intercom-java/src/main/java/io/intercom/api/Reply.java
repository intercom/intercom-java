package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonProperty;

class Reply<T extends Replier> extends TypedData {

    @JsonProperty("message_type")
    private String messageType = "comment";

    @JsonProperty("body")
    private String body;

    @JsonProperty("from")
    T from;

    Reply() {
    }

    @JsonProperty("type")
    String getType() {
        return from.getReplyType();
    }

    String getBody() {
        return body;
    }

    public Reply<T> setBody(String body) {
        this.body = body;
        return this;
    }

    T getFrom() {
        return from;
    }

    @SuppressWarnings("UnusedDeclaration")
    public Reply<T> setFrom(T from) {
        this.from = from;
        return this;
    }

    String getMessageType() {
        return messageType;
    }

    Reply<T> setMessageReplyType(String messageType) {
        this.messageType = messageType;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reply reply = (Reply) o;

        if (body != null ? !body.equals(reply.body) : reply.body != null) return false;
        if (from != null ? !from.equals(reply.from) : reply.from != null) return false;
        //noinspection RedundantIfStatement
        if (!messageType.equals(reply.messageType)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = messageType.hashCode();
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (from != null ? from.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Reply{" +
            "messageType='" + messageType + '\'' +
            ", body='" + body + '\'' +
            ", from=" + from +
            "} " + super.toString();
    }
}
