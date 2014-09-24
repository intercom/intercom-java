package io.intercom.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static io.intercom.api.TestSupport.load;
import static org.junit.Assert.assertEquals;

public class TagTest {

    private static ObjectMapper mapper;

    @BeforeClass
    public static void beforeClass() {
        mapper = TestSupport.objectMapper();
    }

    @Test
    public void TestSerdes() throws Exception {
        String json = load("tag.json");
        final Tag tag = mapper.readValue(json, Tag.class);
        assertEquals(1392734388L, tag.getCreatedAt());
        assertEquals(1392734398L, tag.getUpdatedAt());
        assertEquals("tag-name", tag.getName());
        assertEquals("tag", tag.getType());
        assertEquals("3142", tag.getId());

        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        mapper.writeValue(baos, tag);

        final String json1 = baos.toString();
        final Tag tag1 = mapper.readValue(json1, Tag.class);
        assertEquals(1392734388L, tag1.getCreatedAt());
        assertEquals(1392734398L, tag1.getUpdatedAt());
        assertEquals("tag-name", tag1.getName());
        assertEquals("tag", tag1.getType());
        assertEquals("3142", tag1.getId());

        assertEquals(tag, tag1);
    }
}