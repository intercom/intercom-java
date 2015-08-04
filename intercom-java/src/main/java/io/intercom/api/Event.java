package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Event extends TypedData {

    private static final List<String> BULK_METHODS = Lists.newArrayList("post");
    private static final ArrayList<String> BULK_PATHS = Lists.newArrayListWithExpectedSize(2);

    static {
        BULK_PATHS.add("bulk");
        BULK_PATHS.add("events");
    }

    public static void create(Event event) throws InvalidException, AuthorizationException {

        validateCreateEvent(event);

        if (event.getCreatedAt() == 0L) {
            event.setCreatedAt(System.currentTimeMillis() / 1000);
        }
        DataResource.create(event, "events", Void.class);
    }

    public static Job submit(List<JobItem<Event>> items)
        throws AuthorizationException, ClientException, ServerException, InvalidException, RateLimitException {
        return submit(items, null);
    }

    public static Job submit(List<JobItem<Event>> items, Job job)
        throws AuthorizationException, ClientException, ServerException, InvalidException, RateLimitException {
        return Job.submit(validateJobItems(items), job, BULK_PATHS);
    }

    public static JobItemCollection<Event> listJobErrorFeed(String jobID)
        throws AuthorizationException, ClientException, ServerException, InvalidException, RateLimitException {
        return Job.listJobErrorFeed(jobID, Event.class);
    }

    @VisibleForTesting
    static List<JobItem<Event>> validateJobItems(List<JobItem<Event>> items) {
        final JobSupport jobSupport = new JobSupport();
        for (JobItem<Event> item : items) {
            jobSupport.validateJobItem(item, BULK_METHODS);
            validateCreateEvent(item.getData());
        }

        return items;
    }

    private static final ErrorCollection INVALID_NAME = new ErrorCollection(
        Lists.newArrayList(
            new Error("invalid", "an event must supply an event name")));

    private static final ErrorCollection INVALID_USER = new ErrorCollection(
        Lists.newArrayList(
            new Error("invalid", "an event must supply either an email or a user id")));

    @VisibleForTesting
    static void validateCreateEvent(Event event) {
        if (Strings.isNullOrEmpty(event.getEventName())) {
            throw new InvalidException(INVALID_NAME);
        }

        if (Strings.isNullOrEmpty(event.getUserID())
            && Strings.isNullOrEmpty(event.getEmail())) {
            throw new InvalidException(INVALID_USER);
        }
    }

    @SuppressWarnings("FieldCanBeLocal")
    @JsonProperty("type")
    private final String type = "event";

    @JsonProperty("event_name")
    private String eventName;

    @JsonProperty("created_at")
    private long createdAt;

    @JsonProperty("email")
    private String email;

    @JsonProperty("user_id")
    private String userID;

    @JsonProperty("metadata")
    private Map<String, Object> metadata = Maps.newHashMap();

    public Event() {
    }

    public String getType() {
        return type;
    }

    public String getEventName() {
        return eventName;
    }

    public Event setEventName(String eventName) {
        this.eventName = eventName;
        return this;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    @SuppressWarnings("UnusedReturnValue")
    public Event setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Event setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getUserID() {
        return userID;
    }

    public Event setUserID(String userID) {
        this.userID = userID;
        return this;
    }

    public Event putMetadata(String name, String value) {
        metadata.put(name, value);
        return this;
    }

    public Event putMetadata(String name, boolean value) {
        metadata.put(name, value);
        return this;
    }

    public Event putMetadata(String name, int value) {
        metadata.put(name, value);
        return this;
    }

    public Event putMetadata(String name, double value) {
        metadata.put(name, value);
        return this;
    }

    public Event putMetadata(String name, long value) {
        metadata.put(name, value);
        return this;
    }

    public Event putMetadata(String name, float value) {
        metadata.put(name, value);
        return this;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public Event setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (createdAt != event.createdAt) return false;
        if (email != null ? !email.equals(event.email) : event.email != null) return false;
        if (eventName != null ? !eventName.equals(event.eventName) : event.eventName != null) return false;
        if (metadata != null ? !metadata.equals(event.metadata) : event.metadata != null) return false;
        if (!type.equals(event.type)) return false;
        //noinspection RedundantIfStatement
        if (userID != null ? !userID.equals(event.userID) : event.userID != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + (eventName != null ? eventName.hashCode() : 0);
        result = 31 * result + (int) (createdAt ^ (createdAt >>> 32));
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (userID != null ? userID.hashCode() : 0);
        result = 31 * result + (metadata != null ? metadata.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Event{" +
            "type='" + type + '\'' +
            ", eventName='" + eventName + '\'' +
            ", createdAt=" + createdAt +
            ", email='" + email + '\'' +
            ", userID='" + userID + '\'' +
            ", metadata=" + metadata +
            "} " + super.toString();
    }
}


