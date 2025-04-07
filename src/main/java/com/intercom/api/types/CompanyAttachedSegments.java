/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.intercom.api.types;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CompanyAttachedSegments.Builder.class)
public final class CompanyAttachedSegments {
    private final List<Segment> data;

    private final Map<String, Object> additionalProperties;

    private CompanyAttachedSegments(List<Segment> data, Map<String, Object> additionalProperties) {
        this.data = data;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The type of object - <code>list</code>
     */
    @JsonProperty("type")
    public String getType() {
        return "list";
    }

    /**
     * @return An array containing Segment Objects
     */
    @JsonProperty("data")
    public List<Segment> getData() {
        return data;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CompanyAttachedSegments && equalTo((CompanyAttachedSegments) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CompanyAttachedSegments other) {
        return data.equals(other.data);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.data);
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
        private List<Segment> data = new ArrayList<>();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(CompanyAttachedSegments other) {
            data(other.getData());
            return this;
        }

        @JsonSetter(value = "data", nulls = Nulls.SKIP)
        public Builder data(List<Segment> data) {
            this.data.clear();
            this.data.addAll(data);
            return this;
        }

        public Builder addData(Segment data) {
            this.data.add(data);
            return this;
        }

        public Builder addAllData(List<Segment> data) {
            this.data.addAll(data);
            return this;
        }

        public CompanyAttachedSegments build() {
            return new CompanyAttachedSegments(data, additionalProperties);
        }
    }
}
