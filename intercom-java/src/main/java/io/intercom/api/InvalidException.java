package io.intercom.api;

public class InvalidException extends IntercomException {

    private static final long serialVersionUID = -2111295679006526646L;

    public InvalidException(String message) {
        super(message);
    }

    public InvalidException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidException(ErrorCollection errorCollection) {
        super(errorCollection);
    }

    public InvalidException(ErrorCollection errorCollection, Throwable cause) {
        super(errorCollection, cause);
    }
}
