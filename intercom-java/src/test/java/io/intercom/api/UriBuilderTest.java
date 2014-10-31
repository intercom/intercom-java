package io.intercom.api;

import com.google.common.collect.Maps;
import org.junit.Test;

import java.net.URI;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class UriBuilderTest {

    @Test
    public void builder() {
        final UriBuilder uriBuilder = UriBuilder.newBuilder("http://example.org");
        final HashMap<String, String> map = Maps.newHashMap();
        map.put("c", "quux");
        map.put("b", "bar");
        map.put("a", "foo");
        URI uri = uriBuilder.query(map).build();
        assertEquals("http://example.org?a=foo&b=bar&c=quux", uri.toASCIIString());
    }

    @Test
    public void buildPath() {
        final UriBuilder uriBuilder = UriBuilder.newBuilder("http://example.org");
        final String s = uriBuilder.path("users").path("3142").build().toASCIIString();
        assertEquals("http://example.org/users/3142", s);
    }


    @Test
    public void buildPathMix() {
        final UriBuilder uriBuilder = UriBuilder.newBuilder("http://example.org");
        final HashMap<String, String> map = Maps.newHashMap();
        map.put("c", "quu x"); // check we're encoding ws as '%20' and not '+'
        map.put("b", "bar");
        map.put("a", "foo");
        // check that adding params before paths works
        final String s = uriBuilder.query(map).path("users").path("3142").buildString();
        assertEquals("http://example.org/users/3142?a=foo&b=bar&c=quu%20x", s);
    }


}