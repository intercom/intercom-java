package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;

import java.util.List;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
public final class ErrorCollection {

    @JsonProperty("errors")
    private List<Error> errors;

    // for jackson
    ErrorCollection() {
    }

    public ErrorCollection(List<Error> errors) {
        Preconditions.checkNotNull(errors, "cannot create an error collection with a null error list");
        Preconditions.checkArgument(errors.size() > 0, "cannot create an error collection with an empty error list");
        this.errors = errors;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public String getType() {
        return "error.list";
    }
}
