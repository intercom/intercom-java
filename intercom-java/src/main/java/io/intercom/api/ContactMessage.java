package io.intercom.api;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ContactMessage extends TypedMessage<Contact, ContactMessage> {

    public ContactMessage() {
    }

    @Override
    public String toString() {
        return "ContactMessage{} " + super.toString();
    }

}
