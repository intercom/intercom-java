package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.net.URI;
import java.util.List;
import java.util.Map;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties({"page"})
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public abstract class TypedDataCollection<T extends TypedData> extends TypedData {

    public static final String NEXT_PAGE_REL = "next";

    protected List<T> page = Lists.newArrayList();

    @JsonProperty("pages")
    protected Map<String, URI> pages = Maps.newHashMap();

    @JsonProperty("type")
    protected String type;

    public abstract TypedDataCollection<T> nextPage();

    public boolean hasNextPage() {
        return pages.containsKey("next") && pages.get("next") != null;
    }

    public List<T> getPage() {
        return ImmutableList.<T>builder().addAll(page).build();
    }

    protected <C extends TypedDataCollection<T>> C fetchNextPage(Class<C> typeReference) {
        if (hasNextPage()) {
            final URI next = UriBuilder.newBuilder(pages.get(TypedDataCollection.NEXT_PAGE_REL)).build();
            final HttpClient resource = new HttpClient(next);
            return resource.get(typeReference);
        } else {
            return null;
        }
    }

    public Map<String, URI> getPages() {
        return ImmutableMap.<String, URI>builder().putAll(pages).build();
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypedDataCollection that = (TypedDataCollection) o;

        if (page != null ? !page.equals(that.page) : that.page != null) return false;
        if (pages != null ? !pages.equals(that.pages) : that.pages != null) return false;
        //noinspection RedundantIfStatement
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = page != null ? page.hashCode() : 0;
        result = 31 * result + (pages != null ? pages.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getType() + "{" +
            "page=" + page +
            "} " + super.toString();
    }
}
