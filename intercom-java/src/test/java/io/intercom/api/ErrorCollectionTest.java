package io.intercom.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class ErrorCollectionTest {

    private static ObjectMapper mapper;

    @BeforeClass
    public static void beforeClass() {
        mapper = TestSupport.objectMapper();
    }

    @Test
    public void load() throws Exception {
        String json = TestSupport.load("errors.json");
        final ErrorCollection errors = mapper.readValue(json, ErrorCollection.class);
        assertTrue(errors.getErrors().size() == 2);
    }

    @Test
    public void dontload() {
        try {
            new ErrorCollection(null);
            fail();
        } catch (NullPointerException ignored) {
        }

        try {
            new ErrorCollection(Lists.<Error>newArrayList());
            fail();
        } catch (IllegalArgumentException ignored) {
        }

    }

}