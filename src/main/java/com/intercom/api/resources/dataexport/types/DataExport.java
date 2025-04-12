/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.intercom.api.resources.dataexport.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.intercom.api.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = DataExport.Builder.class)
public final class DataExport {
    private final String jobIdentifier;

    private final Status status;

    private final String downloadExpiresAt;

    private final String downloadUrl;

    private final Map<String, Object> additionalProperties;

    private DataExport(
            String jobIdentifier,
            Status status,
            String downloadExpiresAt,
            String downloadUrl,
            Map<String, Object> additionalProperties) {
        this.jobIdentifier = jobIdentifier;
        this.status = status;
        this.downloadExpiresAt = downloadExpiresAt;
        this.downloadUrl = downloadUrl;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The identifier for your job.
     */
    @JsonProperty("job_identifier")
    public String getJobIdentifier() {
        return jobIdentifier;
    }

    /**
     * @return The current state of your job.
     */
    @JsonProperty("status")
    public Status getStatus() {
        return status;
    }

    /**
     * @return The time after which you will not be able to access the data.
     */
    @JsonProperty("download_expires_at")
    public String getDownloadExpiresAt() {
        return downloadExpiresAt;
    }

    /**
     * @return The location where you can download your data.
     */
    @JsonProperty("download_url")
    public String getDownloadUrl() {
        return downloadUrl;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof DataExport && equalTo((DataExport) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(DataExport other) {
        return jobIdentifier.equals(other.jobIdentifier)
                && status.equals(other.status)
                && downloadExpiresAt.equals(other.downloadExpiresAt)
                && downloadUrl.equals(other.downloadUrl);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.jobIdentifier, this.status, this.downloadExpiresAt, this.downloadUrl);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static JobIdentifierStage builder() {
        return new Builder();
    }

    public interface JobIdentifierStage {
        StatusStage jobIdentifier(@NotNull String jobIdentifier);

        Builder from(DataExport other);
    }

    public interface StatusStage {
        DownloadExpiresAtStage status(@NotNull Status status);
    }

    public interface DownloadExpiresAtStage {
        DownloadUrlStage downloadExpiresAt(@NotNull String downloadExpiresAt);
    }

    public interface DownloadUrlStage {
        _FinalStage downloadUrl(@NotNull String downloadUrl);
    }

    public interface _FinalStage {
        DataExport build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements JobIdentifierStage, StatusStage, DownloadExpiresAtStage, DownloadUrlStage, _FinalStage {
        private String jobIdentifier;

        private Status status;

        private String downloadExpiresAt;

        private String downloadUrl;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(DataExport other) {
            jobIdentifier(other.getJobIdentifier());
            status(other.getStatus());
            downloadExpiresAt(other.getDownloadExpiresAt());
            downloadUrl(other.getDownloadUrl());
            return this;
        }

        /**
         * <p>The identifier for your job.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("job_identifier")
        public StatusStage jobIdentifier(@NotNull String jobIdentifier) {
            this.jobIdentifier = Objects.requireNonNull(jobIdentifier, "jobIdentifier must not be null");
            return this;
        }

        /**
         * <p>The current state of your job.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("status")
        public DownloadExpiresAtStage status(@NotNull Status status) {
            this.status = Objects.requireNonNull(status, "status must not be null");
            return this;
        }

        /**
         * <p>The time after which you will not be able to access the data.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("download_expires_at")
        public DownloadUrlStage downloadExpiresAt(@NotNull String downloadExpiresAt) {
            this.downloadExpiresAt = Objects.requireNonNull(downloadExpiresAt, "downloadExpiresAt must not be null");
            return this;
        }

        /**
         * <p>The location where you can download your data.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("download_url")
        public _FinalStage downloadUrl(@NotNull String downloadUrl) {
            this.downloadUrl = Objects.requireNonNull(downloadUrl, "downloadUrl must not be null");
            return this;
        }

        @java.lang.Override
        public DataExport build() {
            return new DataExport(jobIdentifier, status, downloadExpiresAt, downloadUrl, additionalProperties);
        }
    }

    public static final class Status {
        public static final Status FAILED = new Status(Value.FAILED, "failed");

        public static final Status COMPLETED = new Status(Value.COMPLETED, "completed");

        public static final Status NO_DATA = new Status(Value.NO_DATA, "no_data");

        public static final Status PENDING = new Status(Value.PENDING, "pending");

        public static final Status IN_PROGRESS = new Status(Value.IN_PROGRESS, "in_progress");

        public static final Status CANCELED = new Status(Value.CANCELED, "canceled");

        private final Value value;

        private final String string;

        Status(Value value, String string) {
            this.value = value;
            this.string = string;
        }

        public Value getEnumValue() {
            return value;
        }

        @java.lang.Override
        @JsonValue
        public String toString() {
            return this.string;
        }

        @java.lang.Override
        public boolean equals(Object other) {
            return (this == other) || (other instanceof Status && this.string.equals(((Status) other).string));
        }

        @java.lang.Override
        public int hashCode() {
            return this.string.hashCode();
        }

        public <T> T visit(Visitor<T> visitor) {
            switch (value) {
                case FAILED:
                    return visitor.visitFailed();
                case COMPLETED:
                    return visitor.visitCompleted();
                case NO_DATA:
                    return visitor.visitNoData();
                case PENDING:
                    return visitor.visitPending();
                case IN_PROGRESS:
                    return visitor.visitInProgress();
                case CANCELED:
                    return visitor.visitCanceled();
                case UNKNOWN:
                default:
                    return visitor.visitUnknown(string);
            }
        }

        @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
        public static Status valueOf(String value) {
            switch (value) {
                case "failed":
                    return FAILED;
                case "completed":
                    return COMPLETED;
                case "no_data":
                    return NO_DATA;
                case "pending":
                    return PENDING;
                case "in_progress":
                    return IN_PROGRESS;
                case "canceled":
                    return CANCELED;
                default:
                    return new Status(Value.UNKNOWN, value);
            }
        }

        public enum Value {
            PENDING,

            IN_PROGRESS,

            FAILED,

            COMPLETED,

            NO_DATA,

            CANCELED,

            UNKNOWN
        }

        public interface Visitor<T> {
            T visitPending();

            T visitInProgress();

            T visitFailed();

            T visitCompleted();

            T visitNoData();

            T visitCanceled();

            T visitUnknown(String unknownType);
        }
    }
}
