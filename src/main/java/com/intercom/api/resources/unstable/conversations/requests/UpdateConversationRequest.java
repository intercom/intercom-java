/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.intercom.api.resources.unstable.conversations.requests;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.intercom.api.core.ObjectMappers;
import com.intercom.api.resources.unstable.types.CustomObjectInstanceList;
import com.intercom.api.resources.unstable.types.Datetime;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = UpdateConversationRequest.Builder.class)
public final class UpdateConversationRequest {
    private final int id;

    private final Optional<String> displayAs;

    private final Optional<Boolean> read;

    private final Optional<String> title;

    private final Optional<Map<String, CustomAttributesValue>> customAttributes;

    private final Map<String, Object> additionalProperties;

    private UpdateConversationRequest(
            int id,
            Optional<String> displayAs,
            Optional<Boolean> read,
            Optional<String> title,
            Optional<Map<String, CustomAttributesValue>> customAttributes,
            Map<String, Object> additionalProperties) {
        this.id = id;
        this.displayAs = displayAs;
        this.read = read;
        this.title = title;
        this.customAttributes = customAttributes;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The id of the conversation to target
     */
    @JsonProperty("id")
    public int getId() {
        return id;
    }

    /**
     * @return Set to plaintext to retrieve conversation messages in plain text.
     */
    @JsonProperty("display_as")
    public Optional<String> getDisplayAs() {
        return displayAs;
    }

    /**
     * @return Mark a conversation as read within Intercom.
     */
    @JsonProperty("read")
    public Optional<Boolean> getRead() {
        return read;
    }

    /**
     * @return The title given to the conversation
     */
    @JsonProperty("title")
    public Optional<String> getTitle() {
        return title;
    }

    @JsonProperty("custom_attributes")
    public Optional<Map<String, CustomAttributesValue>> getCustomAttributes() {
        return customAttributes;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UpdateConversationRequest && equalTo((UpdateConversationRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(UpdateConversationRequest other) {
        return id == other.id
                && displayAs.equals(other.displayAs)
                && read.equals(other.read)
                && title.equals(other.title)
                && customAttributes.equals(other.customAttributes);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.id, this.displayAs, this.read, this.title, this.customAttributes);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IdStage builder() {
        return new Builder();
    }

    public interface IdStage {
        /**
         * The id of the conversation to target
         */
        _FinalStage id(int id);

        Builder from(UpdateConversationRequest other);
    }

    public interface _FinalStage {
        UpdateConversationRequest build();

        /**
         * <p>Set to plaintext to retrieve conversation messages in plain text.</p>
         */
        _FinalStage displayAs(Optional<String> displayAs);

        _FinalStage displayAs(String displayAs);

        /**
         * <p>Mark a conversation as read within Intercom.</p>
         */
        _FinalStage read(Optional<Boolean> read);

        _FinalStage read(Boolean read);

        /**
         * <p>The title given to the conversation</p>
         */
        _FinalStage title(Optional<String> title);

        _FinalStage title(String title);

        _FinalStage customAttributes(Optional<Map<String, CustomAttributesValue>> customAttributes);

        _FinalStage customAttributes(Map<String, CustomAttributesValue> customAttributes);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements IdStage, _FinalStage {
        private int id;

        private Optional<Map<String, CustomAttributesValue>> customAttributes = Optional.empty();

        private Optional<String> title = Optional.empty();

        private Optional<Boolean> read = Optional.empty();

        private Optional<String> displayAs = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(UpdateConversationRequest other) {
            id(other.getId());
            displayAs(other.getDisplayAs());
            read(other.getRead());
            title(other.getTitle());
            customAttributes(other.getCustomAttributes());
            return this;
        }

        /**
         * The id of the conversation to target<p>The id of the conversation to target</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("id")
        public _FinalStage id(int id) {
            this.id = id;
            return this;
        }

        @java.lang.Override
        public _FinalStage customAttributes(Map<String, CustomAttributesValue> customAttributes) {
            this.customAttributes = Optional.ofNullable(customAttributes);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "custom_attributes", nulls = Nulls.SKIP)
        public _FinalStage customAttributes(Optional<Map<String, CustomAttributesValue>> customAttributes) {
            this.customAttributes = customAttributes;
            return this;
        }

        /**
         * <p>The title given to the conversation</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage title(String title) {
            this.title = Optional.ofNullable(title);
            return this;
        }

        /**
         * <p>The title given to the conversation</p>
         */
        @java.lang.Override
        @JsonSetter(value = "title", nulls = Nulls.SKIP)
        public _FinalStage title(Optional<String> title) {
            this.title = title;
            return this;
        }

        /**
         * <p>Mark a conversation as read within Intercom.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage read(Boolean read) {
            this.read = Optional.ofNullable(read);
            return this;
        }

        /**
         * <p>Mark a conversation as read within Intercom.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "read", nulls = Nulls.SKIP)
        public _FinalStage read(Optional<Boolean> read) {
            this.read = read;
            return this;
        }

        /**
         * <p>Set to plaintext to retrieve conversation messages in plain text.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage displayAs(String displayAs) {
            this.displayAs = Optional.ofNullable(displayAs);
            return this;
        }

        /**
         * <p>Set to plaintext to retrieve conversation messages in plain text.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "display_as", nulls = Nulls.SKIP)
        public _FinalStage displayAs(Optional<String> displayAs) {
            this.displayAs = displayAs;
            return this;
        }

        @java.lang.Override
        public UpdateConversationRequest build() {
            return new UpdateConversationRequest(id, displayAs, read, title, customAttributes, additionalProperties);
        }
    }

    @JsonDeserialize(using = CustomAttributesValue.Deserializer.class)
    public static final class CustomAttributesValue {
        private final Object value;

        private final int type;

        private CustomAttributesValue(Object value, int type) {
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
                return visitor.visit((String) this.value);
            } else if (this.type == 1) {
                return visitor.visit((int) this.value);
            } else if (this.type == 2) {
                return visitor.visit((Datetime) this.value);
            } else if (this.type == 3) {
                return visitor.visit((CustomObjectInstanceList) this.value);
            }
            throw new IllegalStateException("Failed to visit value. This should never happen.");
        }

        @java.lang.Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof CustomAttributesValue && equalTo((CustomAttributesValue) other);
        }

        private boolean equalTo(CustomAttributesValue other) {
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

        public static CustomAttributesValue of(String value) {
            return new CustomAttributesValue(value, 0);
        }

        public static CustomAttributesValue of(int value) {
            return new CustomAttributesValue(value, 1);
        }

        public static CustomAttributesValue of(Datetime value) {
            return new CustomAttributesValue(value, 2);
        }

        public static CustomAttributesValue of(CustomObjectInstanceList value) {
            return new CustomAttributesValue(value, 3);
        }

        public interface Visitor<T> {
            T visit(String value);

            T visit(int value);

            T visit(Datetime value);

            T visit(CustomObjectInstanceList value);
        }

        static final class Deserializer extends StdDeserializer<CustomAttributesValue> {
            Deserializer() {
                super(CustomAttributesValue.class);
            }

            @java.lang.Override
            public CustomAttributesValue deserialize(JsonParser p, DeserializationContext context) throws IOException {
                Object value = p.readValueAs(Object.class);
                try {
                    return of(ObjectMappers.JSON_MAPPER.convertValue(value, String.class));
                } catch (IllegalArgumentException e) {
                }
                if (value instanceof Integer) {
                    return of((Integer) value);
                }
                try {
                    return of(ObjectMappers.JSON_MAPPER.convertValue(value, Datetime.class));
                } catch (IllegalArgumentException e) {
                }
                try {
                    return of(ObjectMappers.JSON_MAPPER.convertValue(value, CustomObjectInstanceList.class));
                } catch (IllegalArgumentException e) {
                }
                throw new JsonParseException(p, "Failed to deserialize");
            }
        }
    }
}
