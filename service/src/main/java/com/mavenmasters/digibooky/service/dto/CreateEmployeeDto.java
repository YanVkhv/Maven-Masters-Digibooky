package com.mavenmasters.digibooky.service.dto;

public class CreateEmployeeDto {

    private String firstName;
    private String lastName;
    private String email;

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

    public String getEmail() {
        return email;
    }

    public CreateEmployeeDto setEmail(String email) {
        this.email = email;
        return this;
    }
}
