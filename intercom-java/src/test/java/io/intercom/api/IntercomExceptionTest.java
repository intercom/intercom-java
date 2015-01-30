package io.intercom.api;

import com.google.common.collect.Lists;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntercomExceptionTest {

    @Test
    public void testNullCollection() {
        assertEquals("Could not read error message from server", IntercomException.getMessage(null));
    }

    @Test
    public void testBlankCollection() {
        ErrorCollection ec = new ErrorCollection();
        assertEquals("Could not read error message from server", IntercomException.getMessage(ec));
    }

    @Test
    public void testEmptyCollection() {
        try {
            new ErrorCollection(Lists.<Error>newArrayList());
            fail();
        } catch (IllegalArgumentException e) {
        }
        final ErrorCollection ec = new ErrorCollection(Lists.newArrayList(new Error()));
        assertEquals("Could not read error message from server", IntercomException.getMessage(ec));
    }

}