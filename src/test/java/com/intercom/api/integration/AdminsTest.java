package com.intercom.api.integration;

import com.intercom.api.Intercom;
import com.intercom.api.resources.admins.requests.ConfigureAwayAdminRequest;
import com.intercom.api.resources.admins.requests.FindAdminRequest;
import com.intercom.api.resources.admins.requests.ListAllActivityLogsRequest;
import com.intercom.api.resources.admins.types.Admin;
import com.intercom.api.types.ActivityLogList;
import com.intercom.api.types.AdminList;
import com.intercom.api.utils.TestClientFactory;
import java.time.LocalDate;
import java.time.ZoneOffset;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AdminsTest {

    private Intercom client;
    private String adminId;
    private int adminIdInt;

    @BeforeEach
    public void before() {
        // arrange
        client = TestClientFactory.create();
        adminId = client.admins()
                .list()
                .getAdmins()
                .orElseThrow(() -> new RuntimeException("Admins list is required"))
                .get(0)
                .orElseThrow(() -> new RuntimeException("Admin is required"))
                .getId();
        adminIdInt = Integer.parseInt(adminId);
    }

    @Test
    public void testList() {
        // act
        AdminList response = client.admins().list();

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testFind() {
        // act
        Admin response = client.admins()
                .find(FindAdminRequest.builder().adminId(adminIdInt).build())
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testListAllActivityLogs() {
        // act
        ActivityLogList response = client.admins()
                .listAllActivityLogs(ListAllActivityLogsRequest.builder()
                        .createdAtAfter(LocalDate.parse("2021-12-12")
                                .atStartOfDay()
                                .toInstant(ZoneOffset.UTC)
                                .toString())
                        .createdAtBefore(LocalDate.parse("2022-01-01")
                                .atStartOfDay()
                                .toInstant(ZoneOffset.UTC)
                                .toString())
                        .build());

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testAwayOn() {
        // act
        Admin response = client.admins()
                .away(ConfigureAwayAdminRequest.builder()
                        .adminId(adminIdInt)
                        .awayModeEnabled(true)
                        .awayModeReassign(true)
                        .build())
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testAwayOff() {
        // act
        Admin response = client.admins()
                .away(ConfigureAwayAdminRequest.builder()
                        .adminId(adminIdInt)
                        .awayModeEnabled(false)
                        .awayModeReassign(false)
                        .build())
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        // assert
        Assertions.assertNotNull(response);
    }
}
