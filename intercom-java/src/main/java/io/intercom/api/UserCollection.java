package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Iterator;
import java.util.List;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserCollection extends TypedDataCollection<User> implements Iterator<User> {

    protected TypedDataCollectionIterator<User> iterator;

    public UserCollection() {
        iterator = new TypedDataCollectionIterator<User>(this);
    }

    public UserCollection(List<User> users) {
        this();
        this.pageItems = users;
    }

    @JsonProperty("users")
    @Override
    public List<User> getPageItems() {
        return super.getPageItems();
    }

    @Override
    public UserCollection nextPage() {
        return fetchNextPage(UserCollection.class);
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }

    public User next() {
        return iterator.next();
    }

    public void remove() {
        iterator.remove();
    }

}
