package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Iterator;
import java.util.List;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
public class NoteCollection extends TypedDataCollection<Note> implements Iterator<Note> {

    protected TypedDataCollectionIterator<Note> iterator;

    public NoteCollection() {
        iterator = new TypedDataCollectionIterator<Note>(this);
    }

    @Override
    public NoteCollection nextPage() {
        return fetchNextPage(NoteCollection.class);
    }

    @SuppressWarnings("EmptyMethod")
    @JsonProperty("notes")
    @Override
    public List<Note> getPage() {
        return super.getPage();
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }

    public Note next() {
        return iterator.next();
    }

    public void remove() {
        iterator.remove();
    }

}
