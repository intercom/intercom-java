package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Maps;

import java.util.HashMap;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Segment extends TypedData {

    private static final HashMap<String, String> SENTINEL = Maps.newHashMap();

    public static Segment find(String id) throws InvalidException, AuthorizationException {
        final HttpClient resource = new HttpClient(UriBuilder.newBuilder().path("segments").path(id).build());
        return resource.get(Segment.class);
    }

    public static SegmentCollection list() throws InvalidException, AuthorizationException {
        return DataResource.list(SENTINEL, "segments", SegmentCollection.class);
    }

    public static Segment update(Segment segment) throws InvalidException, AuthorizationException {
        if (segment.getId() == null) {
            throw new InvalidException("segment updates must supply an id");
        }
        return DataResource.update(segment, "segments", Segment.class);
    }

    @JsonProperty("type")
    private final String type = "segment";

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("created_at")
    private long createdAt;

    @JsonProperty("updated_at")
    private long updatedAt;

    @SuppressWarnings("WeakerAccess")
    public Segment() {
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Segment setName(String name) {
        this.name = name;
        return this;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Segment segment = (Segment) o;

        if (createdAt != segment.createdAt) return false;
        if (updatedAt != segment.updatedAt) return false;
        if (id != null ? !id.equals(segment.id) : segment.id != null) return false;
        if (name != null ? !name.equals(segment.name) : segment.name != null) return false;
        //noinspection RedundantIfStatement
        if (!type.equals(segment.type)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (int) (createdAt ^ (createdAt >>> 32));
        result = 31 * result + (int) (updatedAt ^ (updatedAt >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Segment{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", createdAt=" + createdAt +
            ", updatedAt=" + updatedAt +
            "} " + super.toString();
    }

}
