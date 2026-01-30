package com.intercom.api.integration;

import com.intercom.api.Intercom;
import com.intercom.api.core.ObjectMappers;
import com.intercom.api.resources.dataattributes.requests.ListDataAttributesRequest;
import com.intercom.api.resources.dataattributes.requests.UpdateDataAttributeRequest;
import com.intercom.api.resources.dataattributes.types.DataAttribute;
import com.intercom.api.resources.dataattributes.types.DataAttributesListRequestModel;
import com.intercom.api.types.CreateDataAttributeRequest;
import com.intercom.api.types.DataAttributeList;
import com.intercom.api.types.UpdateDataAttributeRequestBody;
import com.intercom.api.utils.TestClientFactory;
import com.intercom.api.utils.Utils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled("Workspace has hit CDA limit - see comment in @BeforeEach")
public class DataAttributesTest {

    private Intercom client;
    private DataAttribute dataAttribute;
    private int dataAttributeId;

    @BeforeEach
    public void before() {
        client = TestClientFactory.create();

        // The workspace we test on has hit the CDA limit, so we can't create any more
        // for now. We should reenable this test once we have a new workspace.
        // CreateDataAttributeRequest is a union type, so we need to use ObjectMapper
        // to construct it with name, model, data_type, and description fields.
        Map<String, Object> createRequestData = new HashMap<>();
        createRequestData.put("name", "Bebech" + Utils.randomString());
        createRequestData.put("model", "contact");
        createRequestData.put("data_type", "string");
        createRequestData.put("description", "Dummy description");

        CreateDataAttributeRequest createRequest =
                ObjectMappers.JSON_MAPPER.convertValue(createRequestData, CreateDataAttributeRequest.class);

        dataAttribute = client.dataAttributes().create(createRequest);
        dataAttributeId = dataAttribute
                .getId()
                .orElseThrow(() -> new RuntimeException("dataAttribute.id is required"));
    }

    @Test
    public void testCreate() {
        // assert
        Assertions.assertNotNull(dataAttribute);
    }

    @Test
    public void testUpdate() {
        // UpdateDataAttributeRequestBody is a union type, so we need to use ObjectMapper
        // to construct it with archived, description, and options fields.
        Map<String, Object> updateBodyData = new HashMap<>();
        updateBodyData.put("archived", false);
        updateBodyData.put("description", "Woo-aaa");
        Map<String, String> option1 = new HashMap<>();
        option1.put("value", "1-10");
        Map<String, String> option2 = new HashMap<>();
        option2.put("value", "11-20");
        updateBodyData.put("options", Arrays.asList(option1, option2));

        UpdateDataAttributeRequestBody updateBody =
                ObjectMappers.JSON_MAPPER.convertValue(updateBodyData, UpdateDataAttributeRequestBody.class);

        DataAttribute response = client.dataAttributes()
                .update(UpdateDataAttributeRequest.builder()
                        .dataAttributeId(dataAttributeId)
                        .body(updateBody)
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
