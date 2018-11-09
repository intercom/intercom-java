package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class EventSummaryCollection extends TypedData {

  @JsonProperty("type")
  private final String type = "event.summary";

  @JsonProperty("email")
  private String email;

  @JsonProperty("user_id")
  private String userID;

  @JsonProperty("intercom_user_id")
  private String intercomUserID;

  @JsonProperty("events")
  private List<EventSummary> eventSummaries;

  public EventSummaryCollection() {
  }

  public String getType() {
    return type;
  }

  public String getEmail() {
    return email;
  }

  public String getUserID() {
    return userID;
  }

  public String getIntercomUserID() {
    return intercomUserID ;
  }

  public List<EventSummary> getEventSummaries() {
    return eventSummaries;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    EventSummaryCollection eventSummaryCollection = (EventSummaryCollection) o;

    if (email != null ? !email.equals(eventSummaryCollection.email) : eventSummaryCollection.email != null) return false;
    if (userID != null ? !userID.equals(eventSummaryCollection.userID) : eventSummaryCollection.userID != null) return false;
    if (intercomUserID!= null ? !intercomUserID.equals(eventSummaryCollection.intercomUserID) : eventSummaryCollection.intercomUserID != null) return false;
    if (eventSummaries!= null ? !eventSummaries.equals(eventSummaryCollection.eventSummaries) : eventSummaryCollection.eventSummaries != null) return false;
    if (!type.equals(eventSummaryCollection.type)) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = type.hashCode();
    result = 31 * result + (email != null ? email.hashCode() : 0);
    result = 31 * result + (userID != null ? userID.hashCode() : 0);
    result = 31 * result + (intercomUserID != null ? intercomUserID.hashCode() : 0);
    result = 31 * result + (eventSummaries != null ? eventSummaries.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Event{" +
            "type='" + type + '\'' +
            ", email='" + email + '\'' +
            ", userID='" + userID + '\'' +
            ", intercomUserID='" + intercomUserID + '\'' +
            ", eventSummaries=" + eventSummaries +
            "} " + super.toString();
  }
}
