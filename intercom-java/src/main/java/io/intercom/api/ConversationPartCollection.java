package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConversationPartCollection extends TypedDataCollection<ConversationPart> {

    public ConversationPartCollection() {
        type = "conversation_part.list";
    }

    @JsonProperty("conversation_parts")
    public List<ConversationPart> getPageItems() {
        return super.getPageItems();
    }

    @Override
    public ConversationPartCollection nextPage() {
        return new ConversationPartCollection();
    }
}
