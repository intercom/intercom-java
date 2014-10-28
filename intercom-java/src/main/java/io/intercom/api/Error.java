package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Error extends TypedData {

    @SuppressWarnings("FieldCanBeLocal")
    @JsonProperty("type")
    private final String type = "error";

    @JsonProperty("code")
    private String code;

    @JsonProperty("message")
    private String message;

    public Error() {
    }

    public Error(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Error error = (Error) o;

        if (code != null ? !code.equals(error.code) : error.code != null) return false;
        //noinspection RedundantIfStatement
        if (message != null ? !message.equals(error.message) : error.message != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return getType() + "{" +
            "code='" + code + '\'' +
            ", message='" + message + '\'' +
            "} " + super.toString();
    }

}
