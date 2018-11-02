package io.intercom.api;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Teammate extends TypedData {

    @JsonProperty("type")
    private String type;

    @JsonProperty("id")
    private String id;

    public Teammate() {
    }

    public String getType() {
        return type;
    }

    public Teammate setType(String type) {
        this.type = type;
        return this;
    }

    public String getId() {
        return id;
    }

    public Teammate setId(String id) {
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

        Teammate teammate = (Teammate) o;

        if (id != null ? !id.equals(teammate.id) : teammate.id != null) return false;
        if (type != null ? !type.equals(teammate.type) : teammate.type != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "Teammate{" +
            "type='" + type + '\'' +
            ", id='" + id+ '\'' +
            "} " + super.toString();
    }

}
