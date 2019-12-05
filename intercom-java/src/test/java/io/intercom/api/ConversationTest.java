package io.intercom.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.IOException;
import java.util.Map;

import static io.intercom.api.TestSupport.load;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

@RunWith(PowerMockRunner.class)
@PrepareForTest( { Conversation.class })
public class ConversationTest {

    private static ObjectMapper objectMapper;

    @BeforeClass
    public static void beforeClass() {
        objectMapper = MapperSupport.objectMapper();
    }

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

        adminReply.setAttachmentUrls(new String[]{"http://www.example.com/attachment.jpg"});
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

    @Test
    public void testGetConversationMessageDetailsFromConversation() throws IOException {
        PowerMockito.mockStatic(Conversation.class);

        String json = load("conversation.json");
        final Conversation conversation = objectMapper.readValue(json, Conversation.class);
        final ConversationMessage conversationMessage = conversation.getConversationMessage();

        assertEquals("33954111", conversationMessage.getId());
        assertEquals("<p>test</p>", conversationMessage.getBody());
        assertEquals("Email subject", conversationMessage.getSubject());
        assertEquals("https://intercom.com/", conversationMessage.getUrl());
        assertEquals("customer_initiated", conversationMessage.getDeliveredAs());

        assertEquals("lead", conversationMessage.getAuthor().getType());
        assertEquals("576c1a139d0baad1010011111", conversationMessage.getAuthor().getId());

        assertEquals(2, conversationMessage.getAttachments().size());

        final Attachment firstAttachment = conversationMessage.getAttachments().get(0);
        final Attachment lastAttachment = conversationMessage.getAttachments().get(1);
        assertEquals("upload", firstAttachment.getType());
        assertEquals("123.csv", firstAttachment.getName());
        assertEquals("https://downloads.intercomcdn.com/123.csv", firstAttachment.getUrl());
        assertEquals("text/csv", firstAttachment.getContentType());
        assertEquals(147, firstAttachment.getFilesize());
        assertEquals(0, firstAttachment.getWidth());
        assertEquals(0, firstAttachment.getHeight());

        assertEquals("upload", lastAttachment.getType());
        assertEquals("abc.txt", lastAttachment.getName());
        assertEquals("https://downloads.intercomcdn.com/txt", lastAttachment.getUrl());
        assertEquals("text/csv", lastAttachment.getContentType());
        assertEquals(100, lastAttachment.getFilesize());
        assertEquals(1, lastAttachment.getWidth());
        assertEquals(2, lastAttachment.getHeight());

        PowerMockito.verifyStatic(Mockito.never());
        Conversation.find(conversation.getId());
    }

    @Test
    public void testGetConversationMessageDetailsFromConversationNoAttachments() throws IOException {
        PowerMockito.mockStatic(Conversation.class);

        String json = load("conversation_no_attachments.json");
        final Conversation conversation = objectMapper.readValue(json, Conversation.class);
        final ConversationMessage conversationMessage = conversation.getConversationMessage();

        assertEquals("33954111", conversationMessage.getId());
        assertEquals("<p>test</p>", conversationMessage.getBody());
        assertEquals("Email subject", conversationMessage.getSubject());
        assertEquals("https://intercom.com/", conversationMessage.getUrl());
        assertEquals("customer_initiated", conversationMessage.getDeliveredAs());

        assertEquals("lead", conversationMessage.getAuthor().getType());
        assertEquals("576c1a139d0baad1010011111", conversationMessage.getAuthor().getId());

        assertEquals(0, conversationMessage.getAttachments().size());

        PowerMockito.verifyStatic(Mockito.never());
        Conversation.find(conversation.getId());
    }

    @Test
    public void testGetConversationsPartFromConversation() throws IOException {
        PowerMockito.mockStatic(Conversation.class);

        String json = load("conversation.json");
        final Conversation conversation = objectMapper.readValue(json, Conversation.class);
        assertEquals(2, conversation.getConversationPartCollection().getPage().size());

        PowerMockito.verifyStatic(Mockito.never());
        Conversation.find(conversation.getId());
    }

