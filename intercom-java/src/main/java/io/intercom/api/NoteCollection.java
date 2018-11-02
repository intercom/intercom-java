package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
public class NoteCollection extends TypedDataCollection<Note> {


    public NoteCollection() {
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
}
