package io.intercom.api;

import com.google.common.collect.Lists;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class EventTest {

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
    }


}