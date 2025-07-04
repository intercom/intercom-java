/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.intercom.api.resources.unstable.segments.types;

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
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = Segment.Builder.class)
public final class Segment {
    private final Optional<String> type;

    private final Optional<String> id;

    private final Optional<String> name;

    private final Optional<Integer> createdAt;

    private final Optional<Integer> updatedAt;

    private final Optional<PersonType> personType;

    private final Optional<Integer> count;

    private final Map<String, Object> additionalProperties;

    private Segment(
            Optional<String> type,
            Optional<String> id,
            Optional<String> name,
            Optional<Integer> createdAt,
            Optional<Integer> updatedAt,
            Optional<PersonType> personType,
            Optional<Integer> count,
            Map<String, Object> additionalProperties) {
        this.type = type;
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.personType = personType;
        this.count = count;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The type of object.
     */
    @JsonProperty("type")
    public Optional<String> getType() {
        return type;
    }

    /**
     * @return The unique identifier representing the segment.
     */
    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    /**
     * @return The name of the segment.
     */
    @JsonProperty("name")
    public Optional<String> getName() {
        return name;
    }

    /**
     * @return The time the segment was created.
     */
    @JsonProperty("created_at")
    public Optional<Integer> getCreatedAt() {
        return createdAt;
    }

    /**
     * @return The time the segment was updated.
     */
    @JsonProperty("updated_at")
    public Optional<Integer> getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @return Type of the contact: contact (lead) or user.
     */
    @JsonProperty("person_type")
    public Optional<PersonType> getPersonType() {
        return personType;
    }

    /**
     * @return The number of items in the user segment. It's returned when <code>include_count=true</code> is included in the request.
     */
    @JsonProperty("count")
    public Optional<Integer> getCount() {
        return count;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Segment && equalTo((Segment) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(Segment other) {
        return type.equals(other.type)
                && id.equals(other.id)
                && name.equals(other.name)
                && createdAt.equals(other.createdAt)
                && updatedAt.equals(other.updatedAt)
                && personType.equals(other.personType)
                && count.equals(other.count);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.type, this.id, this.name, this.createdAt, this.updatedAt, this.personType, this.count);
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

        private Optional<String> id = Optional.empty();

        private Optional<String> name = Optional.empty();

        private Optional<Integer> createdAt = Optional.empty();

        private Optional<Integer> updatedAt = Optional.empty();

        private Optional<PersonType> personType = Optional.empty();

        private Optional<Integer> count = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(Segment other) {
            type(other.getType());
            id(other.getId());
            name(other.getName());
            createdAt(other.getCreatedAt());
            updatedAt(other.getUpdatedAt());
            personType(other.getPersonType());
            count(other.getCount());
            return this;
        }

        /**
         * <p>The type of object.</p>
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
         * <p>The unique identifier representing the segment.</p>
         */
        @JsonSetter(value = "id", nulls = Nulls.SKIP)
        public Builder id(Optional<String> id) {
            this.id = id;
            return this;
        }

        public Builder id(String id) {
            this.id = Optional.ofNullable(id);
            return this;
        }

        /**
         * <p>The name of the segment.</p>
         */
        @JsonSetter(value = "name", nulls = Nulls.SKIP)
        public Builder name(Optional<String> name) {
            this.name = name;
            return this;
        }

        public Builder name(String name) {
            this.name = Optional.ofNullable(name);
            return this;
        }

        /**
         * <p>The time the segment was created.</p>
         */
        @JsonSetter(value = "created_at", nulls = Nulls.SKIP)
        public Builder createdAt(Optional<Integer> createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder createdAt(Integer createdAt) {
            this.createdAt = Optional.ofNullable(createdAt);
            return this;
        }

        /**
         * <p>The time the segment was updated.</p>
         */
        @JsonSetter(value = "updated_at", nulls = Nulls.SKIP)
        public Builder updatedAt(Optional<Integer> updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Builder updatedAt(Integer updatedAt) {
            this.updatedAt = Optional.ofNullable(updatedAt);
            return this;
        }

        /**
         * <p>Type of the contact: contact (lead) or user.</p>
         */
        @JsonSetter(value = "person_type", nulls = Nulls.SKIP)
        public Builder personType(Optional<PersonType> personType) {
            this.personType = personType;
            return this;
        }

        public Builder personType(PersonType personType) {
            this.personType = Optional.ofNullable(personType);
            return this;
        }

        /**
         * <p>The number of items in the user segment. It's returned when <code>include_count=true</code> is included in the request.</p>
         */
        @JsonSetter(value = "count", nulls = Nulls.SKIP)
        public Builder count(Optional<Integer> count) {
            this.count = count;
            return this;
        }

        public Builder count(Integer count) {
            this.count = Optional.ofNullable(count);
            return this;
        }

        public Segment build() {
            return new Segment(type, id, name, createdAt, updatedAt, personType, count, additionalProperties);
        }
    }

    public static final class PersonType {
        public static final PersonType USER = new PersonType(Value.USER, "user");

        public static final PersonType CONTACT = new PersonType(Value.CONTACT, "contact");

        private final Value value;

        private final String string;

        PersonType(Value value, String string) {
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
            return (this == other) || (other instanceof PersonType && this.string.equals(((PersonType) other).string));
        }

        @java.lang.Override
        public int hashCode() {
            return this.string.hashCode();
        }

        public <T> T visit(Visitor<T> visitor) {
            switch (value) {
                case USER:
                    return visitor.visitUser();
                case CONTACT:
                    return visitor.visitContact();
                case UNKNOWN:
                default:
                    return visitor.visitUnknown(string);
            }
        }

        @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
        public static PersonType valueOf(String value) {
            switch (value) {
                case "user":
                    return USER;
                case "contact":
                    return CONTACT;
                default:
                    return new PersonType(Value.UNKNOWN, value);
            }
        }

        public enum Value {
            CONTACT,

            USER,

            UNKNOWN
        }

        public interface Visitor<T> {
            T visitContact();

            T visitUser();

            T visitUnknown(String unknownType);
        }
    }
}
