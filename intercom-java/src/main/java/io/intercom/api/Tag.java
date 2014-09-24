package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.List;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Tag extends TypedData {

    private static final HashMap<String, String> SENTINEL = Maps.newHashMap();

    public static Tag tag(Tag tag, UserCollection users) throws InvalidException, AuthorizationException {
        TagTypedCollection tagTypedCollection = new TagTypedCollection();
        tagTypedCollection.setName(tag.getName());
        tagTypedCollection.setId(tag.getId());
        tagTypedCollection.setUsers(users.getPageItems());
        return DataResource.create(tagTypedCollection, "tags", Tag.class);
    }

    public static Tag tag(Tag tag, CompanyCollection companies) throws InvalidException, AuthorizationException {
        TagTypedCollection tagTypedCollection = new TagTypedCollection();
        tagTypedCollection.setName(tag.getName());
        tagTypedCollection.setId(tag.getId());
        tagTypedCollection.setCompanies(companies.getPageItems());
        return DataResource.create(tagTypedCollection, "tags", Tag.class);
    }

    public static Tag create(Tag tag) throws InvalidException, AuthorizationException {
        return DataResource.create(tag, "tags", Tag.class);
    }

    public static Tag update(Tag tag) throws InvalidException, AuthorizationException {
        if (tag.getId() == null) {
            throw new InvalidException("tag updates must supply an id");
        }
        return DataResource.update(tag, "tags", Tag.class);
    }

    public static Tag delete(String id) throws InvalidException, AuthorizationException {
        return DataResource.delete(id, "tags", Tag.class);
    }

    public static Tag delete(Tag tag) throws InvalidException, AuthorizationException {
        return delete(tag.getId());
    }

    public static TagCollection list() throws InvalidException, AuthorizationException {
        return DataResource.list(SENTINEL, "tags", TagCollection.class);
    }

    @SuppressWarnings("UnusedDeclaration")
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    static class TagTypedCollection extends Tag {

        @JsonProperty("users")
        private List<User> users;

        @JsonProperty("companies")
        private List<Company> companies;

        public List<User> getUsers() {
            return users;
        }

        public void setUsers(List<User> users) {
            this.users = users;
        }

        public List<Company> getCompanies() {
            return companies;
        }

        public void setCompanies(List<Company> companies) {
            this.companies = companies;
        }
    }

    @JsonProperty("type")
    private final String type = "tag";

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("created_at")
    private long createdAt;

    @JsonProperty("updated_at")
    private long updatedAt;

    public Tag() {
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public Tag setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Tag setName(String name) {
        this.name = name;
        return this;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tag tag = (Tag) o;

        if (createdAt != tag.createdAt) return false;
        if (updatedAt != tag.updatedAt) return false;
        if (id != null ? !id.equals(tag.id) : tag.id != null) return false;
        if (name != null ? !name.equals(tag.name) : tag.name != null) return false;
        //noinspection RedundantIfStatement
        if (!type.equals(tag.type)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (int) (createdAt ^ (createdAt >>> 32));
        result = 31 * result + (int) (updatedAt ^ (updatedAt >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Tag{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", createdAt=" + createdAt +
            ", updatedAt=" + updatedAt +
            "} " + super.toString();
    }
}
