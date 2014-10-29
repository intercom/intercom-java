package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Iterator;
import java.util.List;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SubscriptionCollection extends TypedDataCollection<Subscription> implements Iterator<Subscription> {

    protected TypedDataCollectionIterator<Subscription> iterator;

    public SubscriptionCollection() {
        iterator = new TypedDataCollectionIterator<Subscription>(this);
    }

    @Override
    public SubscriptionCollection nextPage() {
        return fetchNextPage(SubscriptionCollection.class);
    }

    @SuppressWarnings("EmptyMethod")
    @JsonProperty("items")
    @Override
    public List<Subscription> getPage() {
        return super.getPage();
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }

    public Subscription next() {
        return iterator.next();
    }

    public void remove() {
        iterator.remove();
    }

    @Override
    public String toString() {
        return "SubscriptionCollection{" +
            "} " + super.toString();
    }
}
