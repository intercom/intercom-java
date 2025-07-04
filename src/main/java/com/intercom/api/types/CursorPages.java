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
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CursorPages.Builder.class)
public final class CursorPages {
    private final Optional<Integer> page;

    private final Optional<StartingAfterPaging> next;

    private final Optional<Integer> perPage;

    private final Optional<Integer> totalPages;

    private final Map<String, Object> additionalProperties;

    private CursorPages(
            Optional<Integer> page,
            Optional<StartingAfterPaging> next,
            Optional<Integer> perPage,
            Optional<Integer> totalPages,
            Map<String, Object> additionalProperties) {
        this.page = page;
        this.next = next;
        this.perPage = perPage;
        this.totalPages = totalPages;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return the type of object <code>pages</code>.
     */
    @JsonProperty("type")
    public String getType() {
        return "pages";
    }

    /**
     * @return The current page
     */
    @JsonProperty("page")
    public Optional<Integer> getPage() {
        return page;
    }

    @JsonProperty("next")
    public Optional<StartingAfterPaging> getNext() {
        return next;
    }

    /**
     * @return Number of results per page
     */
    @JsonProperty("per_page")
    public Optional<Integer> getPerPage() {
        return perPage;
    }

    /**
     * @return Total number of pages
     */
    @JsonProperty("total_pages")
    public Optional<Integer> getTotalPages() {
        return totalPages;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CursorPages && equalTo((CursorPages) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CursorPages other) {
        return page.equals(other.page)
                && next.equals(other.next)
                && perPage.equals(other.perPage)
                && totalPages.equals(other.totalPages);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.page, this.next, this.perPage, this.totalPages);
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
        private Optional<Integer> page = Optional.empty();

        private Optional<StartingAfterPaging> next = Optional.empty();

        private Optional<Integer> perPage = Optional.empty();

        private Optional<Integer> totalPages = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(CursorPages other) {
            page(other.getPage());
            next(other.getNext());
            perPage(other.getPerPage());
            totalPages(other.getTotalPages());
            return this;
        }

        /**
         * <p>The current page</p>
         */
        @JsonSetter(value = "page", nulls = Nulls.SKIP)
        public Builder page(Optional<Integer> page) {
            this.page = page;
            return this;
        }

        public Builder page(Integer page) {
            this.page = Optional.ofNullable(page);
            return this;
        }

        @JsonSetter(value = "next", nulls = Nulls.SKIP)
        public Builder next(Optional<StartingAfterPaging> next) {
            this.next = next;
            return this;
        }

        public Builder next(StartingAfterPaging next) {
            this.next = Optional.ofNullable(next);
            return this;
        }

        /**
         * <p>Number of results per page</p>
         */
        @JsonSetter(value = "per_page", nulls = Nulls.SKIP)
        public Builder perPage(Optional<Integer> perPage) {
            this.perPage = perPage;
            return this;
        }

        public Builder perPage(Integer perPage) {
            this.perPage = Optional.ofNullable(perPage);
            return this;
        }

        /**
         * <p>Total number of pages</p>
         */
        @JsonSetter(value = "total_pages", nulls = Nulls.SKIP)
        public Builder totalPages(Optional<Integer> totalPages) {
            this.totalPages = totalPages;
            return this;
        }

        public Builder totalPages(Integer totalPages) {
            this.totalPages = Optional.ofNullable(totalPages);
            return this;
        }

        public CursorPages build() {
            return new CursorPages(page, next, perPage, totalPages, additionalProperties);
        }
    }
}
