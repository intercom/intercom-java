package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Tag extends TypedData {

    private static final Logger logger = LoggerFactory.getLogger("intercom-java");
    private static final HashMap<String, String> SENTINEL = Maps.newHashMap();

    public static Tag tag(Tag tag, User... users) throws InvalidException, AuthorizationException {
        return tag(tag, new UserCollection(Lists.newArrayList(users)));
    }

    public static Tag tag(Tag tag, Company... companies) throws InvalidException, AuthorizationException {
        return tag(tag, new CompanyCollection(Lists.newArrayList(companies)));
    }

    static Tag tag(Tag tag, UserCollection users) throws InvalidException, AuthorizationException {
        TaggableCollection taggableCollection = createTagTypedCollection(tag, users);
        return DataResource.create(taggableCollection, "tags", Tag.class);
    }

    static Tag tag(Tag tag, CompanyCollection companies) throws InvalidException, AuthorizationException {
        TaggableCollection taggableCollection = createTagTypedCollection(tag, companies);
        return DataResource.create(taggableCollection, "tags", Tag.class);
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

    @VisibleForTesting
    static TaggableCollection createTagTypedCollection(Tag tag, UserCollection users) {
        TaggableCollection taggableCollection = new TaggableCollection();
        taggableCollection.setName(tag.getName());
        taggableCollection.setId(tag.getId());
        final List<Map<String, Object>> usersLite = Lists.newArrayList();
        final List<User> pageItems = users.getPage();
        for (User user : pageItems) {
            Map<String, Object> userMap = Maps.newHashMap();
            final String id = user.getId();
            final String email = user.getEmail();
            final String userId = user.getUserId();

            if (user.isUntag()) {
                userMap.put("untag", true);
            }

            if (!Strings.isNullOrEmpty(id)) {
                userMap.put("id", id);
                usersLite.add(userMap);
            } else if (!Strings.isNullOrEmpty(email)) {
                userMap.put("email", email);
                usersLite.add(userMap);
            } else if (!Strings.isNullOrEmpty(userId)) {
                userMap.put("user_id", userId);
                usersLite.add(userMap);
            } else {
                logger.warn("no identifiers found for user tag target, skipping [" + tag + "] [" + user.toString() + "]");
            }
        }
        taggableCollection.setUsers(usersLite);
        return taggableCollection;
    }

    @VisibleForTesting
    static TaggableCollection createTagTypedCollection(Tag tag, CompanyCollection companies) {
        TaggableCollection taggableCollection = new TaggableCollection();
        taggableCollection.setName(tag.getName());
        taggableCollection.setId(tag.getId());

        final List<Map<String, Object>> companiesLite = Lists.newArrayList();
        final List<Company> pageItems = companies.getPage();
        for (Company company : pageItems) {
            Map<String, Object> companyMap = Maps.newHashMap();
            final String companyID = company.getCompanyID();
            final String id = company.getId();
            final String name = company.getName();

            if (company.isUntag()) {
                companyMap.put("untag", true);
            }

            if (!Strings.isNullOrEmpty(companyID)) {
                companyMap.put("company_id", companyID);
                companiesLite.add(companyMap);
            } else if (!Strings.isNullOrEmpty(id)) {
                companyMap.put("id", id);
                companiesLite.add(companyMap);
            } else if (!Strings.isNullOrEmpty(name)) {
                companyMap.put("name", name);
                companiesLite.add(companyMap);
            } else {
                logger.warn("no identifiers found for company tag target, skipping [" + tag + "] [" + company.toString() + "]");
            }
            taggableCollection.setCompanies(companiesLite);
        }
        return taggableCollection;
    }

    @SuppressWarnings("UnusedDeclaration")
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    static class TaggableCollection extends Tag {

        @JsonProperty("users")
        private List<Map<String, Object>> users;

        @JsonProperty("companies")
        private List<Map<String, Object>> companies;

        public List<Map<String, Object>> getUsers() {
            return users;
        }

        public void setUsers(List<Map<String, Object>> usersLite) {
            this.users = usersLite;
        }

        public List<Map<String, Object>> getCompanies() {
            return companies;
        }

        public void setCompanies(List<Map<String, Object>> companies) {
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


    @SuppressWarnings("UnusedReturnValue")
    @VisibleForTesting
    Tag setId(String id) {
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
