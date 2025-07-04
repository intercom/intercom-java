/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.intercom.api.resources.unstable.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.intercom.api.core.ObjectMappers;
import com.intercom.api.resources.unstable.tickets.types.TicketType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = TicketTypeList.Builder.class)
public final class TicketTypeList {
    private final Optional<String> type;

    private final Optional<List<Optional<TicketType>>> data;

    private final Map<String, Object> additionalProperties;

    private TicketTypeList(
            Optional<String> type,
            Optional<List<Optional<TicketType>>> data,
            Map<String, Object> additionalProperties) {
        this.type = type;
        this.data = data;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return String representing the object's type. Always has the value <code>list</code>.
     */
    @JsonProperty("type")
    public Optional<String> getType() {
        return type;
    }

    /**
     * @return A list of ticket_types associated with a given workspace.
     */
    @JsonProperty("data")
    public Optional<List<Optional<TicketType>>> getData() {
        return data;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TicketTypeList && equalTo((TicketTypeList) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(TicketTypeList other) {
        return type.equals(other.type) && data.equals(other.data);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.type, this.data);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> type = Optional.empty();

        private Optional<List<Optional<TicketType>>> data = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(TicketTypeList other) {
            type(other.getType());
            data(other.getData());
            return this;
        }

        /**
         * <p>String representing the object's type. Always has the value <code>list</code>.</p>
         */
        @JsonSetter(value = "type", nulls = Nulls.SKIP)
        public Builder type(Optional<String> type) {
            this.type = type;
            return this;
        }

        public Builder type(String type) {
            this.type = Optional.ofNullable(type);
            return this;
        }

        /**
         * <p>A list of ticket_types associated with a given workspace.</p>
         */
        @JsonSetter(value = "data", nulls = Nulls.SKIP)
        public Builder data(Optional<List<Optional<TicketType>>> data) {
            this.data = data;
            return this;
        }

        public Builder data(List<Optional<TicketType>> data) {
            this.data = Optional.ofNullable(data);
            return this;
        }

        public TicketTypeList build() {
            return new TicketTypeList(type, data, additionalProperties);
        }
    }
}
