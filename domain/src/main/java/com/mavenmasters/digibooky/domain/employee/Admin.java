package com.mavenmasters.digibooky.domain.employee;

import com.mavenmasters.digibooky.domain.member.Email;

import java.util.UUID;

public class Admin {
    private final UUID id;
    private final String firstName;
    private final String lastName;
    private final Email email;


    public Admin(String firstName, String lastName, Email email) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }



}
