package com.intercom.api.integration;

import com.intercom.api.Intercom;
import com.intercom.api.resources.dataattributes.requests.CreateDataAttributeRequest;
import com.intercom.api.resources.dataattributes.requests.ListDataAttributesRequest;
import com.intercom.api.resources.dataattributes.requests.UpdateDataAttributeRequest;
import com.intercom.api.resources.dataattributes.types.DataAttribute;
import com.intercom.api.resources.dataattributes.types.DataAttributesListRequestModel;
import com.intercom.api.types.DataAttributeList;
import com.intercom.api.utils.TestClientFactory;
import com.intercom.api.utils.Utils;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DataAttributesTest {

    private Intercom client;
    private DataAttribute dataAttribute;

    @BeforeEach
    public void before() {
        client = TestClientFactory.create();

        // The workspace we test on has hit the CDA limit, so we can't create any more
        // for now. We should reenable this test once we have a new workspace.
        dataAttribute = client.dataAttributes()
                .create(CreateDataAttributeRequest.builder()
                        .name("Bebech" + Utils.randomString())
                        .model(CreateDataAttributeRequest.Model.CONTACT)
                        .dataType(CreateDataAttributeRequest.DataType.STRING)
                        .description("Dummy description")
                        .build());
    }

    @Test
    public void testCreate() {
        // assert
        Assertions.assertNotNull(dataAttribute);
    }

    @Test
    public void testUpdate() {
        // act
        if (!dataAttribute.getId().isPresent()) {
            throw new RuntimeException("dataAttribute.id is required to update");
        }

        DataAttribute response = client.dataAttributes()
                .update(UpdateDataAttributeRequest.builder()
                        .dataAttributeId(dataAttribute.getId().get().toString())
                        .archived(false)
                        .description("Woo-aaa")
                        .options(List.of(
                                UpdateDataAttributeRequest.OptionsItem.builder()
                                        .value("1-10")
                                        .build(),
                                UpdateDataAttributeRequest.OptionsItem.builder()
                                        .value("11-20")
                                        .build()))
                        .build());

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testList() {
        // act
        DataAttributeList response = client.dataAttributes()
                .list(ListDataAttributesRequest.builder()
                        .includeArchived(true)
                        .model(DataAttributesListRequestModel.CONTACT)
                        .build());

        // assert
        Assertions.assertNotNull(response);
    }
}
