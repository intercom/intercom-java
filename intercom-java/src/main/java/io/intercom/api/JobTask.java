package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class JobTask extends TypedData {

    @JsonProperty("type")
    private final String type = "job_task";

    @JsonProperty("id")
    private String id;

    @JsonProperty("completed_at")
    private Long completedAt;

    @JsonProperty("created_at")
    private long createdAt;

    @JsonProperty("item_count")
    private long itemCount;

    @Override
    public String getType() {
        return type;
    }

    public String getID() {
        return id;
    }

    public Long getCompletedAt() {
        return completedAt;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public long getItemCount() {
        return itemCount;
    }
}
