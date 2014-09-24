package io.intercom.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import java.io.IOException;

public class TestSupport {

    public static String load(String name) throws IOException {
        return Resources.toString(Resources.getResource(name), Charsets.UTF_8);
    }

    public static ObjectMapper objectMapper() {
        return MapperSupport.objectMapper();
    }

}
