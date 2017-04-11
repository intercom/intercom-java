package io.intercom.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Lists;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public abstract class ScrollableTypedDataCollection<T extends TypedData> extends TypedData {

    protected List<T> page = Lists.newArrayList();

    @JsonProperty("scroll_param")
    protected String scrollParam;

    @JsonProperty("type")
    protected String type;

    public String getScrollParam() {
        return scrollParam;
    }

    public String getType() {
        return type;
    }

    public abstract ScrollableTypedDataCollection<T> scroll();

    public List<T> getPage() {
        return page;
    }
}
