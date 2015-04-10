package io.intercom.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.intercom.api.TestSupport.load;
import static org.junit.Assert.assertTrue;

public class SocialProfileTest {


    private static ObjectMapper mapper;

    @BeforeClass
    public static void beforeClass() {
        mapper = MapperSupport.objectMapper();
    }

    @Test
    public void testURLMarshalling() throws Exception {
        String json = load("social_profile_url_1.json");
        SocialProfile socialProfile = mapper.readValue(json, SocialProfile.class);
        assertTrue(socialProfile.getUrl() != null);

        json = load("social_profile_url_2.json");
        socialProfile = mapper.readValue(json, SocialProfile.class);
        assertTrue(socialProfile.getUrl() != null);

        json = load("social_profile_url_3.json");
        socialProfile = mapper.readValue(json, SocialProfile.class);
        assertTrue(socialProfile.getUrl() == null);

        json = load("social_profile_url_4.json");
        socialProfile = mapper.readValue(json, SocialProfile.class);
        assertTrue(socialProfile.getUrl() != null);
    }

}