package io.intercom.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;

import static io.intercom.api.TestSupport.load;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TagTest {

    private static ObjectMapper mapper;

    @BeforeClass
    public static void beforeClass() {
        mapper = TestSupport.objectMapper();
    }

    @Test
    public void testTagUsers() throws Exception {
        String json = load("tag.json");
        final Tag tag = mapper.readValue(json, Tag.class);

        final User user1 = new User().setEmail("wash@serenity.io").untag();
        final User user2 = new User().setUserId("22");
        final User user3 = new User().setId("3434");
        final User user4 = new User().setEmail("malcolm@serenity.io");
        final User user5 = new User().setUserId("23");
        final User user6 = new User().setId("3435");
        final UserCollection uc = new UserCollection(Lists.newArrayList(user1, user2, user3, user4, user5, user6));
        final Tag.TaggableCollection taggableCollection = Tag.createTagTypedCollection(tag, uc);
        final List<Map<String, Object>> users = taggableCollection.getUsers();

        int match = 0;
        for (Map<String, Object> user : users) {
            if (user.containsKey("id") && user.get("id").equals("3434")) {
                match += 1;
            }
            if (user.containsKey("email") && user.get("email").equals("wash@serenity.io")) {
                match += 1;
                assertTrue(user.containsKey("untag") && user.get("untag") == Boolean.TRUE);
            }
            if (user.containsKey("user_id") && user.get("user_id").equals("22")) {
                match += 1;
            }
            if (user.containsKey("id") && user.get("id").equals("3435")) {
                match += 1;
            }
            if (user.containsKey("email") && user.get("email").equals("malcolm@serenity.io")) {
                match += 1;
            }
            if (user.containsKey("user_id") && user.get("user_id").equals("23")) {
                match += 1;
            }
        }
        assertEquals(6, match);
    }

    @Test
    public void testTagCompanies() throws Exception {
        String json = load("tag.json");
        final Tag tag = mapper.readValue(json, Tag.class);

        final Company c1 = new Company().setCompanyID("c1").untag();
        final Company c2 = new Company().setName("name1");
        final Company c3 = new Company().setCompanyID("c3");
        final Company c4 = new Company().setName("name4");
        final Company c5 = new Company().setId("1");
        final Company c6 = new Company().setId("2");
        final CompanyCollection uc = new CompanyCollection(Lists.newArrayList(c1, c2, c3, c4, c5, c6));
        final Tag.TaggableCollection taggableCollection = Tag.createTagTypedCollection(tag, uc);
        final List<Map<String, Object>> companies = taggableCollection.getCompanies();
        int match = 0;
        for (Map<String, Object> company : companies) {
            if (company.containsKey("company_id") && company.get("company_id").equals("c1")) {
                match += 1;
                assertTrue(company.containsKey("untag") && company.get("untag") == Boolean.TRUE);
            }
            if (company.containsKey("name") && company.get("name").equals("name1")) {
                match += 1;
            }
            if (company.containsKey("company_id") && company.get("company_id").equals("c3")) {
                match += 1;
            }
            if (company.containsKey("name") && company.get("name").equals("name4")) {
                match += 1;
            }
            if (company.containsKey("id") && company.get("id").equals("1")) {
                match += 1;
            }
            if (company.containsKey("id") && company.get("id").equals("2")) {
                match += 1;
            }
        }
        assertEquals(6, match);
    }

    @Test
    public void TestSerdes() throws Exception {
        String json = load("tag.json");
        final Tag tag = mapper.readValue(json, Tag.class);
        assertEquals(1392734388L, tag.getCreatedAt());
        assertEquals(1392734398L, tag.getUpdatedAt());
        assertEquals("tag-name", tag.getName());
        assertEquals("tag", tag.getType());
        assertEquals("3142", tag.getId());

        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        mapper.writeValue(baos, tag);

        final String json1 = baos.toString();
        final Tag tag1 = mapper.readValue(json1, Tag.class);
        assertEquals(1392734388L, tag1.getCreatedAt());
        assertEquals(1392734398L, tag1.getUpdatedAt());
        assertEquals("tag-name", tag1.getName());
        assertEquals("tag", tag1.getType());
        assertEquals("3142", tag1.getId());

        assertEquals(tag, tag1);
    }
}