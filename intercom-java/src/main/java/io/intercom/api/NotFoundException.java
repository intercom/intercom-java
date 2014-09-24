package io.intercom.api;

public class NotFoundException extends IntercomException {

    private static final long serialVersionUID = 2917082281352001861L;

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(ErrorCollection errorCollection) {
        super(errorCollection);
    }

    public NotFoundException(ErrorCollection errorCollection, Throwable cause) {
        super(errorCollection, cause);
    }
}
