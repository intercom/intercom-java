/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.intercom.api.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.intercom.api.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = ImageComponent.Builder.class)
public final class ImageComponent {
    private final Optional<String> id;

    private final String url;

    private final Optional<Align> align;

    private final int width;

    private final int height;

    private final Optional<Boolean> rounded;

    private final Optional<String> bottomMargin;

    private final Optional<UrlActionComponent> action;

    private final Map<String, Object> additionalProperties;

    private ImageComponent(
            Optional<String> id,
            String url,
            Optional<Align> align,
            int width,
            int height,
            Optional<Boolean> rounded,
            Optional<String> bottomMargin,
            Optional<UrlActionComponent> action,
            Map<String, Object> additionalProperties) {
        this.id = id;
        this.url = url;
        this.align = align;
        this.width = width;
        this.height = height;
        this.rounded = rounded;
        this.bottomMargin = bottomMargin;
        this.action = action;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return A unique identifier for the component.
     */
    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    /**
     * @return The URL where the image is located.
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * @return Aligns the image inside the component. Default is <code>left</code>.
     */
    @JsonProperty("align")
    public Optional<Align> getAlign() {
        return align;
    }

    /**
     * @return The exact width of the image in pixels.
     */
    @JsonProperty("width")
    public int getWidth() {
        return width;
    }

    /**
     * @return The exact height of the image in pixels.
     */
    @JsonProperty("height")
    public int getHeight() {
        return height;
    }

    /**
     * @return Rounds the corners of the image. Default is <code>false</code>.
     */
    @JsonProperty("rounded")
    public Optional<Boolean> getRounded() {
        return rounded;
    }

    /**
     * @return Disables a component's margin-bottom of 10px.
     */
    @JsonProperty("bottom_margin")
    public Optional<String> getBottomMargin() {
        return bottomMargin;
    }

    /**
     * @return This can be a URL Action only.
     */
    @JsonProperty("action")
    public Optional<UrlActionComponent> getAction() {
        return action;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ImageComponent && equalTo((ImageComponent) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ImageComponent other) {
        return id.equals(other.id)
                && url.equals(other.url)
                && align.equals(other.align)
                && width == other.width
                && height == other.height
                && rounded.equals(other.rounded)
                && bottomMargin.equals(other.bottomMargin)
                && action.equals(other.action);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.id, this.url, this.align, this.width, this.height, this.rounded, this.bottomMargin, this.action);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static UrlStage builder() {
        return new Builder();
    }

    public interface UrlStage {
        WidthStage url(@NotNull String url);

        Builder from(ImageComponent other);
    }

    public interface WidthStage {
        HeightStage width(int width);
    }

    public interface HeightStage {
        _FinalStage height(int height);
    }

    public interface _FinalStage {
        ImageComponent build();

        _FinalStage id(Optional<String> id);

        _FinalStage id(String id);

        _FinalStage align(Optional<Align> align);

        _FinalStage align(Align align);

        _FinalStage rounded(Optional<Boolean> rounded);

        _FinalStage rounded(Boolean rounded);

        _FinalStage bottomMargin(Optional<String> bottomMargin);

        _FinalStage bottomMargin(String bottomMargin);

        _FinalStage action(Optional<UrlActionComponent> action);

        _FinalStage action(UrlActionComponent action);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements UrlStage, WidthStage, HeightStage, _FinalStage {
        private String url;

        private int width;

        private int height;

        private Optional<UrlActionComponent> action = Optional.empty();

        private Optional<String> bottomMargin = Optional.empty();

        private Optional<Boolean> rounded = Optional.empty();

        private Optional<Align> align = Optional.empty();

        private Optional<String> id = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(ImageComponent other) {
            id(other.getId());
            url(other.getUrl());
            align(other.getAlign());
            width(other.getWidth());
            height(other.getHeight());
            rounded(other.getRounded());
            bottomMargin(other.getBottomMargin());
            action(other.getAction());
            return this;
        }

        /**
         * <p>The URL where the image is located.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("url")
        public WidthStage url(@NotNull String url) {
            this.url = Objects.requireNonNull(url, "url must not be null");
            return this;
        }

        /**
         * <p>The exact width of the image in pixels.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("width")
        public HeightStage width(int width) {
            this.width = width;
            return this;
        }

        /**
         * <p>The exact height of the image in pixels.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("height")
        public _FinalStage height(int height) {
            this.height = height;
            return this;
        }

        /**
         * <p>This can be a URL Action only.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage action(UrlActionComponent action) {
            this.action = Optional.ofNullable(action);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "action", nulls = Nulls.SKIP)
        public _FinalStage action(Optional<UrlActionComponent> action) {
            this.action = action;
            return this;
        }

        /**
         * <p>Disables a component's margin-bottom of 10px.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage bottomMargin(String bottomMargin) {
            this.bottomMargin = Optional.ofNullable(bottomMargin);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "bottom_margin", nulls = Nulls.SKIP)
        public _FinalStage bottomMargin(Optional<String> bottomMargin) {
            this.bottomMargin = bottomMargin;
            return this;
        }

        /**
         * <p>Rounds the corners of the image. Default is <code>false</code>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage rounded(Boolean rounded) {
            this.rounded = Optional.ofNullable(rounded);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "rounded", nulls = Nulls.SKIP)
        public _FinalStage rounded(Optional<Boolean> rounded) {
            this.rounded = rounded;
            return this;
        }

        /**
         * <p>Aligns the image inside the component. Default is <code>left</code>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage align(Align align) {
            this.align = Optional.ofNullable(align);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "align", nulls = Nulls.SKIP)
        public _FinalStage align(Optional<Align> align) {
            this.align = align;
            return this;
        }

        /**
         * <p>A unique identifier for the component.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage id(String id) {
            this.id = Optional.ofNullable(id);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "id", nulls = Nulls.SKIP)
        public _FinalStage id(Optional<String> id) {
            this.id = id;
            return this;
        }

        @java.lang.Override
        public ImageComponent build() {
            return new ImageComponent(
                    id, url, align, width, height, rounded, bottomMargin, action, additionalProperties);
        }
    }

    public final class Align {
        public static final Align LEFT = new Align(Value.LEFT, "left");

        public static final Align RIGHT = new Align(Value.RIGHT, "right");

        public static final Align CENTER = new Align(Value.CENTER, "center");

        public static final Align FULL_WIDTH = new Align(Value.FULL_WIDTH, "full_width");

        private final Value value;

        private final String string;

        Align(Value value, String string) {
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
            return (this == other) || (other instanceof Align && this.string.equals(((Align) other).string));
        }

        @java.lang.Override
        public int hashCode() {
            return this.string.hashCode();
        }

        public <T> T visit(Visitor<T> visitor) {
            switch (value) {
                case LEFT:
                    return visitor.visitLeft();
                case RIGHT:
                    return visitor.visitRight();
                case CENTER:
                    return visitor.visitCenter();
                case FULL_WIDTH:
                    return visitor.visitFullWidth();
                case UNKNOWN:
                default:
                    return visitor.visitUnknown(string);
            }
        }

        @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
        public static Align valueOf(String value) {
            switch (value) {
                case "left":
                    return LEFT;
                case "right":
                    return RIGHT;
                case "center":
                    return CENTER;
                case "full_width":
                    return FULL_WIDTH;
                default:
                    return new Align(Value.UNKNOWN, value);
            }
        }

        public enum Value {
            LEFT,

            CENTER,

            RIGHT,

            FULL_WIDTH,

            UNKNOWN
        }

        public interface Visitor<T> {
            T visitLeft();

            T visitCenter();

            T visitRight();

            T visitFullWidth();

            T visitUnknown(String unknownType);
        }
    }
}
