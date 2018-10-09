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
public class Visitor extends TypedData {

    private static final Map<String, String> SENTINEL = Maps.newHashMap();

    public static Visitor findByID(String id)
            throws AuthorizationException, ClientException, ServerException, InvalidException, RateLimitException {
        return new HttpClient(visitorURI(id)).get(Visitor.class);
    }

    public static Visitor findByUserID(String userID)
            throws AuthorizationException, ClientException, ServerException, InvalidException, RateLimitException {
        final Map<String, String> params = Maps.newHashMap();
        params.put("user_id", userID);
        return DataResource.find(params, "visitors", Visitor.class);
    }

    public static Visitor update(Visitor v)
            throws AuthorizationException, ClientException, ServerException, InvalidException, RateLimitException {
        return DataResource.updatePut(VisitorUpdate.buildFrom(v), visitorURI(""), Visitor.class);
    }

    public static Visitor delete(Visitor v)
            throws AuthorizationException, ClientException, ServerException, InvalidException, RateLimitException {
        return DataResource.delete(v.getID(), "visitors", Visitor.class);
    }

    public static Visitor delete(String id)
            throws AuthorizationException, ClientException, ServerException, InvalidException, RateLimitException {
        return DataResource.delete(id, "visitors", Visitor.class);
    }

    public static Contact convertToContact(Visitor v)
            throws AuthorizationException, ClientException, ServerException, InvalidException, RateLimitException {
        return DataResource.post(VisitorConvertBuilder.buildConvertToLead(v), convertURI(), Contact.class);
    }

    public static User convertToUser(Visitor v, User u)
            throws AuthorizationException, ClientException, ServerException, InvalidException, RateLimitException {
        return DataResource.post(VisitorConvertBuilder.buildConvertToUser(v, u), convertURI(), User.class);
    }

    private static URI visitorURI(String id) {
        return UriBuilder.newBuilder().path("visitors").path(id).build();
    }

    private static URI convertURI() {
        return UriBuilder.newBuilder().path("visitors").path("convert").build();
    }


    static class VisitorConvertBuilder {

        static VisitorConvert buildConvertToLead(Visitor v) throws InvalidException {
            return new VisitorConvertBuilder().build(v);
        }

        static VisitorConvert buildConvertToUser(Visitor v, User u) throws InvalidException {
            return new VisitorConvertBuilder().build(v, u);
        }

        VisitorConvert build(Visitor v) throws InvalidException {
            return new VisitorConvert(buildConvertVisitor(v));
        }

        VisitorConvert build(Visitor v, User u) throws InvalidException {
            return new VisitorConvert(buildConvertVisitor(v), buildConvertUser(u));
        }

        HashMap<String, String> buildConvertVisitor(Visitor v) {
            final HashMap<String, String> convertVisitor = Maps.newHashMap();

            if (v.getID() != null) {
                convertVisitor.put("id", v.getID());
            }

            if (v.getUserID() != null) {
                convertVisitor.put("user_id", v.getUserID());
            }

            checkValidConvertVisitor(convertVisitor);

            return convertVisitor;
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

            checkValidConvertUser(convertUser);

            return convertUser;
        }

        void checkValidConvertVisitor(HashMap<String, String> convertUser) {
            if ((!convertUser.containsKey("id")) && (!convertUser.containsKey("user_id"))) {
                throw new InvalidException("a convert visitor must include at least one of, an id or user_id parameter");
            }
        }
        void checkValidConvertUser(HashMap<String, String> convertUser) {
            if ((!convertUser.containsKey("id")) && (!convertUser.containsKey("user_id")) && (!convertUser.containsKey("email"))) {
                throw new InvalidException("a convert user must include at least one of, an id, user_id or email parameter");
            }
        }
    }

