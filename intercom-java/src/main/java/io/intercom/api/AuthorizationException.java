package io.intercom.api;

public class AuthorizationException extends IntercomException {

    private static final long serialVersionUID = 2917082281352001861L;

    public AuthorizationException(String message) {
        super(message);
    }

    public AuthorizationException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthorizationException(ErrorCollection errorCollection) {
        super(errorCollection);
    }

    public AuthorizationException(ErrorCollection errorCollection, Throwable cause) {
        super(errorCollection, cause);
    }
}
