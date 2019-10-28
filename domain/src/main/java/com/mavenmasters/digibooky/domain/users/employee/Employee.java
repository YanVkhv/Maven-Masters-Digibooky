package com.mavenmasters.digibooky.domain.users.employee;

import com.mavenmasters.digibooky.domain.users.RegisteredUser;
import com.mavenmasters.digibooky.domain.users.member.Email;
import com.mavenmasters.digibooky.domain.users.roles.UserRole;

public abstract class Employee extends RegisteredUser {

    public Employee(UserRole userRole, String firstName, String lastName, Email email) {
        super(userRole, firstName, lastName, email);
    }
}
