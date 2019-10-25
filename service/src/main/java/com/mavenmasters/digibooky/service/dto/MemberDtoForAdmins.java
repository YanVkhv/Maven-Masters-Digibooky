package com.mavenmasters.digibooky.service.dto;

import com.mavenmasters.digibooky.domain.users.member.Email;

import java.util.Objects;
import java.util.UUID;

public class MemberDtoForAdmins {

    private UUID uuid;
    private Email email;
    private String firstName;
    private String lastName;
    private String city;

    public UUID getUuid() {
        return uuid;
    }

    public MemberDtoForAdmins setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public Email getEmail() {
        return email;
    }

    public MemberDtoForAdmins setEmail(Email email) {
        this.email = email;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public MemberDtoForAdmins setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getCity() {
        return city;
    }

    public MemberDtoForAdmins setCity(String city) {
        this.city = city;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public MemberDtoForAdmins setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberDtoForAdmins that = (MemberDtoForAdmins) o;
        return Objects.equals(email, that.email) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, email, firstName, lastName, city);
    }
}
