package io.intercom.api;

import com.google.common.collect.Lists;

class Conditions {

    /**
     * Ensures that an object reference passed as a parameter to the calling
     * method is not null. Variant of Guava's Preconditions that returns an
     * InvalidException containing an ErrorCollection
     *
     * @param reference an object reference
     * @param errorMessage the exception message to use if the check fails
     * @return the non-null reference that was validated
     * @throws InvalidException if {@code reference} is null
     */
    public static <T> T checkNotNull(T reference, String errorMessage) {
        if (reference == null) {
            throw new InvalidException(
                new ErrorCollection(
                    Lists.newArrayList(
                        new Error("invalid", "item method must be supplied"))));
        }
        return reference;
    }
}
