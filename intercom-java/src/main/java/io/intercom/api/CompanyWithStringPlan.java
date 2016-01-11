package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Maps;

import java.util.Map;

@SuppressWarnings("UnusedDeclaration")
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
class CompanyWithStringPlan extends TypedData {

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

    @JsonProperty("plan")
    private String plan;

    @JsonIgnoreProperties(ignoreUnknown = false)
    @JsonProperty("custom_attributes")
    private Map<String, CustomAttribute> customAttributes = Maps.newHashMap();

    @JsonProperty("remove")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean remove;

    public CompanyWithStringPlan() {
    }

    public String getType() {
        return "company";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public Integer getSessionCount() {
        return sessionCount;
    }

    public void setSessionCount(Integer sessionCount) {
        this.sessionCount = sessionCount;
    }

    public float getMonthlySpend() {
        return monthlySpend;
    }

    public void setMonthlySpend(float monthlySpend) {
        this.monthlySpend = monthlySpend;
    }

    public long getRemoteCreatedAt() {
        return remoteCreatedAt;
    }

    public void setRemoteCreatedAt(long remoteCreatedAt) {
        this.remoteCreatedAt = remoteCreatedAt;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public Map<String, CustomAttribute> getCustomAttributes() {
        return customAttributes;
    }

    public void setCustomAttributes(Map<String, CustomAttribute> customAttributes) {
        this.customAttributes = customAttributes;
    }

    public Boolean getRemove() {
        return remove;
    }

    public CompanyWithStringPlan setRemove(Boolean remove) {
        this.remove = remove;
        return this;
    }
}
