package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Iterator;
import java.util.List;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
public class JobItemCollection<T extends TypedData>
    extends TypedDataCollection<JobItem<T>>
    implements Iterator<JobItem<T>> {

    protected TypedDataCollectionIterator<JobItem<T>> iterator;

    public JobItemCollection() {
        iterator = new TypedDataCollectionIterator<JobItem<T>>(this);
    }

    public JobItemCollection(List<JobItem<T>> items) {
        this();
        this.page = items;
    }

    @SuppressWarnings("EmptyMethod")
    @JsonProperty("items")
    @Override
    public List<JobItem<T>> getPage() {
        return super.getPage();
    }

    @Override
    public JobItemCollection<T> nextPage() {
        return fetchNextPage(JobItemCollection.class);
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }

    public JobItem<T> next() {
        return iterator.next();
    }

    public void remove() {
        iterator.remove();
    }

}
