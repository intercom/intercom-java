package io.intercom.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static io.intercom.api.TestSupport.load;
import static org.junit.Assert.*;

public class CompanyTest {
    private static ObjectMapper mapper;

    @BeforeClass
    public static void beforeClass() {
        mapper = MapperSupport.objectMapper();
    }

    @Test
    public void TestCustomAttributes() throws Exception {
        final Map<String, CustomAttribute> customAttributes = Maps.newHashMap();
        final CustomAttribute booleanAttribute = CustomAttribute.newBooleanAttribute("a_boolean", false);
        final CustomAttribute doubleAttribute = CustomAttribute.newDoubleAttribute("a_double", 2.34);
        final CustomAttribute floatAttribute = CustomAttribute.newFloatAttribute("a_float", 1.2f);
        final CustomAttribute integerAttribute = CustomAttribute.newIntegerAttribute("an_integer", 123);
        final CustomAttribute longAttribute = CustomAttribute.newLongAttribute("a_long", 1517833441L);
        final CustomAttribute stringAttribute = CustomAttribute.newStringAttribute("a_string", "a string");
        customAttributes.put(booleanAttribute.getName(), booleanAttribute);
        customAttributes.put(doubleAttribute.getName(), doubleAttribute);
        customAttributes.put(floatAttribute.getName(), floatAttribute);
        customAttributes.put(integerAttribute.getName(), integerAttribute);
        customAttributes.put(longAttribute.getName(), longAttribute);
        customAttributes.put(stringAttribute.getName(), stringAttribute);
        final Company company = new Company()
                .setCustomAttributes(customAttributes);

        final Company companyAddAttributeIndividually = new Company();
        companyAddAttributeIndividually.addCustomAttribute(booleanAttribute);
        companyAddAttributeIndividually.addCustomAttribute(doubleAttribute);
        companyAddAttributeIndividually.addCustomAttribute(floatAttribute);
        companyAddAttributeIndividually.addCustomAttribute(integerAttribute);
        companyAddAttributeIndividually.addCustomAttribute(longAttribute);
        companyAddAttributeIndividually.addCustomAttribute(stringAttribute);

        assertEquals(company.getCustomAttributes().get("a_boolean"), companyAddAttributeIndividually.getCustomAttributes().get("a_boolean"));
        assertEquals(company.getCustomAttributes().get("a_double"), companyAddAttributeIndividually.getCustomAttributes().get("a_double"));
        assertEquals(company.getCustomAttributes().get("a_float"), companyAddAttributeIndividually.getCustomAttributes().get("a_float"));
        assertEquals(company.getCustomAttributes().get("an_integer"), companyAddAttributeIndividually.getCustomAttributes().get("an_integer"));
        assertEquals(company.getCustomAttributes().get("a_long"), companyAddAttributeIndividually.getCustomAttributes().get("a_long"));
        assertEquals(company.getCustomAttributes().get("a_string"), companyAddAttributeIndividually.getCustomAttributes().get("a_string"));
    }
    @Test
    public void TestPrepareUpdatableCompany() throws Exception {
        final long now = System.currentTimeMillis() / 1000;
        final CustomAttribute booleanAttribute = CustomAttribute.newBooleanAttribute("a_boolean", false);
        final CustomAttribute doubleAttribute = CustomAttribute.newDoubleAttribute("a_double", 2.34);
        final CustomAttribute floatAttribute = CustomAttribute.newFloatAttribute("a_float", 1.2f);
        final CustomAttribute integerAttribute = CustomAttribute.newIntegerAttribute("an_integer", 123);
        final CustomAttribute longAttribute = CustomAttribute.newLongAttribute("a_long", 1517833441);
        final CustomAttribute stringAttribute = CustomAttribute.newStringAttribute("a_string", "a string");
        final Company.Plan plan = new Company.Plan("my plan");
        final Company company = new Company()
                .setCompanyID("my_company_id")
                .addCustomAttribute(booleanAttribute)
                .addCustomAttribute(doubleAttribute)
                .addCustomAttribute(floatAttribute)
                .addCustomAttribute(integerAttribute)
                .addCustomAttribute(longAttribute)
                .addCustomAttribute(stringAttribute)
                .setId("1")
                .setIndustry("the industry")
                .setMonthlySpend(123)
                .setName("company name")
                .setPlan(plan)
                .setRemoteCreatedAt(now)
                .setSize(432)
                .setWebsite("https://intercom.com");


        final CompanyCollection companyCollection = new CompanyCollection();
        companyCollection.addCompany(company);
        final List<CompanyWithStringPlan> companyUpdateList = CompanyUpdateBuilder.buildUserUpdateCompanies(companyCollection, null);
        final CompanyWithStringPlan companyUpdate = companyUpdateList.get(0);
        assertEquals("my_company_id", companyUpdate.getCompanyID());
        assertEquals(6, companyUpdate.getCustomAttributes().size());
        assertEquals(false, companyUpdate.getCustomAttributes().get("a_boolean").getValue());
        assertEquals(2.34, companyUpdate.getCustomAttributes().get("a_double").getValue());
        assertEquals(1.2f, companyUpdate.getCustomAttributes().get("a_float").getValue());
        assertEquals(123, companyUpdate.getCustomAttributes().get("an_integer").getValue());
        assertEquals(1517833441L, companyUpdate.getCustomAttributes().get("a_long").getValue());
        assertEquals("a string", companyUpdate.getCustomAttributes().get("a_string").getValue());
        assertEquals("1", companyUpdate.getId());
        assertEquals("the industry", companyUpdate.getIndustry());
        assertEquals(123, companyUpdate.getMonthlySpend(), 0f);
        assertEquals("company name", companyUpdate.getName());
        assertEquals("my plan", companyUpdate.getPlan());
        assertEquals(now, companyUpdate.getRemoteCreatedAt());
        assertEquals(432, companyUpdate.getSize());
        assertEquals("https://intercom.com", companyUpdate.getWebsite());
    }


