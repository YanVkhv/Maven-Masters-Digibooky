package com.mavenmasters.digibooky.service.dto;

import com.mavenmasters.digibooky.domain.users.member.Email;

import java.util.UUID;

public class MemberDto {

    private UUID uuid;
    private String inss;
    private Email email;
    private String firstName;
    private String lastName;
    private String city;

    public UUID getUuid() {
        return uuid;
    }

    public MemberDto setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getInss() {
        return inss;
    }

    public MemberDto setInss(String inss) {
        this.inss = inss;
        return this;
    }

    public Email getEmail() {
        return email;
    }

    public MemberDto setEmail(Email email) {
        this.email = email;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public MemberDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getCity() {
        return city;
    }

    public MemberDto setCity(String city) {
        this.city = city;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public MemberDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
}
