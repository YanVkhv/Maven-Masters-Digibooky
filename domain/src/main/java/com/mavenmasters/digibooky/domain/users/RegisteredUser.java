package com.mavenmasters.digibooky.domain.users;

import com.mavenmasters.digibooky.domain.users.member.Email;
import com.mavenmasters.digibooky.domain.users.roles.UserRole;

import java.util.UUID;

public abstract class RegisteredUser {

    private UserRole userRole;
    private final UUID id;
    private final String firstName;
    private final String lastName;
    private final Email email;

    public RegisteredUser(UserRole userRole, String firstName, String lastName, Email email) {
        this.userRole = userRole;
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Email getEmail() {
        return email;
    }

    public UserRole getUserRole() {
        return userRole;
    }

}
