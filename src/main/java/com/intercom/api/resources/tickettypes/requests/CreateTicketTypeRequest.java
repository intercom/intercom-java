/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.intercom.api.resources.tickettypes.requests;

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
@JsonDeserialize(builder = CreateTicketTypeRequest.Builder.class)
public final class CreateTicketTypeRequest {
    private final String name;

    private final Optional<String> description;

    private final Optional<Category> category;

    private final Optional<String> icon;

    private final Optional<Boolean> isInternal;

    private final Map<String, Object> additionalProperties;

    private CreateTicketTypeRequest(
            String name,
            Optional<String> description,
            Optional<Category> category,
            Optional<String> icon,
            Optional<Boolean> isInternal,
            Map<String, Object> additionalProperties) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.icon = icon;
        this.isInternal = isInternal;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The name of the ticket type.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * @return The description of the ticket type.
     */
    @JsonProperty("description")
    public Optional<String> getDescription() {
        return description;
    }

    /**
     * @return Category of the Ticket Type.
     */
    @JsonProperty("category")
    public Optional<Category> getCategory() {
        return category;
    }

    /**
     * @return The icon of the ticket type.
     */
    @JsonProperty("icon")
    public Optional<String> getIcon() {
        return icon;
    }

    /**
     * @return Whether the tickets associated with this ticket type are intended for internal use only or will be shared with customers. This is currently a limited attribute.
     */
    @JsonProperty("is_internal")
    public Optional<Boolean> getIsInternal() {
        return isInternal;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CreateTicketTypeRequest && equalTo((CreateTicketTypeRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CreateTicketTypeRequest other) {
        return name.equals(other.name)
                && description.equals(other.description)
                && category.equals(other.category)
                && icon.equals(other.icon)
                && isInternal.equals(other.isInternal);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.name, this.description, this.category, this.icon, this.isInternal);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static NameStage builder() {
        return new Builder();
    }

    public interface NameStage {
        _FinalStage name(@NotNull String name);

        Builder from(CreateTicketTypeRequest other);
    }

    public interface _FinalStage {
        CreateTicketTypeRequest build();

        _FinalStage description(Optional<String> description);

        _FinalStage description(String description);

        _FinalStage category(Optional<Category> category);

        _FinalStage category(Category category);

        _FinalStage icon(Optional<String> icon);

        _FinalStage icon(String icon);

        _FinalStage isInternal(Optional<Boolean> isInternal);

        _FinalStage isInternal(Boolean isInternal);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NameStage, _FinalStage {
        private String name;

        private Optional<Boolean> isInternal = Optional.empty();

        private Optional<String> icon = Optional.empty();

        private Optional<Category> category = Optional.empty();

        private Optional<String> description = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(CreateTicketTypeRequest other) {
            name(other.getName());
            description(other.getDescription());
            category(other.getCategory());
            icon(other.getIcon());
            isInternal(other.getIsInternal());
            return this;
        }

        /**
         * <p>The name of the ticket type.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("name")
        public _FinalStage name(@NotNull String name) {
            this.name = Objects.requireNonNull(name, "name must not be null");
            return this;
        }

        /**
         * <p>Whether the tickets associated with this ticket type are intended for internal use only or will be shared with customers. This is currently a limited attribute.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage isInternal(Boolean isInternal) {
            this.isInternal = Optional.ofNullable(isInternal);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "is_internal", nulls = Nulls.SKIP)
        public _FinalStage isInternal(Optional<Boolean> isInternal) {
            this.isInternal = isInternal;
            return this;
        }

        /**
         * <p>The icon of the ticket type.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage icon(String icon) {
            this.icon = Optional.ofNullable(icon);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "icon", nulls = Nulls.SKIP)
        public _FinalStage icon(Optional<String> icon) {
            this.icon = icon;
            return this;
        }

        /**
         * <p>Category of the Ticket Type.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage category(Category category) {
            this.category = Optional.ofNullable(category);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "category", nulls = Nulls.SKIP)
        public _FinalStage category(Optional<Category> category) {
            this.category = category;
            return this;
        }

        /**
         * <p>The description of the ticket type.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage description(String description) {
            this.description = Optional.ofNullable(description);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "description", nulls = Nulls.SKIP)
        public _FinalStage description(Optional<String> description) {
            this.description = description;
            return this;
        }

        @java.lang.Override
        public CreateTicketTypeRequest build() {
            return new CreateTicketTypeRequest(name, description, category, icon, isInternal, additionalProperties);
        }
    }

    public static final class Category {
        public static final Category BACK_OFFICE = new Category(Value.BACK_OFFICE, "Back-office");

        public static final Category CUSTOMER = new Category(Value.CUSTOMER, "Customer");

        public static final Category TRACKER = new Category(Value.TRACKER, "Tracker");

        private final Value value;

        private final String string;

        Category(Value value, String string) {
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
            return (this == other) || (other instanceof Category && this.string.equals(((Category) other).string));
        }

        @java.lang.Override
        public int hashCode() {
            return this.string.hashCode();
        }

        public <T> T visit(Visitor<T> visitor) {
            switch (value) {
                case BACK_OFFICE:
                    return visitor.visitBackOffice();
                case CUSTOMER:
                    return visitor.visitCustomer();
                case TRACKER:
                    return visitor.visitTracker();
                case UNKNOWN:
                default:
                    return visitor.visitUnknown(string);
            }
        }

        @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
        public static Category valueOf(String value) {
            switch (value) {
                case "Back-office":
                    return BACK_OFFICE;
                case "Customer":
                    return CUSTOMER;
                case "Tracker":
                    return TRACKER;
                default:
                    return new Category(Value.UNKNOWN, value);
            }
        }

        public enum Value {
            CUSTOMER,

            BACK_OFFICE,

            TRACKER,

            UNKNOWN
        }

        public interface Visitor<T> {
            T visitCustomer();

            T visitBackOffice();

            T visitTracker();

            T visitUnknown(String unknownType);
        }
    }
}
