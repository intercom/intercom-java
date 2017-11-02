package io.intercom.api;

import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("UnusedDeclaration")
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventCollection  extends TypedDataCollection<Event> implements Iterator<Event> {
  protected TypedDataCollectionIterator<Event> iterator;

  public EventCollection() {
    iterator = new TypedDataCollectionIterator<Event>(this);
  }

  public EventCollection(List<Event> events) {
    this();
    this.page = events;
  }

  @SuppressWarnings("EmptyMethod")
  @JsonProperty("events")
  @Override
  public List<Event> getPage() {
    return super.getPage();
  }

  @Override
  public EventCollection nextPage() {
    return fetchNextPage(EventCollection.class);
  }

  public boolean hasNext() {
    return iterator.hasNext();
  }

  public Event next() {
    return iterator.next();
  }

  public void remove() {
    iterator.remove();
  }
}
