package io.intercom.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CompanyUpdateBuilderTest {

    private static ObjectMapper mapper;

    @BeforeClass
    public static void beforeClass() {
        mapper = MapperSupport.objectMapper();
    }


    @Test
    public void testRemove() throws Exception {

        final Company bacon = new Company().setCompanyID("bacon");
        final Company pancake = new Company().setCompanyID("pancake");

        final List<CompanyWithStringPlan> cos = CompanyUpdateBuilder.buildUserUpdateCompanies(
            new CompanyCollection(Lists.newArrayList(pancake)),
            new CompanyCollection(Lists.newArrayList(bacon))
        );

        Boolean baconIsRemoved = null;
        Boolean pancakeIsRemoved = null;

        CompanyWithStringPlan baconCo = null;
        CompanyWithStringPlan pancakeCo = null;

        for (CompanyWithStringPlan co : cos) {
            if (co.getCompanyID().equals("pancake")) {
                pancakeIsRemoved = co.getRemove();
                pancakeCo = co;
            }

            if (co.getCompanyID().equals("bacon")) {
                baconIsRemoved = co.getRemove();
                baconCo = co;
            }

        }
        assertNull(pancakeIsRemoved);
        assertTrue(baconIsRemoved);

        final String pancakeJson = mapper.writeValueAsString(pancakeCo);
        assertFalse(pancakeJson.contains("remove"));
        assertFalse(pancakeJson.contains("true"));

        final String baconJson = mapper.writeValueAsString(baconCo);
        assertTrue(baconJson.contains("remove"));
        assertTrue(baconJson.contains("true"));
    }

}