package io.intercom.api;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

import java.util.List;

class JobSupport {


    public void validateJobItem(JobItem item, List<String> methods) {
        if (!methods.contains(item.getMethod())) {
            final String message = String.format(
                "job method [%s] not allowed, must be one of "
                    + Joiner.on(", ").join(methods), item.getMethod()
            );
            throw new InvalidException(
                new ErrorCollection(
                    Lists.newArrayList(
                        new Error("invalid", message))));
        }
    }

}
