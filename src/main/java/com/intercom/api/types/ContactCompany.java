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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.intercom.api.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = ContactCompany.Builder.class)
public final class ContactCompany {
    private final String id;

    private final String url;

    private final Map<String, Object> additionalProperties;

    private ContactCompany(String id, String url, Map<String, Object> additionalProperties) {
        this.id = id;
        this.url = url;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The unique identifier for the company
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * @return The type of the object
     */
    @JsonProperty("type")
    public String getType() {
        return "company";
    }

    /**
     * @return URL to get the full company resource
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ContactCompany && equalTo((ContactCompany) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ContactCompany other) {
        return id.equals(other.id) && url.equals(other.url);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.id, this.url);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IdStage builder() {
        return new Builder();
    }

    public interface IdStage {
        /**
         * The unique identifier for the company
         */
        UrlStage id(@NotNull String id);

        Builder from(ContactCompany other);
    }

    public interface UrlStage {
        /**
         * URL to get the full company resource
         */
        _FinalStage url(@NotNull String url);
    }

    public interface _FinalStage {
        ContactCompany build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements IdStage, UrlStage, _FinalStage {
        private String id;

        private String url;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(ContactCompany other) {
            id(other.getId());
            url(other.getUrl());
            return this;
        }

        /**
         * The unique identifier for the company<p>The unique identifier for the company</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("id")
        public UrlStage id(@NotNull String id) {
            this.id = Objects.requireNonNull(id, "id must not be null");
            return this;
        }

        /**
         * URL to get the full company resource<p>URL to get the full company resource</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("url")
        public _FinalStage url(@NotNull String url) {
            this.url = Objects.requireNonNull(url, "url must not be null");
            return this;
        }

        @java.lang.Override
        public ContactCompany build() {
            return new ContactCompany(id, url, additionalProperties);
        }
    }
}
