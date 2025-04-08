package com.intercom.api.integration;

import com.intercom.api.Intercom;
import com.intercom.api.resources.dataexport.requests.CancelDataExportRequest;
import com.intercom.api.resources.dataexport.requests.CreateDataExportRequest;
import com.intercom.api.resources.dataexport.requests.FindDataExportRequest;
import com.intercom.api.resources.dataexport.types.DataExport;
import com.intercom.api.utils.TestClientFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DataExportTest {

    private Intercom client;
    private DataExport export;

    @BeforeEach
    public void before() {
        // arrange
        client = TestClientFactory.create();

        export = client.dataExport()
                .create(CreateDataExportRequest.builder()
                        .createdAtAfter(1670000000)
                        .createdAtBefore(1670940528)
                        .build());
    }

    @Test
    public void testCreate() {
        // assert
        Assertions.assertNotNull(export);

        // cleanup
        client.dataExport()
                .cancel(CancelDataExportRequest.builder()
                        .jobIdentifier(export.getJobIdentifier())
                        .build());
    }

    @Test
    public void testFind() {
        // act
        DataExport response = client.dataExport()
                .find(FindDataExportRequest.builder()
                        .jobIdentifier(export.getJobIdentifier())
                        .build());

        // assert
        Assertions.assertNotNull(response);

        // cleanup
        client.dataExport()
                .cancel(CancelDataExportRequest.builder()
                        .jobIdentifier(export.getJobIdentifier())
                        .build());
    }

    @Test
    public void testCancel() {
        // act
        DataExport response = client.dataExport()
                .cancel(CancelDataExportRequest.builder()
                        .jobIdentifier(export.getJobIdentifier())
                        .build());

        // assert
        Assertions.assertNotNull(response);
    }
}
