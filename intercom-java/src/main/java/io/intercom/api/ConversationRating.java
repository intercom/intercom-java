package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConversationRating extends TypedData {

    @JsonProperty
    private int rating;

    @JsonProperty
    private String remark;

    @JsonProperty("created_at")
    private long createdAt;

    @JsonProperty
    private Customer customer;

    @JsonProperty
    private Teammate teammate;

    public ConversationRating() {
    }

    public int getRating() {
        return rating;
    }

    public String getRemark() {
        return remark;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Teammate getTeammate() {
        return teammate;
    }

    @Override
    public int hashCode() {
        int result = remark != null ? remark.hashCode() : 0;
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (teammate != null ? teammate.hashCode() : 0);
        result = 31 * result + (int) (createdAt ^ (createdAt >>> 32));
        result = 31 * result + rating;

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConversationRating that = (ConversationRating) o;

        if (customer != null ? !customer.equals(that.customer) : that.customer != null) return false;
        if (teammate != null ? !teammate.equals(that.teammate) : that.teammate != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (createdAt != that.createdAt) return false;
        if (rating != that.rating) return false;

        return true;
    }

    @Override
    public String toString() {
        return "ConversationRating{" +
            "rating='" + rating + '\'' +
            ", remark='" + remark + '\'' +
            ", created_at='" + createdAt + '\'' +
            ", customer=" + customer +
            ", teammate=" + teammate +
            "} " + super.toString();
    }
}
