package io.intercom.api;

import com.google.common.collect.Lists;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class JobSupportTest {

    @Test
    public void testItemValidation() {

        final JobSupport jobSupport = new JobSupport();
        try {
            jobSupport.validateJobItem(new JobItem("levitate", new User()), Lists.newArrayList("post"));
            fail("item with an unknown method");
        } catch (InvalidException e) {
            assertTrue(e.getFirstError() != null);
        }
    }
}