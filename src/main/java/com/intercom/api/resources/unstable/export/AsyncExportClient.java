/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.intercom.api.resources.unstable.export;

import com.intercom.api.core.ClientOptions;
import com.intercom.api.core.RequestOptions;
import com.intercom.api.resources.unstable.export.requests.PostExportReportingDataEnqueueRequest;
import com.intercom.api.resources.unstable.export.types.GetExportReportingDataGetDatasetsResponse;
import com.intercom.api.resources.unstable.export.types.PostExportReportingDataEnqueueResponse;
import java.util.concurrent.CompletableFuture;

public class AsyncExportClient {
    protected final ClientOptions clientOptions;

    private final AsyncRawExportClient rawClient;

    public AsyncExportClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.rawClient = new AsyncRawExportClient(clientOptions);
    }

    /**
     * Get responses with HTTP metadata like headers
     */
    public AsyncRawExportClient withRawResponse() {
        return this.rawClient;
    }

    public CompletableFuture<PostExportReportingDataEnqueueResponse> enqueueANewReportingDataExportJob(
            PostExportReportingDataEnqueueRequest request) {
        return this.rawClient.enqueueANewReportingDataExportJob(request).thenApply(response -> response.body());
    }

    public CompletableFuture<PostExportReportingDataEnqueueResponse> enqueueANewReportingDataExportJob(
            PostExportReportingDataEnqueueRequest request, RequestOptions requestOptions) {
        return this.rawClient
                .enqueueANewReportingDataExportJob(request, requestOptions)
                .thenApply(response -> response.body());
    }

    public CompletableFuture<GetExportReportingDataGetDatasetsResponse> listAvailableDatasetsAndAttributes() {
        return this.rawClient.listAvailableDatasetsAndAttributes().thenApply(response -> response.body());
    }

    public CompletableFuture<GetExportReportingDataGetDatasetsResponse> listAvailableDatasetsAndAttributes(
            RequestOptions requestOptions) {
        return this.rawClient.listAvailableDatasetsAndAttributes(requestOptions).thenApply(response -> response.body());
    }
}
