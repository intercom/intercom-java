package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
class JobItemRequest<T extends TypedData> extends TypedData {

    @JsonProperty("items")
    private List<JobItem<T>> items;

    @JsonProperty("job")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Job job;

    public JobItemRequest(List<JobItem<T>> items, Job job) {
        this.items = items;
        this.job = job;
    }

    public List<JobItem<T>> getItems() {
        return items;
    }

    public Job getJob() {
        return job;
    }

    @Override
    String getType() {
        return "job_item.list";
    }
}
