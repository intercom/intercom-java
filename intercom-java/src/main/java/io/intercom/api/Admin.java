package io.intercom.api;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Maps;

import java.util.Map;


@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Admin extends TypedData implements Replier {

    private static final Map<String, String> SENTINEL = Maps.newHashMap();

    public static final String TYPE_NOBODY = "nobody_admin";

    // don't make public for now
    static AdminCollection list(Map<String, String> params)
        throws AuthorizationException, ClientException, ServerException, InvalidException, RateLimitException {
        return DataResource.list(params, "admins", AdminCollection.class);
    }

    public static AdminCollection list()
        throws AuthorizationException, ClientException, ServerException, InvalidException, RateLimitException {
        return DataResource.list(SENTINEL, "admins", AdminCollection.class);
    }

    @SuppressWarnings("FieldCanBeLocal")
    @JsonProperty("type")
    private final String type = "admin";

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("created_at")
    private long createdAt;

    @JsonProperty("updated_at")
    private long updatedAt;

    @JsonProperty("open")
    private long open;

    @JsonProperty("closed")
    private long closed;

    public Admin() {
    }

    @JsonIgnore
    public String getReplyType() {
        return getType() + "_reply";
    }

    public String getType() {
        return type;
    }

    @JsonIgnore
    public boolean isNobody() {
        return TYPE_NOBODY.equalsIgnoreCase(getType());
    }

    @JsonIgnore
    public boolean isSomebody() {
        return (!isNobody()) && (getId() != null);
    }

    public String getId() {
        return id;
    }

    public Admin setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public long getOpen() {
        return open;
    }

    public long getClosed() {
        return closed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Admin admin = (Admin) o;

        if (closed != admin.closed) return false;
        if (createdAt != admin.createdAt) return false;
        if (open != admin.open) return false;
        if (updatedAt != admin.updatedAt) return false;
        if (email != null ? !email.equals(admin.email) : admin.email != null) return false;
        if (id != null ? !id.equals(admin.id) : admin.id != null) return false;
        if (name != null ? !name.equals(admin.name) : admin.name != null) return false;
        //noinspection RedundantIfStatement
        if (!type.equals(admin.type)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (int) (createdAt ^ (createdAt >>> 32));
        result = 31 * result + (int) (updatedAt ^ (updatedAt >>> 32));
        result = 31 * result + (int) (open ^ (open >>> 32));
        result = 31 * result + (int) (closed ^ (closed >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Admin{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", createdAt=" + createdAt +
            ", updatedAt=" + updatedAt +
            "} " + super.toString();
    }

}
