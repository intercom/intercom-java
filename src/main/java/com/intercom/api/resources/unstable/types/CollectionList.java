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
import com.intercom.api.resources.unstable.helpcenter.types.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CollectionList.Builder.class)
public final class CollectionList {
    private final Optional<String> type;

    private final Optional<CursorPages> pages;

    private final Optional<Integer> totalCount;

    private final Optional<List<Collection>> data;

    private final Map<String, Object> additionalProperties;

    private CollectionList(
            Optional<String> type,
            Optional<CursorPages> pages,
            Optional<Integer> totalCount,
            Optional<List<Collection>> data,
            Map<String, Object> additionalProperties) {
        this.type = type;
        this.pages = pages;
        this.totalCount = totalCount;
        this.data = data;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The type of the object - <code>list</code>.
     */
    @JsonProperty("type")
    public Optional<String> getType() {
        return type;
    }

    @JsonProperty("pages")
    public Optional<CursorPages> getPages() {
        return pages;
    }

    /**
     * @return A count of the total number of collections.
     */
    @JsonProperty("total_count")
    public Optional<Integer> getTotalCount() {
        return totalCount;
    }

    /**
     * @return An array of collection objects
     */
    @JsonProperty("data")
    public Optional<List<Collection>> getData() {
        return data;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CollectionList && equalTo((CollectionList) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CollectionList other) {
        return type.equals(other.type)
                && pages.equals(other.pages)
                && totalCount.equals(other.totalCount)
                && data.equals(other.data);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.type, this.pages, this.totalCount, this.data);
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

        private Optional<CursorPages> pages = Optional.empty();

        private Optional<Integer> totalCount = Optional.empty();

        private Optional<List<Collection>> data = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(CollectionList other) {
            type(other.getType());
            pages(other.getPages());
            totalCount(other.getTotalCount());
            data(other.getData());
            return this;
        }

        /**
         * <p>The type of the object - <code>list</code>.</p>
         */
        @JsonSetter(value = "type", nulls = Nulls.SKIP)
        public Builder type(Optional<String> type) {
            this.type = type;
            return this;
        }

        public Builder type(String type) {
            this.type = Optional.ofNullable(type);
            return this;
        }

        @JsonSetter(value = "pages", nulls = Nulls.SKIP)
        public Builder pages(Optional<CursorPages> pages) {
            this.pages = pages;
            return this;
        }

        public Builder pages(CursorPages pages) {
            this.pages = Optional.ofNullable(pages);
            return this;
        }

        /**
         * <p>A count of the total number of collections.</p>
         */
        @JsonSetter(value = "total_count", nulls = Nulls.SKIP)
        public Builder totalCount(Optional<Integer> totalCount) {
            this.totalCount = totalCount;
            return this;
        }

        public Builder totalCount(Integer totalCount) {
            this.totalCount = Optional.ofNullable(totalCount);
            return this;
        }

        /**
         * <p>An array of collection objects</p>
         */
        @JsonSetter(value = "data", nulls = Nulls.SKIP)
        public Builder data(Optional<List<Collection>> data) {
            this.data = data;
            return this;
        }

        public Builder data(List<Collection> data) {
            this.data = Optional.ofNullable(data);
            return this;
        }

        public CollectionList build() {
            return new CollectionList(type, pages, totalCount, data, additionalProperties);
        }
    }
}
