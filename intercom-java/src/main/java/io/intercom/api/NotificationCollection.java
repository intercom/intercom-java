package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
public class NotificationCollection extends TypedDataCollection<Notification> {


    public NotificationCollection() {
        type = "notification.list";
    }

    @Override
    public NotificationCollection nextPage() {
        return fetchNextPage(NotificationCollection.class);
    }

    @SuppressWarnings("EmptyMethod")
    @JsonProperty("notifications")
    @Override
    public List<Notification> getPage() {
        return super.getPage();
    }
}
