package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Iterator;
import java.util.List;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SegmentCollection extends TypedDataCollection<Segment> implements Iterator<Segment> {

    protected TypedDataCollectionIterator<Segment> iterator;

    public SegmentCollection() {
        type = "segment.list";
        iterator = new TypedDataCollectionIterator<Segment>(this);
    }

    @Override
    public SegmentCollection nextPage() {
        return fetchNextPage(SegmentCollection.class);
    }

    @JsonProperty("segments")
    @Override
    public List<Segment> getPageItems() {
        return super.getPageItems();
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }

    public Segment next() {
        return iterator.next();
    }

    public void remove() {
        iterator.remove();
    }

    @Override
    public String toString() {
        return "SegmentCollection{" +
            "} " + super.toString();
    }
}
