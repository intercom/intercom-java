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
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CanvasObject.Builder.class)
public final class CanvasObject {
    private final ContentObject content;

    private final Optional<String> contentUrl;

    private final Optional<Map<String, Object>> storedData;

    private final Map<String, Object> additionalProperties;

    private CanvasObject(
            ContentObject content,
            Optional<String> contentUrl,
            Optional<Map<String, Object>> storedData,
            Map<String, Object> additionalProperties) {
        this.content = content;
        this.contentUrl = contentUrl;
        this.storedData = storedData;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The content object that will be shown as the UI of the app. Max Size is 64KB.
     */
    @JsonProperty("content")
    public ContentObject getContent() {
        return content;
    }

    /**
     * @return The URL which we make Live Canvas requests to. You must respond to these with a content object. Max size is 64KB.
     */
    @JsonProperty("content_url")
    public Optional<String> getContentUrl() {
        return contentUrl;
    }

    /**
     * @return Optional Stored Data that you want to be returned in the next sent request. Max Size is 64KB.
     */
    @JsonProperty("stored_data")
    public Optional<Map<String, Object>> getStoredData() {
        return storedData;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CanvasObject && equalTo((CanvasObject) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CanvasObject other) {
        return content.equals(other.content)
                && contentUrl.equals(other.contentUrl)
                && storedData.equals(other.storedData);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.content, this.contentUrl, this.storedData);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ContentStage builder() {
        return new Builder();
    }

    public interface ContentStage {
        _FinalStage content(@NotNull ContentObject content);

        Builder from(CanvasObject other);
    }

    public interface _FinalStage {
        CanvasObject build();

        _FinalStage contentUrl(Optional<String> contentUrl);

        _FinalStage contentUrl(String contentUrl);

        _FinalStage storedData(Optional<Map<String, Object>> storedData);

        _FinalStage storedData(Map<String, Object> storedData);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ContentStage, _FinalStage {
        private ContentObject content;

        private Optional<Map<String, Object>> storedData = Optional.empty();

        private Optional<String> contentUrl = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(CanvasObject other) {
            content(other.getContent());
            contentUrl(other.getContentUrl());
            storedData(other.getStoredData());
            return this;
        }

        /**
         * <p>The content object that will be shown as the UI of the app. Max Size is 64KB.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("content")
        public _FinalStage content(@NotNull ContentObject content) {
            this.content = Objects.requireNonNull(content, "content must not be null");
            return this;
        }

        /**
         * <p>Optional Stored Data that you want to be returned in the next sent request. Max Size is 64KB.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage storedData(Map<String, Object> storedData) {
            this.storedData = Optional.ofNullable(storedData);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "stored_data", nulls = Nulls.SKIP)
        public _FinalStage storedData(Optional<Map<String, Object>> storedData) {
            this.storedData = storedData;
            return this;
        }

        /**
         * <p>The URL which we make Live Canvas requests to. You must respond to these with a content object. Max size is 64KB.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage contentUrl(String contentUrl) {
            this.contentUrl = Optional.ofNullable(contentUrl);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "content_url", nulls = Nulls.SKIP)
        public _FinalStage contentUrl(Optional<String> contentUrl) {
            this.contentUrl = contentUrl;
            return this;
        }

        @java.lang.Override
        public CanvasObject build() {
            return new CanvasObject(content, contentUrl, storedData, additionalProperties);
        }
    }
}
