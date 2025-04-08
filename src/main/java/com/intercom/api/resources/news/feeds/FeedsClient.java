/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.intercom.api.resources.news.feeds;

import com.intercom.api.core.ClientOptions;
import com.intercom.api.core.RequestOptions;
import com.intercom.api.resources.news.feeds.requests.FindNewsFeedRequest;
import com.intercom.api.resources.news.feeds.requests.ListNewsFeedItemsRequest;
import com.intercom.api.resources.news.types.Newsfeed;
import com.intercom.api.types.PaginatedNewsItemResponse;
import com.intercom.api.types.PaginatedNewsfeedResponse;

public class FeedsClient {
    protected final ClientOptions clientOptions;

    private final RawFeedsClient rawClient;

    public FeedsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.rawClient = new RawFeedsClient(clientOptions);
    }

    /**
     * Get responses with HTTP metadata like headers
     */
    public RawFeedsClient withRawResponse() {
        return this.rawClient;
    }

    /**
     * You can fetch a list of all news items that are live on a given newsfeed
     */
    public PaginatedNewsItemResponse listItems(ListNewsFeedItemsRequest request) {
        return this.rawClient.listItems(request).body();
    }

    /**
     * You can fetch a list of all news items that are live on a given newsfeed
     */
    public PaginatedNewsItemResponse listItems(ListNewsFeedItemsRequest request, RequestOptions requestOptions) {
        return this.rawClient.listItems(request, requestOptions).body();
    }

    /**
     * You can fetch a list of all newsfeeds
     */
    public PaginatedNewsfeedResponse list() {
        return this.rawClient.list().body();
    }

    /**
     * You can fetch a list of all newsfeeds
     */
    public PaginatedNewsfeedResponse list(RequestOptions requestOptions) {
        return this.rawClient.list(requestOptions).body();
    }

    /**
     * You can fetch the details of a single newsfeed
     */
    public Newsfeed find(FindNewsFeedRequest request) {
        return this.rawClient.find(request).body();
    }

    /**
     * You can fetch the details of a single newsfeed
     */
    public Newsfeed find(FindNewsFeedRequest request, RequestOptions requestOptions) {
        return this.rawClient.find(request, requestOptions).body();
    }
}
