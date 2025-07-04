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
@JsonDeserialize(builder = FileAttribute.Builder.class)
public final class FileAttribute {
    private final String type;

    private final String name;

    private final String url;

    private final String contentType;

    private final int filesize;

    private final int width;

    private final int height;

    private final Map<String, Object> additionalProperties;

    private FileAttribute(
            String type,
            String name,
            String url,
            String contentType,
            int filesize,
            int width,
            int height,
            Map<String, Object> additionalProperties) {
        this.type = type;
        this.name = name;
        this.url = url;
        this.contentType = contentType;
        this.filesize = filesize;
        this.width = width;
        this.height = height;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * @return The name of the file
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * @return The url of the file. This is a temporary URL and will expire after 30 minutes.
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * @return The type of file
     */
    @JsonProperty("content_type")
    public String getContentType() {
        return contentType;
    }

    /**
     * @return The size of the file in bytes
     */
    @JsonProperty("filesize")
    public int getFilesize() {
        return filesize;
    }

    /**
     * @return The width of the file in pixels, if applicable
     */
    @JsonProperty("width")
    public int getWidth() {
        return width;
    }

    /**
     * @return The height of the file in pixels, if applicable
     */
    @JsonProperty("height")
    public int getHeight() {
        return height;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof FileAttribute && equalTo((FileAttribute) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(FileAttribute other) {
        return type.equals(other.type)
                && name.equals(other.name)
                && url.equals(other.url)
                && contentType.equals(other.contentType)
                && filesize == other.filesize
                && width == other.width
                && height == other.height;
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.type, this.name, this.url, this.contentType, this.filesize, this.width, this.height);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static TypeStage builder() {
        return new Builder();
    }

    public interface TypeStage {
        NameStage type(@NotNull String type);

        Builder from(FileAttribute other);
    }

    public interface NameStage {
        /**
         * The name of the file
         */
        UrlStage name(@NotNull String name);
    }

    public interface UrlStage {
        /**
         * The url of the file. This is a temporary URL and will expire after 30 minutes.
         */
        ContentTypeStage url(@NotNull String url);
    }

    public interface ContentTypeStage {
        /**
         * The type of file
         */
        FilesizeStage contentType(@NotNull String contentType);
    }

    public interface FilesizeStage {
        /**
         * The size of the file in bytes
         */
        WidthStage filesize(int filesize);
    }

    public interface WidthStage {
        /**
         * The width of the file in pixels, if applicable
         */
        HeightStage width(int width);
    }

    public interface HeightStage {
        /**
         * The height of the file in pixels, if applicable
         */
        _FinalStage height(int height);
    }

    public interface _FinalStage {
        FileAttribute build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements TypeStage,
                    NameStage,
                    UrlStage,
                    ContentTypeStage,
                    FilesizeStage,
                    WidthStage,
                    HeightStage,
                    _FinalStage {
        private String type;

        private String name;

        private String url;

        private String contentType;

        private int filesize;

        private int width;

        private int height;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(FileAttribute other) {
            type(other.getType());
            name(other.getName());
            url(other.getUrl());
            contentType(other.getContentType());
            filesize(other.getFilesize());
            width(other.getWidth());
            height(other.getHeight());
            return this;
        }

        @java.lang.Override
        @JsonSetter("type")
        public NameStage type(@NotNull String type) {
            this.type = Objects.requireNonNull(type, "type must not be null");
            return this;
        }

        /**
         * The name of the file<p>The name of the file</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("name")
        public UrlStage name(@NotNull String name) {
            this.name = Objects.requireNonNull(name, "name must not be null");
            return this;
        }

        /**
         * The url of the file. This is a temporary URL and will expire after 30 minutes.<p>The url of the file. This is a temporary URL and will expire after 30 minutes.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("url")
        public ContentTypeStage url(@NotNull String url) {
            this.url = Objects.requireNonNull(url, "url must not be null");
            return this;
        }

        /**
         * The type of file<p>The type of file</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("content_type")
        public FilesizeStage contentType(@NotNull String contentType) {
            this.contentType = Objects.requireNonNull(contentType, "contentType must not be null");
            return this;
        }

        /**
         * The size of the file in bytes<p>The size of the file in bytes</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("filesize")
        public WidthStage filesize(int filesize) {
            this.filesize = filesize;
            return this;
        }

        /**
         * The width of the file in pixels, if applicable<p>The width of the file in pixels, if applicable</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("width")
        public HeightStage width(int width) {
            this.width = width;
            return this;
        }

        /**
         * The height of the file in pixels, if applicable<p>The height of the file in pixels, if applicable</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("height")
        public _FinalStage height(int height) {
            this.height = height;
            return this;
        }

        @java.lang.Override
        public FileAttribute build() {
            return new FileAttribute(type, name, url, contentType, filesize, width, height, additionalProperties);
        }
    }
}
