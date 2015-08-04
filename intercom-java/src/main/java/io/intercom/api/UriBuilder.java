package io.intercom.api;

import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class UriBuilder {

    public static UriBuilder newBuilder() {
        return new UriBuilder(Intercom.getApiBaseURI());
    }

    public static UriBuilder newBuilder(String uri) {
        return new UriBuilder(uri);
    }

    public static UriBuilder newBuilder(URI uri) {
        return new UriBuilder(uri);
    }

    private StringBuilder uri;

    private TreeMap<String, String> paramsMap; // treemap to simplify testing

    private UriBuilder(String uri) {
        try {
            this.uri = new StringBuilder(new URI(uri).toASCIIString());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private UriBuilder(URI uri) {
        this.uri = new StringBuilder(uri.toASCIIString());
    }

    public String buildString() {
        return build().toASCIIString();
    }

    public URI build() {
        if (paramsMap != null) {
            uri.append("?");
            final StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : paramsMap.entrySet()) {
                sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            if (sb.lastIndexOf("&") == sb.length() - 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            uri.append(sb);
        }

        try {
            return new URI(uri.toString());
        } catch (URISyntaxException e) {
            throw new IntercomException("could not create api url", e);
        }
    }

    public UriBuilder path(String path) {
        uri.append("/").append(urlEncode(path));
        return this;
    }

    public UriBuilder path(List<String> path) {
        List<String> urlEncoded =  Lists.newArrayList();
        for (String s : path) {
            urlEncoded.add(urlEncode(s));
        }
        uri.append("/").append(Joiner.on("/").join(urlEncoded));
        return this;
    }

    public UriBuilder query(String param, String value) {
        if (paramsMap == null) {
            paramsMap = Maps.newTreeMap();
        }
        paramsMap.put(urlEncode(param), urlEncode(value));
        return this;
    }

    public UriBuilder query(Map<String, String> params) {
        for (Map.Entry<String, String> entry : params.entrySet()) {
            query(entry.getKey(), entry.getValue());
        }
        return this;
    }

    private String urlEncode(String param) {
        try {
            // URLEncoder is a html forms encoder not a percent encoder
            return java.net.URLEncoder.encode(param, Charsets.UTF_8.name()).replaceAll("\\+", "%20");
        } catch (UnsupportedEncodingException e) {
            throw new IntercomException("could not encode url param " + param, e);
        }
    }
}
