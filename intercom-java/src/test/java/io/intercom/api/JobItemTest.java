package io.intercom.api;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class JobItemTest {

    @Test
    public void testItemValidation() {

        try {
            new JobItem<User>(null, new User());
            fail("item with no method");
        } catch (InvalidException e) {
            assertTrue(e.getFirstError() != null);
        }

        try {
            new JobItem<User>("post", null);
            fail("item with no data");
        } catch (InvalidException e) {
            assertTrue(e.getFirstError() != null);
        }
    }
}