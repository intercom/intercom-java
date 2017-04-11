package io.intercom.api;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Maps;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Contact extends TypedData implements Replier {

    private static final Map<String, String> SENTINEL = Maps.newHashMap();

    public static Contact findByID(String id)
            throws AuthorizationException, ClientException, ServerException, InvalidException, RateLimitException {
        return new HttpClient(contactURI(id)).get(Contact.class);
    }

    public static Contact findByUserID(String userID)
            throws AuthorizationException, ClientException, ServerException, InvalidException, RateLimitException {
        final Map<String, String> params = Maps.newHashMap();
        params.put("user_id", userID);
        return DataResource.find(params, "contacts", Contact.class);
    }

    public static ContactCollection listByEmail(String email)
            throws AuthorizationException, ClientException, ServerException, InvalidException, RateLimitException {
        final Map<String, String> params = Maps.newHashMap();
        params.put("email", email);
        return list(params);
    }

    public static ContactCollection list(Map<String, String> params)
            throws AuthorizationException, ClientException, ServerException, InvalidException, RateLimitException {
        return DataResource.list(params, "contacts", ContactCollection.class);
    }

    public static ContactCollection list()
            throws AuthorizationException, ClientException, ServerException, InvalidException, RateLimitException {
        return DataResource.list(SENTINEL, "contacts", ContactCollection.class);
    }

    public static ScrollableContactCollection scroll()
            throws AuthorizationException, ClientException, ServerException, InvalidException, RateLimitException {
        return DataResource.scroll(null, "contacts", ScrollableContactCollection.class);
    }

    public static Contact create(Contact c)
            throws AuthorizationException, ClientException, ServerException, InvalidException, RateLimitException {
        return DataResource.create(ContactUpdate.buildFrom(c), "contacts", Contact.class);
    }

    public static Contact update(Contact c)
            throws AuthorizationException, ClientException, ServerException, InvalidException, RateLimitException {
        return DataResource.update(ContactUpdate.buildFrom(c), "contacts", Contact.class);
    }

    public static Contact delete(Contact c)
            throws AuthorizationException, ClientException, ServerException, InvalidException, RateLimitException {
        return DataResource.delete(c.getID(), "contacts", Contact.class);
    }

    public static User convert(Contact c, User u)
            throws AuthorizationException, ClientException, ServerException, InvalidException, RateLimitException {
        return DataResource.post(ContactConvertBuilder.buildConvert(c, u), convertURI(), User.class);
    }

    private static URI contactURI(String id) {
        return UriBuilder.newBuilder().path("contacts").path(id).build();
    }

    private static URI convertURI() {
        return UriBuilder.newBuilder().path("contacts").path("convert").build();
    }

    static class ContactConvertBuilder {

        static ContactConvert buildConvert(Contact c, User u) throws InvalidException {
            return new ContactConvertBuilder().build(c, u);
        }

        ContactConvert build(Contact c, User u) throws InvalidException {
            return new ContactConvert(buildConvertContact(c), buildConvertUser(u));
        }

        HashMap<String, String> buildConvertUser(User u) {
            final HashMap<String, String> convertUser = Maps.newHashMap();

            if (u.getId() != null) {
                convertUser.put("id", u.getId());
            }

            if (u.getUserId() != null) {
                convertUser.put("user_id", u.getUserId());
            }

            if (u.getEmail() != null) {
                convertUser.put("email", u.getEmail());
            }

            checkValidConvertContact(convertUser);

            return convertUser;
        }

        void checkValidConvertContact(HashMap<String, String> convertUser) {
            if ((!convertUser.containsKey("id")) && (!convertUser.containsKey("user_id")) && (!convertUser.containsKey("email"))) {
                throw new InvalidException("a convert user must include at least one of, an id, user_id or email parameter");
            }
        }

        HashMap<String, String> buildConvertContact(Contact c) {
            final HashMap<String, String> convertContact = Maps.newHashMap();

            if (c.getID() != null) {
                convertContact.put("id", c.getID());
            }

            if (c.getUserID() != null) {
                convertContact.put("user_id", c.getUserID());
            }

            checkValidConvertUser(convertContact);

            return convertContact;
        }

        void checkValidConvertUser(HashMap<String, String> convertContact) {
            if ((!convertContact.containsKey("id")) && (!convertContact.containsKey("user_id"))) {
                throw new InvalidException("a convert contact must include at least one of, an id or a user_id parameter");
            }
        }
    }


    @SuppressWarnings("UnusedDeclaration")
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    static class ContactConvert {

        @JsonProperty("contact")
        private Map<String, String> contact;

        @JsonProperty("user")
        private Map<String, String> user;

        public ContactConvert() {
        }

        public ContactConvert(Map<String, String> contact, Map<String, String> user) {
            this.contact = contact;
            this.user = user;
        }

        public Map<String, String> getContact() {
            return contact;
        }

        public void setContact(Map<String, String> contact) {
            this.contact = contact;
        }

        public Map<String, String> getUser() {
            return user;
        }

        public void setUser(Map<String, String> user) {
            this.user = user;
        }
    }

    @SuppressWarnings("UnusedDeclaration")
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    static class ContactUpdate extends TypedData {

        static ContactUpdate buildFrom(Contact c) {
            final ContactUpdate contactUpdate = new ContactUpdate();
            contactUpdate.id = c.getID(); // propagated, noset
            contactUpdate.userID = c.getUserID(); // propagated, noset
            contactUpdate.email = c.getEmail();
            contactUpdate.phone = c.getPhone();
            contactUpdate.name = c.getName();
            contactUpdate.lastSeenIP = c.getLastSeenIP();
            contactUpdate.customAttributes = c.getCustomAttributes();
            contactUpdate.lastRequestAt = c.getLastRequestAt();
            contactUpdate.unsubscribedFromEmails = c.getUnsubscribedFromEmails();
            return contactUpdate;
        }

        @JsonProperty("type")
        @JsonInclude(JsonInclude.Include.NON_DEFAULT)
        private String type;

        @JsonProperty("id")
        private String id;

        @JsonProperty("user_id")
        private String userID;

        @JsonProperty("email")
        private String email;

        @JsonProperty("phone")
        private String phone;

        @JsonProperty("name")
        private String name;

        @JsonProperty("last_seen_ip")
        private String lastSeenIP;

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

        /*
         * Making these Booleans allows us to send true or false as set
         * values leaving null the ignored field for NON_DEFAULT. A
         * primitive would result in false not being sent
         */

        @JsonProperty("unsubscribed_from_emails")
        @JsonInclude(JsonInclude.Include.NON_DEFAULT)
        private Boolean unsubscribedFromEmails;

        @JsonProperty("update_last_request_at")
        @JsonInclude(JsonInclude.Include.NON_DEFAULT)
        private Boolean updateLastRequestAt;

        @JsonProperty("new_session")
        @JsonInclude(JsonInclude.Include.NON_DEFAULT)
        private Boolean newSession;

        public ContactUpdate() {
        }

        public String getType() {
            return type;
        }

        public String getID() {
            return id;
        }

        public String getUserID() {
            return userID;
        }

        public String getEmail() {
            return email;
        }

        public String getPhone() {
            return phone;
        }

        public String getName() {
            return name;
        }

        public String getLastSeenIP() {
            return lastSeenIP;
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
    private final String type = "contact";

    @JsonProperty("id")
    private String id;

    @JsonProperty("user_id")
    private String userID;

    @JsonProperty("email")
    private String email;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("name")
    private String name;

    @JsonProperty("pseudonym")
    private String pseudonym;

    @JsonProperty("avatar")
    private Avatar avatar;

    @JsonProperty("created_at")
    private long createdAt;

    @JsonProperty("updated_at")
    private long updatedAt;

    @JsonProperty("unsubscribed_from_emails")
    private Boolean unsubscribedFromEmails;

    @JsonProperty("session_count")
    private int sessionCount;

    @JsonProperty("last_request_at")
    private long lastRequestAt;

    @JsonProperty("last_seen_ip")
    private String lastSeenIP;

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

    public Contact() {
    }

    public Contact untag() {
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

    public String getID() {
        return id;
    }

    @VisibleForTesting
    Contact setID(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Contact setName(String name) {
        this.name = name;
        return this;
    }

    public String getPseudonym() {
        return pseudonym;
    }

    public String getEmail() {
        return email;
    }

    public Contact setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Contact setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getUserID() {
        return userID;
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

    public Boolean getUnsubscribedFromEmails() {
        return unsubscribedFromEmails;
    }

    public Contact setUnsubscribedFromEmails(boolean unsubscribedFromEmails) {
        this.unsubscribedFromEmails = unsubscribedFromEmails;
        return this;
    }

    public int getSessionCount() {
        return sessionCount;
    }

    public long getLastRequestAt() {
        return lastRequestAt;
    }

    public Contact setLastRequestAt(long lastRequestAt) {
        this.lastRequestAt = lastRequestAt;
        return this;
    }

    public String getLastSeenIP() {
        return lastSeenIP;
    }

    public Contact setLastSeenIP(String lastSeenIP) {
        this.lastSeenIP = lastSeenIP;
        return this;
    }

    public Map<String, CustomAttribute> getCustomAttributes() {
        return customAttributes;
    }

    public Contact setCustomAttributes(Map<String, CustomAttribute> customAttributes) {
        this.customAttributes = customAttributes;
        return this;
    }

    public Contact addCustomAttribute(CustomAttribute customAttribute) {
        this.customAttributes.put(customAttribute.getName(), customAttribute);
        return this;
    }

    public String getUserAgentData() {
        return userAgentData;
    }

    public LocationData getLocationData() {
        return locationData;
    }

    public CompanyCollection getCompanyCollection() {
        return companyCollection;
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

    public Boolean isNewSession() {
        return newSession;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (createdAt != contact.createdAt) return false;
        if (updatedAt != contact.updatedAt) return false;
        if (sessionCount != contact.sessionCount) return false;
        if (lastRequestAt != contact.lastRequestAt) return false;
        if (!type.equals(contact.type)) return false;
        if (id != null ? !id.equals(contact.id) : contact.id != null) return false;
        if (name != null ? !name.equals(contact.name) : contact.name != null) return false;
        if (email != null ? !email.equals(contact.email) : contact.email != null) return false;
        if (phone != null ? !phone.equals(contact.phone) : contact.phone != null) return false;
        if (userID != null ? !userID.equals(contact.userID) : contact.userID != null) return false;
        if (avatar != null ? !avatar.equals(contact.avatar) : contact.avatar != null) return false;
        if (unsubscribedFromEmails != null ? !unsubscribedFromEmails.equals(contact.unsubscribedFromEmails) : contact.unsubscribedFromEmails != null)
            return false;
        if (lastSeenIP != null ? !lastSeenIP.equals(contact.lastSeenIP) : contact.lastSeenIP != null) return false;
        if (customAttributes != null ? !customAttributes.equals(contact.customAttributes) : contact.customAttributes != null)
            return false;
        if (userAgentData != null ? !userAgentData.equals(contact.userAgentData) : contact.userAgentData != null)
            return false;
        if (locationData != null ? !locationData.equals(contact.locationData) : contact.locationData != null)
            return false;
        if (companyCollection != null ? !companyCollection.equals(contact.companyCollection) : contact.companyCollection != null)
            return false;
        if (socialProfileCollection != null ? !socialProfileCollection.equals(contact.socialProfileCollection) : contact.socialProfileCollection != null)
            return false;
        if (segmentCollection != null ? !segmentCollection.equals(contact.segmentCollection) : contact.segmentCollection != null)
            return false;
        if (tagCollection != null ? !tagCollection.equals(contact.tagCollection) : contact.tagCollection != null)
            return false;
        if (updateLastRequestAt != null ? !updateLastRequestAt.equals(contact.updateLastRequestAt) : contact.updateLastRequestAt != null)
            return false;
        //noinspection SimplifiableIfStatement
        if (newSession != null ? !newSession.equals(contact.newSession) : contact.newSession != null) return false;
        return !(untag != null ? !untag.equals(contact.untag) : contact.untag != null);

    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (userID != null ? userID.hashCode() : 0);
        result = 31 * result + (avatar != null ? avatar.hashCode() : 0);
        result = 31 * result + (int) (createdAt ^ (createdAt >>> 32));
        result = 31 * result + (int) (updatedAt ^ (updatedAt >>> 32));
        result = 31 * result + (unsubscribedFromEmails != null ? unsubscribedFromEmails.hashCode() : 0);
        result = 31 * result + sessionCount;
        result = 31 * result + (int) (lastRequestAt ^ (lastRequestAt >>> 32));
        result = 31 * result + (lastSeenIP != null ? lastSeenIP.hashCode() : 0);
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
        return "Contact{" +
                "type='" + type + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", userID='" + userID + '\'' +
                ", avatar=" + avatar +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", unsubscribedFromEmails=" + unsubscribedFromEmails +
                ", sessionCount=" + sessionCount +
                ", lastRequestAt=" + lastRequestAt +
                ", lastSeenIP='" + lastSeenIP + '\'' +
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
