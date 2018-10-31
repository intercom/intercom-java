package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SegmentCollection extends TypedDataCollection<Segment> {

    public SegmentCollection() {
        type = "segment.list";
    }

    @Override
    public SegmentCollection nextPage() {
        return fetchNextPage(SegmentCollection.class);
    }

    @SuppressWarnings("EmptyMethod")
    @JsonProperty("segments")
    @Override
    public List<Segment> getPage() {
        return super.getPage();
    }

    @Override
    public String toString() {
        return "SegmentCollection{" +
                "} " + super.toString();
    }
}
