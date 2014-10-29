package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Iterator;
import java.util.List;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyCollection extends TypedDataCollection<Company> implements Iterator<Company> {

    protected TypedDataCollectionIterator<Company> iterator;

    @JsonProperty("total_count")
    private long totalCount;

    public CompanyCollection() {
        type = "company.list";
        iterator = new TypedDataCollectionIterator<Company>(this);
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

    public boolean hasNext() {
        return iterator.hasNext();
    }

    public Company next() {
        return iterator.next();
    }

    public void remove() {
        iterator.remove();
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
