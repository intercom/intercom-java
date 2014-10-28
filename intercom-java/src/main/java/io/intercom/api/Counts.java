package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Maps;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Counts {

    static Counts countQuery(Map<String, String> query) {
        final URI build = UriBuilder.newBuilder()
            .path("counts")
            .query(query)
            .build();
        final HttpClient resource = new HttpClient(build);
        return resource.get(Counts.class);
    }

    public static Counts.Totals appTotals() throws InvalidException, AuthorizationException {
        final HttpClient resource = new HttpClient(UriBuilder.newBuilder().path("counts").build());
        return resource.get(Totals.class);
    }

//    public static Long userCount() throws InvalidException, AuthorizationException{
//        final HashMap<String, String> params = Maps.newHashMap();
//        params.put("type", "user");
//        return countQuery(params).getUser().getUser();
//    }

    public static List<CountItem> userTags() throws InvalidException, AuthorizationException {
        final HashMap<String, String> params = Maps.newHashMap();
        params.put("type", "user");
        params.put("count", "tag");
        return countQuery(params).getUser().getTags();
    }

    public static List<CountItem> userSegments() throws InvalidException, AuthorizationException {
        final HashMap<String, String> params = Maps.newHashMap();
        params.put("type", "user");
        params.put("count", "segment");
        return countQuery(params).getUser().getSegments();
    }

    public static Counts.Conversation conversationTotals() throws InvalidException, AuthorizationException {
        final HashMap<String, String> params = Maps.newHashMap();
        params.put("type", "conversation");
        return countQuery(params).getConversation();
    }

    public static Counts.Conversation conversationAdmins() throws InvalidException, AuthorizationException {
        final HashMap<String, String> params = Maps.newHashMap();
        params.put("type", "conversation");
        params.put("count", "admin");
        return countQuery(params).getConversation();
    }

//    public static Long companyCount() throws InvalidException, AuthorizationException{
//        final HashMap<String, String> params = Maps.newHashMap();
//        params.put("type", "company");
//        return countQuery(params).getCompany().getCompanies();
//    }

    public static List<CountItem> companySegments() throws InvalidException, AuthorizationException {
        final HashMap<String, String> params = Maps.newHashMap();
        params.put("type", "company");
        params.put("count", "segment");
        return countQuery(params).getCompany().getSegments();
    }

    public static List<CountItem> companyTags() throws InvalidException, AuthorizationException {
        final HashMap<String, String> params = Maps.newHashMap();
        params.put("type", "company");
        params.put("count", "tag");
        return countQuery(params).getCompany().getTags();
    }

    public static List<CountItem> companyUsers() throws InvalidException, AuthorizationException {
        final HashMap<String, String> params = Maps.newHashMap();
        params.put("type", "company");
        params.put("count", "user");
        return countQuery(params).getCompany().getUsers();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public static class Totals {

        @JsonProperty("company")
        private CountItem company;

        @JsonProperty("segment")
        private CountItem segment;

        @JsonProperty("tag")
        private CountItem tag;

        @JsonProperty("user")
        private CountItem user;

        public CountItem getCompany() {
            return company;
        }

        public CountItem getSegment() {
            return segment;
        }

        public CountItem getTag() {
            return tag;
        }

        public CountItem getUser() {
            return user;
        }

        @Override
        public String toString() {
            return "Totals{" +
                "company=" + company +
                ", segment=" + segment +
                ", tag=" + tag +
                ", user=" + user +
                '}';
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public static class CountItem {

        private String name;

        private long value;

        public CountItem(String name, long value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public long getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "CountItem{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public static class Conversation {

        @JsonProperty("admin")
        List<Admin> admins;

        @JsonProperty("assigned")
        private long assigned;

        @JsonProperty("closed")
        private long closed;

        @JsonProperty("open")
        private long open;

        @JsonProperty("unassigned")
        private long unassigned;

        Conversation() {
        }

        public List<Admin> getAdmins() {
            return admins;
        }

        public long getAssigned() {
            return assigned;
        }

        public long getClosed() {
            return closed;
        }

        public long getOpen() {
            return open;
        }

        public long getUnassigned() {
            return unassigned;
        }

        @Override
        public String toString() {
            return "Conversation{" +
                "assigned=" + assigned +
                ", closed=" + closed +
                ", open=" + open +
                ", unassigned=" + unassigned +
                ", admins=" + admins +
                '}';
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public static class User {

        @JsonProperty("user")
        private long user;

        @JsonProperty("tag")
        private List<CountItem> tags;

        @JsonProperty("segment")
        private List<CountItem> segments;

        User() {
        }

        public long getUser() {
            return user;
        }

        public List<CountItem> getTags() {
            return tags;
        }

        public List<CountItem> getSegments() {
            return segments;
        }

        @Override
        public String toString() {
            return "User{" +
                "user=" + user +
                ", tags=" + tags +
                ", segments=" + segments +
                '}';
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public static class Company {

        @JsonProperty("company")
        private long companies;

        @JsonProperty("tag")
        private List<CountItem> tags;

        @JsonProperty("user")
        private List<CountItem> users;

        @JsonProperty("segment")
        private List<CountItem> segments;

        Company() {
        }

        public long getCompanies() {
            return companies;
        }

        public List<CountItem> getTags() {
            return tags;
        }

        public List<CountItem> getUsers() {
            return users;
        }

        public List<CountItem> getSegments() {
            return segments;
        }

        @Override
        public String toString() {
            return "Company{" +
                "companies=" + companies +
                ", tags=" + tags +
                ", users=" + users +
                ", segments=" + segments +
                '}';
        }
    }

    @JsonProperty("type")
    private String type = "count";

    @JsonProperty("company")
    private Counts.Company company;

    @JsonProperty("user")
    private Counts.User user;

    @JsonProperty("conversation")
    private Counts.Conversation conversation;

    public String getType() {
        return type;
    }

    public Company getCompany() {
        return company;
    }

    public User getUser() {
        return user;
    }

    public Conversation getConversation() {
        return conversation;
    }

    @Override
    public String toString() {
        return "Counts{" +
            "type='" + type + '\'' +
            ", company=" + company +
            ", user=" + user +
            ", conversation=" + conversation +
            '}';
    }
}