    @Test
    public void testGetConversationsPartFromConversationCollection() throws IOException {
        PowerMockito.mockStatic(Conversation.class);

        String conversationsJson = load("conversations.json");
        final ConversationCollection conversationCollection = objectMapper.readValue(conversationsJson, ConversationCollection.class);
        final Conversation conversation = conversationCollection.getPage().get(0);

        String conversationJson = load("conversation.json");
        final Conversation conversationWithParts = objectMapper.readValue(conversationJson, Conversation.class);
        Mockito.when(Conversation.find(conversation.getId())).thenReturn(conversationWithParts);
        assertEquals(2, conversation.getConversationPartCollection().getPage().size());

        PowerMockito.verifyStatic(Mockito.times(1));
        Conversation.find(conversation.getId());
    }

    @Test
    public void testGetEmptyConversationsPartFromConversationCollection() throws IOException {
        PowerMockito.mockStatic(Conversation.class);

        String conversationsJson = load("conversations.json");
        final ConversationCollection conversationCollection = objectMapper.readValue(conversationsJson, ConversationCollection.class);
        final Conversation conversation = conversationCollection.getPage().get(0);

        String conversationJson = load("conversation_no_parts.json");
        final Conversation conversationWithParts = objectMapper.readValue(conversationJson, Conversation.class);
        Mockito.when(Conversation.find(conversation.getId())).thenReturn(conversationWithParts);
        assertEquals(0, conversation.getConversationPartCollection().getPage().size());

        PowerMockito.verifyStatic(Mockito.times(1));
        Conversation.find(conversation.getId());
    }

    @Test
    public void testGetTagsFromConversation() throws IOException {
        PowerMockito.mockStatic(Conversation.class);

        String json = load("conversation.json");
        final Conversation conversation = objectMapper.readValue(json, Conversation.class);
        assertEquals(2, conversation.getTagCollection().getPage().size());

        PowerMockito.verifyStatic(Mockito.never());
        Conversation.find(conversation.getId());
    }

    @Test
    public void testGetTagFromTagCollection() throws IOException {
        PowerMockito.mockStatic(Conversation.class);

        String conversationsJson = load("conversations.json");
        final ConversationCollection conversationCollection = objectMapper.readValue(conversationsJson, ConversationCollection.class);
        final Conversation conversation = conversationCollection.getPage().get(0);

        String conversationJson = load("conversation.json");
        final Conversation conversationWithTags = objectMapper.readValue(conversationJson, Conversation.class);
        Mockito.when(Conversation.find(conversation.getId())).thenReturn(conversationWithTags);
        assertEquals(2, conversation.getTagCollection().getPage().size());

        PowerMockito.verifyStatic(Mockito.times(1));
        Conversation.find(conversation.getId());
    }

    @Test
    public void testGetEmptyTagFromTagCollection() throws IOException {
        PowerMockito.mockStatic(Conversation.class);

        String conversationsJson = load("conversations.json");
        final ConversationCollection conversationCollection = objectMapper.readValue(conversationsJson, ConversationCollection.class);
        final Conversation conversation = conversationCollection.getPage().get(0);

        String conversationJson = load("conversation_no_tags.json");
        final Conversation conversationWithTags= objectMapper.readValue(conversationJson, Conversation.class);
        Mockito.when(Conversation.find(conversation.getId())).thenReturn(conversationWithTags);
        assertEquals(0, conversation.getConversationPartCollection().getPage().size());

        PowerMockito.verifyStatic(Mockito.times(1));
        Conversation.find(conversation.getId());
    }
    private Map<String, String> buildRequestParameters(String html) {
        Map<String, String> params2 = Maps.newHashMap();
        params2.put("type", "admin");
        params2.put("admin_id", "1");
        params2.put("display_as", html);
        return params2;
    }

    @Test
    public void testGetConversationCustomerFirstReply() throws IOException {
        PowerMockito.mockStatic(Conversation.class);

        String json = load("conversation.json");
        final Conversation conversation = objectMapper.readValue(json, Conversation.class);
        assertNotNull(conversation.getCustomerFirstReply());
        assertEquals(1468236397, conversation.getCustomerFirstReply().getCreatedAt());
        assertEquals("conversation", conversation.getCustomerFirstReply().getType());
        assertEquals("https://someurl", conversation.getCustomerFirstReply().getUrl());
    }
}
