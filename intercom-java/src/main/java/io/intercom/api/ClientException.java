package io.intercom.api;

public class ClientException extends IntercomException {

    private static final long serialVersionUID = -2111295679006526646L;

    public ClientException(String message) {
        super(message);
    }

    public ClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClientException(ErrorCollection errorCollection) {
        super(errorCollection);
    }

    public ClientException(ErrorCollection errorCollection, Throwable cause) {
        super(errorCollection, cause);
    }
}
