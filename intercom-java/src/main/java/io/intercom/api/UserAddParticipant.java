package io.intercom.api;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserAddParticipant  {

    @JsonProperty("intercom_user_id")
    public String intercomUserId;

    @JsonProperty("user_id")
    public String userId;

    @JsonProperty("email")
    public String email;

    @JsonProperty("customer")
    private Participant participant;

    public String getIntercomUserId() {
        return intercomUserId;
    }

    public UserAddParticipant setIntercomUserId(String intercomUserId) {
        this.intercomUserId = intercomUserId;
        return this;
    }

    public String getUserID() {
        return userId;
    }

    public UserAddParticipant setUserID(String userId) {
        this.userId = userId;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserAddParticipant setEmail(String email) {
        this.email = email;
        return this;
    }

    private Participant getParticipant(){
        return participant;
    }

    public UserAddParticipant setParticipant(Participant participant){
        this.participant = participant;
        return this;
    }

    @Override
    public String toString() {
        return "UserAddParticipant{" +
                "intercomUserId='" + intercomUserId + "\'" +
                "userId='" + userId + "\'" +
                "email='" + email + "\'" +
                ",participant=" + participant +
                "} " + super.toString();
    }
}
