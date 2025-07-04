/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.intercom.api.resources.unstable.types;

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
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = ConversationResponseTime.Builder.class)
public final class ConversationResponseTime {
    private final Optional<Integer> teamId;

    private final Optional<String> teamName;

    private final Optional<Integer> responseTime;

    private final Map<String, Object> additionalProperties;

    private ConversationResponseTime(
            Optional<Integer> teamId,
            Optional<String> teamName,
            Optional<Integer> responseTime,
            Map<String, Object> additionalProperties) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.responseTime = responseTime;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Id of the assigned team.
     */
    @JsonProperty("team_id")
    public Optional<Integer> getTeamId() {
        return teamId;
    }

    /**
     * @return Name of the assigned Team, null if team does not exist, Unassigned if no team is assigned.
     */
    @JsonProperty("team_name")
    public Optional<String> getTeamName() {
        return teamName;
    }

    /**
     * @return First response time of assigned team in seconds.
     */
    @JsonProperty("response_time")
    public Optional<Integer> getResponseTime() {
        return responseTime;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ConversationResponseTime && equalTo((ConversationResponseTime) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ConversationResponseTime other) {
        return teamId.equals(other.teamId)
                && teamName.equals(other.teamName)
                && responseTime.equals(other.responseTime);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.teamId, this.teamName, this.responseTime);
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
        private Optional<Integer> teamId = Optional.empty();

        private Optional<String> teamName = Optional.empty();

        private Optional<Integer> responseTime = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ConversationResponseTime other) {
            teamId(other.getTeamId());
            teamName(other.getTeamName());
            responseTime(other.getResponseTime());
            return this;
        }

        /**
         * <p>Id of the assigned team.</p>
         */
        @JsonSetter(value = "team_id", nulls = Nulls.SKIP)
        public Builder teamId(Optional<Integer> teamId) {
            this.teamId = teamId;
            return this;
        }

        public Builder teamId(Integer teamId) {
            this.teamId = Optional.ofNullable(teamId);
            return this;
        }

        /**
         * <p>Name of the assigned Team, null if team does not exist, Unassigned if no team is assigned.</p>
         */
        @JsonSetter(value = "team_name", nulls = Nulls.SKIP)
        public Builder teamName(Optional<String> teamName) {
            this.teamName = teamName;
            return this;
        }

        public Builder teamName(String teamName) {
            this.teamName = Optional.ofNullable(teamName);
            return this;
        }

        /**
         * <p>First response time of assigned team in seconds.</p>
         */
        @JsonSetter(value = "response_time", nulls = Nulls.SKIP)
        public Builder responseTime(Optional<Integer> responseTime) {
            this.responseTime = responseTime;
            return this;
        }

        public Builder responseTime(Integer responseTime) {
            this.responseTime = Optional.ofNullable(responseTime);
            return this;
        }

        public ConversationResponseTime build() {
            return new ConversationResponseTime(teamId, teamName, responseTime, additionalProperties);
        }
    }
}
