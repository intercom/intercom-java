package io.intercom.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static io.intercom.api.TestSupport.load;
import static org.junit.Assert.*;

public class AdminTest {

    private static ObjectMapper mapper;

    @BeforeClass
    public static void beforeClass() {
        mapper = MapperSupport.objectMapper();
    }

    @Test
    public void TestAdminParseJson() throws Exception {
        String json = load("admin.json");
        final Admin admin = mapper.readValue(json, Admin.class);
        assertEquals("admin", admin.getType());
        assertEquals("123456", admin.getId());
        assertEquals("Admin Name", admin.getName());
        assertEquals("admin@domain.com", admin.getEmail());
        assertTrue(admin.getAwayModeEnabled());
        assertFalse(admin.getAwayModeReassign());
        assertEquals( "https://avatarurl.com/image.jpg", admin.getAvatar().getImageURL().toString());
        assertNotNull(admin.getTeamIds());
        assertEquals(3, admin.getTeamIds().size());
        assertTrue(admin.getTeamIds().contains("123"));
        assertTrue(admin.getTeamIds().contains("456"));
        assertTrue(admin.getTeamIds().contains("789"));
    }

    @Test
    public void TestAdminTeamParseJson() throws Exception {
        String json = load("admin_team.json");
        final Admin admin = mapper.readValue(json, Admin.class);
        assertEquals("team", admin.getType());
        assertEquals("654321", admin.getId());
        assertEquals("A Team", admin.getName());
        assertEquals("team-email@teams.intercom.io", admin.getEmail());
        assertFalse(admin.getAwayModeEnabled());
        assertFalse(admin.getAwayModeReassign());
        assertEquals("https://domain.com/avatar", admin.getAvatar().getImageURL().toString());
        assertNotNull(admin.getAdminIds());
        assertEquals(3, admin.getAdminIds().size());
        assertTrue(admin.getAdminIds().contains("321"));
        assertTrue(admin.getAdminIds().contains("654"));
        assertTrue(admin.getAdminIds().contains("987"));
    }


    @Test
    public void TestAdminParseAdminList() throws Exception {
        String json = load("admins.json");
        final AdminCollection adminCollection = mapper.readValue(json, AdminCollection.class);

        assertEquals(6, adminCollection.getPage().size());
    }

    @Test
    public void TestAdminSerialiseDeserialise() throws Exception {
        String json = load("admin.json");
        final Admin admin = mapper.readValue(json, Admin.class);
        final String json1 = mapper.writeValueAsString(admin);
        System.out.println(json1);
        final Admin admin1 = mapper.readValue(json1, Admin.class);
        assertTrue(admin.equals(admin1));
    }

}
