/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.intercom.api.resources.dataattributes.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class DataAttributesListRequestModel {
    public static final DataAttributesListRequestModel CONTACT =
            new DataAttributesListRequestModel(Value.CONTACT, "contact");

    public static final DataAttributesListRequestModel CONVERSATION =
            new DataAttributesListRequestModel(Value.CONVERSATION, "conversation");

    public static final DataAttributesListRequestModel COMPANY =
            new DataAttributesListRequestModel(Value.COMPANY, "company");

    private final Value value;

    private final String string;

    DataAttributesListRequestModel(Value value, String string) {
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
        return (this == other)
                || (other instanceof DataAttributesListRequestModel
                        && this.string.equals(((DataAttributesListRequestModel) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case CONTACT:
                return visitor.visitContact();
            case CONVERSATION:
                return visitor.visitConversation();
            case COMPANY:
                return visitor.visitCompany();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static DataAttributesListRequestModel valueOf(String value) {
        switch (value) {
            case "contact":
                return CONTACT;
            case "conversation":
                return CONVERSATION;
            case "company":
                return COMPANY;
            default:
                return new DataAttributesListRequestModel(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        CONTACT,

        COMPANY,

        CONVERSATION,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitContact();

        T visitCompany();

        T visitConversation();

        T visitUnknown(String unknownType);
    }
}
