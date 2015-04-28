package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Iterator;
import java.util.List;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactCollection extends TypedDataCollection<Contact> implements Iterator<Contact> {

    protected TypedDataCollectionIterator<Contact> iterator;

    public ContactCollection() {
        iterator = new TypedDataCollectionIterator<Contact>(this);
    }

    public ContactCollection(List<Contact> contacts) {
        this();
        this.page = contacts;
    }

    @SuppressWarnings("EmptyMethod")
    @JsonProperty("contacts")
    @Override
    public List<Contact> getPage() {
        return super.getPage();
    }

    @Override
    public ContactCollection nextPage() {
        return fetchNextPage(ContactCollection.class);
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }

    public Contact next() {
        return iterator.next();
    }

    public void remove() {
        iterator.remove();
    }

}
