package io.intercom.api;

public class RateLimitException extends IntercomException {

    private static final long serialVersionUID = -6100754169056165622L;

    public RateLimitException(String message) {
        super(message);
    }

    public RateLimitException(String message, Throwable cause) {
        super(message, cause);
    }

    public RateLimitException(ErrorCollection errorCollection) {
        super(errorCollection);
    }

    public RateLimitException(ErrorCollection errorCollection, Throwable cause) {
        super(errorCollection, cause);
    }
}
