package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Subscription extends TypedData {

    private static final HashMap<String, String> SENTINEL = Maps.newHashMap();

    public static Subscription create(Subscription subscription) throws InvalidException, AuthorizationException {
        return DataResource.create(subscription, "subscriptions", Subscription.class);
    }

    public static Subscription update(Subscription subscription) throws InvalidException, AuthorizationException {
        return DataResource.update(subscription, "subscriptions", subscription.getId(), Subscription.class);
    }

    public static Subscription delete(Subscription subscription) throws InvalidException, AuthorizationException {
        return DataResource.delete(subscription.getId(), "subscriptions", Subscription.class);
    }

    public static Subscription find(String id) throws InvalidException, AuthorizationException {
        final HttpClient resource = new HttpClient(UriBuilder.newBuilder().path("subscriptions").path(id).build());
        return resource.get(Subscription.class);
    }

    public static SubscriptionCollection list() throws InvalidException, AuthorizationException {
        return DataResource.list(SENTINEL, "subscriptions", SubscriptionCollection.class);
    }

    public static Subscription ping(String id) throws InvalidException, AuthorizationException {
        final HttpClient resource = new HttpClient(UriBuilder.newBuilder().path("subscriptions").path(id).path("ping").build());
        return resource.post(Subscription.class, null);
    }

    public static Subscription ping(Subscription subscription) throws InvalidException, AuthorizationException {
        return ping(subscription.getId());
    }

    public static NotificationCollection sentFeed(String id) throws InvalidException, AuthorizationException {
        final URI feedURI = UriBuilder.newBuilder()
            .path("subscriptions")
            .path(id)
            .path("sent")
            .build();
        final HttpClient resource = new HttpClient(feedURI);
        return resource.get(NotificationCollection.class);
    }

    public static NotificationErrorCollection errorFeed(String id) throws InvalidException, AuthorizationException {
        final URI feedURI = UriBuilder.newBuilder()
            .path("subscriptions")
            .path(id)
            .path("error")
            .build();
        final HttpClient resource = new HttpClient(feedURI);
        return resource.get(NotificationErrorCollection.class);
    }

    @SuppressWarnings("UnusedDeclaration")
    public static class Topic {
        private static final String SUBTYPE_WILDCARD = "*";

        private static final String TEXT = "text";

        private final static String COMPANY_NAME = "company";

        private final static String CONVERSATION_NAME = "conversation";

        private final static String CONVERSATION_PART_NAME = "conversation_part";

        private static final String USER_NAME = "user";

        private static final String CONTACT_NAME = "contact";

        private static final String VISITOR_NAME = "visitor";

        private static final String EVENT_NAME = "event";

        public static final Topic PING = new Topic("ping", SUBTYPE_WILDCARD);

        public static final Topic COMPANY = new Topic(COMPANY_NAME, SUBTYPE_WILDCARD);

        public static final Topic COMPANY_CREATED = new Topic(COMPANY_NAME, "created");

        public static final Topic CONVERSATION = new Topic(CONVERSATION_NAME, SUBTYPE_WILDCARD);

        public static final Topic CONVERSATION_USER_CREATED = new Topic(CONVERSATION_NAME, "user.created");

        public static final Topic CONVERSATION_USER_REPLY = new Topic(CONVERSATION_NAME, "user.replied");

        public static final Topic CONVERSATION_ADMIN_REPLY = new Topic(CONVERSATION_NAME, "admin.replied");

        public static final Topic CONVERSATION_ADMIN_ASSIGNED = new Topic(CONVERSATION_NAME, "admin.assigned");

        public static final Topic CONVERSATION_ADMIN_CLOSED = new Topic(CONVERSATION_NAME, "admin.closed");

        public static final Topic CONVERSATION_ADMIN_OPEN = new Topic(CONVERSATION_NAME, "admin.opened");

        public static final Topic CONVERSATION_ADMIN_NOTED = new Topic(CONVERSATION_NAME, "admin.noted");

        public static final Topic CONVERSATION_ADMIN_SINGLE_CREATED = new Topic(CONVERSATION_NAME, "admin.single.created");

        public static final Topic CONVERSATION_PART_TAG_CREATED= new Topic(CONVERSATION_PART_NAME, "tag.created");

        public static final Topic USER = new Topic(USER_NAME, SUBTYPE_WILDCARD);

        public static final Topic USER_CREATED = new Topic(USER_NAME, "created");

        public static final Topic USER_DELETED = new Topic(USER_NAME, "deleted");

        public static final Topic USER_EMAIL_UPDATED = new Topic(USER_NAME, "email.updated");

        public static final Topic USER_UNSUBSCRIBED = new Topic(USER_NAME, "unsubscribed");

        public static final Topic USER_TAG_CREATED = new Topic(USER_NAME, "tag.created");

        public static final Topic USER_TAG_DELETED = new Topic(USER_NAME, "tag.deleted");

        public static final Topic CONTACT = new Topic(CONTACT_NAME, SUBTYPE_WILDCARD);

        public static final Topic CONTACT_ADDED_EMAIL = new Topic(CONTACT_NAME, "added_email");

        public static final Topic CONTACT_CREATED= new Topic(CONTACT_NAME, "created");

        public static final Topic CONTACT_SIGNED_UP = new Topic(CONTACT_NAME, "signed_up");

        public static final Topic VISITOR = new Topic(VISITOR_NAME, SUBTYPE_WILDCARD);

        public static final Topic VISITOR_SIGNED_UP = new Topic(VISITOR_NAME, "signed_up");

        public static final Topic EVENT_CREATED = new Topic(EVENT_NAME, "created");

        public static final Topic ALL_TOPIC = valueOf("all");

        public static Topic valueOf(String type) throws IllegalArgumentException {
            if (type.contains(".")) {
                final String[] split = type.split("\\.", 2); // fragile: assume one dot
                return new Topic(split[0], split[1]);
            } else {
                return new Topic(type);
            }
        }

        private String type;

        private String subType;

        private String toString;

        public Topic(String type) {
            this(type, SUBTYPE_WILDCARD);
        }

        public Topic(String type, String subType) {
            Preconditions.checkArgument(type != null, "type part cannot be null");
            Preconditions.checkArgument(subType != null, "subType part cannot be null");
            this.type = type;
            this.subType = subType;
            // memo the string representation
            if (SUBTYPE_WILDCARD.equals(subType)) {
                toString = type;
            } else {
                toString = type + "." + subType;
            }
        }

        public String getType() {
            return type;
        }

        public String getSubType() {
            return subType;
        }

        public boolean isCompatible(String type) {
            return this.isCompatible(valueOf(type));
        }

        public boolean isCompatible(Topic other) {
            if (other == null) {
                return false;
            }
            //noinspection SimplifiableIfStatement
            if (type.equalsIgnoreCase(other.type) && (subType.equals(SUBTYPE_WILDCARD) || other.subType.equals(SUBTYPE_WILDCARD))) {
                return true;
            } else {
                return this.type.equalsIgnoreCase(other.type) && this.subType.equalsIgnoreCase(other.subType);
            }
        }

        @Override
        public int hashCode() {
            int result = type != null ? type.hashCode() : 0;
            result = 31 * result + (subType != null ? subType.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return toString;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            final Topic Topic = (Topic) o;
            if (subType != null ? !subType.equals(Topic.subType) : Topic.subType != null) {
                return false;
            }
            //noinspection RedundantIfStatement
            if (type != null ? !type.equals(Topic.type) : Topic.type != null) {
                return false;
            }
            return true;
        }


    }

    @SuppressWarnings("FieldCanBeLocal")
    @JsonProperty("type")
    private final String type = "notification_subscription";

    @JsonProperty("id")
    private String id;

    @JsonProperty("created_at")
    private long createdAt;

    @JsonProperty("updated_at")
    private long updatedAt;

    @JsonProperty("service_type")
    private final String serviceType = "web";

    @JsonProperty("app_id")
    private String appID;

    @JsonProperty("url")
    private URI url;

    @JsonProperty("self")
    private URI self;

    @JsonProperty("topics")
    private List<Topic> topics = Lists.newArrayList();

    @JsonProperty("metadata")
    private Map<String, ArrayList<String>> metadata = Maps.newHashMap();

    @JsonProperty("active")
    private boolean active;

    @JsonProperty("hub_secret")
    private String hubSecret;

    @JsonProperty("mode")
    private String mode = "point";

    @JsonProperty("links")
    private Map<String, URI> links = Maps.newHashMap();

    @JsonProperty("notes")
    private List<String> notes = Lists.newArrayList();

    public Subscription() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public String getServiceType() {
        return serviceType;
    }

    public String getAppID() {
        return appID;
    }

    public void setAppID(String appID) {
        this.appID = appID;
    }

    public URI getUrl() {
        return url;
    }

    public void setUrl(URI url) {
        this.url = url;
    }

    public URI getSelf() {
        return self;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public void addTopic(Topic topic) {
        this.topics.add(topic);
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Map<String, ArrayList<String>> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, ArrayList<String>> metadata) {
        this.metadata = metadata;
    }

    public String getHubSecret() {
        return hubSecret;
    }

    public void setHubSecret(String hubSecret) {
        this.hubSecret = hubSecret;
    }

    public String getMode() {
        return mode;
    }

    public List<String> getNotes() {
        return notes;
    }

    public void setNotes(List<String> notes) {
        this.notes = notes;
    }

    @JsonIgnore
    public String getURLString() {
        return url.toASCIIString();
    }

    @JsonIgnore
    public boolean requiresSignature() {
        return getHubSecret() != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subscription that = (Subscription) o;

        if (active != that.active) return false;
        if (createdAt != that.createdAt) return false;
        if (updatedAt != that.updatedAt) return false;
        if (appID != null ? !appID.equals(that.appID) : that.appID != null) return false;
        if (hubSecret != null ? !hubSecret.equals(that.hubSecret) : that.hubSecret != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (links != null ? !links.equals(that.links) : that.links != null) return false;
        if (metadata != null ? !metadata.equals(that.metadata) : that.metadata != null) return false;
        if (mode != null ? !mode.equals(that.mode) : that.mode != null) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;
        if (self != null ? !self.equals(that.self) : that.self != null) return false;
        if (!serviceType.equals(that.serviceType)) return false;
        if (topics != null ? !topics.equals(that.topics) : that.topics != null) return false;
        if (!type.equals(that.type)) return false;
        //noinspection RedundantIfStatement
        if (url != null ? !url.equals(that.url) : that.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (int) (createdAt ^ (createdAt >>> 32));
        result = 31 * result + (int) (updatedAt ^ (updatedAt >>> 32));
        result = 31 * result + (serviceType.hashCode());
        result = 31 * result + (appID != null ? appID.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (self != null ? self.hashCode() : 0);
        result = 31 * result + (topics != null ? topics.hashCode() : 0);
        result = 31 * result + (metadata != null ? metadata.hashCode() : 0);
        result = 31 * result + (active ? 1 : 0);
        result = 31 * result + (hubSecret != null ? hubSecret.hashCode() : 0);
        result = 31 * result + (mode != null ? mode.hashCode() : 0);
        result = 31 * result + (links != null ? links.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Subscription{" +
            "id='" + id + '\'' +
            ", createdAt=" + createdAt +
            ", updatedAt=" + updatedAt +
            ", serviceType='" + serviceType + '\'' +
            ", appID='" + appID + '\'' +
            ", url=" + url +
            ", self=" + self +
            ", topics=" + topics +
            ", metadata=" + metadata +
            ", active=" + active +
            ", hubSecret='" + hubSecret + '\'' +
            ", mode='" + mode + '\'' +
            ", links=" + links +
            ", notes=" + notes +
            "} " + super.toString();
    }


}
