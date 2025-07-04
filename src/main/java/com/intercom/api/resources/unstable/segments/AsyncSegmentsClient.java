/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.intercom.api.resources.unstable.segments;

import com.intercom.api.core.ClientOptions;
import com.intercom.api.core.RequestOptions;
import com.intercom.api.resources.unstable.segments.requests.ListSegmentsRequest;
import com.intercom.api.resources.unstable.segments.requests.RetrieveSegmentRequest;
import com.intercom.api.resources.unstable.segments.types.Segment;
import com.intercom.api.resources.unstable.types.SegmentList;
import java.util.concurrent.CompletableFuture;

public class AsyncSegmentsClient {
    protected final ClientOptions clientOptions;

    private final AsyncRawSegmentsClient rawClient;

    public AsyncSegmentsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.rawClient = new AsyncRawSegmentsClient(clientOptions);
    }

    /**
     * Get responses with HTTP metadata like headers
     */
    public AsyncRawSegmentsClient withRawResponse() {
        return this.rawClient;
    }

    /**
     * You can fetch a list of all segments.
     */
    public CompletableFuture<SegmentList> listSegments() {
        return this.rawClient.listSegments().thenApply(response -> response.body());
    }

    /**
     * You can fetch a list of all segments.
     */
    public CompletableFuture<SegmentList> listSegments(ListSegmentsRequest request) {
        return this.rawClient.listSegments(request).thenApply(response -> response.body());
    }

    /**
     * You can fetch a list of all segments.
     */
    public CompletableFuture<SegmentList> listSegments(ListSegmentsRequest request, RequestOptions requestOptions) {
        return this.rawClient.listSegments(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * You can fetch the details of a single segment.
     */
    public CompletableFuture<Segment> retrieveSegment(RetrieveSegmentRequest request) {
        return this.rawClient.retrieveSegment(request).thenApply(response -> response.body());
    }

    /**
     * You can fetch the details of a single segment.
     */
    public CompletableFuture<Segment> retrieveSegment(RetrieveSegmentRequest request, RequestOptions requestOptions) {
        return this.rawClient.retrieveSegment(request, requestOptions).thenApply(response -> response.body());
    }
}
