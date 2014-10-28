package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Note extends TypedData {

    private static final HashMap<String, String> SENTINEL = Maps.newHashMap();

    public static Note find(String id) throws InvalidException, AuthorizationException {
        return DataResource.find(id, "notes", Note.class);
    }

    public static Note create(Note note) throws InvalidException, AuthorizationException {
        return DataResource.create(note, "notes", Note.class);
    }

    public static NoteCollection list(Map<String, String> params) throws InvalidException, AuthorizationException {
        if ((!params.containsKey("email")) && (!params.containsKey("id")) && (!params.containsKey("user_id")) && (!params.containsKey("intercom_user_id"))) {
            throw new InvalidException("a notes query must include an email, user_id or intercom_user_id parameter");
        }
        return DataResource.list(params, "notes", NoteCollection.class);
    }

    @JsonProperty("type")
    private final String type = "note";

    @JsonProperty("id")
    private String id;

    @JsonProperty("body")
    private String body;

    @JsonProperty("created_at")
    private long createdAt;

    @JsonProperty("user")
    private User user;

    @JsonProperty("author")
    private Author author;

    public Note() {
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public Note setBody(String body) {
        this.body = body;
        return this;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public User getUser() {
        return user;
    }

    public Note setUser(User user) {
        this.user = user;
        return this;
    }

    public Author getAuthor() {
        return author;
    }

    public Note setAuthor(Author author) {
        this.author = author;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Note note = (Note) o;

        if (createdAt != note.createdAt) return false;
        if (author != null ? !author.equals(note.author) : note.author != null) return false;
        if (body != null ? !body.equals(note.body) : note.body != null) return false;
        if (id != null ? !id.equals(note.id) : note.id != null) return false;
        if (!type.equals(note.type)) return false;
        //noinspection RedundantIfStatement
        if (user != null ? !user.equals(note.user) : note.user != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (int) (createdAt ^ (createdAt >>> 32));
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Note{" +
            "id='" + id + '\'' +
            ", body='" + body + '\'' +
            ", createdAt=" + createdAt +
            ", user=" + user +
            ", author=" + author +
            "} " + super.toString();
    }

}
