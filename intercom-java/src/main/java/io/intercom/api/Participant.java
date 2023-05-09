package io.intercom.api;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Participant {

    @JsonProperty("intercom_user_id")
    private String intercomUserId;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("email")
    private String email;

    public Participant() {
    }

    public String getIntercomUserId() {
        return intercomUserId;
    }

    public Participant setIntercomUserId(String intercomUserId) {
        this.intercomUserId = intercomUserId;;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public Participant setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Participant setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public int hashCode() {
        int result = intercomUserId != null ? intercomUserId.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Participant customer = (Participant) o;

        if (intercomUserId != null ? !intercomUserId.equals(customer.intercomUserId) : customer.intercomUserId != null) return false;
        if (userId != null ? !userId.equals(customer.userId) : customer.userId != null) return false;
        if (email != null ? !email.equals(customer.email) : customer.email != null) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Participant{" +
                ", intercomUserId='" + intercomUserId+ '\'' +
                ", userId='" + userId+ '\'' +
                ", email='" + email+ '\'' +
                "} " + super.toString();
    }
}
