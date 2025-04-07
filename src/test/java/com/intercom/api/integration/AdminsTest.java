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

    @BeforeEach
    public void before() {
        // arrange
        client = TestClientFactory.create();
        adminId = client.admins().list().getAdmins().get(0).getId();
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
        Admin response =
                client.admins().find(FindAdminRequest.builder().adminId(adminId).build());

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
                        .adminId(adminId)
                        .awayModeEnabled(true)
                        .awayModeReassign(true)
                        .build());

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testAwayOff() {
        // act
        Admin response = client.admins()
                .away(ConfigureAwayAdminRequest.builder()
                        .adminId(adminId)
                        .awayModeEnabled(false)
                        .awayModeReassign(false)
                        .build());

        // assert
        Assertions.assertNotNull(response);
    }
}
