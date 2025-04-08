/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.intercom.api.resources.admins;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.intercom.api.core.ClientOptions;
import com.intercom.api.core.IntercomApiException;
import com.intercom.api.core.IntercomException;
import com.intercom.api.core.MediaTypes;
import com.intercom.api.core.ObjectMappers;
import com.intercom.api.core.QueryStringMapper;
import com.intercom.api.core.RequestOptions;
import com.intercom.api.errors.NotFoundError;
import com.intercom.api.errors.UnauthorizedError;
import com.intercom.api.resources.admins.requests.ConfigureAwayAdminRequest;
import com.intercom.api.resources.admins.requests.FindAdminRequest;
import com.intercom.api.resources.admins.requests.ListAllActivityLogsRequest;
import com.intercom.api.resources.admins.types.Admin;
import com.intercom.api.types.ActivityLogList;
import com.intercom.api.types.AdminList;
import com.intercom.api.types.AdminWithApp;
import com.intercom.api.types.Error;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
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

public class AsyncAdminsClient {
    protected final ClientOptions clientOptions;

    public AsyncAdminsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * You can view the currently authorised admin along with the embedded app object (a &quot;workspace&quot; in legacy terminology).
     * <blockquote>
     * <p>🚧 Single Sign On</p>
     * <p>If you are building a custom &quot;Log in with Intercom&quot; flow for your site, and you call the <code>/me</code> endpoint to identify the logged-in user, you should not accept any sign-ins from users with unverified email addresses as it poses a potential impersonation security risk.</p>
     * </blockquote>
     */
    public CompletableFuture<AdminWithApp> identify() {
        return identify(null);
    }

    /**
     * You can view the currently authorised admin along with the embedded app object (a &quot;workspace&quot; in legacy terminology).
     * <blockquote>
     * <p>🚧 Single Sign On</p>
     * <p>If you are building a custom &quot;Log in with Intercom&quot; flow for your site, and you call the <code>/me</code> endpoint to identify the logged-in user, you should not accept any sign-ins from users with unverified email addresses as it poses a potential impersonation security risk.</p>
     * </blockquote>
     */
    public CompletableFuture<AdminWithApp> identify(RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("me")
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        CompletableFuture<AdminWithApp> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        future.complete(ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), AdminWithApp.class));
                        return;
                    }
                    String responseBodyString = responseBody != null ? responseBody.string() : "{}";
                    future.completeExceptionally(new IntercomApiException(
                            "Error with status code " + response.code(),
                            response.code(),
                            ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class)));
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
     * You can set an Admin as away for the Inbox.
     */
    public CompletableFuture<Admin> away(ConfigureAwayAdminRequest request) {
        return away(request, null);
    }

    /**
     * You can set an Admin as away for the Inbox.
     */
    public CompletableFuture<Admin> away(ConfigureAwayAdminRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("admins")
                .addPathSegment(request.getAdminId())
                .addPathSegments("away")
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
                .method("PUT", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        CompletableFuture<Admin> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        future.complete(ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), Admin.class));
                        return;
                    }
                    String responseBodyString = responseBody != null ? responseBody.string() : "{}";
                    try {
                        switch (response.code()) {
                            case 401:
                                future.completeExceptionally(new UnauthorizedError(
                                        ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class)));
                                return;
                            case 404:
                                future.completeExceptionally(new NotFoundError(
                                        ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class)));
                                return;
                        }
                    } catch (JsonProcessingException ignored) {
                        // unable to map error response, throwing generic error
                    }
                    future.completeExceptionally(new IntercomApiException(
                            "Error with status code " + response.code(),
                            response.code(),
                            ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class)));
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
     * You can get a log of activities by all admins in an app.
     */
    public CompletableFuture<ActivityLogList> listAllActivityLogs(ListAllActivityLogsRequest request) {
        return listAllActivityLogs(request, null);
    }

    /**
     * You can get a log of activities by all admins in an app.
     */
    public CompletableFuture<ActivityLogList> listAllActivityLogs(
            ListAllActivityLogsRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("admins/activity_logs");
        QueryStringMapper.addQueryParameter(httpUrl, "created_at_after", request.getCreatedAtAfter(), false);
        if (request.getCreatedAtBefore().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "created_at_before", request.getCreatedAtBefore().get(), false);
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
        CompletableFuture<ActivityLogList> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        future.complete(
                                ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), ActivityLogList.class));
                        return;
                    }
                    String responseBodyString = responseBody != null ? responseBody.string() : "{}";
                    try {
                        if (response.code() == 401) {
                            future.completeExceptionally(new UnauthorizedError(
                                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class)));
                            return;
                        }
                    } catch (JsonProcessingException ignored) {
                        // unable to map error response, throwing generic error
                    }
                    future.completeExceptionally(new IntercomApiException(
                            "Error with status code " + response.code(),
                            response.code(),
                            ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class)));
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
     * You can fetch a list of admins for a given workspace.
     */
    public CompletableFuture<AdminList> list() {
        return list(null);
    }

    /**
     * You can fetch a list of admins for a given workspace.
     */
    public CompletableFuture<AdminList> list(RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("admins")
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        CompletableFuture<AdminList> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        future.complete(ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), AdminList.class));
                        return;
                    }
                    String responseBodyString = responseBody != null ? responseBody.string() : "{}";
                    try {
                        if (response.code() == 401) {
                            future.completeExceptionally(new UnauthorizedError(
                                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class)));
                            return;
                        }
                    } catch (JsonProcessingException ignored) {
                        // unable to map error response, throwing generic error
                    }
                    future.completeExceptionally(new IntercomApiException(
                            "Error with status code " + response.code(),
                            response.code(),
                            ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class)));
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
     * You can retrieve the details of a single admin.
     */
    public CompletableFuture<Admin> find(FindAdminRequest request) {
        return find(request, null);
    }

    /**
     * You can retrieve the details of a single admin.
     */
    public CompletableFuture<Admin> find(FindAdminRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("admins")
                .addPathSegment(request.getAdminId())
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
        CompletableFuture<Admin> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        future.complete(ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), Admin.class));
                        return;
                    }
                    String responseBodyString = responseBody != null ? responseBody.string() : "{}";
                    try {
                        switch (response.code()) {
                            case 401:
                                future.completeExceptionally(new UnauthorizedError(
                                        ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class)));
                                return;
                            case 404:
                                future.completeExceptionally(new NotFoundError(
                                        ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class)));
                                return;
                        }
                    } catch (JsonProcessingException ignored) {
                        // unable to map error response, throwing generic error
                    }
                    future.completeExceptionally(new IntercomApiException(
                            "Error with status code " + response.code(),
                            response.code(),
                            ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class)));
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
