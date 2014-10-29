package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Iterator;
import java.util.List;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class TagCollection extends TypedDataCollection<Tag> implements Iterator<Tag> {

    protected TypedDataCollectionIterator<Tag> iterator;

    public TagCollection() {
        iterator = new TypedDataCollectionIterator<Tag>(this);
    }

    @Override
    public TagCollection nextPage() {
        return fetchNextPage(TagCollection.class);
    }

    @SuppressWarnings("EmptyMethod")
    @JsonProperty("tags")
    @Override
    public List<Tag> getPage() {
        return super.getPage();
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }

    public Tag next() {
        return iterator.next();
    }

    public void remove() {
        iterator.remove();
    }

    @Override
    public String toString() {
        return "TagCollection{" +
            "} " + super.toString();
    }
}
