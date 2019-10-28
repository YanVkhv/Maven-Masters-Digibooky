package com.mavenmasters.digibooky.domain.exceptions;

public class InvalidEmailAddressException extends RuntimeException {

    public static final String THIS_IS_NOT_A_VALID_EMAIL_ADDRESS = "This is not a valid email address";

    public InvalidEmailAddressException() {
        super(THIS_IS_NOT_A_VALID_EMAIL_ADDRESS);
    }

    public InvalidEmailAddressException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidEmailAddressException(Throwable cause) {
        super(cause);
    }

}
