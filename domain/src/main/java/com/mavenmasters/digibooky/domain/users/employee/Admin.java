package com.mavenmasters.digibooky.domain.users.employee;

import com.mavenmasters.digibooky.domain.users.RegisteredUser;
import com.mavenmasters.digibooky.domain.users.member.Email;
import com.mavenmasters.digibooky.domain.users.roles.UserRole;

public class Admin extends Employee {


    public Admin(String firstName, String lastName, Email email) {
        super(UserRole.ADMIN, firstName, lastName, email);

    }


}
