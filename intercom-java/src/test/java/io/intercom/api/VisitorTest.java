package io.intercom.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static io.intercom.api.TestSupport.load;
import static org.junit.Assert.*;

public class VisitorTest {

    private static ObjectMapper mapper;

    @BeforeClass
    public static void beforeClass() {
        mapper = MapperSupport.objectMapper();
    }

    @Test
    public void TestVisitorUpdate() throws Exception {
        final Avatar avatar = new Avatar()
            .setImageURL("http://example.com/256Wash.jpg");

        final long now = System.currentTimeMillis() / 1000;
        final Visitor visitor = new Visitor()
            .setEmail("wash@serenity.io")
            .setPhone("+1234567890")
            .setID("54321")
            .setUserID("22")
            .setName("Wash")
            .setUnsubscribedFromEmails(true)
            .setLastSeenUserAgent("user-agent")
            .setLastSeenIP("1.2.3.4")
            .setUtmCampaign("utm campaign")
            .setUtmContent("utm content")
            .setUtmMedium("utm medium")
            .setUtmSource("utm source")
            .setUtmTerm("utm term")
            .addCustomAttribute(CustomAttribute.newStringAttribute("test_string", "visitor string"))
            .addCustomAttribute(CustomAttribute.newIntegerAttribute("test_integer", 123))
            .setAvatar(avatar);

        final Visitor.VisitorUpdate visitorUpdate = Visitor.VisitorUpdate.buildFrom(visitor);

        assertEquals("wash@serenity.io", visitorUpdate.getEmail());
        assertEquals("+1234567890", visitorUpdate.getPhone());
        assertEquals("54321", visitorUpdate.getID());
        assertEquals("22", visitorUpdate.getUserID());
        assertEquals("Wash", visitorUpdate.getName());
        assertEquals(true, visitorUpdate.getUnsubscribedFromEmails());
        assertEquals("user-agent", visitorUpdate.getLastSeenUserAgent());
        assertEquals("1.2.3.4", visitorUpdate.getLastSeenIP());
        assertEquals("utm campaign", visitorUpdate.getUtmCampaign());
        assertEquals("utm content", visitorUpdate.getUtmContent());
        assertEquals("utm medium", visitorUpdate.getUtmMedium());
        assertEquals("utm source", visitorUpdate.getUtmSource());
        assertEquals("utm term", visitorUpdate.getUtmTerm());
        assertEquals("http://example.com/256Wash.jpg", visitorUpdate.getAvatar().getImageURL().toString());
        Map<String, CustomAttribute> attributes = visitorUpdate.getCustomAttributes();
        assertEquals(2, attributes.size());
        assertEquals("visitor string", attributes.get("test_string").getValue());
        assertEquals(123, attributes.get("test_integer").getValue());

    }

    @Test
    public void TestVisitorParseJson() throws Exception {
        String json = load("visitor.json");
        final Visitor visitor = mapper.readValue(json, Visitor.class);
        assertEquals("visitor", visitor.getType());
        assertEquals("5b69565fa737210d1c2127f1", visitor.getID());
        assertEquals("6a347bc9-0b96-4925-bbbc-1f8b11f94c50", visitor.getUserID());
        assertEquals("visitor@example.com", visitor.getEmail());
        assertEquals("123456789", visitor.getPhone());
        assertEquals("Violet Star from Singapore", visitor.getPseudonym());
        assertEquals("A Visitor", visitor.getName());

        assertEquals("https://static.intercomassets.com/app/pseudonym_avatars_2018/violet-star.png", visitor.getAvatar().getImageURL().toString());

        Map<String, CustomAttribute> attributes = visitor.getCustomAttributes();
        assertEquals(2, attributes.size());
        assertEquals("visitor string", attributes.get("test_string").getValue());
        assertEquals(123, attributes.get("test_integer").getValue());
        assertEquals("61.6.236.243", visitor.getLastSeenIP());
        assertEquals("Bandar Seri Begawan",visitor.getLocationData().getCity_Name());
        assertEquals("BRN",visitor.getLocationData().getCountryCode());
        assertEquals("Brunei Darussalam",visitor.getLocationData().getCountryName());
        assertEquals("AS",visitor.getLocationData().getContinentCode());
        assertEquals("1234",visitor.getLocationData().getPostalCode());
        assertEquals("a region",visitor.getLocationData().getRegionName());
        assertEquals("Asia/Brunei",visitor.getLocationData().getTimezone());
        assertEquals("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.84 Safari/537.36",visitor.getUserAgentData());
        assertEquals(1533636256,visitor.getLastRequestAt());
        assertEquals(1533630047,visitor.getCreatedAt());
        assertEquals(1533636257,visitor.getUpdatedAt());

        assertEquals("utm campaign", visitor.getUtmCampaign());
        assertEquals("utm content", visitor.getUtmContent());
        assertEquals("utm medium", visitor.getUtmMedium());
        assertEquals("utm source", visitor.getUtmSource());
        assertEquals("utm term", visitor.getUtmTerm());
        assertEquals("the referrer", visitor.getReferrer());
    }

}
