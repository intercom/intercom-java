package io.intercom.api;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ParticipantResponse {

    @JsonProperty("customers")
    private List<Customer> customers;

    public ParticipantResponse() {
    }

    public List<Customer> getCustomers(){
        return customers;
    }
}