    @Test
    public void TestReadJsonResponse() throws Exception {
        String json = load("company.json");
        final Company company = mapper.readValue(json, Company.class);
        final TagCollection tagCollection = company.getTagCollection();
        final List<Tag> tags = tagCollection.getPage();
        final SegmentCollection segmentCollection = company.getSegmentCollection();
        final List<Segment> segments = segmentCollection.getPage();
        final Tag tag = tags.get(0);
        final Segment segment1 = segments.get(0);
        final Segment segment2= segments.get(1);
        final Company.Plan plan = company.getPlan();
        assertEquals("6", company.getCompanyID());
        assertEquals("5694b58371b5025a2a0003e6", company.getId());
        assertEquals("Blue Sun", company.getName());
        assertEquals(1452586372, company.getCreatedAt());
        assertEquals(49, company.getMonthlySpend(), 0f);
        assertEquals("plan", plan.getType());
        assertEquals("150154", plan.getId());
        assertEquals("plan1", plan.getName());
        assertEquals(1517835268, company.getUpdatedAt());
        assertEquals(1394531169, company.getRemoteCreatedAt());
        assertEquals(1496292261, company.getLastRequestAt());
        assertEquals(2, company.getSessionCount());
        assertEquals("Manufacturing", company.getIndustry());
        assertEquals("http://www.example.com", company.getWebsite());
        assertEquals(85, company.getSize());
        assertEquals("tag.list", tagCollection.getType());
        assertEquals("tag", tag.getType());
        assertEquals("1072802", tag.getId());
        assertEquals("CompanyTag1", tag.getName());
        assertEquals("segment.list", segmentCollection.getType());
        assertEquals(2, segments.size());
        assertEquals("segment", segment1.getType());
        assertEquals("58b7c061d5cf5649a59f7097", segment1.getId());
        assertEquals("segment", segment2.getType());
        assertEquals("593107f85950a28b168aa9d3", segment2.getId());
        assertEquals(new Integer(1), company.getUserCount());

        final Map<String, CustomAttribute> customAttributes = company.getCustomAttributes();
        CustomAttribute customAttribute;

        customAttribute = customAttributes.get("truthy_typed");
        assertEquals(Boolean.class, customAttribute.getValueClass());
        assertEquals(Boolean.TRUE, customAttribute.getValue());
        assertEquals(Boolean.TRUE, customAttribute.booleanValue());
        assertEquals("truthy_typed", customAttribute.getName());

        customAttribute = customAttributes.get("floatly_typed");
        assertEquals(Double.class, customAttribute.getValueClass());
        assertEquals(155.5d, customAttribute.getValue());
        assertEquals(155.5d, customAttribute.doubleValue(), 0d);
        assertEquals("floatly_typed", customAttribute.getName());

        customAttribute = customAttributes.get("stringly_typed");
        assertEquals(String.class, customAttribute.getValueClass());
        assertEquals("data", customAttribute.getValue());
        assertEquals("data", customAttribute.textValue());
        assertEquals("stringly_typed", customAttribute.getName());

        customAttribute = customAttributes.get("dately_typed_at");
        assertEquals(Long.class, customAttribute.getValueClass());
        assertEquals(1397574667L, customAttribute.getValue());
        assertEquals(1397574667L, customAttribute.longValue());
        assertEquals("dately_typed_at", customAttribute.getName());

        customAttribute = customAttributes.get("longly_typed");
        assertEquals(Long.class, customAttribute.getValueClass());
        assertEquals(221397574667L, customAttribute.getValue());
        assertEquals(221397574667L, customAttribute.longValue());
        assertEquals("longly_typed", customAttribute.getName());

        customAttribute = customAttributes.get("intly_typed");
        assertEquals(Integer.class, customAttribute.getValueClass());
        assertEquals(1, customAttribute.getValue());
        assertEquals(1, customAttribute.integerValue());
        assertEquals("intly_typed", customAttribute.getName());

        // null values are not ignored
        customAttribute = customAttributes.get("nully_typed");
        assertEquals(null, customAttribute);
    }

