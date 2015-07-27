package io.intercom.api;

import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class ConversationTest {

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