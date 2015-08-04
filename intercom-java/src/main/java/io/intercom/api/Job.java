package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.google.common.collect.Maps;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Job extends TypedData {

    private static final HashMap<String, String> SENTINEL = Maps.newHashMap();

    public static Job find(String id)
        throws AuthorizationException, ClientException, ServerException, InvalidException, RateLimitException {
        return find(id, SENTINEL);
    }

    public static Job find(String id, Map<String, String> params)
        throws AuthorizationException, ClientException, ServerException, InvalidException, RateLimitException {
        return new HttpClient(
            UriBuilder.newBuilder().path("jobs").path(id).query(params).build()
        ).get(Job.class);
    }

    public static Job update(Job job)
        throws AuthorizationException, ClientException, ServerException, InvalidException, RateLimitException {
        return DataResource.post(
            job,
            UriBuilder.newBuilder().path("jobs").path(job.getID()).build(),
            Job.class);
    }

    static <T extends TypedData> Job submit(List<JobItem<T>> items, List<String> bulkPaths)
        throws AuthorizationException, ClientException, ServerException, InvalidException, RateLimitException {
        return submit(items, null, bulkPaths);
    }

    static <T extends TypedData> Job submit(List<JobItem<T>> items, Job job, List<String> bulkPaths)
        throws AuthorizationException, ClientException, ServerException, InvalidException, RateLimitException {
        return DataResource.create(new JobItemRequest<T>(items, job), bulkPaths, Job.class);
    }

    static <T extends TypedData> JobItemCollection<T> listJobErrorFeed(String jobID, Class<T> c)
        throws AuthorizationException, ClientException, ServerException, InvalidException, RateLimitException {
        final URI feedURI = UriBuilder.newBuilder()
            .path("jobs")
            .path(jobID)
            .path("error")
            .build();
        final HttpClient resource = new HttpClient(feedURI);
        final TypeReference<JobItemCollection<T>> typeReference =
            new TypeReference<JobItemCollection<T>>() {
            };

        final JavaType type = MapperSupport
            .objectMapper()
            .getTypeFactory()
            .constructParametricType(JobItemCollection.class, c);
        return resource.get(type);
    }


    @JsonProperty("type")
    private final String type = "job";

    @JsonProperty("id")
    private String id;

    @JsonProperty("app_id")
    private String appID;

    @JsonProperty("created_at")
    private long createdAt;

    @JsonProperty("updated_at")
    private long updatedAt;

    @JsonProperty("completed_at")
    private long completedAt;

    @JsonProperty("closing_at")
    private long closingAt;

    @JsonProperty("name")
    private String name;

    @JsonProperty("state")
    private String state;

    @JsonProperty("tasks")
    private List<JobTask> tasks;

    @JsonProperty("links")
    private Map<String, URI> links;

    public Job() {
    }

    public String getType() {
        return type;
    }

    public String getID() {
        return id;
    }

    public Job setID(String id) {
        this.id = id;
        return this;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public long getCompletedAt() {
        return completedAt;
    }

    public String getName() {
        return name;
    }

    public Job setName(String name) {
        this.name = name;
        return this;
    }

    public String getState() {
        return state;
    }

    public String getAppID() {
        return appID;
    }

    public Map<String, URI> getLinks() {
        return links;
    }

    public long getClosingAt() {
        return closingAt;
    }

    public Job setClosingAt(long closingAt) {
        this.closingAt = closingAt;
        return this;
    }

    public List<JobTask> getTasks() {
        return tasks;
    }

    @Override
    public String toString() {
        return "Job{" +
            "type='" + type + '\'' +
            ", id='" + id + '\'' +
            ", appID='" + appID + '\'' +
            ", createdAt=" + createdAt +
            ", updatedAt=" + updatedAt +
            ", completedAt=" + completedAt +
            ", name='" + name + '\'' +
            ", state='" + state + '\'' +
            ", links=" + links +
            "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Job job = (Job) o;

        if (createdAt != job.createdAt) return false;
        if (updatedAt != job.updatedAt) return false;
        if (completedAt != job.completedAt) return false;
        //noinspection ConstantConditions
        if (type != null ? !type.equals(job.type) : job.type != null) return false;
        if (id != null ? !id.equals(job.id) : job.id != null) return false;
        if (appID != null ? !appID.equals(job.appID) : job.appID != null) return false;
        if (name != null ? !name.equals(job.name) : job.name != null) return false;
        //noinspection SimplifiableIfStatement
        if (state != null ? !state.equals(job.state) : job.state != null) return false;
        return !(links != null ? !links.equals(job.links) : job.links != null);

    }

    @Override
    public int hashCode() {
        @SuppressWarnings("ConstantConditions") int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (appID != null ? appID.hashCode() : 0);
        result = 31 * result + (int) (createdAt ^ (createdAt >>> 32));
        result = 31 * result + (int) (updatedAt ^ (updatedAt >>> 32));
        result = 31 * result + (int) (completedAt ^ (completedAt >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (links != null ? links.hashCode() : 0);
        return result;
    }
}
