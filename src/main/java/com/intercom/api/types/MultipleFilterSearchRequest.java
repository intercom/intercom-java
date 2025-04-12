/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.intercom.api.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.intercom.api.core.ObjectMappers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = MultipleFilterSearchRequest.Builder.class)
public final class MultipleFilterSearchRequest {
    private final Optional<Operator> operator;

    private final Optional<List<MultipleOrSingleFilterSearchRequest>> value;

    private final Map<String, Object> additionalProperties;

    private MultipleFilterSearchRequest(
            Optional<Operator> operator,
            Optional<List<MultipleOrSingleFilterSearchRequest>> value,
            Map<String, Object> additionalProperties) {
        this.operator = operator;
        this.value = value;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return An operator to allow boolean inspection between multiple fields.
     */
    @JsonProperty("operator")
    public Optional<Operator> getOperator() {
        return operator;
    }

    @JsonProperty("value")
    public Optional<List<MultipleOrSingleFilterSearchRequest>> getValue() {
        return value;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof MultipleFilterSearchRequest && equalTo((MultipleFilterSearchRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(MultipleFilterSearchRequest other) {
        return operator.equals(other.operator) && value.equals(other.value);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.operator, this.value);
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
        private Optional<Operator> operator = Optional.empty();

        private Optional<List<MultipleOrSingleFilterSearchRequest>> value = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(MultipleFilterSearchRequest other) {
            operator(other.getOperator());
            value(other.getValue());
            return this;
        }

        @JsonSetter(value = "operator", nulls = Nulls.SKIP)
        public Builder operator(Optional<Operator> operator) {
            this.operator = operator;
            return this;
        }

        public Builder operator(Operator operator) {
            this.operator = Optional.ofNullable(operator);
            return this;
        }

        @JsonSetter(value = "value", nulls = Nulls.SKIP)
        public Builder value(Optional<List<MultipleOrSingleFilterSearchRequest>> value) {
            this.value = value;
            return this;
        }

        public Builder value(List<MultipleOrSingleFilterSearchRequest> value) {
            this.value = Optional.ofNullable(value);
            return this;
        }

        public MultipleFilterSearchRequest build() {
            return new MultipleFilterSearchRequest(operator, value, additionalProperties);
        }
    }

    public static final class Operator {
        public static final Operator AND = new Operator(Value.AND, "AND");

        public static final Operator OR = new Operator(Value.OR, "OR");

        private final Value value;

        private final String string;

        Operator(Value value, String string) {
            this.value = value;
            this.string = string;
        }

        public Value getEnumValue() {
            return value;
        }

        @java.lang.Override
        @JsonValue
        public String toString() {
            return this.string;
        }

        @java.lang.Override
        public boolean equals(Object other) {
            return (this == other) || (other instanceof Operator && this.string.equals(((Operator) other).string));
        }

        @java.lang.Override
        public int hashCode() {
            return this.string.hashCode();
        }

        public <T> T visit(Visitor<T> visitor) {
            switch (value) {
                case AND:
                    return visitor.visitAnd();
                case OR:
                    return visitor.visitOr();
                case UNKNOWN:
                default:
                    return visitor.visitUnknown(string);
            }
        }

        @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
        public static Operator valueOf(String value) {
            switch (value) {
                case "AND":
                    return AND;
                case "OR":
                    return OR;
                default:
                    return new Operator(Value.UNKNOWN, value);
            }
        }

        public enum Value {
            AND,

            OR,

            UNKNOWN
        }

        public interface Visitor<T> {
            T visitAnd();

            T visitOr();

            T visitUnknown(String unknownType);
        }
    }
}
