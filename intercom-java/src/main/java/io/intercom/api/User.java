package io.intercom.api;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class User extends TypedData implements Replier {

    private static final Map<String, String> SENTINEL = Maps.newHashMap();
    private static final ArrayList<String> BULK_PATHS = Lists.newArrayListWithExpectedSize(2);

    static {
        BULK_PATHS.add("bulk");
        BULK_PATHS.add("users");
    }

    private static List<CompanyWithStringPlan> buildUserUpdateCompanies(User user) {
        return CompanyUpdateBuilder.buildUserUpdateCompanies(user.getCompanyCollection(), user.getRemoveCompanyCollection());
    }

    public static User find(String id)
        throws AuthorizationException, ClientException, ServerException, InvalidException, RateLimitException {
        final URI users = UriBuilder.newBuilder().path("users").path(id).build();
        final HttpClient resource = new HttpClient(users);
        return resource.get(User.class);
    }

    public static User find(Map<String, String> params)
        throws AuthorizationException, ClientException, ServerException, InvalidException, RateLimitException {
        if ((!params.containsKey("email")) && (!params.containsKey("user_id"))) {
            throw new InvalidException("a user find must include an email or user_id parameter");
        }
        return DataResource.find(params, "users", User.class);
    }

    public static User create(User user)
        throws AuthorizationException, ClientException, ServerException, InvalidException, RateLimitException {
        return DataResource.create(UserUpdate.buildFrom(user), "users", User.class);
    }

    public static User update(User user) throws InvalidException, AuthorizationException {
        // only send fields the server allows for update
        return DataResource.update(UserUpdate.buildFrom(user), "users", User.class);
    }

    public static User delete(String id)
        throws AuthorizationException, ClientException, ServerException, InvalidException, RateLimitException {
        return DataResource.delete(id, "users", User.class);
    }

    public static UserCollection list(Map<String, String> params)
        throws AuthorizationException, ClientException, ServerException, InvalidException, RateLimitException {
        return DataResource.list(params, "users", UserCollection.class);
    }

    public static UserCollection list()
        throws AuthorizationException, ClientException, ServerException, InvalidException, RateLimitException {
        return DataResource.list(SENTINEL, "users", UserCollection.class);
    }

    public static ScrollableUserCollection scroll()
            throws AuthorizationException, ClientException, ServerException, InvalidException, RateLimitException {
        return DataResource.scroll(null, "users", ScrollableUserCollection.class);
    }

    public static Job submit(final List<JobItem<User>> items)
        throws AuthorizationException, ClientException, ServerException, InvalidException, RateLimitException {
        return submit(items, null);
    }

    public static Job submit(final List<JobItem<User>> items, Job job)
        throws AuthorizationException, ClientException, ServerException, InvalidException, RateLimitException {
        return Job.submit(UserUpdate.validateAndConvertJobItems(items), job, BULK_PATHS);
    }

    public static JobItemCollection<User> listJobErrorFeed(String jobID)
        throws AuthorizationException, ClientException, ServerException, InvalidException, RateLimitException {
        return Job.listJobErrorFeed(jobID, User.class);
    }

    @SuppressWarnings("UnusedDeclaration")
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    static class UserUpdate extends TypedData {

        private static final List<String> BULK_METHODS = Lists.newArrayList("post", "delete");

        static UserUpdate buildFrom(User user) {
            final UserUpdate userUpdate = new UserUpdate();
            userUpdate.userId = user.getUserId();
            userUpdate.email = user.getEmail();
            userUpdate.phone = user.getPhone();
            userUpdate.id = user.getId();
            userUpdate.remoteCreatedAt = user.getRemoteCreatedAt();
            userUpdate.name = user.getName();
            userUpdate.lastSeenIp = user.getLastSeenIp();
            userUpdate.customAttributes = user.getCustomAttributes();
            userUpdate.lastSeenUserAgent = user.getUserAgentData();

            if(! buildUserUpdateCompanies(user).isEmpty()) {
                userUpdate.companyCollection = buildUserUpdateCompanies(user);
            }

            userUpdate.lastRequestAt = user.getLastRequestAt();
            userUpdate.signedUpAt = user.getSignedUpAt();
            userUpdate.unsubscribedFromEmails = user.getUnsubscribedFromEmails();
            userUpdate.updateLastRequestAt = user.isUpdateLastRequestAt();
            userUpdate.newSession = user.isNewSession();
            return userUpdate;
        }

        static List<JobItem<UserUpdate>> validateAndConvertJobItems(List<JobItem<User>> items) {
            final List<JobItem<UserUpdate>> updateItems = Lists.newArrayList();
            final JobSupport jobSupport = new JobSupport();
            for (JobItem<User> item : items) {
                jobSupport.validateJobItem(item, BULK_METHODS);
                final JobItem<UserUpdate> jobItem = new JobItem<UserUpdate>(item.getMethod(), buildFrom(item.getData()), item.getData().getType());
                updateItems.add(jobItem);
            }
            return updateItems;
        }

        @JsonProperty("type")
        @JsonInclude(JsonInclude.Include.NON_DEFAULT)
        private String type;

        @JsonProperty("id")
        private String id;

        @JsonProperty("user_id")
        private String userId;

        @JsonProperty("email")
        private String email;

        @JsonProperty("phone")
        private String phone;

        @JsonProperty("remote_created_at")
        private long remoteCreatedAt;

        @JsonProperty("name")
        private String name;

        @JsonProperty("last_seen_ip")
        private String lastSeenIp;

        @JsonIgnoreProperties(ignoreUnknown = false)
        @JsonProperty("custom_attributes")
        private Map<String, CustomAttribute> customAttributes = Maps.newHashMap();

        @JsonProperty("last_seen_user_agent")
        private String lastSeenUserAgent;

        @JsonProperty("companies")
        private List<CompanyWithStringPlan> companyCollection;

        @JsonProperty("last_request_at")
        private long lastRequestAt;

        @JsonProperty("signed_up_at")
        private long signedUpAt;

        /**
         * Making this a Boolean allows us to send true or false as set
         * values leaving null the ignored field for NON_DEFAULT. A
         * primitive would result in false not being sent
         */
        @JsonProperty("unsubscribed_from_emails")
        @JsonInclude(JsonInclude.Include.NON_DEFAULT)
        private Boolean unsubscribedFromEmails;

        /**
         * Making this a Boolean allows us to send true or false as set
         * values leaving null the ignored field for NON_DEFAULT. A
         * primitive would result in false not being sent
         */
        @JsonProperty("update_last_request_at")
        @JsonInclude(JsonInclude.Include.NON_DEFAULT)
        private Boolean updateLastRequestAt;

        /**
         * Making this a Boolean allows us to send true or false as set
         * values leaving null the ignored field for NON_DEFAULT. A
         * primitive would result in false not being sent
         */
        @JsonProperty("new_session")
        @JsonInclude(JsonInclude.Include.NON_DEFAULT)
        private Boolean newSession;

        public UserUpdate() {
        }

        public String getType() {
            return type;
        }

        public String getId() {
            return id;
        }

        public String getUserId() {
            return userId;
        }

        public String getEmail() {
            return email;
        }

        public String getPhone() {
            return phone;
        }

        public long getRemoteCreatedAt() {
            return remoteCreatedAt;
        }

        public String getName() {
            return name;
        }

        public String getLastSeenIp() {
            return lastSeenIp;
        }

        public Map<String, CustomAttribute> getCustomAttributes() {
            return customAttributes;
        }

        public String getLastSeenUserAgent() {
            return lastSeenUserAgent;
        }

        public List<CompanyWithStringPlan> getCompanyCollection() {
            return companyCollection;
        }

        public long getLastRequestAt() {
            return lastRequestAt;
        }

        public long getSignedUpAt() {
            return signedUpAt;
        }

        public Boolean getUnsubscribedFromEmails() {
            return unsubscribedFromEmails;
        }

        public Boolean isUpdateLastRequestAt() {
            return updateLastRequestAt;
        }

        public Boolean isNewSession() {
            return newSession;
        }
    }

    @JsonProperty("type")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private final String type = "user";

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("pseudonym")
    private String pseudonym;

    @JsonProperty("avatar")
    private Avatar avatar;

    @JsonProperty("created_at")
    private long createdAt;

    @JsonProperty("updated_at")
    private long updatedAt;

    @JsonProperty("remote_created_at")
    private long remoteCreatedAt;

    @JsonProperty("unsubscribed_from_emails")
    private Boolean unsubscribedFromEmails;

    @JsonProperty("session_count")
    private int sessionCount;

    @JsonProperty("last_request_at")
    private long lastRequestAt;

    @JsonProperty("signed_up_at")
    private long signedUpAt;

    @JsonProperty("last_seen_ip")
    private String lastSeenIp;

    @JsonIgnoreProperties(ignoreUnknown = false)
    @JsonProperty("custom_attributes")
    private Map<String, CustomAttribute> customAttributes = Maps.newHashMap();

    @JsonProperty("user_agent_data")
    private String userAgentData;

    @JsonProperty("location_data")
    private LocationData locationData;

    @JsonIgnoreProperties(ignoreUnknown = false)
    @JsonProperty("companies")
    private CompanyCollection companyCollection = new CompanyCollection();

    @JsonProperty("social_profiles")
    private SocialProfileCollection socialProfileCollection = new SocialProfileCollection();

    @JsonProperty("segments")
    private SegmentCollection segmentCollection = new SegmentCollection();

    @JsonProperty("tags")
    private TagCollection tagCollection = new TagCollection();

    @JsonProperty("update_last_request_at")
    private Boolean updateLastRequestAt;

    @JsonProperty("new_session")
    private Boolean newSession;

    private Boolean untag;

    private CompanyCollection removeCompanyCollection = new CompanyCollection();

    public User() {
    }

    public User untag() {
        untag = Boolean.TRUE;
        return this;
    }

    boolean isUntag() {
        return untag == null ? false : untag;
    }

    @JsonIgnore
    public String getReplyType() {
        return getType() + "_reply";
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public User setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public User setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getPseudonym() {
        return pseudonym;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public long getRemoteCreatedAt() {
        return remoteCreatedAt;
    }

    public User setRemoteCreatedAt(long remoteCreatedAt) {
        this.remoteCreatedAt = remoteCreatedAt;
        return this;
    }

    public Boolean getUnsubscribedFromEmails() {
        return unsubscribedFromEmails;
    }

    public User setUnsubscribedFromEmails(boolean unsubscribedFromEmails) {
        this.unsubscribedFromEmails = unsubscribedFromEmails;
        return this;
    }

    public int getSessionCount() {
        return sessionCount;
    }

    public long getLastRequestAt() {
        return lastRequestAt;
    }

    public User setLastRequestAt(long lastRequestAt) {
        this.lastRequestAt = lastRequestAt;
        return this;
    }

    public long getSignedUpAt() {
        return signedUpAt;
    }

    public User setSignedUpAt(long signedUpAt) {
        this.signedUpAt = signedUpAt;
        return this;
    }

    public String getLastSeenIp() {
        return lastSeenIp;
    }

    public User setLastSeenIp(String lastSeenIp) {
        this.lastSeenIp = lastSeenIp;
        return this;
    }

    public Map<String, CustomAttribute> getCustomAttributes() {
        return customAttributes;
    }

    public User setCustomAttributes(Map<String, CustomAttribute> customAttributes) {
        this.customAttributes = customAttributes;
        return this;
    }

    public User addCustomAttribute(CustomAttribute customAttribute) {
        this.customAttributes.put(customAttribute.getName(), customAttribute);
        return this;
    }

    public String getUserAgentData() {
        return userAgentData;
    }

    public User setUserAgentData(String userAgentData) {
        this.userAgentData = userAgentData;
        return this;
    }

    public LocationData getLocationData() {
        return locationData;
    }

    public CompanyCollection getCompanyCollection() {
        return companyCollection;
    }

    public User setCompanyCollection(CompanyCollection companyCollection) {
        this.companyCollection = companyCollection;
        return this;
    }

    public User addCompany(Company company) {
        // sneak past the immutable list
        this.companyCollection.addCompany(company);
        return this;
    }

    public User removeCompany(Company company) {
        this.removeCompanyCollection.addCompany(company);
        return this;
    }

    public SocialProfileCollection getSocialProfileCollection() {
        return socialProfileCollection;
    }

    public SegmentCollection getSegmentCollection() {
        return segmentCollection;
    }

    public TagCollection getTagCollection() {
        return tagCollection;
    }

    public Boolean isUpdateLastRequestAt() {
        return updateLastRequestAt;
    }

    public User setUpdateLastRequestAt(boolean updateLastRequestAt) {
        this.updateLastRequestAt = updateLastRequestAt;
        return this;
    }

    public Boolean isNewSession() {
        return newSession;
    }

    public User setNewSession(boolean newSession) {
        this.newSession = newSession;
        return this;
    }

    CompanyCollection getRemoveCompanyCollection() {
        return removeCompanyCollection;
    }

    void setRemoveCompanyCollection(CompanyCollection removeCompanyCollection) {
        this.removeCompanyCollection = removeCompanyCollection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (createdAt != user.createdAt) return false;
        if (lastRequestAt != user.lastRequestAt) return false;
        if (signedUpAt != user.signedUpAt) return false;
        if (newSession != user.newSession) return false;
        if (remoteCreatedAt != user.remoteCreatedAt) return false;
        if (sessionCount != user.sessionCount) return false;
        if (unsubscribedFromEmails != user.unsubscribedFromEmails) return false;
        if (updateLastRequestAt != user.updateLastRequestAt) return false;
        if (updatedAt != user.updatedAt) return false;
        if (avatar != null ? !avatar.equals(user.avatar) : user.avatar != null) return false;
        if (companyCollection != null ? !companyCollection.equals(user.companyCollection) : user.companyCollection != null)
            return false;
        if (customAttributes != null ? !customAttributes.equals(user.customAttributes) : user.customAttributes != null)
            return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (phone != null ? !phone.equals(user.phone) : user.phone != null) return false;
        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (lastSeenIp != null ? !lastSeenIp.equals(user.lastSeenIp) : user.lastSeenIp != null) return false;
        if (locationData != null ? !locationData.equals(user.locationData) : user.locationData != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (segmentCollection != null ? !segmentCollection.equals(user.segmentCollection) : user.segmentCollection != null)
            return false;
        if (socialProfileCollection != null ? !socialProfileCollection.equals(user.socialProfileCollection) : user.socialProfileCollection != null)
            return false;
        if (tagCollection != null ? !tagCollection.equals(user.tagCollection) : user.tagCollection != null)
            return false;
        if (!type.equals(user.type)) return false;
        if (untag != null ? !untag.equals(user.untag) : user.untag != null) return false;
        if (userAgentData != null ? !userAgentData.equals(user.userAgentData) : user.userAgentData != null)
            return false;
        //noinspection RedundantIfStatement
        if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;

        return true;
    }


    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (pseudonym != null ? pseudonym.hashCode() : 0);
        result = 31 * result + (avatar != null ? avatar.hashCode() : 0);
        result = 31 * result + (int) (createdAt ^ (createdAt >>> 32));
        result = 31 * result + (int) (updatedAt ^ (updatedAt >>> 32));
        result = 31 * result + (int) (remoteCreatedAt ^ (remoteCreatedAt >>> 32));
        result = 31 * result + (unsubscribedFromEmails != null ? unsubscribedFromEmails.hashCode() : 0);
        result = 31 * result + sessionCount;
        result = 31 * result + (int) (lastRequestAt ^ (lastRequestAt >>> 32));
        result = 31 * result + (int) (signedUpAt ^ (signedUpAt >>> 32));
        result = 31 * result + (lastSeenIp != null ? lastSeenIp.hashCode() : 0);
        result = 31 * result + (customAttributes != null ? customAttributes.hashCode() : 0);
        result = 31 * result + (userAgentData != null ? userAgentData.hashCode() : 0);
        result = 31 * result + (locationData != null ? locationData.hashCode() : 0);
        result = 31 * result + (companyCollection != null ? companyCollection.hashCode() : 0);
        result = 31 * result + (socialProfileCollection != null ? socialProfileCollection.hashCode() : 0);
        result = 31 * result + (segmentCollection != null ? segmentCollection.hashCode() : 0);
        result = 31 * result + (tagCollection != null ? tagCollection.hashCode() : 0);
        result = 31 * result + (updateLastRequestAt != null ? updateLastRequestAt.hashCode() : 0);
        result = 31 * result + (newSession != null ? newSession.hashCode() : 0);
        result = 31 * result + (untag != null ? untag.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "type='" + type + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", userId='" + userId + '\'' +
                ", avatar=" + avatar +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", remoteCreatedAt=" + remoteCreatedAt +
                ", unsubscribedFromEmails=" + unsubscribedFromEmails +
                ", sessionCount=" + sessionCount +
                ", lastRequestAt=" + lastRequestAt +
                ", signedUpAt=" + signedUpAt +
                ", lastSeenIp='" + lastSeenIp + '\'' +
                ", customAttributes=" + customAttributes +
                ", userAgentData='" + userAgentData + '\'' +
                ", locationData=" + locationData +
                ", companyCollection=" + companyCollection +
                ", socialProfileCollection=" + socialProfileCollection +
                ", segmentCollection=" + segmentCollection +
                ", tagCollection=" + tagCollection +
                ", updateLastRequestAt=" + updateLastRequestAt +
                ", newSession=" + newSession +
                ", untag=" + untag +
                "} " + super.toString();
    }
}
