/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.intercom.api.resources.tickettypes.attributes.requests;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
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
@JsonDeserialize(builder = CreateTicketTypeAttributeRequest.Builder.class)
public final class CreateTicketTypeAttributeRequest {
    private final String ticketTypeId;

    private final String name;

    private final String description;

    private final DataType dataType;

    private final Optional<Boolean> requiredToCreate;

    private final Optional<Boolean> requiredToCreateForContacts;

    private final Optional<Boolean> visibleOnCreate;

    private final Optional<Boolean> visibleToContacts;

    private final Optional<Boolean> multiline;

    private final Optional<String> listItems;

    private final Optional<Boolean> allowMultipleValues;

    private final Map<String, Object> additionalProperties;

    private CreateTicketTypeAttributeRequest(
            String ticketTypeId,
            String name,
            String description,
            DataType dataType,
            Optional<Boolean> requiredToCreate,
            Optional<Boolean> requiredToCreateForContacts,
            Optional<Boolean> visibleOnCreate,
            Optional<Boolean> visibleToContacts,
            Optional<Boolean> multiline,
            Optional<String> listItems,
            Optional<Boolean> allowMultipleValues,
            Map<String, Object> additionalProperties) {
        this.ticketTypeId = ticketTypeId;
        this.name = name;
        this.description = description;
        this.dataType = dataType;
        this.requiredToCreate = requiredToCreate;
        this.requiredToCreateForContacts = requiredToCreateForContacts;
        this.visibleOnCreate = visibleOnCreate;
        this.visibleToContacts = visibleToContacts;
        this.multiline = multiline;
        this.listItems = listItems;
        this.allowMultipleValues = allowMultipleValues;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The unique identifier for the ticket type which is given by Intercom.
     */
    @JsonProperty("ticket_type_id")
    public String getTicketTypeId() {
        return ticketTypeId;
    }

    /**
     * @return The name of the ticket type attribute
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * @return The description of the attribute presented to the teammate or contact
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * @return The data type of the attribute
     */
    @JsonProperty("data_type")
    public DataType getDataType() {
        return dataType;
    }

    /**
     * @return Whether the attribute is required to be filled in when teammates are creating the ticket in Inbox.
     */
    @JsonProperty("required_to_create")
    public Optional<Boolean> getRequiredToCreate() {
        return requiredToCreate;
    }

    /**
     * @return Whether the attribute is required to be filled in when contacts are creating the ticket in Messenger.
     */
    @JsonProperty("required_to_create_for_contacts")
    public Optional<Boolean> getRequiredToCreateForContacts() {
        return requiredToCreateForContacts;
    }

    /**
     * @return Whether the attribute is visible to teammates when creating a ticket in Inbox.
     */
    @JsonProperty("visible_on_create")
    public Optional<Boolean> getVisibleOnCreate() {
        return visibleOnCreate;
    }

    /**
     * @return Whether the attribute is visible to contacts when creating a ticket in Messenger.
     */
    @JsonProperty("visible_to_contacts")
    public Optional<Boolean> getVisibleToContacts() {
        return visibleToContacts;
    }

    /**
     * @return Whether the attribute allows multiple lines of text (only applicable to string attributes)
     */
    @JsonProperty("multiline")
    public Optional<Boolean> getMultiline() {
        return multiline;
    }

    /**
     * @return A comma delimited list of items for the attribute value (only applicable to list attributes)
     */
    @JsonProperty("list_items")
    public Optional<String> getListItems() {
        return listItems;
    }

    /**
     * @return Whether the attribute allows multiple files to be attached to it (only applicable to file attributes)
     */
    @JsonProperty("allow_multiple_values")
    public Optional<Boolean> getAllowMultipleValues() {
        return allowMultipleValues;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CreateTicketTypeAttributeRequest && equalTo((CreateTicketTypeAttributeRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CreateTicketTypeAttributeRequest other) {
        return ticketTypeId.equals(other.ticketTypeId)
                && name.equals(other.name)
                && description.equals(other.description)
                && dataType.equals(other.dataType)
                && requiredToCreate.equals(other.requiredToCreate)
                && requiredToCreateForContacts.equals(other.requiredToCreateForContacts)
                && visibleOnCreate.equals(other.visibleOnCreate)
                && visibleToContacts.equals(other.visibleToContacts)
                && multiline.equals(other.multiline)
                && listItems.equals(other.listItems)
                && allowMultipleValues.equals(other.allowMultipleValues);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.ticketTypeId,
                this.name,
                this.description,
                this.dataType,
                this.requiredToCreate,
                this.requiredToCreateForContacts,
                this.visibleOnCreate,
                this.visibleToContacts,
                this.multiline,
                this.listItems,
                this.allowMultipleValues);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static TicketTypeIdStage builder() {
        return new Builder();
    }

    public interface TicketTypeIdStage {
        NameStage ticketTypeId(@NotNull String ticketTypeId);

        Builder from(CreateTicketTypeAttributeRequest other);
    }

    public interface NameStage {
        DescriptionStage name(@NotNull String name);
    }

    public interface DescriptionStage {
        DataTypeStage description(@NotNull String description);
    }

    public interface DataTypeStage {
        _FinalStage dataType(@NotNull DataType dataType);
    }

    public interface _FinalStage {
        CreateTicketTypeAttributeRequest build();

        _FinalStage requiredToCreate(Optional<Boolean> requiredToCreate);

        _FinalStage requiredToCreate(Boolean requiredToCreate);

        _FinalStage requiredToCreateForContacts(Optional<Boolean> requiredToCreateForContacts);

        _FinalStage requiredToCreateForContacts(Boolean requiredToCreateForContacts);

        _FinalStage visibleOnCreate(Optional<Boolean> visibleOnCreate);

        _FinalStage visibleOnCreate(Boolean visibleOnCreate);

        _FinalStage visibleToContacts(Optional<Boolean> visibleToContacts);

        _FinalStage visibleToContacts(Boolean visibleToContacts);

        _FinalStage multiline(Optional<Boolean> multiline);

        _FinalStage multiline(Boolean multiline);

        _FinalStage listItems(Optional<String> listItems);

        _FinalStage listItems(String listItems);

        _FinalStage allowMultipleValues(Optional<Boolean> allowMultipleValues);

        _FinalStage allowMultipleValues(Boolean allowMultipleValues);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements TicketTypeIdStage, NameStage, DescriptionStage, DataTypeStage, _FinalStage {
        private String ticketTypeId;

        private String name;

        private String description;

        private DataType dataType;

        private Optional<Boolean> allowMultipleValues = Optional.empty();

        private Optional<String> listItems = Optional.empty();

        private Optional<Boolean> multiline = Optional.empty();

        private Optional<Boolean> visibleToContacts = Optional.empty();

        private Optional<Boolean> visibleOnCreate = Optional.empty();

        private Optional<Boolean> requiredToCreateForContacts = Optional.empty();

        private Optional<Boolean> requiredToCreate = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(CreateTicketTypeAttributeRequest other) {
            ticketTypeId(other.getTicketTypeId());
            name(other.getName());
            description(other.getDescription());
            dataType(other.getDataType());
            requiredToCreate(other.getRequiredToCreate());
            requiredToCreateForContacts(other.getRequiredToCreateForContacts());
            visibleOnCreate(other.getVisibleOnCreate());
            visibleToContacts(other.getVisibleToContacts());
            multiline(other.getMultiline());
            listItems(other.getListItems());
            allowMultipleValues(other.getAllowMultipleValues());
            return this;
        }

        /**
         * <p>The unique identifier for the ticket type which is given by Intercom.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("ticket_type_id")
        public NameStage ticketTypeId(@NotNull String ticketTypeId) {
            this.ticketTypeId = Objects.requireNonNull(ticketTypeId, "ticketTypeId must not be null");
            return this;
        }

        /**
         * <p>The name of the ticket type attribute</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("name")
        public DescriptionStage name(@NotNull String name) {
            this.name = Objects.requireNonNull(name, "name must not be null");
            return this;
        }

        /**
         * <p>The description of the attribute presented to the teammate or contact</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("description")
        public DataTypeStage description(@NotNull String description) {
            this.description = Objects.requireNonNull(description, "description must not be null");
            return this;
        }

        /**
         * <p>The data type of the attribute</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("data_type")
        public _FinalStage dataType(@NotNull DataType dataType) {
            this.dataType = Objects.requireNonNull(dataType, "dataType must not be null");
            return this;
        }

        /**
         * <p>Whether the attribute allows multiple files to be attached to it (only applicable to file attributes)</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage allowMultipleValues(Boolean allowMultipleValues) {
            this.allowMultipleValues = Optional.ofNullable(allowMultipleValues);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "allow_multiple_values", nulls = Nulls.SKIP)
        public _FinalStage allowMultipleValues(Optional<Boolean> allowMultipleValues) {
            this.allowMultipleValues = allowMultipleValues;
            return this;
        }

        /**
         * <p>A comma delimited list of items for the attribute value (only applicable to list attributes)</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage listItems(String listItems) {
            this.listItems = Optional.ofNullable(listItems);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "list_items", nulls = Nulls.SKIP)
        public _FinalStage listItems(Optional<String> listItems) {
            this.listItems = listItems;
            return this;
        }

        /**
         * <p>Whether the attribute allows multiple lines of text (only applicable to string attributes)</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage multiline(Boolean multiline) {
            this.multiline = Optional.ofNullable(multiline);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "multiline", nulls = Nulls.SKIP)
        public _FinalStage multiline(Optional<Boolean> multiline) {
            this.multiline = multiline;
            return this;
        }

        /**
         * <p>Whether the attribute is visible to contacts when creating a ticket in Messenger.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage visibleToContacts(Boolean visibleToContacts) {
            this.visibleToContacts = Optional.ofNullable(visibleToContacts);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "visible_to_contacts", nulls = Nulls.SKIP)
        public _FinalStage visibleToContacts(Optional<Boolean> visibleToContacts) {
            this.visibleToContacts = visibleToContacts;
            return this;
        }

        /**
         * <p>Whether the attribute is visible to teammates when creating a ticket in Inbox.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage visibleOnCreate(Boolean visibleOnCreate) {
            this.visibleOnCreate = Optional.ofNullable(visibleOnCreate);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "visible_on_create", nulls = Nulls.SKIP)
        public _FinalStage visibleOnCreate(Optional<Boolean> visibleOnCreate) {
            this.visibleOnCreate = visibleOnCreate;
            return this;
        }

        /**
         * <p>Whether the attribute is required to be filled in when contacts are creating the ticket in Messenger.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage requiredToCreateForContacts(Boolean requiredToCreateForContacts) {
            this.requiredToCreateForContacts = Optional.ofNullable(requiredToCreateForContacts);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "required_to_create_for_contacts", nulls = Nulls.SKIP)
        public _FinalStage requiredToCreateForContacts(Optional<Boolean> requiredToCreateForContacts) {
            this.requiredToCreateForContacts = requiredToCreateForContacts;
            return this;
        }

        /**
         * <p>Whether the attribute is required to be filled in when teammates are creating the ticket in Inbox.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage requiredToCreate(Boolean requiredToCreate) {
            this.requiredToCreate = Optional.ofNullable(requiredToCreate);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "required_to_create", nulls = Nulls.SKIP)
        public _FinalStage requiredToCreate(Optional<Boolean> requiredToCreate) {
            this.requiredToCreate = requiredToCreate;
            return this;
        }

        @java.lang.Override
        public CreateTicketTypeAttributeRequest build() {
            return new CreateTicketTypeAttributeRequest(
                    ticketTypeId,
                    name,
                    description,
                    dataType,
                    requiredToCreate,
                    requiredToCreateForContacts,
                    visibleOnCreate,
                    visibleToContacts,
                    multiline,
                    listItems,
                    allowMultipleValues,
                    additionalProperties);
        }
    }

    public enum DataType {
        STRING("string"),

        LIST("list"),

        INTEGER("integer"),

        DECIMAL("decimal"),

        BOOLEAN("boolean"),

        DATETIME("datetime"),

        FILES("files");

        private final String value;

        DataType(String value) {
            this.value = value;
        }

        @JsonValue
        @java.lang.Override
        public String toString() {
            return this.value;
        }
    }
}
