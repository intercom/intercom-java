package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserPermanentDeleteRequest {

    @JsonProperty("intercom_user_id")
    private String intercomUserId;

    public UserPermanentDeleteRequest() {
    }

    public UserPermanentDeleteRequest(String intercomUserId) {
        this.setIntercomUserId(intercomUserId);
    }

    public String getIntercomUserId() {
        return intercomUserId;
    }

    public UserPermanentDeleteRequest setIntercomUserId(String intercomUserId) {
        this.intercomUserId = intercomUserId;
        return this;
    }

    @Override
    public String toString() {
        return "UserPermanentlyDeleteResponse{" +
                "intercomUserId='" + intercomUserId + '\'' +
                "} " + super.toString();
    }
}
