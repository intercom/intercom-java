package io.intercom.api;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Maps;

import java.net.URI;
import java.util.List;
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

    public static Admin find(String id)
        throws AuthorizationException, ClientException, ServerException, InvalidException, RateLimitException {
        final HttpClient resource = new HttpClient(UriBuilder.newBuilder().path("admins").path(id).build());
        return resource.get(Admin.class);
    }

    public static Admin setAwayMode(String id, boolean away_mode_enabled, boolean away_mode_reassign) {
        final URI uri = UriBuilder.newBuilder()
                .path("admins")
                .path(id)
                .path("away")
                .build();
        return new HttpClient(uri)
                .put(Admin.class, new AdminAwayMode(id, away_mode_enabled, away_mode_reassign));
    }

    @SuppressWarnings("FieldCanBeLocal")
    @JsonProperty("type")
    private String type = "admin";

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

    @JsonProperty("away_mode_enabled")
    private boolean awayModeEnabled;

    @JsonProperty("away_mode_reassign")
    private boolean awayModeReassign;

    @JsonProperty("avatar")
    private Avatar avatar;

    @JsonProperty("team_ids")
    private List<String> teamIds;

    @JsonProperty("admin_ids")
    private List<String> adminIds;

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

    public boolean getAwayModeEnabled(){
        return awayModeEnabled;
    }

    public boolean getAwayModeReassign(){
        return awayModeReassign;
    }

    public Avatar getAvatar(){
        return avatar;
    }

    public List getTeamIds(){
        return teamIds;
    }
    public List getAdminIds(){
        return adminIds;
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
        if (awayModeEnabled != admin.awayModeEnabled) return false;
        if (awayModeReassign != admin.awayModeReassign) return false;
        if (avatar != null ? !avatar.equals(admin.avatar) : admin.avatar != null) return false;
        if (teamIds != null ? !teamIds.equals(admin.teamIds) : admin.teamIds != null) return false;
        if (adminIds != null ? !adminIds.equals(admin.adminIds) : admin.adminIds != null) return false;

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
        result = 31 * result + (awayModeEnabled ? 1 : 0);
        result = 31 * result + (awayModeReassign ? 1 : 0);
        result = 31 * result + (avatar != null ? avatar.hashCode() : 0);
        result = 31 * result + (teamIds != null ? teamIds.hashCode() : 0);
        result = 31 * result + (adminIds != null ? adminIds.hashCode() : 0);
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
            ", awayModeEnabled=" + awayModeEnabled +
            ", awayModeReassign=" + awayModeReassign +
            ", teamIds=" + teamIds +
            ", adminIds=" + adminIds+
            ", avatar=" + avatar+
            "} " + super.toString();
    }

}
