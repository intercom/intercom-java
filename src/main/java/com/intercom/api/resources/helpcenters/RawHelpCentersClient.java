/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.intercom.api.resources.helpcenters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.intercom.api.core.ClientOptions;
import com.intercom.api.core.IntercomApiException;
import com.intercom.api.core.IntercomException;
import com.intercom.api.core.IntercomHttpResponse;
import com.intercom.api.core.ObjectMappers;
import com.intercom.api.core.QueryStringMapper;
import com.intercom.api.core.RequestOptions;
import com.intercom.api.core.pagination.SyncPagingIterable;
import com.intercom.api.errors.NotFoundError;
import com.intercom.api.errors.UnauthorizedError;
import com.intercom.api.resources.helpcenter.types.HelpCenter;
import com.intercom.api.resources.helpcenter.types.HelpCenterList;
import com.intercom.api.resources.helpcenters.requests.FindHelpCenterRequest;
import com.intercom.api.resources.helpcenters.requests.ListHelpCentersRequest;
import com.intercom.api.types.Error;
import java.io.IOException;
import java.util.List;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class RawHelpCentersClient {
    protected final ClientOptions clientOptions;

    public RawHelpCentersClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * You can fetch the details of a single Help Center by making a GET request to <code>https://api.intercom.io/help_center/help_center/&lt;id&gt;</code>.
     */
    public IntercomHttpResponse<HelpCenter> find(FindHelpCenterRequest request) {
        return find(request, null);
    }

    /**
     * You can fetch the details of a single Help Center by making a GET request to <code>https://api.intercom.io/help_center/help_center/&lt;id&gt;</code>.
     */
    public IntercomHttpResponse<HelpCenter> find(FindHelpCenterRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("help_center/help_centers")
                .addPathSegment(request.getHelpCenterId())
                .build();
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return new IntercomHttpResponse<>(
                        ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), HelpCenter.class), response);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            try {
                switch (response.code()) {
                    case 401:
                        throw new UnauthorizedError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class), response);
                    case 404:
                        throw new NotFoundError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class), response);
                }
            } catch (JsonProcessingException ignored) {
                // unable to map error response, throwing generic error
            }
            throw new IntercomApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class),
                    response);
        } catch (IOException e) {
            throw new IntercomException("Network error executing HTTP request", e);
        }
    }

    /**
     * You can list all Help Centers by making a GET request to <code>https://api.intercom.io/help_center/help_centers</code>.
     */
    public IntercomHttpResponse<SyncPagingIterable<HelpCenter>> list() {
        return list(ListHelpCentersRequest.builder().build());
    }

    /**
     * You can list all Help Centers by making a GET request to <code>https://api.intercom.io/help_center/help_centers</code>.
     */
    public IntercomHttpResponse<SyncPagingIterable<HelpCenter>> list(ListHelpCentersRequest request) {
        return list(request, null);
    }

    /**
     * You can list all Help Centers by making a GET request to <code>https://api.intercom.io/help_center/help_centers</code>.
     */
    public IntercomHttpResponse<SyncPagingIterable<HelpCenter>> list(
            ListHelpCentersRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("help_center/help_centers");
        if (request.getPage().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "page", request.getPage().get().toString(), false);
        }
        if (request.getPerPage().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "per_page", request.getPerPage().get().toString(), false);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                HelpCenterList parsedResponse =
                        ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), HelpCenterList.class);
                int newPageNumber = request.getPage().map(page -> page + 1).orElse(1);
                ListHelpCentersRequest nextRequest = ListHelpCentersRequest.builder()
                        .from(request)
                        .page(newPageNumber)
                        .build();
                List<HelpCenter> result = parsedResponse.getData();
                return new IntercomHttpResponse<>(
                        new SyncPagingIterable<HelpCenter>(true, result, () -> list(nextRequest, requestOptions)
                                .body()),
                        response);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            try {
                if (response.code() == 401) {
                    throw new UnauthorizedError(
                            ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class), response);
                }
            } catch (JsonProcessingException ignored) {
                // unable to map error response, throwing generic error
            }
            throw new IntercomApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class),
                    response);
        } catch (IOException e) {
            throw new IntercomException("Network error executing HTTP request", e);
        }
    }
}
