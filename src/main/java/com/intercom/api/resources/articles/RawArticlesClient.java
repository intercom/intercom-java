/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.intercom.api.resources.articles;

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
import com.intercom.api.errors.BadRequestError;
import com.intercom.api.errors.NotFoundError;
import com.intercom.api.errors.UnauthorizedError;
import com.intercom.api.resources.articles.requests.CreateArticleRequest;
import com.intercom.api.resources.articles.requests.DeleteArticleRequest;
import com.intercom.api.resources.articles.requests.FindArticleRequest;
import com.intercom.api.resources.articles.requests.ListArticlesRequest;
import com.intercom.api.resources.articles.requests.SearchArticlesRequest;
import com.intercom.api.resources.articles.requests.UpdateArticleRequest;
import com.intercom.api.resources.articles.types.Article;
import com.intercom.api.resources.articles.types.ArticleListItem;
import com.intercom.api.resources.articles.types.SearchArticlesResponse;
import com.intercom.api.types.ArticleList;
import com.intercom.api.types.DeletedArticleObject;
import com.intercom.api.types.Error;
import java.io.IOException;
import java.util.List;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class RawArticlesClient {
    protected final ClientOptions clientOptions;

    public RawArticlesClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * You can fetch a list of all articles by making a GET request to <code>https://api.intercom.io/articles</code>.
     * <blockquote>
     * <p>📘 How are the articles sorted and ordered?</p>
     * <p>Articles will be returned in descending order on the <code>updated_at</code> attribute. This means if you need to iterate through results then we'll show the most recently updated articles first.</p>
     * </blockquote>
     */
    public IntercomHttpResponse<SyncPagingIterable<ArticleListItem>> list() {
        return list(ListArticlesRequest.builder().build());
    }

    /**
     * You can fetch a list of all articles by making a GET request to <code>https://api.intercom.io/articles</code>.
     * <blockquote>
     * <p>📘 How are the articles sorted and ordered?</p>
     * <p>Articles will be returned in descending order on the <code>updated_at</code> attribute. This means if you need to iterate through results then we'll show the most recently updated articles first.</p>
     * </blockquote>
     */
    public IntercomHttpResponse<SyncPagingIterable<ArticleListItem>> list(ListArticlesRequest request) {
        return list(request, null);
    }

    /**
     * You can fetch a list of all articles by making a GET request to <code>https://api.intercom.io/articles</code>.
     * <blockquote>
     * <p>📘 How are the articles sorted and ordered?</p>
     * <p>Articles will be returned in descending order on the <code>updated_at</code> attribute. This means if you need to iterate through results then we'll show the most recently updated articles first.</p>
     * </blockquote>
     */
    public IntercomHttpResponse<SyncPagingIterable<ArticleListItem>> list(
            ListArticlesRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("articles");
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
                ArticleList parsedResponse =
                        ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), ArticleList.class);
                int newPageNumber = request.getPage().map(page -> page + 1).orElse(1);
                ListArticlesRequest nextRequest = ListArticlesRequest.builder()
                        .from(request)
                        .page(newPageNumber)
                        .build();
                List<ArticleListItem> result = parsedResponse.getData();
                return new IntercomHttpResponse<>(
                        new SyncPagingIterable<ArticleListItem>(true, result, () -> list(nextRequest, requestOptions)
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

    /**
     * You can create a new article by making a POST request to <code>https://api.intercom.io/articles</code>.
     */
    public IntercomHttpResponse<Article> create(CreateArticleRequest request) {
        return create(request, null);
    }

    /**
     * You can create a new article by making a POST request to <code>https://api.intercom.io/articles</code>.
     */
    public IntercomHttpResponse<Article> create(CreateArticleRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("articles")
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
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return new IntercomHttpResponse<>(
                        ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), Article.class), response);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            try {
                switch (response.code()) {
                    case 400:
                        throw new BadRequestError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class), response);
                    case 401:
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

    /**
     * You can fetch the details of a single article by making a GET request to <code>https://api.intercom.io/articles/&lt;id&gt;</code>.
     */
    public IntercomHttpResponse<Article> find(FindArticleRequest request) {
        return find(request, null);
    }

    /**
     * You can fetch the details of a single article by making a GET request to <code>https://api.intercom.io/articles/&lt;id&gt;</code>.
     */
    public IntercomHttpResponse<Article> find(FindArticleRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("articles")
                .addPathSegment(request.getArticleId())
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
                        ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), Article.class), response);
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
     * You can update the details of a single article by making a PUT request to <code>https://api.intercom.io/articles/&lt;id&gt;</code>.
     */
    public IntercomHttpResponse<Article> update(UpdateArticleRequest request) {
        return update(request, null);
    }

    /**
     * You can update the details of a single article by making a PUT request to <code>https://api.intercom.io/articles/&lt;id&gt;</code>.
     */
    public IntercomHttpResponse<Article> update(UpdateArticleRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("articles")
                .addPathSegment(request.getArticleId())
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
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return new IntercomHttpResponse<>(
                        ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), Article.class), response);
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
     * You can delete a single article by making a DELETE request to <code>https://api.intercom.io/articles/&lt;id&gt;</code>.
     */
    public IntercomHttpResponse<DeletedArticleObject> delete(DeleteArticleRequest request) {
        return delete(request, null);
    }

    /**
     * You can delete a single article by making a DELETE request to <code>https://api.intercom.io/articles/&lt;id&gt;</code>.
     */
    public IntercomHttpResponse<DeletedArticleObject> delete(
            DeleteArticleRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("articles")
                .addPathSegment(request.getArticleId())
                .build();
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl)
                .method("DELETE", null)
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
                        ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), DeletedArticleObject.class),
                        response);
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
     * You can search for articles by making a GET request to <code>https://api.intercom.io/articles/search</code>.
     */
    public IntercomHttpResponse<SearchArticlesResponse> search() {
        return search(SearchArticlesRequest.builder().build());
    }

    /**
     * You can search for articles by making a GET request to <code>https://api.intercom.io/articles/search</code>.
     */
    public IntercomHttpResponse<SearchArticlesResponse> search(SearchArticlesRequest request) {
        return search(request, null);
    }

    /**
     * You can search for articles by making a GET request to <code>https://api.intercom.io/articles/search</code>.
     */
    public IntercomHttpResponse<SearchArticlesResponse> search(
            SearchArticlesRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("articles/search");
        if (request.getPhrase().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "phrase", request.getPhrase().get(), false);
        }
        if (request.getState().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "state", request.getState().get(), false);
        }
        if (request.getHelpCenterId().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "help_center_id", request.getHelpCenterId().get().toString(), false);
        }
        if (request.getHighlight().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "highlight", request.getHighlight().get().toString(), false);
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
                return new IntercomHttpResponse<>(
                        ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), SearchArticlesResponse.class),
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
