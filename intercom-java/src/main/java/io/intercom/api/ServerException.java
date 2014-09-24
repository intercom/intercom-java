package io.intercom.api;

public class ServerException extends IntercomException {

    private static final long serialVersionUID = 7823280575981918941L;

    public ServerException(String message) {
        super(message);
    }

    public ServerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServerException(ErrorCollection errorCollection) {
        super(errorCollection);
    }

    public ServerException(ErrorCollection errorCollection, Throwable cause) {
        super(errorCollection, cause);
    }
}
