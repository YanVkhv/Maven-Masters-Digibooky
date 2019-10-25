package com.mavenmasters.digibooky.domain.users.employee;

import com.mavenmasters.digibooky.domain.users.RegisteredUser;
import com.mavenmasters.digibooky.domain.users.member.Email;
import com.mavenmasters.digibooky.domain.users.roles.UserRole;

public class Librarian extends RegisteredUser {

    public Librarian(String firstName, String lastName, Email email) {
        super(UserRole.LIBRARIAN, firstName, lastName, email);

    }


}