    @SuppressWarnings("UnusedDeclaration")
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    static class VisitorConvert {

        @JsonProperty("visitor")
        private Map<String, String> visitor;

        @JsonProperty("user")
        private Map<String, String> user;

        @JsonProperty("type")
        private String type;

        public VisitorConvert() {
        }

        public VisitorConvert(Map<String, String> visitor) {
            this.visitor = visitor;
            this.type = "lead";
        }

        public VisitorConvert(Map<String, String> visitor, Map<String, String> user) {
            this.visitor = visitor;
            this.user = user;
            this.type = "user";
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Map<String, String> getVisitor() {
            return visitor;
        }

        public void setVisitor(Map<String, String> visitor) {
            this.visitor = visitor;
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
    static class VisitorUpdate extends TypedData {

        static VisitorUpdate buildFrom(Visitor v) {
            final VisitorUpdate visitorUpdate = new VisitorUpdate();
            visitorUpdate.id = v.getID(); // propagated, noset
            visitorUpdate.userID = v.getUserID(); // propagated, noset
            if(v.getEmail() != null && v.getEmail() != "")  visitorUpdate.email = v.getEmail();
            visitorUpdate.phone = v.getPhone();
            visitorUpdate.name = v.getName();
            visitorUpdate.lastSeenIP = v.getLastSeenIP();
            visitorUpdate.customAttributes = v.getCustomAttributes();
            visitorUpdate.avatar = v.getAvatar();
            visitorUpdate.lastRequestAt = v.getLastRequestAt();
            visitorUpdate.lastSeenUserAgent= v.getLastSeenUserAgent();
            visitorUpdate.unsubscribedFromEmails = v.getUnsubscribedFromEmails();
            visitorUpdate.utmCampaign = v.getUtmCampaign();
            visitorUpdate.utmContent = v.getUtmContent();
            visitorUpdate.utmMedium= v.getUtmMedium();
            visitorUpdate.utmSource= v.getUtmSource();
            visitorUpdate.utmTerm= v.getUtmTerm();
            return visitorUpdate;
        }

        @JsonProperty("type")
        @JsonInclude(JsonInclude.Include.NON_DEFAULT)
        private String type;

        @JsonProperty("id")
        private String id;

        @JsonProperty("user_id")
        private String userID;

        @JsonProperty("email")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String email;

        @JsonProperty("phone")
        private String phone;

        @JsonProperty("name")
        private String name;

        @JsonProperty("utm_campaign")
        private String utmCampaign;

        @JsonProperty("utm_content")
        private String utmContent;

        @JsonProperty("utm_medium")
        private String utmMedium;

        @JsonProperty("utm_source")
        private String utmSource;

        @JsonProperty("utm_term")
        private String utmTerm;

        @JsonProperty("last_seen_ip")
        private String lastSeenIP;

        @JsonProperty("avatar")
        private Avatar avatar;

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
        private String signedUpAt;

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


        public VisitorUpdate() {
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

        public Avatar getAvatar() {
            return avatar;
        }

        public String getUtmCampaign() {
            return utmCampaign;
        }

        public String getUtmContent() {
            return utmContent;
        }

        public String getUtmMedium() {
            return utmMedium;
        }

        public String getUtmSource() {
            return utmSource;
        }

        public String getUtmTerm() {
            return utmTerm;
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
    }

    @JsonProperty("type")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private final String type = "visitor";

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

    @JsonProperty("last_seen_user_agent")
    private String lastSeenUserAgent;

    @JsonProperty("referrer")
    private String referrer;

    @JsonProperty("utm_campaign")
    private String utmCampaign;

    @JsonProperty("utm_content")
    private String utmContent;

    @JsonProperty("utm_medium")
    private String utmMedium;

    @JsonProperty("utm_source")
    private String utmSource;

    @JsonProperty("utm_term")
    private String utmTerm;

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

    public Visitor() {
    }

    public String getType() {
        return type;
    }

    public String getID() {
        return id;
    }

    public Visitor setID(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Visitor setName(String name) {
        this.name = name;
        return this;
    }

    public String getPseudonym() {
        return pseudonym;
    }

    public String getEmail() {
        return email;
    }

    public Visitor setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Visitor setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getUserID() {
        return userID;
    }

    public Visitor setUserID(String userID) {
        this.userID = userID;
        return this;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public Visitor setAvatar(Avatar avatar) {
        this.avatar = avatar;
        return this;
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

    public Visitor setUnsubscribedFromEmails(boolean unsubscribedFromEmails) {
        this.unsubscribedFromEmails = unsubscribedFromEmails;
        return this;
    }

    public int getSessionCount() {
        return sessionCount;
    }

    public long getLastRequestAt() {
        return lastRequestAt;
    }

    public Visitor setLastRequestAt(long lastRequestAt) {
        this.lastRequestAt = lastRequestAt;
        return this;
    }

    public String getLastSeenIP() {
        return lastSeenIP;
    }

    public Visitor setLastSeenIP(String lastSeenIP) {
        this.lastSeenIP = lastSeenIP;
        return this;
    }

    public String getLastSeenUserAgent() {
        return lastSeenUserAgent;
    }

    public Visitor setLastSeenUserAgent(String lastSeenUserAgent) {
        this.lastSeenUserAgent = lastSeenUserAgent;
        return this;
    }

    public Map<String, CustomAttribute> getCustomAttributes() {
        return customAttributes;
    }

    public Visitor setCustomAttributes(Map<String, CustomAttribute> customAttributes) {
        this.customAttributes = customAttributes;
        return this;
    }

    public Visitor addCustomAttribute(CustomAttribute customAttribute) {
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

    public String getReferrer() {
        return referrer;
    }

    public String getUtmCampaign() {
        return utmCampaign;
    }

    public Visitor setUtmCampaign(String utmCampaign) {
        this.utmCampaign = utmCampaign;
        return this;
    }

    public String getUtmContent() {
        return utmContent;
    }

    public Visitor setUtmContent(String utmContent) {
        this.utmContent = utmContent;
        return this;
    }

    public String getUtmMedium() {
        return utmMedium;
    }

    public Visitor setUtmMedium(String utmMedium) {
        this.utmMedium = utmMedium;
        return this;
    }

    public String getUtmSource() {
        return utmSource;
    }

    public Visitor setUtmSource(String utmSource) {
        this.utmSource = utmSource;
        return this;
    }

    public String getUtmTerm() {
        return utmTerm;
    }

    public Visitor setUtmTerm(String utmTerm) {
        this.utmTerm = utmTerm;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Visitor Visitor = (Visitor) o;

        if (createdAt != Visitor.createdAt) return false;
        if (updatedAt != Visitor.updatedAt) return false;
        if (sessionCount != Visitor.sessionCount) return false;
        if (lastRequestAt != Visitor.lastRequestAt) return false;
        if (!type.equals(Visitor.type)) return false;
        if (id != null ? !id.equals(Visitor.id) : Visitor.id != null) return false;
        if (name != null ? !name.equals(Visitor.name) : Visitor.name != null) return false;
        if (email != null ? !email.equals(Visitor.email) : Visitor.email != null) return false;
        if (phone != null ? !phone.equals(Visitor.phone) : Visitor.phone != null) return false;
        if (userID != null ? !userID.equals(Visitor.userID) : Visitor.userID != null) return false;
        if (avatar != null ? !avatar.equals(Visitor.avatar) : Visitor.avatar != null) return false;
        if (unsubscribedFromEmails != null ? !unsubscribedFromEmails.equals(Visitor.unsubscribedFromEmails) : Visitor.unsubscribedFromEmails != null)
            return false;
        if (lastSeenIP != null ? !lastSeenIP.equals(Visitor.lastSeenIP) : Visitor.lastSeenIP != null) return false;
        if (customAttributes != null ? !customAttributes.equals(Visitor.customAttributes) : Visitor.customAttributes != null)
            return false;
        if (userAgentData != null ? !userAgentData.equals(Visitor.userAgentData) : Visitor.userAgentData != null)
            return false;
        if (locationData != null ? !locationData.equals(Visitor.locationData) : Visitor.locationData != null)
            return false;
        if (companyCollection != null ? !companyCollection.equals(Visitor.companyCollection) : Visitor.companyCollection != null)
            return false;
        if (socialProfileCollection != null ? !socialProfileCollection.equals(Visitor.socialProfileCollection) : Visitor.socialProfileCollection != null)
            return false;
        if (segmentCollection != null ? !segmentCollection.equals(Visitor.segmentCollection) : Visitor.segmentCollection != null)
            return false;
        if (tagCollection != null ? !tagCollection.equals(Visitor.tagCollection) : Visitor.tagCollection != null)
            return false;
        if (updateLastRequestAt != null ? !updateLastRequestAt.equals(Visitor.updateLastRequestAt) : Visitor.updateLastRequestAt != null)
            return false;
        if (referrer != null ? !referrer.equals(Visitor.referrer) : Visitor.referrer != null) return false;
        if (utmCampaign != null ? !utmCampaign.equals(Visitor.utmCampaign) : Visitor.utmCampaign != null) return false;
        if (utmContent != null ? !utmContent.equals(Visitor.utmContent) : Visitor.utmContent != null) return false;
        if (utmMedium != null ? !utmMedium.equals(Visitor.utmMedium) : Visitor.utmMedium != null) return false;
        if (utmSource != null ? !utmSource.equals(Visitor.utmSource) : Visitor.utmSource != null) return false;
        if (utmTerm != null ? !utmTerm.equals(Visitor.utmTerm) : Visitor.utmTerm != null) return false;

        return true;
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
        result = 31 * result + (referrer != null ? referrer.hashCode() : 0);
        result = 31 * result + (utmContent != null ? utmContent.hashCode() : 0);
        result = 31 * result + (utmCampaign != null ? utmCampaign.hashCode() : 0);
        result = 31 * result + (utmMedium != null ? utmMedium.hashCode() : 0);
        result = 31 * result + (utmSource != null ? utmSource.hashCode() : 0);
        result = 31 * result + (utmTerm != null ? utmTerm.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Visitor{" +
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
                ", referrer=" + referrer +
                ", utmCampaign='" + utmCampaign + '\'' +
                ", utmContent='" + utmContent + '\'' +
                ", utmMedium='" + utmMedium + '\'' +
                ", utmSource='" + utmSource + '\'' +
                ", utmTerm='" + utmTerm + '\'' +
                "} " + super.toString();
    }
}
