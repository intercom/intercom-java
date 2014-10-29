package io.intercom.api;

import java.util.Iterator;
import java.util.NoSuchElementException;

class TypedDataCollectionIterator<T extends TypedData> implements Iterator<T> {

    private TypedDataCollection<T> rollingCollection;
    private int pos;

    public TypedDataCollectionIterator(TypedDataCollection<T> startingCollection) {
        this.rollingCollection = startingCollection;
        this.pos = 0;
    }

    public boolean hasNext() {
        if (pos == rollingCollection.getPage().size()) {
            if (rollingCollection.hasNextPage()) {
                rollingCollection = rollingCollection.nextPage();
                pos = 0;
                return true;
            } else {
                return false;
            }
        } else {
            return pos <= rollingCollection.getPage().size();
        }
    }

    public T next() {
        iterate();
        final T t = rollingCollection.getPage().get(pos);
        pos++;
        return t;
    }

    private void iterate() {
        if (pos == rollingCollection.getPage().size()) {
            if (rollingCollection.hasNextPage()) {
                rollingCollection = rollingCollection.nextPage();
                pos = 0;
            } else {
                throw new NoSuchElementException();
            }
        }
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
