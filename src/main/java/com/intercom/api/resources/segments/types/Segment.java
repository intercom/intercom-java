/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.intercom.api.resources.segments.types;

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
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = Segment.Builder.class)
public final class Segment {
    private final String id;

    private final String name;

    private final int createdAt;

    private final Optional<Integer> updatedAt;

    private final PersonType personType;

    private final Optional<Integer> count;

    private final Map<String, Object> additionalProperties;

    private Segment(
            String id,
            String name,
            int createdAt,
            Optional<Integer> updatedAt,
            PersonType personType,
            Optional<Integer> count,
            Map<String, Object> additionalProperties) {
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
    public String getType() {
        return "segment";
    }

    /**
     * @return The unique identifier representing the segment.
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * @return The name of the segment.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * @return The time the segment was created.
     */
    @JsonProperty("created_at")
    public int getCreatedAt() {
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
    public PersonType getPersonType() {
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
        return id.equals(other.id)
                && name.equals(other.name)
                && createdAt == other.createdAt
                && updatedAt.equals(other.updatedAt)
                && personType.equals(other.personType)
                && count.equals(other.count);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.createdAt, this.updatedAt, this.personType, this.count);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IdStage builder() {
        return new Builder();
    }

    public interface IdStage {
        NameStage id(@NotNull String id);

        Builder from(Segment other);
    }

    public interface NameStage {
        CreatedAtStage name(@NotNull String name);
    }

    public interface CreatedAtStage {
        PersonTypeStage createdAt(int createdAt);
    }

    public interface PersonTypeStage {
        _FinalStage personType(@NotNull PersonType personType);
    }

    public interface _FinalStage {
        Segment build();

        _FinalStage updatedAt(Optional<Integer> updatedAt);

        _FinalStage updatedAt(Integer updatedAt);

        _FinalStage count(Optional<Integer> count);

        _FinalStage count(Integer count);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements IdStage, NameStage, CreatedAtStage, PersonTypeStage, _FinalStage {
        private String id;

        private String name;

        private int createdAt;

        private PersonType personType;

        private Optional<Integer> count = Optional.empty();

        private Optional<Integer> updatedAt = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(Segment other) {
            id(other.getId());
            name(other.getName());
            createdAt(other.getCreatedAt());
            updatedAt(other.getUpdatedAt());
            personType(other.getPersonType());
            count(other.getCount());
            return this;
        }

        /**
         * <p>The unique identifier representing the segment.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("id")
        public NameStage id(@NotNull String id) {
            this.id = Objects.requireNonNull(id, "id must not be null");
            return this;
        }

        /**
         * <p>The name of the segment.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("name")
        public CreatedAtStage name(@NotNull String name) {
            this.name = Objects.requireNonNull(name, "name must not be null");
            return this;
        }

        /**
         * <p>The time the segment was created.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("created_at")
        public PersonTypeStage createdAt(int createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * <p>Type of the contact: contact (lead) or user.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("person_type")
        public _FinalStage personType(@NotNull PersonType personType) {
            this.personType = Objects.requireNonNull(personType, "personType must not be null");
            return this;
        }

        /**
         * <p>The number of items in the user segment. It's returned when <code>include_count=true</code> is included in the request.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage count(Integer count) {
            this.count = Optional.ofNullable(count);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "count", nulls = Nulls.SKIP)
        public _FinalStage count(Optional<Integer> count) {
            this.count = count;
            return this;
        }

        /**
         * <p>The time the segment was updated.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage updatedAt(Integer updatedAt) {
            this.updatedAt = Optional.ofNullable(updatedAt);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "updated_at", nulls = Nulls.SKIP)
        public _FinalStage updatedAt(Optional<Integer> updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        @java.lang.Override
        public Segment build() {
            return new Segment(id, name, createdAt, updatedAt, personType, count, additionalProperties);
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
