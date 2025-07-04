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
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = ResultsResponse.Builder.class)
public final class ResultsResponse {
    private final Map<String, Object> results;

    private final Map<String, Object> additionalProperties;

    private ResultsResponse(Map<String, Object> results, Map<String, Object> additionalProperties) {
        this.results = results;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Key-value pairs of data you want access to in the Initialize request
     */
    @JsonProperty("results")
    public Map<String, Object> getResults() {
        return results;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ResultsResponse && equalTo((ResultsResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ResultsResponse other) {
        return results.equals(other.results);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.results);
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
        private Map<String, Object> results = new LinkedHashMap<>();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ResultsResponse other) {
            results(other.getResults());
            return this;
        }

        /**
         * <p>Key-value pairs of data you want access to in the Initialize request</p>
         */
        @JsonSetter(value = "results", nulls = Nulls.SKIP)
        public Builder results(Map<String, Object> results) {
            this.results.clear();
            this.results.putAll(results);
            return this;
        }

        public Builder putAllResults(Map<String, Object> results) {
            this.results.putAll(results);
            return this;
        }

        public Builder results(String key, Object value) {
            this.results.put(key, value);
            return this;
        }

        public ResultsResponse build() {
            return new ResultsResponse(results, additionalProperties);
        }
    }
}
