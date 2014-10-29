package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Iterator;
import java.util.List;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConversationCollection extends TypedDataCollection<Conversation> implements Iterator<Conversation> {

    protected TypedDataCollectionIterator<Conversation> iterator;

    public ConversationCollection() {
        type = "conversation.list";
        iterator = new TypedDataCollectionIterator<Conversation>(this);
    }

    @SuppressWarnings("EmptyMethod")
    @JsonProperty("conversations")
    public List<Conversation> getPage() {
        return super.getPage();
    }

    @Override
    public ConversationCollection nextPage() {
        return fetchNextPage(ConversationCollection.class);
    }


    public boolean hasNext() {
        return iterator.hasNext();
    }

    public Conversation next() {
        return iterator.next();
    }

    public void remove() {
        iterator.remove();
    }

}
