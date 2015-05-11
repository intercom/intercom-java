package io.intercom.api;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class UserMessage extends TypedMessage<User, UserMessage>  {

    public UserMessage() {
    }

    @JsonIgnore
    @Deprecated
    public UserMessage setUser(User user) {
        this.from = user;
        return this;
    }

    @Override
    public String toString() {
        return "UserMessage{} " + super.toString();
    }
}
