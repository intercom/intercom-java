package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Maps;

import java.net.URI;
import java.util.Map;

@SuppressWarnings("UnusedDeclaration")
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Company extends TypedData {

    private static final Map<String, String> SENTINEL = Maps.newHashMap();

    public static Company find(String id) throws InvalidException, AuthorizationException {
        final HttpClient resource = new HttpClient(UriBuilder.newBuilder().path("companies").path(id).build());
        return resource.get(Company.class);
    }

    public static Company find(Map<String, String> params) throws InvalidException, AuthorizationException {
        if (!params.containsKey("company_id") && !params.containsKey("name")) {
            throw new InvalidException("a company find must include a company_id or name parameter");
        }
        return DataResource.find(params, "companies", Company.class);
    }

    public static Company create(Company company) throws InvalidException, AuthorizationException {
        return update(company);
    }

    public static Company update(Company company) throws InvalidException, AuthorizationException {
        // because the data is asymmetric on the plan field
        final CompanyWithStringPlan entity = new CompanyWithStringPlan();
        entity.setCompanyID(company.getCompanyID());
        entity.setName(company.getName());
        entity.setSessionCount(company.getSessionCount());
        entity.setMonthlySpend(company.getMonthlySpend());
        entity.setRemoteCreatedAt(company.getRemoteCreatedAt());
        if(company.getCustomAttributes() != null) {
            entity.getCustomAttributes().putAll(company.getCustomAttributes());
        }
        if(company.getPlan() !=null )  {
            entity.setPlan(company.getPlan().getName());
        }
        return DataResource.update(entity, "companies", Company.class);
    }

    public static Company delete(String id) throws InvalidException, AuthorizationException {
        return DataResource.delete(id, "companies", Company.class);
    }

    public static CompanyCollection list(Map<String, String> params) throws InvalidException, AuthorizationException {
        return DataResource.list(params, "companies", CompanyCollection.class);
    }

    public static CompanyCollection list() throws InvalidException, AuthorizationException {
        return DataResource.list(SENTINEL, "companies", CompanyCollection.class);
    }

    public static UserCollection listUsers(Map<String, String> params) throws InvalidException, AuthorizationException {
        URI usersURI;
        if (params.containsKey("company_id")) {
            usersURI = UriBuilder.newBuilder()
                .path("companies")
                .query("company_id", params.get("company_id"))
                .query("type", "users")
                .build();
        } else if (params.containsKey("id")) {
            usersURI = UriBuilder.newBuilder()
                .path("companies")
                .path(params.get("id"))
                .path("users")
                .build();
        } else {
            throw new InvalidException("a company user list query must supply a company_id or id parameter");
        }
        final HttpClient resource = new HttpClient(usersURI);
        return resource.get(UserCollection.class);
    }

    @SuppressWarnings("UnusedDeclaration")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Plan extends TypedData {

        @JsonProperty("type")
        protected String type;

        @JsonProperty("id")
        private String id;

        @JsonProperty("name")
        private String name;

        public Plan() {
            type = "plan";
        }

        public Plan(String name) {
            this();
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        @Override
        public int hashCode() {
            int result = id != null ? id.hashCode() : 0;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Plan plan = (Plan) o;

            if (id != null ? !id.equals(plan.id) : plan.id != null) return false;
            //noinspection RedundantIfStatement
            if (name != null ? !name.equals(plan.name) : plan.name != null) return false;

            return true;
        }


        @Override
        public String toString() {
            return "Plan{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                "} " + super.toString();
        }


    }

    @SuppressWarnings("FieldCanBeLocal")
    @JsonProperty("type")
    private final String type = "company";

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("company_id")
    private String companyID;

    @JsonProperty("session_count")
    private int sessionCount;

    @JsonProperty("monthly_spend")
    private float monthlySpend;

    @JsonProperty("remote_created_at")
    private long remoteCreatedAt;

    @JsonProperty("created_at")
    private long createdAt;

    @JsonProperty("updated_at")
    private long updatedAt;

    @JsonProperty("plan")
    private Plan plan;

    @JsonProperty("user_count")
    private Integer userCount;

    @JsonIgnoreProperties(ignoreUnknown = false)
    @JsonProperty("custom_attributes")
    private Map<String, CustomAttribute> customAttributes = Maps.newHashMap();

    @JsonProperty("segments")
    private SegmentCollection segmentCollection = new SegmentCollection();

    @JsonProperty("tags")
    private TagCollection tagCollection = new TagCollection();

    private Boolean untag;

    public Company() {
    }

    public Company untag() {
        untag = Boolean.TRUE;
        return this;
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    @VisibleForTesting
    Company setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Company setName(String name) {
        this.name = name;
        return this;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public String getCompanyID() {
        return companyID;
    }

    public Company setCompanyID(String companyID) {
        this.companyID = companyID;
        return this;
    }

    public int getSessionCount() {
        return sessionCount;
    }

    /**
     * Deprecated. The Intercom API does not support changing the
     * session value for a company. Calling this method has no
     * effect.
     *
     * @param sessionCount this value is ignored
     * @return the company object
     */
    @Deprecated
    public Company setSessionCount(int sessionCount) {
        return this;
    }

    public long getRemoteCreatedAt() {
        return remoteCreatedAt;
    }

    public Company setRemoteCreatedAt(long remoteCreatedAt) {
        this.remoteCreatedAt = remoteCreatedAt;
        return this;
    }

    public Map<String, CustomAttribute> getCustomAttributes() {
        return customAttributes;
    }

    public Company setCustomAttributes(Map<String, CustomAttribute> customAttributes) {
        this.customAttributes = customAttributes;
        return this;
    }

    public Company addCustomAttribute(CustomAttribute customAttribute) {
        this.customAttributes.put(customAttribute.getName(), customAttribute);
        return this;
    }

    public Plan getPlan() {
        return plan;
    }

    public Company setPlan(Plan plan) {
        this.plan = plan;
        return this;
    }

    public Integer getUserCount() {
        return userCount;
    }

    public float getMonthlySpend() {
        return monthlySpend;
    }

    public Company setMonthlySpend(float monthlySpend) {
        this.monthlySpend = monthlySpend;
        return this;
    }

    public SegmentCollection getSegmentCollection() {
        return segmentCollection;
    }

    public TagCollection getTagCollection() {
        return tagCollection;
    }

    boolean isUntag() {
        return untag == null ? false : untag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (createdAt != company.createdAt) return false;
        if (Float.compare(company.monthlySpend, monthlySpend) != 0) return false;
        if (remoteCreatedAt != company.remoteCreatedAt) return false;
        if (sessionCount != company.sessionCount) return false;
        if (updatedAt != company.updatedAt) return false;
        if (companyID != null ? !companyID.equals(company.companyID) : company.companyID != null) return false;
        if (customAttributes != null ? !customAttributes.equals(company.customAttributes) : company.customAttributes != null)
            return false;
        if (id != null ? !id.equals(company.id) : company.id != null) return false;
        if (name != null ? !name.equals(company.name) : company.name != null) return false;
        if (plan != null ? !plan.equals(company.plan) : company.plan != null) return false;
        if (segmentCollection != null ? !segmentCollection.equals(company.segmentCollection) : company.segmentCollection != null)
            return false;
        if (tagCollection != null ? !tagCollection.equals(company.tagCollection) : company.tagCollection != null)
            return false;
        if (!type.equals(company.type)) return false;
        if (untag != null ? !untag.equals(company.untag) : company.untag != null) return false;
        //noinspection RedundantIfStatement
        if (userCount != null ? !userCount.equals(company.userCount) : company.userCount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (companyID != null ? companyID.hashCode() : 0);
        result = 31 * result + sessionCount;
        result = 31 * result + (monthlySpend != +0.0f ? Float.floatToIntBits(monthlySpend) : 0);
        result = 31 * result + (int) (remoteCreatedAt ^ (remoteCreatedAt >>> 32));
        result = 31 * result + (int) (createdAt ^ (createdAt >>> 32));
        result = 31 * result + (int) (updatedAt ^ (updatedAt >>> 32));
        result = 31 * result + (plan != null ? plan.hashCode() : 0);
        result = 31 * result + (userCount != null ? userCount.hashCode() : 0);
        result = 31 * result + (customAttributes != null ? customAttributes.hashCode() : 0);
        result = 31 * result + (segmentCollection != null ? segmentCollection.hashCode() : 0);
        result = 31 * result + (tagCollection != null ? tagCollection.hashCode() : 0);
        result = 31 * result + (untag != null ? untag.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Company{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", companyID='" + companyID + '\'' +
            ", sessionCount=" + sessionCount +
            ", monthlySpend=" + monthlySpend +
            ", remoteCreatedAt=" + remoteCreatedAt +
            ", createdAt=" + createdAt +
            ", updatedAt=" + updatedAt +
            ", plan=" + plan +
            ", customAttributes=" + customAttributes +
            ", segmentCollection=" + segmentCollection +
            ", tagCollection=" + tagCollection +
            "} " + super.toString();
    }


}
