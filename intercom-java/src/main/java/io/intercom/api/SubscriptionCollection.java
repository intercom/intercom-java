package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SubscriptionCollection extends TypedDataCollection<Subscription> {

    public SubscriptionCollection() {
    }

    @Override
    public SubscriptionCollection nextPage() {
        return fetchNextPage(SubscriptionCollection.class);
    }

    @SuppressWarnings("EmptyMethod")
    @JsonProperty("items")
    @Override
    public List<Subscription> getPage() {
        return super.getPage();
    }

    @Override
    public String toString() {
        return "SubscriptionCollection{" +
                "} " + super.toString();
    }
}
