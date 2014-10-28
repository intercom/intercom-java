package io.intercom.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static io.intercom.api.TestSupport.load;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserTest {

    private static ObjectMapper mapper;

    @BeforeClass
    public static void beforeClass() {
        mapper = MapperSupport.objectMapper();
    }

    @Test
    public void TestUserUpdate() throws Exception {

        final long now = System.currentTimeMillis()/1000;
        final User user = new User()
            .setEmail("wash@serenity.io")
            .setUserId("22")
            .setRemoteCreatedAt(now)
            .setName("Wash")
            .setUnsubscribedFromEmails(true)
            .setUpdateLastRequestAt(true)
            .setNewSession(true)
            .setUserAgentData("user-agent");

        final User.UserUpdate userUpdate = User.buildUserUpdate(user);

        assertEquals("wash@serenity.io", userUpdate.getEmail());
        assertEquals("22", userUpdate.getUserId());
        assertEquals(now, userUpdate.getRemoteCreatedAt());
        assertEquals("Wash", userUpdate.getName());
        assertEquals(true, userUpdate.getUnsubscribedFromEmails());
        assertEquals(true, userUpdate.isUpdateLastRequestAt());
        assertEquals(true, userUpdate.isNewSession());
        assertEquals("user-agent", userUpdate.getLastSeenUserAgent());
    }

    @Test
    public void TestUserSerdesNullAndNotEmpty() throws Exception {
        final User user = new User();
        user.setEmail("a@b.com");
        user.setUserId("1");
        final String json = mapper.writeValueAsString(user);
        final Map map = mapper.readValue(json, Map.class);
        assertTrue(map.size() == 2);
        assertTrue(map.containsKey("email"));
        assertTrue(map.containsKey("user_id"));
    }

    @Test
    public void TestUserSerdesTrip() throws Exception {
        String json = load("user.json");
        final User user = mapper.readValue(json, User.class);
        final String json1 = mapper.writeValueAsString(user);
        final User user1 = mapper.readValue(json1, User.class);
        assertTrue(user.equals(user1));
    }

    @Test
    public void TestCustomAttributeSerdesTrip() throws Exception {
        String json = load("user.json");
        final User user = mapper.readValue(json, User.class);
        final String json1 = mapper.writeValueAsString(user);
        final User user1 = mapper.readValue(json1, User.class);
        assertEquals(user.getCustomAttributes(), user1.getCustomAttributes());
    }

    @Test
    public void TestSerdes() throws Exception {
        String json = load("user.json");
        final User user = mapper.readValue(json, User.class);
        assertEquals("user", user.getType());
        assertEquals("530370b477ad7120001d", user.getId());
        assertEquals("25", user.getUserId());
        assertEquals("wash@serenity.io", user.getEmail());
        assertEquals("Hoban Washburne", user.getName());
        assertEquals(0, user.getSessionCount());
        assertEquals("1.2.3.4", user.getLastSeenIp());
        assertEquals(Boolean.FALSE, user.getUnsubscribedFromEmails());
        assertEquals("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.9", user.getUserAgentData());
        assertEquals(1397574667L, user.getLastRequestAt());
        assertEquals(1392731331L, user.getRemoteCreatedAt());
        assertEquals(1392734388L, user.getCreatedAt());
        assertEquals(1392734388L, user.getUpdatedAt());

        final SegmentCollection segmentCollection = user.getSegmentCollection();
        assertEquals("segment.list", segmentCollection.getType());
        final List<Segment> items = segmentCollection.getPageItems();
        final Segment segment = items.get(0);
        assertEquals("segment", segment.getType());
        assertEquals("5310d8e7598c9a0b24000002", segment.getId());


        @SuppressWarnings("UnusedDeclaration")
        final CompanyCollection companyCollection = user.getCompanyCollection();

        final Map<String, CustomAttribute> customAttributes = user.getCustomAttributes();
        CustomAttribute customAttribute;

        customAttribute = customAttributes.get("truthy_typed");
        assertEquals(Boolean.class, customAttribute.getValueClass());
        assertEquals(Boolean.TRUE, customAttribute.getValue());
        assertEquals(Boolean.TRUE, customAttribute.booleanValue());
        assertEquals("truthy_typed", customAttribute.getName());

        customAttribute = customAttributes.get("floatly_typed");
        assertEquals(Double.class, customAttribute.getValueClass());
        assertEquals(155.5d, customAttribute.getValue());
        assertEquals(155.5d, customAttribute.doubleValue(), 0d);
        assertEquals("floatly_typed", customAttribute.getName());

        customAttribute = customAttributes.get("stringly_typed");
        assertEquals(String.class, customAttribute.getValueClass());
        assertEquals("data", customAttribute.getValue());
        assertEquals("data", customAttribute.textValue());
        assertEquals("stringly_typed", customAttribute.getName());

        customAttribute = customAttributes.get("dately_typed_at");
        assertEquals(Long.class, customAttribute.getValueClass());
        assertEquals(1397574667L, customAttribute.getValue());
        assertEquals(1397574667L, customAttribute.longValue());
        assertEquals("dately_typed_at", customAttribute.getName());

        customAttribute = customAttributes.get("longly_typed");
        assertEquals(Long.class, customAttribute.getValueClass());
        assertEquals(221397574667L, customAttribute.getValue());
        assertEquals(221397574667L, customAttribute.longValue());
        assertEquals("longly_typed", customAttribute.getName());

        customAttribute = customAttributes.get("intly_typed");
        assertEquals(Integer.class, customAttribute.getValueClass());
        assertEquals(1, customAttribute.getValue());
        assertEquals(1, customAttribute.integerValue());
        assertEquals("intly_typed", customAttribute.getName());

        // null values are not ignored
        customAttribute = customAttributes.get("nully_typed");
        assertEquals(null, customAttribute);
    }
}