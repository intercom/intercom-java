package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Iterator;
import java.util.List;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AdminCollection extends TypedDataCollection<Admin> implements Iterator<Admin> {
    protected TypedDataCollectionIterator<Admin> iterator;

    public AdminCollection() {
        type = "company.list";
        iterator = new TypedDataCollectionIterator<Admin>(this);
    }

    @Override
    public AdminCollection nextPage() {
        return fetchNextPage(AdminCollection.class);
    }

    @SuppressWarnings("EmptyMethod")
    @JsonProperty("admins")
    @Override
    public List<Admin> getPage() {
        return super.getPage();
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }

    public Admin next() {
        return iterator.next();
    }

    public void remove() {
        iterator.remove();
    }

}
