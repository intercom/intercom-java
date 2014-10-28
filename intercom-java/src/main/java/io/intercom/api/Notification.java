package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Maps;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties({"intercom"})
public class Notification extends TypedData {

    public static Notification readJSON(String json) throws InvalidException {
        try {
            return MapperSupport.objectMapper().readValue(json, Notification.class);
        } catch (IOException e) {
            throw new InvalidException("could not parse json string [" + e.getMessage() + "]", e);
        }
    }

    public static Notification readJSON(InputStream json) throws InvalidException {
        try {
            return MapperSupport.objectMapper().readValue(json, Notification.class);
        } catch (IOException e) {
            throw new InvalidException("could not parse json stream [" + e.getMessage() + "]", e);
        }
    }

    @JsonProperty("type")
    private final String type = "notification_event";

    @JsonProperty("id")
    private String id;

    @JsonProperty("topic")
    private String topic;

    @JsonProperty("app_id")
    private String appID;

    @JsonProperty("data")
    private NotificationData data;

    @JsonProperty("delivery_status")
    private String deliveryStatus;

    @JsonProperty("delivery_attempts")
    private int deliveryAttempts;

    @JsonProperty("delivered_at")
    private long deliveredAt;

    @JsonProperty("first_sent_at")
    private long firstSentAt;

    @JsonProperty("created_at")
    private long createdAt;

    @JsonProperty
    private Map<String, URI> links = Maps.newHashMap();

    @JsonProperty("self")
    private URI self;

    public Notification() {
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getAppID() {
        return appID;
    }

    public void setAppID(String appID) {
        this.appID = appID;
    }

    public NotificationData getData() {
        return data;
    }

    public void setData(NotificationData data) {
        this.data = data;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public int getDeliveryAttempts() {
        return deliveryAttempts;
    }

    public void setDeliveryAttempts(int deliveryAttempts) {
        this.deliveryAttempts = deliveryAttempts;
    }

    public long getDeliveredAt() {
        return deliveredAt;
    }

    public void setDeliveredAt(long deliveredAt) {
        this.deliveredAt = deliveredAt;
    }

    public long getFirstSentAt() {
        return firstSentAt;
    }

    public void setFirstSentAt(long firstSentAt) {
        this.firstSentAt = firstSentAt;
    }


    public long getCreatedAt() {
        return createdAt;
    }

    public Map<String, URI> getLinks() {
        return links;
    }

    public void setLinks(Map<String, URI> links) {
        this.links = links;
    }

    public URI getSelf() {
        return self;
    }

    public void setSelf(URI self) {
        this.self = self;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (topic != null ? topic.hashCode() : 0);
        result = 31 * result + (appID != null ? appID.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (deliveryStatus != null ? deliveryStatus.hashCode() : 0);
        result = 31 * result + deliveryAttempts;
        result = 31 * result + (int) (deliveredAt ^ (deliveredAt >>> 32));
        result = 31 * result + (int) (firstSentAt ^ (firstSentAt >>> 32));
        result = 31 * result + (int) (createdAt ^ (createdAt >>> 32));
        result = 31 * result + (links != null ? links.hashCode() : 0);
        result = 31 * result + (self != null ? self.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Notification that = (Notification) o;

        if (createdAt != that.createdAt) return false;
        if (deliveredAt != that.deliveredAt) return false;
        if (deliveryAttempts != that.deliveryAttempts) return false;
        if (firstSentAt != that.firstSentAt) return false;
        if (appID != null ? !appID.equals(that.appID) : that.appID != null) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (deliveryStatus != null ? !deliveryStatus.equals(that.deliveryStatus) : that.deliveryStatus != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (links != null ? !links.equals(that.links) : that.links != null) return false;
        if (self != null ? !self.equals(that.self) : that.self != null) return false;
        //noinspection RedundantIfStatement
        if (topic != null ? !topic.equals(that.topic) : that.topic != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "Notification{" +
            "type='" + type + '\'' +
            ", id='" + id + '\'' +
            ", topic='" + topic + '\'' +
            ", appID='" + appID + '\'' +
            ", data=" + data +
            ", deliveryStatus='" + deliveryStatus + '\'' +
            ", deliveryAttempts=" + deliveryAttempts +
            ", deliveredAt=" + deliveredAt +
            ", firstSentAt=" + firstSentAt +
            ", createdAt=" + createdAt +
            ", links=" + links +
            ", self=" + self +
            "} " + super.toString();
    }
}
