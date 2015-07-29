package io.intercom.api;

import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class ConversationTest {

    @Test
    public void testIsNullOrBlank() {
        assertTrue(Conversation.isNullOrBlank(null));
        assertTrue(Conversation.isNullOrBlank(""));
        assertTrue(Conversation.isNullOrBlank(" "));
        assertTrue(Conversation.isNullOrBlank("\n"));
        assertTrue(Conversation.isNullOrBlank("\r"));
        assertFalse(Conversation.isNullOrBlank("reply"));
    }

    @Test
    public void testAdminReply() {

        AdminReply adminReply = new AdminReply(null);
        adminReply.setAssigneeID("1");
        assertEquals(Conversation.MESSAGE_TYPE_ASSIGNMENT, adminReply.getMessageType());

        try {
            Conversation.validateAdminReplyRequest(adminReply);
        } catch (InvalidException e) {
            fail();
        }

        adminReply = new AdminReply(null);
        adminReply.setMessageType("comment");
        try {
            Conversation.validateAdminReplyRequest(adminReply);
            fail();
        } catch (InvalidException e) {
            assertTrue(e.getMessage()
                .contains("a comment or note reply must have a body"));
        }

        adminReply.setBody(" ");
        try {
            Conversation.validateAdminReplyRequest(adminReply);
            fail();
        } catch (InvalidException e) {
            assertTrue(e.getMessage()
                .contains("a comment or note reply must have a body"));
        }

        adminReply.setBody("Once, in flight school, I was laconic");
        try {
            Conversation.validateAdminReplyRequest(adminReply);
        } catch (InvalidException e) {
            fail();
        }
    }

    @Test
    public void testDisplayAs() {

        try {
            Conversation.list(buildRequestParameters("pdf"));
            fail();
        } catch (InvalidException e) {
            assertTrue(e.getMessage()
                .contains("A display_as parameter must have one of the values plaintext, html"));
        }

        try {
            Conversation.validateListRequest(buildRequestParameters("plaintext"));
        } catch (InvalidException e) {
            fail();
        }

        try {
            Conversation.validateListRequest(buildRequestParameters("html"));
        } catch (InvalidException e) {
            fail();
        }
    }

    private Map<String, String> buildRequestParameters(String html) {
        Map<String, String> params2 = Maps.newHashMap();
        params2.put("type", "admin");
        params2.put("admin_id", "1");
        params2.put("display_as", html);
        return params2;
    }
}