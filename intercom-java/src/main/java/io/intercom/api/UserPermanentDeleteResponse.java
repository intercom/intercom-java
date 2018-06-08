package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserPermanentDeleteResponse {

    @JsonProperty("id")
    private String id;

    public UserPermanentDeleteResponse() {
    }

    public String getId() {
        return id;
    }

    public UserPermanentDeleteResponse setId(String id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "UserPermanentDeleteResponse{" +
                "id='" + id + '\'' +
                "} " + super.toString();
    }
}
