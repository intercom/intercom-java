package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Iterator;
import java.util.List;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
public class NotificationErrorCollection extends TypedDataCollection<NotificationError> implements Iterator<NotificationError> {

    protected TypedDataCollectionIterator<NotificationError> iterator;

    public NotificationErrorCollection() {
        type = "notification.list";
        iterator = new TypedDataCollectionIterator<NotificationError>(this);
    }

    @SuppressWarnings("EmptyMethod")
    @JsonProperty("notifications")
    @Override
    public List<NotificationError> getPage() {
        return super.getPage();
    }

    @Override
    public NotificationErrorCollection nextPage() {
        return fetchNextPage(NotificationErrorCollection.class);
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }

    public NotificationError next() {
        return iterator.next();
    }

    public void remove() {
        iterator.remove();
    }
}
