package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Iterator;
import java.util.List;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConversationCollection extends TypedDataCollection<Conversation> {


    public ConversationCollection() {
        type = "conversation.list";
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
}
