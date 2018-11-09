package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserCollection extends TypedDataCollection<User> {


    public UserCollection() {
    }

    public UserCollection(List<User> users) {
        this();
        this.page = users;
    }

    @SuppressWarnings("EmptyMethod")
    @JsonProperty("users")
    @Override
    public List<User> getPage() {
        return super.getPage();
    }

    @Override
    public UserCollection nextPage() {
        return fetchNextPage(UserCollection.class);
    }
}
