package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
public class NotificationErrorCollection extends TypedDataCollection<NotificationError> {

    public NotificationErrorCollection() {
        type = "notification.list";
    }

    @SuppressWarnings("EmptyMethod")
    @JsonProperty("notifications")
    @Override
    public List<NotificationError> getPage() {
        return super.getPage();
    }

    @Override
    public NotificationErrorCollection nextPage() {
        return fetchNextPage(NotificationErrorCollection.class);
    }
}
