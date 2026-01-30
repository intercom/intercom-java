package com.intercom.api.integration;

import com.intercom.api.Intercom;
import com.intercom.api.resources.teams.requests.FindTeamRequest;
import com.intercom.api.resources.teams.types.Team;
import com.intercom.api.types.TeamList;
import com.intercom.api.utils.TestClientFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamsTest {

    private Intercom client;
    private String teamId;

    @BeforeEach
    public void before() {
        // arrange
        client = TestClientFactory.create();
        teamId = client.teams()
                .list()
                .getTeams()
                .orElseThrow(() -> new RuntimeException("Teams list is required"))
                .get(0)
                .getId()
                .orElseThrow(() -> new RuntimeException("Team ID is required"));
    }

    @Test
    public void testList() {
        // act
        TeamList response = client.teams().list();

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testFind() {
        // act
        Team response =
                client.teams().find(FindTeamRequest.builder().teamId(teamId).build());

        // assert
        Assertions.assertNotNull(response);
    }
}
