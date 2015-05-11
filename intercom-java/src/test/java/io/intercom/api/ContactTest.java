package io.intercom.api;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContactTest {


    @Test
    public void testValidateConvertBuilder() {
        Contact.ContactConvertBuilder builder = new Contact.ContactConvertBuilder();

        Contact c = new Contact();
        User u = new User().setEmail("a@b.com");

        try {
            builder.build(c,u);
            fail();
        } catch (InvalidException e) {
            assertTrue(e.getMessage().contains("convert contact must"));
        }

        c = new Contact().setID("1");
        u = new User();

        try {
            builder.build(c,u);
            fail();
        } catch (InvalidException e) {
            assertTrue(e.getMessage().contains("convert user must"));
        }
    }

}