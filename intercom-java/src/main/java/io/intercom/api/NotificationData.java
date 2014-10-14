package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
public class NotificationData extends TypedData {

    @JsonProperty("type")
    protected String type;

    @JsonProperty
    private Map item;

    public NotificationData() {
        type = "notification_event_data";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map getItem() {
        return item;
    }

    public void setItem(Map item) {
        this.item = item;
    }

    @Override
    public int hashCode() {
        return item != null ? item.hashCode() : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NotificationData that = (NotificationData) o;

        //noinspection RedundantIfStatement
        if (item != null ? !item.equals(that.item) : that.item != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "NotificationData{" +
            "type='" + type + '\'' +
            ", item=" + item +
            "} " + super.toString();
    }
}
