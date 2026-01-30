package com.intercom.api.integration;

import com.intercom.api.Intercom;
import com.intercom.api.resources.segments.requests.FindSegmentRequest;
import com.intercom.api.resources.segments.types.Segment;
import com.intercom.api.types.SegmentList;
import com.intercom.api.utils.TestClientFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SegmentsTest {

    private Intercom client;
    private Segment segment;
    private String segmentId;

    @BeforeEach
    public void before() {
        // arrange
        client = TestClientFactory.create();
        segment = client.segments().list().getSegments()
                .orElseThrow(() -> new RuntimeException("Segments list is required"))
                .get(0);
        segmentId = segment.getId()
                .orElseThrow(() -> new RuntimeException("Segment ID is required"));
    }

    @Test
    public void testList() {
        // act
        SegmentList response = client.segments().list();

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testFind() {
        // act
        Segment response = client.segments()
                .find(FindSegmentRequest.builder().segmentId(segmentId).build());

        // assert
        Assertions.assertNotNull(response);
    }
}
