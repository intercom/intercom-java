package io.intercom.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static io.intercom.api.TestSupport.load;
import static org.junit.Assert.assertEquals;

public class NoteTest {

    private static ObjectMapper mapper;

    @BeforeClass
    public static void beforeClass() {
        mapper = TestSupport.objectMapper();
    }

    @Test
    public void TestSerdes() throws Exception {
        String json = load("note.json");
        final Note note = mapper.readValue(json, Note.class);
        assertEquals("16", note.getId());
        assertEquals(1389913941L, note.getCreatedAt());
        assertEquals("<p>Text for my note</p>", note.getBody());

        final Author author = note.getAuthor();
        assertEquals(true, author.isAdmin());
        assertEquals("21", author.getId());
        assertEquals("Jayne Cobb", author.getName());
        assertEquals("jayne@serenity.io", author.getEmail());

        final User user = note.getUser();
        assertEquals("user", user.getType());
        assertEquals("5310d8e8598c9a0b24000005", user.getId());


        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        mapper.writeValue(baos, note);

        final String json1 = baos.toString();
        final Note note1 = mapper.readValue(json, Note.class);
        assertEquals("16", note1.getId());
        assertEquals(1389913941L, note1.getCreatedAt());
        assertEquals("<p>Text for my note</p>", note1.getBody());

        final Author author1 = note1.getAuthor();
        assertEquals(true, author1.isAdmin());
        assertEquals("21", author1.getId());
        assertEquals("Jayne Cobb", author1.getName());
        assertEquals("jayne@serenity.io", author1.getEmail());

        final User user1 = note1.getUser();
        assertEquals("user", user1.getType());
        assertEquals("5310d8e8598c9a0b24000005", user1.getId());

        assertEquals(note, note1);
    }
}