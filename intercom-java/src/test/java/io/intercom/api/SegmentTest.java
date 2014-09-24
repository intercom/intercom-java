package io.intercom.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static io.intercom.api.TestSupport.load;
import static org.junit.Assert.assertEquals;

public class SegmentTest {

    private static ObjectMapper mapper;

    @BeforeClass
    public static void beforeClass() {
        mapper = TestSupport.objectMapper();
    }

    @Test
    public void TestSerdes() throws Exception {
        String json = load("segment.json");
        final Segment segment = mapper.readValue(json, Segment.class);
        assertEquals(1392734388L, segment.getCreatedAt());
        assertEquals(1392734398L, segment.getUpdatedAt());
        assertEquals("segment-name", segment.getName());
        assertEquals("segment", segment.getType());
        assertEquals("3142", segment.getId());

        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        mapper.writeValue(baos, segment);

        final String json1 = baos.toString();
        final Segment segment1 = mapper.readValue(json1, Segment.class);
        assertEquals(1392734388L, segment1.getCreatedAt());
        assertEquals(1392734398L, segment1.getUpdatedAt());
        assertEquals("segment-name", segment1.getName());
        assertEquals("segment", segment1.getType());
        assertEquals("3142", segment1.getId());

        assertEquals(segment, segment1);
    }

}