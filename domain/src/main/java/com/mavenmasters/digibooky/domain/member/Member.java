package com.mavenmasters.digibooky.domain.member;

import java.util.UUID;

public class Member {

    private final UUID uuid;
    private final String inss;
    private Email email;
    private final String firstName;
    private final String lastName;
    private String city;


    public Member(String inss, Email email, String firstName, String lastName, String city) {
        this.firstName = firstName;
        this.uuid = UUID.randomUUID();
        this.inss = inss;
        this.email = email;
        this.lastName = lastName;
        this.city = city;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getInss() {
        return inss;
    }

    public Email getEmail() {
        return email;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }

    public String getFirstName() {
        return firstName;
    }
}