    @Test
    public void TestReadJsonResponseNoCompanyData() throws Exception {
        String json = load("company_no_data_except_company_id.json");
        final Company company = mapper.readValue(json, Company.class);
        final TagCollection tagCollection = company.getTagCollection();
        final List<Tag> tags = tagCollection.getPage();
        final SegmentCollection segmentCollection = company.getSegmentCollection();
        final List<Segment> segments = segmentCollection.getPage();
        final Company.Plan plan = company.getPlan();
        assertEquals("6", company.getCompanyID());
        assertEquals("5694b58371b5025a2a0003e6", company.getId());
        assertEquals(null, company.getName());
        assertEquals(1452586372, company.getCreatedAt());
        assertEquals(0, company.getMonthlySpend(), 0f);
        assertEquals("plan", plan.getType());
        assertEquals(null, plan.getId());
        assertEquals(null, plan.getName());
        assertEquals(1517835268, company.getUpdatedAt());
        assertEquals(0, company.getRemoteCreatedAt());
        assertEquals(0, company.getLastRequestAt());
        assertEquals(0, company.getSessionCount());
        assertEquals(null, company.getIndustry());
        assertEquals(null, company.getWebsite());
        assertEquals(0, company.getSize());
        assertEquals("tag.list", tagCollection.getType());
        assertEquals(0, tags.size());
        assertEquals("segment.list", segmentCollection.getType());
        assertEquals(0, segments.size());
        assertEquals(new Integer(0), company.getUserCount());

        final Map<String, CustomAttribute> customAttributes = company.getCustomAttributes();
        assertEquals(0, customAttributes.size());
    }

}