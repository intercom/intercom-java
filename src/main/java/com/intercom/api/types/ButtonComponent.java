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
@JsonDeserialize(builder = ButtonComponent.Builder.class)
public final class ButtonComponent {
    private final String id;

    private final String label;

    private final ActionComponent action;

    private final Optional<Style> style;

    private final Optional<Boolean> disabled;

    private final Map<String, Object> additionalProperties;

    private ButtonComponent(
            String id,
            String label,
            ActionComponent action,
            Optional<Style> style,
            Optional<Boolean> disabled,
            Map<String, Object> additionalProperties) {
        this.id = id;
        this.label = label;
        this.action = action;
        this.style = style;
        this.disabled = disabled;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return A unique identifier for the component.
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * @return The text that will be rendered inside the button.
     */
    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    /**
     * @return This can be a Submit Action, URL Action, or Sheets Action.
     */
    @JsonProperty("action")
    public ActionComponent getAction() {
        return action;
    }

    /**
     * @return Styles the button. Default is 'primary'.
     */
    @JsonProperty("style")
    public Optional<Style> getStyle() {
        return style;
    }

    /**
     * @return Styles the button and prevents the action. Default is false.
     */
    @JsonProperty("disabled")
    public Optional<Boolean> getDisabled() {
        return disabled;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ButtonComponent && equalTo((ButtonComponent) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ButtonComponent other) {
        return id.equals(other.id)
                && label.equals(other.label)
                && action.equals(other.action)
                && style.equals(other.style)
                && disabled.equals(other.disabled);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.id, this.label, this.action, this.style, this.disabled);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IdStage builder() {
        return new Builder();
    }

    public interface IdStage {
        LabelStage id(@NotNull String id);

        Builder from(ButtonComponent other);
    }

    public interface LabelStage {
        ActionStage label(@NotNull String label);
    }

    public interface ActionStage {
        _FinalStage action(@NotNull ActionComponent action);
    }

    public interface _FinalStage {
        ButtonComponent build();

        _FinalStage style(Optional<Style> style);

        _FinalStage style(Style style);

        _FinalStage disabled(Optional<Boolean> disabled);

        _FinalStage disabled(Boolean disabled);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements IdStage, LabelStage, ActionStage, _FinalStage {
        private String id;

        private String label;

        private ActionComponent action;

        private Optional<Boolean> disabled = Optional.empty();

        private Optional<Style> style = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(ButtonComponent other) {
            id(other.getId());
            label(other.getLabel());
            action(other.getAction());
            style(other.getStyle());
            disabled(other.getDisabled());
            return this;
        }

        /**
         * <p>A unique identifier for the component.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("id")
        public LabelStage id(@NotNull String id) {
            this.id = Objects.requireNonNull(id, "id must not be null");
            return this;
        }

        /**
         * <p>The text that will be rendered inside the button.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("label")
        public ActionStage label(@NotNull String label) {
            this.label = Objects.requireNonNull(label, "label must not be null");
            return this;
        }

        /**
         * <p>This can be a Submit Action, URL Action, or Sheets Action.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("action")
        public _FinalStage action(@NotNull ActionComponent action) {
            this.action = Objects.requireNonNull(action, "action must not be null");
            return this;
        }

        /**
         * <p>Styles the button and prevents the action. Default is false.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage disabled(Boolean disabled) {
            this.disabled = Optional.ofNullable(disabled);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "disabled", nulls = Nulls.SKIP)
        public _FinalStage disabled(Optional<Boolean> disabled) {
            this.disabled = disabled;
            return this;
        }

        /**
         * <p>Styles the button. Default is 'primary'.</p>
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

        @java.lang.Override
        public ButtonComponent build() {
            return new ButtonComponent(id, label, action, style, disabled, additionalProperties);
        }
    }

    public static final class Style {
        public static final Style SECONDARY = new Style(Value.SECONDARY, "secondary");

        public static final Style LINK = new Style(Value.LINK, "link");

        public static final Style PRIMARY = new Style(Value.PRIMARY, "primary");

        private final Value value;

        private final String string;

        Style(Value value, String string) {
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
            return (this == other) || (other instanceof Style && this.string.equals(((Style) other).string));
        }

        @java.lang.Override
        public int hashCode() {
            return this.string.hashCode();
        }

        public <T> T visit(Visitor<T> visitor) {
            switch (value) {
                case SECONDARY:
                    return visitor.visitSecondary();
                case LINK:
                    return visitor.visitLink();
                case PRIMARY:
                    return visitor.visitPrimary();
                case UNKNOWN:
                default:
                    return visitor.visitUnknown(string);
            }
        }

        @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
        public static Style valueOf(String value) {
            switch (value) {
                case "secondary":
                    return SECONDARY;
                case "link":
                    return LINK;
                case "primary":
                    return PRIMARY;
                default:
                    return new Style(Value.UNKNOWN, value);
            }
        }

        public enum Value {
            PRIMARY,

            SECONDARY,

            LINK,

            UNKNOWN
        }

        public interface Visitor<T> {
            T visitPrimary();

            T visitSecondary();

            T visitLink();

            T visitUnknown(String unknownType);
        }
    }
}
