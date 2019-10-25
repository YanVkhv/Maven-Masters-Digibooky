package com.mavenmasters.digibooky.service.dto;

import com.mavenmasters.digibooky.domain.users.member.Email;

public class CreateEmployeeDto {

    private String firstName;
    private String lastName;
    private Email email;

    public String getFirstName() {
        return firstName;
    }

    public CreateEmployeeDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public CreateEmployeeDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Email getEmail() {
        return email;
    }

    public CreateEmployeeDto setEmail(Email email) {
        this.email = email;
        return this;
    }
}
