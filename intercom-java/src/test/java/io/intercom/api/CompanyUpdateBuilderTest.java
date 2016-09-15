package io.intercom.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Map;

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

    @Test
    public void shouldIncludeCustomAttributes() throws Exception {

        final Company withCustomAttributes = new Company().setName("Weyland Corp").setCompanyID("2093");

        withCustomAttributes.addCustomAttribute(CustomAttribute.newIntegerAttribute("foodstuff-items", 246));
        withCustomAttributes.addCustomAttribute(CustomAttribute.newStringAttribute("bestseller", "fruity oaty bar"));

        final List<CompanyWithStringPlan> updatedCompanies = CompanyUpdateBuilder.buildUserUpdateCompanies(new CompanyCollection(Lists.newArrayList(withCustomAttributes)), null);

        CompanyWithStringPlan weylandCorp = null;

        for (CompanyWithStringPlan updatedCompany : updatedCompanies) {
            if (updatedCompany.getCompanyID().equals("2093")) {
                weylandCorp = updatedCompany;
            }
        }

        assertNotNull(weylandCorp);
        assertNotNull(weylandCorp.getCustomAttributes());
        Map<String, CustomAttribute> retrievedAttributes = weylandCorp.getCustomAttributes();

        assertNotNull(retrievedAttributes.get("foodstuff-items"));
        assertTrue(retrievedAttributes.get("foodstuff-items").getValue().equals(246));
        assertNotNull(retrievedAttributes.get("bestseller"));
        assertTrue(retrievedAttributes.get("bestseller").getValue().equals("fruity oaty bar"));


    }

}