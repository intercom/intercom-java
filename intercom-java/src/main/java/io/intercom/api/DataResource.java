package io.intercom.api;

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

    public static <T, R> R update(T entity, String collectionPath, Class<R> response) {
        final HttpClient resource = new HttpClient(UriBuilder.newBuilder().path(collectionPath).build());
        return resource.post(response, entity);
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

}
