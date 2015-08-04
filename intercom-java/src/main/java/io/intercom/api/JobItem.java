package io.intercom.api;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class JobItem<T extends TypedData> extends TypedData {

    @JsonProperty("type")
    private final String type = "job_item";

    @JsonProperty("id")
    private String id;

    @JsonProperty("updated_at")
    private long updatedAt;

    @JsonProperty("method")
    private String method;

    @JsonProperty("data_type")
    private String dataType;

    @JsonProperty("error")
    private Error error;

    @JsonProperty("data")
    private T data;

    public JobItem() {
    }

    public JobItem(String method, T data) {
        checkNotNull(method, data);
        this.method = method;
        this.data = data;
        this.dataType = data.getType();
    }

    private void checkNotNull(String method, T data) {
        Conditions.checkNotNull(method, "item method must be supplied");
        Conditions.checkNotNull(data, "item data must be supplied");
    }

    public String getType() {
        return type;
    }

    public String getID() {
        return id;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public String getMethod() {
        return method;
    }

    public JobItem<T> setMethod(String method) {
        this.method = method;
        return this;
    }

    public Error getError() {
        return error;
    }

    public T getData() {
        return data;
    }

    public JobItem<T> setData(T data) {
        this.data = data;
        return this;
    }

    public String getDataType() {
        return dataType;
    }

    @Override
    public String toString() {
        return "JobItem{" +
            "type='" + type + '\'' +
            ", id='" + id + '\'' +
            ", updatedAt=" + updatedAt +
            ", method='" + method + '\'' +
            ", dataType='" + dataType + '\'' +
            ", error=" + error +
            ", data=" + data +
            "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JobItem<?> jobItem = (JobItem<?>) o;

        if (updatedAt != jobItem.updatedAt) return false;
        //noinspection ConstantConditions
        if (type != null ? !type.equals(jobItem.type) : jobItem.type != null) return false;
        if (id != null ? !id.equals(jobItem.id) : jobItem.id != null) return false;
        if (method != null ? !method.equals(jobItem.method) : jobItem.method != null) return false;
        if (dataType != null ? !dataType.equals(jobItem.dataType) : jobItem.dataType != null) return false;
        //noinspection SimplifiableIfStatement
        if (error != null ? !error.equals(jobItem.error) : jobItem.error != null) return false;
        return !(data != null ? !data.equals(jobItem.data) : jobItem.data != null);

    }

    @Override
    public int hashCode() {
        @SuppressWarnings("ConstantConditions") int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (int) (updatedAt ^ (updatedAt >>> 32));
        result = 31 * result + (method != null ? method.hashCode() : 0);
        result = 31 * result + (dataType != null ? dataType.hashCode() : 0);
        result = 31 * result + (error != null ? error.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }
}
