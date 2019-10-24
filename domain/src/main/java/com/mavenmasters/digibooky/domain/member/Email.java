package com.mavenmasters.digibooky.domain.member;

import java.util.IllegalFormatException;

public class Email {
    private String email;

    public Email(String email) {
        if (!isValid(email)) {
            throw new IllegalArgumentException("This is not a valid email address");
        }
        this.email = email;
    }

    private boolean isValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }
}
