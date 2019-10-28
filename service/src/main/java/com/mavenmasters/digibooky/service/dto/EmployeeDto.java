package com.mavenmasters.digibooky.service.dto;

import com.mavenmasters.digibooky.domain.users.member.Email;

import java.util.UUID;

public class EmployeeDto {

    private UUID id;
    private String firstName;
    private String lastName;
    private Email email;

    public UUID getId() {
        return id;
    }

    public EmployeeDto setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public EmployeeDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public EmployeeDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Email getEmail() {
        return email;
    }

    public EmployeeDto setEmail(Email email) {
        this.email = email;
        return this;
    }

}
