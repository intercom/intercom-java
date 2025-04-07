/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.intercom.api.resources.companies.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.intercom.api.core.ObjectMappers;
import com.intercom.api.resources.segments.types.Segment;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = Company.Builder.class)
public final class Company {
    private final Optional<String> type;

    private final String id;

    private final String name;

    private final String appId;

    private final Optional<Plan> plan;

    private final String companyId;

    private final int remoteCreatedAt;

    private final int createdAt;

    private final int updatedAt;

    private final int lastRequestAt;

    private final int size;

    private final String website;

    private final String industry;

    private final int monthlySpend;

    private final int sessionCount;

    private final int userCount;

    private final Optional<Map<String, Object>> customAttributes;

    private final Optional<Tags> tags;

    private final Optional<Segments> segments;

    private final Map<String, Object> additionalProperties;

    private Company(
            Optional<String> type,
            String id,
            String name,
            String appId,
            Optional<Plan> plan,
            String companyId,
            int remoteCreatedAt,
            int createdAt,
            int updatedAt,
            int lastRequestAt,
            int size,
            String website,
            String industry,
            int monthlySpend,
            int sessionCount,
            int userCount,
            Optional<Map<String, Object>> customAttributes,
            Optional<Tags> tags,
            Optional<Segments> segments,
            Map<String, Object> additionalProperties) {
        this.type = type;
        this.id = id;
        this.name = name;
        this.appId = appId;
        this.plan = plan;
        this.companyId = companyId;
        this.remoteCreatedAt = remoteCreatedAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.lastRequestAt = lastRequestAt;
        this.size = size;
        this.website = website;
        this.industry = industry;
        this.monthlySpend = monthlySpend;
        this.sessionCount = sessionCount;
        this.userCount = userCount;
        this.customAttributes = customAttributes;
        this.tags = tags;
        this.segments = segments;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Value is <code>company</code>
     */
    @JsonProperty("type")
    public Optional<String> getType() {
        return type;
    }

    /**
     * @return The Intercom defined id representing the company.
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * @return The name of the company.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * @return The Intercom defined code of the workspace the company is associated to.
     */
    @JsonProperty("app_id")
    public String getAppId() {
        return appId;
    }

    @JsonProperty("plan")
    public Optional<Plan> getPlan() {
        return plan;
    }

    /**
     * @return The company id you have defined for the company.
     */
    @JsonProperty("company_id")
    public String getCompanyId() {
        return companyId;
    }

    /**
     * @return The time the company was created by you.
     */
    @JsonProperty("remote_created_at")
    public int getRemoteCreatedAt() {
        return remoteCreatedAt;
    }

    /**
     * @return The time the company was added in Intercom.
     */
    @JsonProperty("created_at")
    public int getCreatedAt() {
        return createdAt;
    }

    /**
     * @return The last time the company was updated.
     */
    @JsonProperty("updated_at")
    public int getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @return The time the company last recorded making a request.
     */
    @JsonProperty("last_request_at")
    public int getLastRequestAt() {
        return lastRequestAt;
    }

    /**
     * @return The number of employees in the company.
     */
    @JsonProperty("size")
    public int getSize() {
        return size;
    }

    /**
     * @return The URL for the company website.
     */
    @JsonProperty("website")
    public String getWebsite() {
        return website;
    }

    /**
     * @return The industry that the company operates in.
     */
    @JsonProperty("industry")
    public String getIndustry() {
        return industry;
    }

    /**
     * @return How much revenue the company generates for your business.
     */
    @JsonProperty("monthly_spend")
    public int getMonthlySpend() {
        return monthlySpend;
    }

    /**
     * @return How many sessions the company has recorded.
     */
    @JsonProperty("session_count")
    public int getSessionCount() {
        return sessionCount;
    }

    /**
     * @return The number of users in the company.
     */
    @JsonProperty("user_count")
    public int getUserCount() {
        return userCount;
    }

    /**
     * @return The custom attributes you have set on the company.
     */
    @JsonProperty("custom_attributes")
    public Optional<Map<String, Object>> getCustomAttributes() {
        return customAttributes;
    }

    /**
     * @return The list of tags associated with the company
     */
    @JsonProperty("tags")
    public Optional<Tags> getTags() {
        return tags;
    }

    /**
     * @return The list of segments associated with the company
     */
    @JsonProperty("segments")
    public Optional<Segments> getSegments() {
        return segments;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Company && equalTo((Company) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(Company other) {
        return type.equals(other.type)
                && id.equals(other.id)
                && name.equals(other.name)
                && appId.equals(other.appId)
                && plan.equals(other.plan)
                && companyId.equals(other.companyId)
                && remoteCreatedAt == other.remoteCreatedAt
                && createdAt == other.createdAt
                && updatedAt == other.updatedAt
                && lastRequestAt == other.lastRequestAt
                && size == other.size
                && website.equals(other.website)
                && industry.equals(other.industry)
                && monthlySpend == other.monthlySpend
                && sessionCount == other.sessionCount
                && userCount == other.userCount
                && customAttributes.equals(other.customAttributes)
                && tags.equals(other.tags)
                && segments.equals(other.segments);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.type,
                this.id,
                this.name,
                this.appId,
                this.plan,
                this.companyId,
                this.remoteCreatedAt,
                this.createdAt,
                this.updatedAt,
                this.lastRequestAt,
                this.size,
                this.website,
                this.industry,
                this.monthlySpend,
                this.sessionCount,
                this.userCount,
                this.customAttributes,
                this.tags,
                this.segments);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IdStage builder() {
        return new Builder();
    }

    public interface IdStage {
        NameStage id(@NotNull String id);

        Builder from(Company other);
    }

    public interface NameStage {
        AppIdStage name(@NotNull String name);
    }

    public interface AppIdStage {
        CompanyIdStage appId(@NotNull String appId);
    }

    public interface CompanyIdStage {
        RemoteCreatedAtStage companyId(@NotNull String companyId);
    }

    public interface RemoteCreatedAtStage {
        CreatedAtStage remoteCreatedAt(int remoteCreatedAt);
    }

    public interface CreatedAtStage {
        UpdatedAtStage createdAt(int createdAt);
    }

    public interface UpdatedAtStage {
        LastRequestAtStage updatedAt(int updatedAt);
    }

    public interface LastRequestAtStage {
        SizeStage lastRequestAt(int lastRequestAt);
    }

    public interface SizeStage {
        WebsiteStage size(int size);
    }

    public interface WebsiteStage {
        IndustryStage website(@NotNull String website);
    }

    public interface IndustryStage {
        MonthlySpendStage industry(@NotNull String industry);
    }

    public interface MonthlySpendStage {
        SessionCountStage monthlySpend(int monthlySpend);
    }

    public interface SessionCountStage {
        UserCountStage sessionCount(int sessionCount);
    }

    public interface UserCountStage {
        _FinalStage userCount(int userCount);
    }

    public interface _FinalStage {
        Company build();

        _FinalStage type(Optional<String> type);

        _FinalStage type(String type);

        _FinalStage plan(Optional<Plan> plan);

        _FinalStage plan(Plan plan);

        _FinalStage customAttributes(Optional<Map<String, Object>> customAttributes);

        _FinalStage customAttributes(Map<String, Object> customAttributes);

        _FinalStage tags(Optional<Tags> tags);

        _FinalStage tags(Tags tags);

        _FinalStage segments(Optional<Segments> segments);

        _FinalStage segments(Segments segments);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements IdStage,
                    NameStage,
                    AppIdStage,
                    CompanyIdStage,
                    RemoteCreatedAtStage,
                    CreatedAtStage,
                    UpdatedAtStage,
                    LastRequestAtStage,
                    SizeStage,
                    WebsiteStage,
                    IndustryStage,
                    MonthlySpendStage,
                    SessionCountStage,
                    UserCountStage,
                    _FinalStage {
        private String id;

        private String name;

        private String appId;

        private String companyId;

        private int remoteCreatedAt;

        private int createdAt;

        private int updatedAt;

        private int lastRequestAt;

        private int size;

        private String website;

        private String industry;

        private int monthlySpend;

        private int sessionCount;

        private int userCount;

        private Optional<Segments> segments = Optional.empty();

        private Optional<Tags> tags = Optional.empty();

        private Optional<Map<String, Object>> customAttributes = Optional.empty();

        private Optional<Plan> plan = Optional.empty();

        private Optional<String> type = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(Company other) {
            type(other.getType());
            id(other.getId());
            name(other.getName());
            appId(other.getAppId());
            plan(other.getPlan());
            companyId(other.getCompanyId());
            remoteCreatedAt(other.getRemoteCreatedAt());
            createdAt(other.getCreatedAt());
            updatedAt(other.getUpdatedAt());
            lastRequestAt(other.getLastRequestAt());
            size(other.getSize());
            website(other.getWebsite());
            industry(other.getIndustry());
            monthlySpend(other.getMonthlySpend());
            sessionCount(other.getSessionCount());
            userCount(other.getUserCount());
            customAttributes(other.getCustomAttributes());
            tags(other.getTags());
            segments(other.getSegments());
            return this;
        }

        /**
         * <p>The Intercom defined id representing the company.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("id")
        public NameStage id(@NotNull String id) {
            this.id = Objects.requireNonNull(id, "id must not be null");
            return this;
        }

        /**
         * <p>The name of the company.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("name")
        public AppIdStage name(@NotNull String name) {
            this.name = Objects.requireNonNull(name, "name must not be null");
            return this;
        }

        /**
         * <p>The Intercom defined code of the workspace the company is associated to.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("app_id")
        public CompanyIdStage appId(@NotNull String appId) {
            this.appId = Objects.requireNonNull(appId, "appId must not be null");
            return this;
        }

        /**
         * <p>The company id you have defined for the company.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("company_id")
        public RemoteCreatedAtStage companyId(@NotNull String companyId) {
            this.companyId = Objects.requireNonNull(companyId, "companyId must not be null");
            return this;
        }

        /**
         * <p>The time the company was created by you.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("remote_created_at")
        public CreatedAtStage remoteCreatedAt(int remoteCreatedAt) {
            this.remoteCreatedAt = remoteCreatedAt;
            return this;
        }

        /**
         * <p>The time the company was added in Intercom.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("created_at")
        public UpdatedAtStage createdAt(int createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * <p>The last time the company was updated.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("updated_at")
        public LastRequestAtStage updatedAt(int updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        /**
         * <p>The time the company last recorded making a request.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("last_request_at")
        public SizeStage lastRequestAt(int lastRequestAt) {
            this.lastRequestAt = lastRequestAt;
            return this;
        }

        /**
         * <p>The number of employees in the company.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("size")
        public WebsiteStage size(int size) {
            this.size = size;
            return this;
        }

        /**
         * <p>The URL for the company website.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("website")
        public IndustryStage website(@NotNull String website) {
            this.website = Objects.requireNonNull(website, "website must not be null");
            return this;
        }

        /**
         * <p>The industry that the company operates in.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("industry")
        public MonthlySpendStage industry(@NotNull String industry) {
            this.industry = Objects.requireNonNull(industry, "industry must not be null");
            return this;
        }

        /**
         * <p>How much revenue the company generates for your business.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("monthly_spend")
        public SessionCountStage monthlySpend(int monthlySpend) {
            this.monthlySpend = monthlySpend;
            return this;
        }

        /**
         * <p>How many sessions the company has recorded.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("session_count")
        public UserCountStage sessionCount(int sessionCount) {
            this.sessionCount = sessionCount;
            return this;
        }

        /**
         * <p>The number of users in the company.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("user_count")
        public _FinalStage userCount(int userCount) {
            this.userCount = userCount;
            return this;
        }

        /**
         * <p>The list of segments associated with the company</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage segments(Segments segments) {
            this.segments = Optional.ofNullable(segments);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "segments", nulls = Nulls.SKIP)
        public _FinalStage segments(Optional<Segments> segments) {
            this.segments = segments;
            return this;
        }

        /**
         * <p>The list of tags associated with the company</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage tags(Tags tags) {
            this.tags = Optional.ofNullable(tags);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "tags", nulls = Nulls.SKIP)
        public _FinalStage tags(Optional<Tags> tags) {
            this.tags = tags;
            return this;
        }

        /**
         * <p>The custom attributes you have set on the company.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage customAttributes(Map<String, Object> customAttributes) {
            this.customAttributes = Optional.ofNullable(customAttributes);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "custom_attributes", nulls = Nulls.SKIP)
        public _FinalStage customAttributes(Optional<Map<String, Object>> customAttributes) {
            this.customAttributes = customAttributes;
            return this;
        }

        @java.lang.Override
        public _FinalStage plan(Plan plan) {
            this.plan = Optional.ofNullable(plan);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "plan", nulls = Nulls.SKIP)
        public _FinalStage plan(Optional<Plan> plan) {
            this.plan = plan;
            return this;
        }

        /**
         * <p>Value is <code>company</code></p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage type(String type) {
            this.type = Optional.ofNullable(type);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "type", nulls = Nulls.SKIP)
        public _FinalStage type(Optional<String> type) {
            this.type = type;
            return this;
        }

        @java.lang.Override
        public Company build() {
            return new Company(
                    type,
                    id,
                    name,
                    appId,
                    plan,
                    companyId,
                    remoteCreatedAt,
                    createdAt,
                    updatedAt,
                    lastRequestAt,
                    size,
                    website,
                    industry,
                    monthlySpend,
                    sessionCount,
                    userCount,
                    customAttributes,
                    tags,
                    segments,
                    additionalProperties);
        }
    }

    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    @JsonDeserialize(builder = Tags.Builder.class)
    public static final class Tags {
        private final Optional<String> type;

        private final Optional<List<Object>> tags;

        private final Map<String, Object> additionalProperties;

        private Tags(Optional<String> type, Optional<List<Object>> tags, Map<String, Object> additionalProperties) {
            this.type = type;
            this.tags = tags;
            this.additionalProperties = additionalProperties;
        }

        /**
         * @return The type of the object
         */
        @JsonProperty("type")
        public Optional<String> getType() {
            return type;
        }

        @JsonProperty("tags")
        public Optional<List<Object>> getTags() {
            return tags;
        }

        @java.lang.Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof Tags && equalTo((Tags) other);
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        private boolean equalTo(Tags other) {
            return type.equals(other.type) && tags.equals(other.tags);
        }

        @java.lang.Override
        public int hashCode() {
            return Objects.hash(this.type, this.tags);
        }

        @java.lang.Override
        public String toString() {
            return ObjectMappers.stringify(this);
        }

        public static Builder builder() {
            return new Builder();
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static final class Builder {
            private Optional<String> type = Optional.empty();

            private Optional<List<Object>> tags = Optional.empty();

            @JsonAnySetter
            private Map<String, Object> additionalProperties = new HashMap<>();

            private Builder() {}

            public Builder from(Tags other) {
                type(other.getType());
                tags(other.getTags());
                return this;
            }

            @JsonSetter(value = "type", nulls = Nulls.SKIP)
            public Builder type(Optional<String> type) {
                this.type = type;
                return this;
            }

            public Builder type(String type) {
                this.type = Optional.ofNullable(type);
                return this;
            }

            @JsonSetter(value = "tags", nulls = Nulls.SKIP)
            public Builder tags(Optional<List<Object>> tags) {
                this.tags = tags;
                return this;
            }

            public Builder tags(List<Object> tags) {
                this.tags = Optional.ofNullable(tags);
                return this;
            }

            public Tags build() {
                return new Tags(type, tags, additionalProperties);
            }
        }
    }

    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    @JsonDeserialize(builder = Segments.Builder.class)
    public static final class Segments {
        private final Optional<String> type;

        private final Optional<List<Segment>> segments;

        private final Map<String, Object> additionalProperties;

        private Segments(
                Optional<String> type, Optional<List<Segment>> segments, Map<String, Object> additionalProperties) {
            this.type = type;
            this.segments = segments;
            this.additionalProperties = additionalProperties;
        }

        /**
         * @return The type of the object
         */
        @JsonProperty("type")
        public Optional<String> getType() {
            return type;
        }

        @JsonProperty("segments")
        public Optional<List<Segment>> getSegments() {
            return segments;
        }

        @java.lang.Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof Segments && equalTo((Segments) other);
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        private boolean equalTo(Segments other) {
            return type.equals(other.type) && segments.equals(other.segments);
        }

        @java.lang.Override
        public int hashCode() {
            return Objects.hash(this.type, this.segments);
        }

        @java.lang.Override
        public String toString() {
            return ObjectMappers.stringify(this);
        }

        public static Builder builder() {
            return new Builder();
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static final class Builder {
            private Optional<String> type = Optional.empty();

            private Optional<List<Segment>> segments = Optional.empty();

            @JsonAnySetter
            private Map<String, Object> additionalProperties = new HashMap<>();

            private Builder() {}

            public Builder from(Segments other) {
                type(other.getType());
                segments(other.getSegments());
                return this;
            }

            @JsonSetter(value = "type", nulls = Nulls.SKIP)
            public Builder type(Optional<String> type) {
                this.type = type;
                return this;
            }

            public Builder type(String type) {
                this.type = Optional.ofNullable(type);
                return this;
            }

            @JsonSetter(value = "segments", nulls = Nulls.SKIP)
            public Builder segments(Optional<List<Segment>> segments) {
                this.segments = segments;
                return this;
            }

            public Builder segments(List<Segment> segments) {
                this.segments = Optional.ofNullable(segments);
                return this;
            }

            public Segments build() {
                return new Segments(type, segments, additionalProperties);
            }
        }
    }

    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    @JsonDeserialize(builder = Plan.Builder.class)
    public static final class Plan {
        private final Optional<String> type;

        private final Optional<String> id;

        private final Optional<String> name;

        private final Map<String, Object> additionalProperties;

        private Plan(
                Optional<String> type,
                Optional<String> id,
                Optional<String> name,
                Map<String, Object> additionalProperties) {
            this.type = type;
            this.id = id;
            this.name = name;
            this.additionalProperties = additionalProperties;
        }

        /**
         * @return Value is always &quot;plan&quot;
         */
        @JsonProperty("type")
        public Optional<String> getType() {
            return type;
        }

        /**
         * @return The id of the plan
         */
        @JsonProperty("id")
        public Optional<String> getId() {
            return id;
        }

        /**
         * @return The name of the plan
         */
        @JsonProperty("name")
        public Optional<String> getName() {
            return name;
        }

        @java.lang.Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof Plan && equalTo((Plan) other);
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        private boolean equalTo(Plan other) {
            return type.equals(other.type) && id.equals(other.id) && name.equals(other.name);
        }

        @java.lang.Override
        public int hashCode() {
            return Objects.hash(this.type, this.id, this.name);
        }

        @java.lang.Override
        public String toString() {
            return ObjectMappers.stringify(this);
        }

        public static Builder builder() {
            return new Builder();
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static final class Builder {
            private Optional<String> type = Optional.empty();

            private Optional<String> id = Optional.empty();

            private Optional<String> name = Optional.empty();

            @JsonAnySetter
            private Map<String, Object> additionalProperties = new HashMap<>();

            private Builder() {}

            public Builder from(Plan other) {
                type(other.getType());
                id(other.getId());
                name(other.getName());
                return this;
            }

            @JsonSetter(value = "type", nulls = Nulls.SKIP)
            public Builder type(Optional<String> type) {
                this.type = type;
                return this;
            }

            public Builder type(String type) {
                this.type = Optional.ofNullable(type);
                return this;
            }

            @JsonSetter(value = "id", nulls = Nulls.SKIP)
            public Builder id(Optional<String> id) {
                this.id = id;
                return this;
            }

            public Builder id(String id) {
                this.id = Optional.ofNullable(id);
                return this;
            }

            @JsonSetter(value = "name", nulls = Nulls.SKIP)
            public Builder name(Optional<String> name) {
                this.name = name;
                return this;
            }

            public Builder name(String name) {
                this.name = Optional.ofNullable(name);
                return this;
            }

            public Plan build() {
                return new Plan(type, id, name, additionalProperties);
            }
        }
    }
}
