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
        this(getMessage(errorCollection));
        this.errorCollection = errorCollection;
    }

    public static String getMessage(ErrorCollection errorCollection) {
        String message = "Could not read error message from server";
        if(errorCollection!=null
            && errorCollection.getErrors() != null
            && errorCollection.getErrors().size() > 0
            && errorCollection.getErrors().get(0) != null
            && errorCollection.getErrors().get(0).getMessage() != null){
            message = errorCollection.getErrors().get(0).getMessage();
        }
        return message;
    }

    @SuppressWarnings("WeakerAccess")
    public IntercomException(ErrorCollection errorCollection, Throwable cause) {
        this(getMessage(errorCollection), cause);
        this.errorCollection = errorCollection;
    }

    public ErrorCollection getErrorCollection() {
        return errorCollection;
    }

    public Error getFirstError() {
        return errorCollection.getErrors().get(0);
    }
}
