/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.intercom.api.resources.phonecallredirects;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.intercom.api.core.ClientOptions;
import com.intercom.api.core.IntercomApiException;
import com.intercom.api.core.IntercomException;
import com.intercom.api.core.IntercomHttpResponse;
import com.intercom.api.core.MediaTypes;
import com.intercom.api.core.ObjectMappers;
import com.intercom.api.core.RequestOptions;
import com.intercom.api.errors.BadRequestError;
import com.intercom.api.errors.UnauthorizedError;
import com.intercom.api.errors.UnprocessableEntityError;
import com.intercom.api.resources.phonecallredirects.requests.CreatePhoneCallRedirectRequest;
import com.intercom.api.types.Error;
import com.intercom.api.types.PhoneSwitch;
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

public class AsyncRawPhoneCallRedirectsClient {
    protected final ClientOptions clientOptions;

    public AsyncRawPhoneCallRedirectsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * You can use the API to deflect phone calls to the Intercom Messenger.
     * Calling this endpoint will send an SMS with a link to the Messenger to the phone number specified.
     * <p>If custom attributes are specified, they will be added to the user or lead's custom data attributes.</p>
     */
    public CompletableFuture<IntercomHttpResponse<PhoneSwitch>> create(CreatePhoneCallRedirectRequest request) {
        return create(request, null);
    }

    /**
     * You can use the API to deflect phone calls to the Intercom Messenger.
     * Calling this endpoint will send an SMS with a link to the Messenger to the phone number specified.
     * <p>If custom attributes are specified, they will be added to the user or lead's custom data attributes.</p>
     */
    public CompletableFuture<IntercomHttpResponse<PhoneSwitch>> create(
            CreatePhoneCallRedirectRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("phone_call_redirects")
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
        CompletableFuture<IntercomHttpResponse<PhoneSwitch>> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        future.complete(new IntercomHttpResponse<>(
                                ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), PhoneSwitch.class),
                                response));
                        return;
                    }
                    String responseBodyString = responseBody != null ? responseBody.string() : "{}";
                    try {
                        switch (response.code()) {
                            case 400:
                                future.completeExceptionally(new BadRequestError(
                                        ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class),
                                        response));
                                return;
                            case 401:
                                future.completeExceptionally(new UnauthorizedError(
                                        ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class),
                                        response));
                                return;
                            case 422:
                                future.completeExceptionally(new UnprocessableEntityError(
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
