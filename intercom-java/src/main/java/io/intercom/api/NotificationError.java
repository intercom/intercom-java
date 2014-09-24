package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class NotificationError extends Notification {

    @JsonProperty("http_request")
    private RequestResponseCapture capture;

    public RequestResponseCapture getCapture() {
        return capture;
    }

    public void setCapture(RequestResponseCapture capture) {
        this.capture = capture;
    }

    @Override
    public String toString() {
        return "NotificationError{" +
            "capture=" + capture +
            "} " + super.toString();
    }
}
