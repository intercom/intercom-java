package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConversationPart extends TypedData {

    @JsonProperty("type")
    private final String type = "conversation_part";

    @JsonProperty
    private String id;

    @JsonProperty("part_type")
    private String partType;

    @JsonProperty
    private String body;

    @JsonProperty
    private Author author;

    @JsonProperty("assigned_to")
    private Admin assignedTo;

    @JsonProperty("created_at")
    private long createdAt;

    @JsonProperty("updated_at")
    private long updatedAt;

    @JsonProperty("notified_at")
    private long NotifiedAt;

    public ConversationPart() {
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public String getPartType() {
        return partType;
    }

    public String getBody() {
        return body;
    }

    public Author getAuthor() {
        return author;
    }

    public Admin getAssignedTo() {
        return assignedTo;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public long getNotifiedAt() {
        return NotifiedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConversationPart that = (ConversationPart) o;

        if (NotifiedAt != that.NotifiedAt) return false;
        if (createdAt != that.createdAt) return false;
        if (updatedAt != that.updatedAt) return false;
        if (assignedTo != null ? !assignedTo.equals(that.assignedTo) : that.assignedTo != null) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        if (body != null ? !body.equals(that.body) : that.body != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (partType != null ? !partType.equals(that.partType) : that.partType != null) return false;
        //noinspection RedundantIfStatement
        if (!type.equals(that.type)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (partType != null ? partType.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (assignedTo != null ? assignedTo.hashCode() : 0);
        result = 31 * result + (int) (createdAt ^ (createdAt >>> 32));
        result = 31 * result + (int) (updatedAt ^ (updatedAt >>> 32));
        result = 31 * result + (int) (NotifiedAt ^ (NotifiedAt >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "ConversationPart{" +
            "type='" + type + '\'' +
            ", id='" + id + '\'' +
            ", partType='" + partType + '\'' +
            ", body='" + body + '\'' +
            ", author=" + author +
            ", assignedTo=" + assignedTo +
            ", createdAt=" + createdAt +
            ", updatedAt=" + updatedAt +
            ", NotifiedAt=" + NotifiedAt +
            "} " + super.toString();
    }
}
