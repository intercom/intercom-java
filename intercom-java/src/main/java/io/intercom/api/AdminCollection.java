package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AdminCollection extends TypedDataCollection<Admin> {

    public AdminCollection() {
        type = "company.list";
    }

    @Override
    public AdminCollection nextPage() {
        return fetchNextPage(AdminCollection.class);
    }

    @SuppressWarnings("EmptyMethod")
    @JsonProperty("admins")
    @Override
    public List<Admin> getPage() {
        return super.getPage();
    }
}
