package io.intercom.api;

public class IntercomException extends RuntimeException {

    private static final long serialVersionUID = -2723350106062183796L;

    private ErrorCollection errorCollection;

    @SuppressWarnings("WeakerAccess")
    public IntercomException(String message) {
        super(message);
    }

    public IntercomException(String message, Throwable cause) {
        super(message, cause);
    }

    public IntercomException(ErrorCollection errorCollection) {
        this(errorCollection.getErrors().get(0).getMessage());
        this.errorCollection = errorCollection;
    }

    @SuppressWarnings("WeakerAccess")
    public IntercomException(ErrorCollection errorCollection, Throwable cause) {
        this(errorCollection.getErrors().get(0).getMessage(), cause);
        this.errorCollection = errorCollection;
    }

    public ErrorCollection getErrorCollection() {
        return errorCollection;
    }

    public Error getFirstError() {
        return errorCollection.getErrors().get(0);
    }
}
