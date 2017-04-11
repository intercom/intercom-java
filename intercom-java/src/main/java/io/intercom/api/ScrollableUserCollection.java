package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ScrollableUserCollection extends ScrollableTypedDataCollection<User> {

    @Override
    public ScrollableUserCollection scroll() {
        return DataResource.scroll(getScrollParam(), "users", ScrollableUserCollection.class);
    }

    @JsonProperty("users")
    @Override
    public List<User> getPage() {
        return super.getPage();
    }

}
