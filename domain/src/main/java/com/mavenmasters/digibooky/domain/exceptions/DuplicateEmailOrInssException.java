package com.mavenmasters.digibooky.domain.exceptions;

public class DuplicateEmailOrInssException extends RuntimeException {

    public static final String THIS_EMAIL_AND_OR_INSS_NUMBER_ALREADY_EXIST_S_IN_OUR_DATABASE = "This email and/or INSS number already exist(s) in our database.";

    public DuplicateEmailOrInssException() {
        super(THIS_EMAIL_AND_OR_INSS_NUMBER_ALREADY_EXIST_S_IN_OUR_DATABASE);
    }

    public DuplicateEmailOrInssException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateEmailOrInssException(Throwable cause) {
        super(cause);
    }


}
