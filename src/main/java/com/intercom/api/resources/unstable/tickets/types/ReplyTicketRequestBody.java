/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.intercom.api.resources.unstable.tickets.types;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.intercom.api.core.ObjectMappers;
import com.intercom.api.resources.unstable.types.AdminReplyTicketRequest;
import com.intercom.api.resources.unstable.types.ContactReplyTicketRequest;
import java.io.IOException;
import java.util.Objects;

@JsonDeserialize(using = ReplyTicketRequestBody.Deserializer.class)
public final class ReplyTicketRequestBody {
    private final Object value;

    private final int type;

    private ReplyTicketRequestBody(Object value, int type) {
        this.value = value;
        this.type = type;
    }

    @JsonValue
    public Object get() {
        return this.value;
    }

    @SuppressWarnings("unchecked")
    public <T> T visit(Visitor<T> visitor) {
        if (this.type == 0) {
            return visitor.visit((ContactReplyTicketRequest) this.value);
        } else if (this.type == 1) {
            return visitor.visit((AdminReplyTicketRequest) this.value);
        }
        throw new IllegalStateException("Failed to visit value. This should never happen.");
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ReplyTicketRequestBody && equalTo((ReplyTicketRequestBody) other);
    }

    private boolean equalTo(ReplyTicketRequestBody other) {
        return value.equals(other.value);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.value);
    }

    @java.lang.Override
    public String toString() {
        return this.value.toString();
    }

    public static ReplyTicketRequestBody of(ContactReplyTicketRequest value) {
        return new ReplyTicketRequestBody(value, 0);
    }

    public static ReplyTicketRequestBody of(AdminReplyTicketRequest value) {
        return new ReplyTicketRequestBody(value, 1);
    }

    public interface Visitor<T> {
        T visit(ContactReplyTicketRequest value);

        T visit(AdminReplyTicketRequest value);
    }

    static final class Deserializer extends StdDeserializer<ReplyTicketRequestBody> {
        Deserializer() {
            super(ReplyTicketRequestBody.class);
        }

        @java.lang.Override
        public ReplyTicketRequestBody deserialize(JsonParser p, DeserializationContext context) throws IOException {
            Object value = p.readValueAs(Object.class);
            try {
                return of(ObjectMappers.JSON_MAPPER.convertValue(value, ContactReplyTicketRequest.class));
            } catch (IllegalArgumentException e) {
            }
            try {
                return of(ObjectMappers.JSON_MAPPER.convertValue(value, AdminReplyTicketRequest.class));
            } catch (IllegalArgumentException e) {
            }
            throw new JsonParseException(p, "Failed to deserialize");
        }
    }
}
