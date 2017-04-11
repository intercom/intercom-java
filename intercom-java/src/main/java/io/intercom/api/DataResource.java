package io.intercom.api;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;

import java.net.URI;
import java.util.List;
import java.util.Map;

abstract class DataResource {

    @SuppressWarnings("SameParameterValue")
    public static <T> T find(String id, String collectionPath, Class<T> c) {
        final HttpClient resource = new HttpClient(UriBuilder.newBuilder().path(collectionPath).path(id).build());
        return resource.get(c);
    }

    public static <T> T find(Map<String, String> params, String collectionPath, Class<T> c) {
        final HttpClient resource = new HttpClient(UriBuilder.newBuilder().path(collectionPath).query(params).build());
        return resource.get(c);
    }

    public static <T, R> R create(T entity, String collectionPath, Class<R> response) {
        final HttpClient resource = new HttpClient(UriBuilder.newBuilder().path(collectionPath).build());
        return resource.post(response, entity);
    }

    public static <T, R> R create(T entity, List<String> paths, Class<R> response) {
        final HttpClient resource = new HttpClient(UriBuilder.newBuilder().path(paths).build());
        return resource.post(response, entity);
    }

    public static <T, R> R update(T entity, String collectionPath, Class<R> response) {
        final HttpClient resource = new HttpClient(UriBuilder.newBuilder().path(collectionPath).build());
        return resource.post(response, entity);
    }

    public static <T, R> R post(T entity, URI path, Class<R> response) {
        final HttpClient resource = new HttpClient(path);
        return resource.post(response, entity);
    }

    public static <T, R> R updatePut(T entity, URI collectionPath, Class<R> response) {
        final HttpClient resource = new HttpClient(collectionPath);
        return resource.put(response, entity);
    }

    @SuppressWarnings("SameParameterValue")
    public static <T, R> R update(T entity, String collectionPath, String id, Class<R> response) {
        final HttpClient resource = new HttpClient(UriBuilder.newBuilder().path(collectionPath).path(id).build());
        return resource.post(response, entity);
    }

    public static <T> T delete(String id, String collectionPath, Class<T> c) {
        final HttpClient resource = new HttpClient(UriBuilder.newBuilder().path(collectionPath).path(id).build());
        return resource.delete(c);
    }

    public static <C> C list(Map<String, String> params, String collectionPath, Class<C> c) {
        final HttpClient resource = new HttpClient(UriBuilder.newBuilder().path(collectionPath).query(params).build());
        return resource.get(c);
    }

    public static <C> C scroll(String scrollParam, String collectionPath, Class<C> c) {
        Map<String, String> params = Maps.newHashMap();
        if (!Strings.isNullOrEmpty(scrollParam)) {
            params.put("scroll_param", scrollParam);
        }
        final HttpClient resource = new HttpClient(UriBuilder.newBuilder().path(collectionPath + "/scroll").query(params).build());
        return resource.get(c);
    }

}
