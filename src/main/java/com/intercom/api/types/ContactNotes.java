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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = ContactNotes.Builder.class)
public final class ContactNotes {
    private final List<AddressableList> data;

    private final String url;

    private final int totalCount;

    private final boolean hasMore;

    private final Map<String, Object> additionalProperties;

    private ContactNotes(
            List<AddressableList> data,
            String url,
            int totalCount,
            boolean hasMore,
            Map<String, Object> additionalProperties) {
        this.data = data;
        this.url = url;
        this.totalCount = totalCount;
        this.hasMore = hasMore;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return This object represents the notes attached to a contact.
     */
    @JsonProperty("data")
    public List<AddressableList> getData() {
        return data;
    }

    /**
     * @return Url to get more company resources for this contact
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * @return Int representing the total number of companyies attached to this contact
     */
    @JsonProperty("total_count")
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * @return Whether there's more Addressable Objects to be viewed. If true, use the url to view all
     */
    @JsonProperty("has_more")
    public boolean getHasMore() {
        return hasMore;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ContactNotes && equalTo((ContactNotes) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ContactNotes other) {
        return data.equals(other.data)
                && url.equals(other.url)
                && totalCount == other.totalCount
                && hasMore == other.hasMore;
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.data, this.url, this.totalCount, this.hasMore);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static UrlStage builder() {
        return new Builder();
    }

    public interface UrlStage {
        TotalCountStage url(@NotNull String url);

        Builder from(ContactNotes other);
    }

    public interface TotalCountStage {
        HasMoreStage totalCount(int totalCount);
    }

    public interface HasMoreStage {
        _FinalStage hasMore(boolean hasMore);
    }

    public interface _FinalStage {
        ContactNotes build();

        _FinalStage data(List<AddressableList> data);

        _FinalStage addData(AddressableList data);

        _FinalStage addAllData(List<AddressableList> data);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements UrlStage, TotalCountStage, HasMoreStage, _FinalStage {
        private String url;

        private int totalCount;

        private boolean hasMore;

        private List<AddressableList> data = new ArrayList<>();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(ContactNotes other) {
            data(other.getData());
            url(other.getUrl());
            totalCount(other.getTotalCount());
            hasMore(other.getHasMore());
            return this;
        }

        /**
         * <p>Url to get more company resources for this contact</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("url")
        public TotalCountStage url(@NotNull String url) {
            this.url = Objects.requireNonNull(url, "url must not be null");
            return this;
        }

        /**
         * <p>Int representing the total number of companyies attached to this contact</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("total_count")
        public HasMoreStage totalCount(int totalCount) {
            this.totalCount = totalCount;
            return this;
        }

        /**
         * <p>Whether there's more Addressable Objects to be viewed. If true, use the url to view all</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("has_more")
        public _FinalStage hasMore(boolean hasMore) {
            this.hasMore = hasMore;
            return this;
        }

        /**
         * <p>This object represents the notes attached to a contact.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage addAllData(List<AddressableList> data) {
            this.data.addAll(data);
            return this;
        }

        /**
         * <p>This object represents the notes attached to a contact.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage addData(AddressableList data) {
            this.data.add(data);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "data", nulls = Nulls.SKIP)
        public _FinalStage data(List<AddressableList> data) {
            this.data.clear();
            this.data.addAll(data);
            return this;
        }

        @java.lang.Override
        public ContactNotes build() {
            return new ContactNotes(data, url, totalCount, hasMore, additionalProperties);
        }
    }
}
