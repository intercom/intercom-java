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
@JsonDeserialize(builder = CurrentCanvas.Builder.class)
public final class CurrentCanvas {
    private final CanvasObject currentCanvas;

    private final Map<String, Object> additionalProperties;

    private CurrentCanvas(CanvasObject currentCanvas, Map<String, Object> additionalProperties) {
        this.currentCanvas = currentCanvas;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The canvas object representing the current canvas state.
     */
    @JsonProperty("current_canvas")
    public CanvasObject getCurrentCanvas() {
        return currentCanvas;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CurrentCanvas && equalTo((CurrentCanvas) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CurrentCanvas other) {
        return currentCanvas.equals(other.currentCanvas);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.currentCanvas);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static CurrentCanvasStage builder() {
        return new Builder();
    }

    public interface CurrentCanvasStage {
        _FinalStage currentCanvas(@NotNull CanvasObject currentCanvas);

        Builder from(CurrentCanvas other);
    }

    public interface _FinalStage {
        CurrentCanvas build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements CurrentCanvasStage, _FinalStage {
        private CanvasObject currentCanvas;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(CurrentCanvas other) {
            currentCanvas(other.getCurrentCanvas());
            return this;
        }

        /**
         * <p>The canvas object representing the current canvas state.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("current_canvas")
        public _FinalStage currentCanvas(@NotNull CanvasObject currentCanvas) {
            this.currentCanvas = Objects.requireNonNull(currentCanvas, "currentCanvas must not be null");
            return this;
        }

        @java.lang.Override
        public CurrentCanvas build() {
            return new CurrentCanvas(currentCanvas, additionalProperties);
        }
    }
}
