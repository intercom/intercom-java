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
@JsonDeserialize(builder = TextComponent.Builder.class)
public final class TextComponent {
    private final Optional<String> id;

    private final String text;

    private final Optional<Align> align;

    private final Optional<Style> style;

    private final Optional<String> bottomMargin;

    private final Map<String, Object> additionalProperties;

    private TextComponent(
            Optional<String> id,
            String text,
            Optional<Align> align,
            Optional<Style> style,
            Optional<String> bottomMargin,
            Map<String, Object> additionalProperties) {
        this.id = id;
        this.text = text;
        this.align = align;
        this.style = style;
        this.bottomMargin = bottomMargin;
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
     * @return The text that will be rendered.
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /**
     * @return Aligns the text. Default is <code>left</code>.
     */
    @JsonProperty("align")
    public Optional<Align> getAlign() {
        return align;
    }

    /**
     * @return Styles the text. Default is <code>paragraph</code>.
     */
    @JsonProperty("style")
    public Optional<Style> getStyle() {
        return style;
    }

    /**
     * @return Disables a component's margin-bottom of 10px.
     */
    @JsonProperty("bottom_margin")
    public Optional<String> getBottomMargin() {
        return bottomMargin;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TextComponent && equalTo((TextComponent) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(TextComponent other) {
        return id.equals(other.id)
                && text.equals(other.text)
                && align.equals(other.align)
                && style.equals(other.style)
                && bottomMargin.equals(other.bottomMargin);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.id, this.text, this.align, this.style, this.bottomMargin);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static TextStage builder() {
        return new Builder();
    }

    public interface TextStage {
        _FinalStage text(@NotNull String text);

        Builder from(TextComponent other);
    }

    public interface _FinalStage {
        TextComponent build();

        _FinalStage id(Optional<String> id);

        _FinalStage id(String id);

        _FinalStage align(Optional<Align> align);

        _FinalStage align(Align align);

        _FinalStage style(Optional<Style> style);

        _FinalStage style(Style style);

        _FinalStage bottomMargin(Optional<String> bottomMargin);

        _FinalStage bottomMargin(String bottomMargin);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements TextStage, _FinalStage {
        private String text;

        private Optional<String> bottomMargin = Optional.empty();

        private Optional<Style> style = Optional.empty();

        private Optional<Align> align = Optional.empty();

        private Optional<String> id = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(TextComponent other) {
            id(other.getId());
            text(other.getText());
            align(other.getAlign());
            style(other.getStyle());
            bottomMargin(other.getBottomMargin());
            return this;
        }

        /**
         * <p>The text that will be rendered.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("text")
        public _FinalStage text(@NotNull String text) {
            this.text = Objects.requireNonNull(text, "text must not be null");
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
         * <p>Styles the text. Default is <code>paragraph</code>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage style(Style style) {
            this.style = Optional.ofNullable(style);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "style", nulls = Nulls.SKIP)
        public _FinalStage style(Optional<Style> style) {
            this.style = style;
            return this;
        }

        /**
         * <p>Aligns the text. Default is <code>left</code>.</p>
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
        public TextComponent build() {
            return new TextComponent(id, text, align, style, bottomMargin, additionalProperties);
        }
    }

    public enum Style {
        HEADER("header"),

        PARAGRAPH("paragraph"),

        MUTED("muted"),

        ERROR("error");

        private final String value;

        Style(String value) {
            this.value = value;
        }

        @JsonValue
        @java.lang.Override
        public String toString() {
            return this.value;
        }
    }

    public enum Align {
        LEFT("left"),

        CENTER("center"),

        RIGHT("right");

        private final String value;

        Align(String value) {
            this.value = value;
        }

        @JsonValue
        @java.lang.Override
        public String toString() {
            return this.value;
        }
    }
}
