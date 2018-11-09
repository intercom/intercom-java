package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class EventSummary {

    @JsonProperty("name")
    private String name;

    @JsonProperty("first")
    private String first;

    @JsonProperty("last")
    private String last;

    @JsonProperty("count")
    private int count;

    @JsonProperty("description")
    private String description;

    public EventSummary() {
    }

    public String getName() {
        return name;
    }

    public String getFirstOccurredAtString() {
        return first;
    }

    public Date getFirstOccurredAt() throws ParseException {
        return stringToDate(first);
    }

    public String getLastOccurredAtString() {
        return last;
    }

    public Date getLastOccurredAt() throws ParseException {
        return stringToDate(last);
    }

    public int getCount() {
        return count;
    }

    public String getDescription() {
        return description;
    }

    private Date stringToDate(String dateString) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX").parse(dateString);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventSummary eventSummary = (EventSummary) o;

        if (name != null ? !name.equals(eventSummary.name) : eventSummary.name != null) return false;
        if (first != null ? !first.equals(eventSummary.first) : eventSummary.first != null) return false;
        if (last != null ? !last.equals(eventSummary.last) : eventSummary.last != null) return false;
        if (count != eventSummary.count) return false;
        if (description != null ? !description.equals(eventSummary.description) : eventSummary.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (name!= null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (first != null ? first.hashCode() : 0);
        result = 31 * result + (last != null ? last.hashCode() : 0);
        result = 31 * result + count;
        return result;
    }
    @Override
    public String toString() {
        return "EventSummaryCollection{" +
            "name='" + name+ '\'' +
            ", count=" + count +
            ", description='" + description + '\'' +
            ", first='" + first + '\'' +
            ", last='" + last + '\'' +
            "} " + super.toString();
    }
}
