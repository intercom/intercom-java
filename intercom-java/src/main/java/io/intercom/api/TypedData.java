package io.intercom.api;

public interface TypedData {

    default String getType() {
        throw new UnsupportedOperationException();
    }

}
