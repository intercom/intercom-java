/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.intercom.api.resources.notes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.intercom.api.core.ClientOptions;
import com.intercom.api.core.IntercomApiException;
import com.intercom.api.core.IntercomException;
import com.intercom.api.core.IntercomHttpResponse;
import com.intercom.api.core.MediaTypes;
import com.intercom.api.core.ObjectMappers;
import com.intercom.api.core.QueryStringMapper;
import com.intercom.api.core.RequestOptions;
import com.intercom.api.core.pagination.SyncPagingIterable;
import com.intercom.api.errors.NotFoundError;
import com.intercom.api.errors.UnauthorizedError;
import com.intercom.api.resources.notes.requests.CreateContactNoteRequest;
import com.intercom.api.resources.notes.requests.FindNoteRequest;
import com.intercom.api.resources.notes.requests.ListContactNotesRequest;
import com.intercom.api.resources.notes.types.Note;
import com.intercom.api.types.Error;
import com.intercom.api.types.NoteList;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;

public class AsyncRawNotesClient {
    protected final ClientOptions clientOptions;

    public AsyncRawNotesClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * You can fetch a list of notes that are associated to a contact.
     */
    public CompletableFuture<IntercomHttpResponse<SyncPagingIterable<Note>>> list(ListContactNotesRequest request) {
        return list(request, null);
    }

    /**
     * You can fetch a list of notes that are associated to a contact.
     */
    public CompletableFuture<IntercomHttpResponse<SyncPagingIterable<Note>>> list(
            ListContactNotesRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("contacts")
                .addPathSegment(request.getContactId())
                .addPathSegments("notes");
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
        CompletableFuture<IntercomHttpResponse<SyncPagingIterable<Note>>> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        NoteList parsedResponse =
                                ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), NoteList.class);
                        int newPageNumber =
                                request.getPage().map(page -> page + 1).orElse(1);
                        ListContactNotesRequest nextRequest = ListContactNotesRequest.builder()
                                .from(request)
                                .page(newPageNumber)
                                .build();
                        List<Note> result = parsedResponse.getData();
                        future.complete(new IntercomHttpResponse<>(
                                new SyncPagingIterable<Note>(true, result, () -> {
                                    try {
                                        return list(nextRequest, requestOptions)
                                                .get()
                                                .body();
                                    } catch (InterruptedException | ExecutionException e) {
                                        throw new RuntimeException(e);
                                    }
                                }),
                                response));
                        return;
                    }
                    String responseBodyString = responseBody != null ? responseBody.string() : "{}";
                    try {
                        if (response.code() == 404) {
                            future.completeExceptionally(new NotFoundError(
                                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class), response));
                            return;
                        }
                    } catch (JsonProcessingException ignored) {
                        // unable to map error response, throwing generic error
                    }
                    future.completeExceptionally(new IntercomApiException(
                            "Error with status code " + response.code(),
                            response.code(),
                            ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class),
                            response));
                    return;
                } catch (IOException e) {
                    future.completeExceptionally(new IntercomException("Network error executing HTTP request", e));
                }
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                future.completeExceptionally(new IntercomException("Network error executing HTTP request", e));
            }
        });
        return future;
    }

    /**
     * You can add a note to a single contact.
     */
    public CompletableFuture<IntercomHttpResponse<Note>> create(CreateContactNoteRequest request) {
        return create(request, null);
    }

    /**
     * You can add a note to a single contact.
     */
    public CompletableFuture<IntercomHttpResponse<Note>> create(
            CreateContactNoteRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("contacts")
                .addPathSegment(request.getContactId())
                .addPathSegments("notes")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (JsonProcessingException e) {
            throw new IntercomException("Failed to serialize request", e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        CompletableFuture<IntercomHttpResponse<Note>> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        future.complete(new IntercomHttpResponse<>(
                                ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), Note.class), response));
                        return;
                    }
                    String responseBodyString = responseBody != null ? responseBody.string() : "{}";
                    try {
                        if (response.code() == 404) {
                            future.completeExceptionally(new NotFoundError(
                                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class), response));
                            return;
                        }
                    } catch (JsonProcessingException ignored) {
                        // unable to map error response, throwing generic error
                    }
                    future.completeExceptionally(new IntercomApiException(
                            "Error with status code " + response.code(),
                            response.code(),
                            ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class),
                            response));
                    return;
                } catch (IOException e) {
                    future.completeExceptionally(new IntercomException("Network error executing HTTP request", e));
                }
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                future.completeExceptionally(new IntercomException("Network error executing HTTP request", e));
            }
        });
        return future;
    }

    /**
     * You can fetch the details of a single note.
     */
    public CompletableFuture<IntercomHttpResponse<Note>> find(FindNoteRequest request) {
        return find(request, null);
    }

    /**
     * You can fetch the details of a single note.
     */
    public CompletableFuture<IntercomHttpResponse<Note>> find(FindNoteRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("notes")
                .addPathSegment(request.getNoteId())
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
        CompletableFuture<IntercomHttpResponse<Note>> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        future.complete(new IntercomHttpResponse<>(
                                ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), Note.class), response));
                        return;
                    }
                    String responseBodyString = responseBody != null ? responseBody.string() : "{}";
                    try {
                        switch (response.code()) {
                            case 401:
                                future.completeExceptionally(new UnauthorizedError(
                                        ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class),
                                        response));
                                return;
                            case 404:
                                future.completeExceptionally(new NotFoundError(
                                        ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class),
                                        response));
                                return;
                        }
                    } catch (JsonProcessingException ignored) {
                        // unable to map error response, throwing generic error
                    }
                    future.completeExceptionally(new IntercomApiException(
                            "Error with status code " + response.code(),
                            response.code(),
                            ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class),
                            response));
                    return;
                } catch (IOException e) {
                    future.completeExceptionally(new IntercomException("Network error executing HTTP request", e));
                }
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                future.completeExceptionally(new IntercomException("Network error executing HTTP request", e));
            }
        });
        return future;
    }
}
