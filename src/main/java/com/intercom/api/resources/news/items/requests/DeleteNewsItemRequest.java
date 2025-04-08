/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.intercom.api.resources.news.items.requests;

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
@JsonDeserialize(builder = DeleteNewsItemRequest.Builder.class)
public final class DeleteNewsItemRequest {
    private final String newsItemId;

    private final Map<String, Object> additionalProperties;

    private DeleteNewsItemRequest(String newsItemId, Map<String, Object> additionalProperties) {
        this.newsItemId = newsItemId;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The unique identifier for the news item which is given by Intercom.
     */
    @JsonProperty("news_item_id")
    public String getNewsItemId() {
        return newsItemId;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof DeleteNewsItemRequest && equalTo((DeleteNewsItemRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(DeleteNewsItemRequest other) {
        return newsItemId.equals(other.newsItemId);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.newsItemId);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static NewsItemIdStage builder() {
        return new Builder();
    }

    public interface NewsItemIdStage {
        _FinalStage newsItemId(@NotNull String newsItemId);

        Builder from(DeleteNewsItemRequest other);
    }

    public interface _FinalStage {
        DeleteNewsItemRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NewsItemIdStage, _FinalStage {
        private String newsItemId;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(DeleteNewsItemRequest other) {
            newsItemId(other.getNewsItemId());
            return this;
        }

        /**
         * <p>The unique identifier for the news item which is given by Intercom.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("news_item_id")
        public _FinalStage newsItemId(@NotNull String newsItemId) {
            this.newsItemId = Objects.requireNonNull(newsItemId, "newsItemId must not be null");
            return this;
        }

        @java.lang.Override
        public DeleteNewsItemRequest build() {
            return new DeleteNewsItemRequest(newsItemId, additionalProperties);
        }
    }
}
