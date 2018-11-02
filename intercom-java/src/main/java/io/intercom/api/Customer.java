package io.intercom.api;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Customer extends TypedData {

    @JsonProperty("type")
    private String type;

    @JsonProperty("id")
    private String id;

    public Customer() {
    }

    public String getType() {
        return type;
    }

    public Customer setType(String type) {
        this.type = type;
        return this;
    }

    public String getId() {
        return id;
    }

    public Customer setId(String id) {
        this.id = id;
        return this;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (id != null ? !id.equals(customer.id) : customer.id != null) return false;
        if (type != null ? !type.equals(customer.type) : customer.type != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "Customer{" +
            "type='" + type + '\'' +
            ", id='" + id+ '\'' +
            "} " + super.toString();
    }

}
