package io.intercom.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.IOException;
import java.util.List;

import static io.intercom.api.TestSupport.load;

import static org.junit.Assert.*;


@RunWith(PowerMockRunner.class)
@PrepareForTest( { Conversation.class })
public class ConversationPartTest {

    private static ObjectMapper objectMapper;

    @BeforeClass
    public static void beforeClass() {
        objectMapper = MapperSupport.objectMapper();
    }

    @Test
    public void testGetConversationPartDetailsFromConversationNoAttachments() throws IOException {
        PowerMockito.mockStatic(Conversation.class);

        String json = load("conversation_no_attachments.json");
        final Conversation conversation = objectMapper.readValue(json, Conversation.class);
        final List<ConversationPart> parts = conversation.getConversationPartCollection().getPage();

        assertEquals(2, parts.size());

        final ConversationPart part = parts.get(0);

        assertEquals("142533411", part.getId());
        assertEquals("comment", part.getPartType());
        assertEquals("<p>dm-9187dba8-fb3b-cb99-da05-37a932d3d678</p>", part.getBody());
        assertEquals(1468031160, part.getCreatedAt());
        assertEquals(1468031160, part.getUpdatedAt());
        assertEquals(1468031160, part.getNotifiedAt());
        assertEquals(null, part.getAssignedTo());
        assertEquals("576c1a139d0baad1010001111", part.getAuthor().getId());
        assertEquals("user", part.getAuthor().getType());
        assertEquals(0, part.getAttachments().size());

        PowerMockito.verifyStatic(Mockito.never());
        Conversation.find(conversation.getId());
    }

    @Test
    public void testGetAttachmentsFromConversationPart() throws IOException {
        String json = load("conversation_part_with_attachments.json");
        final ConversationPart part = objectMapper.readValue(json, ConversationPart.class);

        final List<Attachment> attachments = part.getAttachments();
        assertEquals(2, attachments.size());

        final Attachment attachment = attachments.get(0);

        assertEquals("upload", attachment.getType());
        assertEquals("Attachment.pdf", attachment.getName());
        assertEquals("https://api.example.com/uploads/111222333", attachment.getUrl());
        assertEquals("application/pdf", attachment.getContentType());
        assertEquals(8388608, attachment.getFilesize());
        assertEquals(1024, attachment.getWidth());
        assertEquals(8192, attachment.getHeight());
    }
}