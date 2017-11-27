package io.intercom.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Map;

import static io.intercom.api.TestSupport.load;
import static org.junit.Assert.assertEquals;

public class NotificationTest {
    private static ObjectMapper mapper;

    @BeforeClass
    public static void beforeClass() {
        mapper = TestSupport.objectMapper();
    }

    @Test
    public void testPayload() throws Exception {
        String json = load("notification.json");
        final Notification notification = mapper.readValue(json, Notification.class);

        assertEquals("notif_d9697680-d363-11e7-9ccb-d3a7f70c358c", notification.getId());
        assertEquals(1511781145L, notification.getCreatedAt());
        assertEquals("a86dr8yl", notification.getAppID());
        assertEquals("pending", notification.getDeliveryStatus());
        assertEquals("user.created", notification.getTopic());
        assertEquals(1, notification.getDeliveryAttempts());
        assertEquals(1511781146L, notification.getFirstSentAt());

        final NotificationData notificationData = notification.getData();
        final Map notificationDataItem = notificationData.getItem();
        assertEquals("user", notificationDataItem.get("type"));
        assertEquals("5a1bf31767893985752b4041", notificationDataItem.get("id"));
        assertEquals("test1234", notificationDataItem.get("user_id"));
    }
}
