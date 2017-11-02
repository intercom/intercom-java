package io.intercom.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.intercom.api.TestSupport.load;
import static org.junit.Assert.*;

public class EventTest {
    private static ObjectMapper mapper;

    @BeforeClass
    public static void beforeClass() {
        mapper = MapperSupport.objectMapper();
    }

    @Test
    public void testBulkValidation() {

        Event event = new Event();
        event.setEmail(null);
        event.setEventName("bought-hat");

        try {
            Event.validateJobItems(Lists.newArrayList(new JobItem<Event>("post", event)));
            fail("bulk event with no user id or email should be invalid");
        } catch (InvalidException e) {
            assertTrue(e.getFirstError() != null);
        }

        event = new Event();
        event.setEmail("jayne@serenity.io");
        event.setEventName(null);
        try {
            Event.validateJobItems(Lists.newArrayList(new JobItem<Event>("post", event)));
            fail("bulk event with a blank name should be invalid");
        } catch (InvalidException e) {
            assertTrue(e.getFirstError() != null);
        }

        event = new Event();
        event.setEmail("jayne@serenity.io");
        event.setEventName("bought-hat");
        try {
            Event.validateJobItems(Lists.newArrayList(new JobItem<Event>("levitate", event)));
            fail("bulk event with an unknown method");
        } catch (InvalidException e) {
            assertTrue(e.getFirstError() != null);
        }
    }

    @Test
    public void testMissingUser() {
        final Event event1 = new Event().setEventName("bought-hat");
        try {
            Event.create(event1);
            fail("an event with no user id or email should be invalid");
        } catch (InvalidException e) {
            assertTrue(e.getFirstError() != null);
        }

        final Event event2 = new Event()
            .setEventName("bought-hat")
            .setUserID("")
            .putMetadata("invitee_email", "jayne@serenity.io");
        try {
            Event.create(event2);
            fail("an event with a blank  user id should be invalid");
        } catch (InvalidException e) {
            assertTrue(e.getFirstError() != null);
        }

        final Event event3 = new Event().setEmail("");
        try {
            Event.create(event3);
            fail("an event with a blank  email should be invalid");
        } catch (InvalidException e) {
            assertTrue(e.getFirstError() != null);
        }

    }

    @Test
    public void testMissingEventName() {
        Event event1 = new Event()
            .setEmail("jayne@serenity.io");
        try {
            Event.create(event1);
            fail("an event with a blank  name should be invalid");
        } catch (InvalidException e) {
            assertTrue(e.getFirstError() != null);

        }

        Event event2 = new Event()
            .setEmail("jayne@serenity.io")
            .setEventName("");
        try {
            Event.create(event2);
            fail("an event with a blank  name should be invalid");
        } catch (InvalidException e) {
            assertTrue(e.getFirstError() != null);
        }
    }

    @Test
    public void testMissingId() {
        final Event event1 = new Event().setEventName("test-id");
        try {
            Event.create(event1);
            fail("an event with no id or email should be invalid");
        } catch (InvalidException e) {
            assertTrue(e.getFirstError() != null);
        }

        final Event event2 = new Event()
                .setEventName("test-id")
                .setId("")
                .putMetadata("invitee_email", "jayne@serenity.io");
        try {
            Event.create(event2);
            fail("an event with an empty id should be invalid");
        } catch (InvalidException e) {
            assertTrue(e.getFirstError() != null);
        }

        final Event event3 = new Event()
                .setId("49bf6b081d661db4408a51e1")
                .setEmail("");
        try {
            Event.create(event3);
            fail("an event with an empty email should be invalid");
        } catch (InvalidException e) {
            assertTrue(e.getFirstError() != null);
        }

    }

    @Test
    public void testValid() {
        Event event1 = new Event()
            .setEmail("jayne@serenity.io")
            .setEventName("bought-hat");
        try {
            Event.validateCreateEvent(event1);
        } catch (InvalidException e) {
            fail("an event with an email and a name should be valid");
        }

        Event event2 = new Event()
            .setUserID("1")
            .setEventName("bought-hat");
        try {
            Event.validateCreateEvent(event2);
        } catch (InvalidException e) {
            fail("an event with a user id and a name should be valid");
        }

        Event event3 = new Event()
            .setUserID("1")
            .setEmail("jayne@serenity.io")
            .setEventName("bought-hat");
        try {
            Event.validateCreateEvent(event3);
        } catch (InvalidException e) {
            fail("an event with a user id, email and a name should be valid");
        }

        Event event4 = new Event()
                .setId("49bf6b081d661db4408a51e1")
                .setEventName("test-id");
        try {
            Event.validateCreateEvent(event4);
        } catch (InvalidException e) {
            fail("an event with an id and a name should be valid");
        }

        Event event5 = new Event()
                .setId("49bf6b081d661db4408a51e1")
                .setEmail("jayne@serenity.io")
                .setEventName("test-id");
        try {
            Event.validateCreateEvent(event5);
        } catch (InvalidException e) {
            fail("an event with an id, email and a name should be valid");
        }

    }
    @Test
    public void testListing() throws Exception {
        String json = load("events.json");
        final EventCollection eventCollection = mapper.readValue(json, EventCollection.class);
        assertEquals(2, eventCollection.getPage().size());

        final Event eventWithNoMetadata = eventCollection.getPage().get(0);
        assertEquals("cc7e2992-e6f1-11e7-9f85-25b0a92374f6", eventWithNoMetadata.getId());
        assertEquals(1513931185, eventWithNoMetadata.getCreatedAt());
        assertEquals("test-event", eventWithNoMetadata.getEventName());
        assertEquals("25", eventWithNoMetadata.getUserID());
        assertEquals("530370b477ad7120001d", eventWithNoMetadata.getIntercomUserID());
        assertEquals(0, eventWithNoMetadata.getMetadata().size());

        final Event eventWithMetadata = eventCollection.getPage().get(1);
        assertEquals("9a096a26-b8c5-11e7-b012-3f043042e6d0", eventWithMetadata.getId());
        assertEquals(1508854449, eventWithMetadata.getCreatedAt());
        assertEquals("invited-friend", eventWithMetadata.getEventName());
        assertEquals("25", eventWithMetadata.getUserID());
        assertEquals("530370b477ad7120001d", eventWithMetadata.getIntercomUserID());
        assertNotEquals(null, eventWithMetadata.getMetadata());
        assertEquals(2, eventWithMetadata.getMetadata().size());
        assertEquals("pi@example.org", eventWithMetadata.getMetadata().get("invitee_email"));
        assertEquals("ADDAFRIEND", eventWithMetadata.getMetadata().get("invite_code"));
        assertEquals(null, eventWithMetadata.getMetadata().get("non_existing_key"));
    }
}

