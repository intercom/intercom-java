package com.intercom.api.integration;

import com.intercom.api.Intercom;
import com.intercom.api.core.pagination.SyncPagingIterable;
import com.intercom.api.resources.contacts.types.Contact;
import com.intercom.api.resources.events.requests.ListEventsRequest;
import com.intercom.api.types.CreateDataEventRequest;
import com.intercom.api.types.DataEventSummary;
import com.intercom.api.types.MultipleFilterSearchRequest;
import com.intercom.api.types.SearchRequest;
import com.intercom.api.types.SingleFilterSearchRequest;
import com.intercom.api.types.StartingAfterPaging;
import com.intercom.api.utils.TestClientFactory;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EventsTest {

    Intercom client;
    String userId;

    @BeforeEach
    public void before() {
        // arrange
        client = TestClientFactory.create();

        List<SingleFilterSearchRequest> value = new ArrayList<>();
        SingleFilterSearchRequest query1 = SingleFilterSearchRequest.builder()
                .field("role")
                .operator(SingleFilterSearchRequest.Operator.EQUALS)
                .value(SingleFilterSearchRequest.Value.of("user"))
                .build();
        value.add(query1);
        SingleFilterSearchRequest query2 = SingleFilterSearchRequest.builder()
                .field("external_id")
                .operator(SingleFilterSearchRequest.Operator.NOT_EQUALS)
                .value(Optional.empty())
                .build();
        value.add(query2);

        SyncPagingIterable<Contact> randomUsers = client.contacts()
                .search(SearchRequest.builder()
                        .query(SearchRequest.Query.of(MultipleFilterSearchRequest.builder()
                                .operator(MultipleFilterSearchRequest.Operator.AND)
                                .value(MultipleFilterSearchRequest.Value.ofListOfSingleFilterSearchRequest(value))
                                .build()))
                        .pagination(StartingAfterPaging.builder().perPage(1).build())
                        .build());

        userId = randomUsers.getItems().get(0).getExternalId().orElse("");
        if (userId.isEmpty()) {
            throw new RuntimeException("userId is required to run tests");
        }
    }

    @Test
    public void testCreate() {
        // assert
        Assertions.assertDoesNotThrow(() -> {
            Map<String, String> metadata = new HashMap<>();
            metadata.put("guidance", "provided");
            metadata.put("wereall", "gonna make it");
            metadata.put("price", "9001");

            client.events()
                    .create(CreateDataEventRequest.of(CreateDataEventRequest.WithUserId.builder()
                            .userId(userId)
                            .eventName("opinion-rejected")
                            .createdAt((int) new Date().toInstant().getEpochSecond())
                            .metadata(metadata)
                            .build()));
        });
    }

    @Test
    public void testListBy() {
        // act
        DataEventSummary response = client.events()
                .list(ListEventsRequest.builder()
                        .type("user")
                        .userId(userId)
                        .perPage(2)
                        .summary(true)
                        .build());

        // assert
        Assertions.assertNotNull(response);
    }
}
