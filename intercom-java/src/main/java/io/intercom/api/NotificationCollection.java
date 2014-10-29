package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Iterator;
import java.util.List;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
public class NotificationCollection extends TypedDataCollection<Notification> implements Iterator<Notification> {

    protected TypedDataCollectionIterator<Notification> iterator;

    public NotificationCollection() {
        type = "notification.list";
        iterator = new TypedDataCollectionIterator<Notification>(this);
    }

    @Override
    public NotificationCollection nextPage() {
        return fetchNextPage(NotificationCollection.class);
    }

    @SuppressWarnings("EmptyMethod")
    @JsonProperty("notifications")
    @Override
    public List<Notification> getPage() {
        return super.getPage();
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }

    public Notification next() {
        return iterator.next();
    }

    public void remove() {
        iterator.remove();
    }

}
