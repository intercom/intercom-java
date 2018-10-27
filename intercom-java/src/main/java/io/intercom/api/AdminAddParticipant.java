package io.intercom.api;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AdminAddParticipant {

    @JsonProperty("admin_id")
    public String adminId;

    @JsonProperty("customer")
    private Participant participant;

    public String getAdminId() {
        return adminId;
    }

    public AdminAddParticipant setAdminId(String adminId) {
        this.adminId = adminId;
        return this;
    }

    private Participant getParticipant(){
        return participant;
    }

    public AdminAddParticipant setParticipant(Participant participant){
        this.participant = participant;
        return this;
    }

    @Override
    public String toString() {
        return "AdminAddParticipant{" +
                "adminId='" + adminId + "\'" +
                ",participant=" + participant +
                "} " + super.toString();
    }
}
