package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyCollection extends TypedDataCollection<Company> {

    @JsonProperty("total_count")
    private long totalCount;

    public CompanyCollection() {
        type = "company.list";
    }

    public CompanyCollection(List<Company> companies) {
        this();
        this.page = companies;
    }

    @SuppressWarnings("EmptyMethod")
    @JsonProperty("companies")
    @Override
    public List<Company> getPage() {
        return super.getPage();
    }

    public long getTotalCount() {
        return totalCount;
    }

    @Override
    public CompanyCollection nextPage() {
        return fetchNextPage(CompanyCollection.class);
    }

    @Override
    public String toString() {
        return "CompanyCollection{" +
            ", totalCount=" + totalCount +
            "} " + super.toString();
    }

    void addCompany(Company company) {
        page.add(company);
    }
}
