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
import com.intercom.api.resources.news.types.Newsfeed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = PaginatedNewsfeedResponse.Builder.class)
public final class PaginatedNewsfeedResponse {
    private final Optional<CursorPages> pages;

    private final int totalCount;

    private final List<Newsfeed> data;

    private final Map<String, Object> additionalProperties;

    private PaginatedNewsfeedResponse(
            Optional<CursorPages> pages,
            int totalCount,
            List<Newsfeed> data,
            Map<String, Object> additionalProperties) {
        this.pages = pages;
        this.totalCount = totalCount;
        this.data = data;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The type of object
     */
    @JsonProperty("type")
    public String getType() {
        return "list";
    }

    @JsonProperty("pages")
    public Optional<CursorPages> getPages() {
        return pages;
    }

    /**
     * @return A count of the total number of Newsfeeds.
     */
    @JsonProperty("total_count")
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * @return An array of Newsfeeds
     */
    @JsonProperty("data")
    public List<Newsfeed> getData() {
        return data;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof PaginatedNewsfeedResponse && equalTo((PaginatedNewsfeedResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(PaginatedNewsfeedResponse other) {
        return pages.equals(other.pages) && totalCount == other.totalCount && data.equals(other.data);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.pages, this.totalCount, this.data);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static TotalCountStage builder() {
        return new Builder();
    }

    public interface TotalCountStage {
        _FinalStage totalCount(int totalCount);

        Builder from(PaginatedNewsfeedResponse other);
    }

    public interface _FinalStage {
        PaginatedNewsfeedResponse build();

        _FinalStage pages(Optional<CursorPages> pages);

        _FinalStage pages(CursorPages pages);

        _FinalStage data(List<Newsfeed> data);

        _FinalStage addData(Newsfeed data);

        _FinalStage addAllData(List<Newsfeed> data);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements TotalCountStage, _FinalStage {
        private int totalCount;

        private List<Newsfeed> data = new ArrayList<>();

        private Optional<CursorPages> pages = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(PaginatedNewsfeedResponse other) {
            pages(other.getPages());
            totalCount(other.getTotalCount());
            data(other.getData());
            return this;
        }

        /**
         * <p>A count of the total number of Newsfeeds.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("total_count")
        public _FinalStage totalCount(int totalCount) {
            this.totalCount = totalCount;
            return this;
        }

        /**
         * <p>An array of Newsfeeds</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage addAllData(List<Newsfeed> data) {
            this.data.addAll(data);
            return this;
        }

        /**
         * <p>An array of Newsfeeds</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage addData(Newsfeed data) {
            this.data.add(data);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "data", nulls = Nulls.SKIP)
        public _FinalStage data(List<Newsfeed> data) {
            this.data.clear();
            this.data.addAll(data);
            return this;
        }

        @java.lang.Override
        public _FinalStage pages(CursorPages pages) {
            this.pages = Optional.ofNullable(pages);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "pages", nulls = Nulls.SKIP)
        public _FinalStage pages(Optional<CursorPages> pages) {
            this.pages = pages;
            return this;
        }

        @java.lang.Override
        public PaginatedNewsfeedResponse build() {
            return new PaginatedNewsfeedResponse(pages, totalCount, data, additionalProperties);
        }
    }
}
