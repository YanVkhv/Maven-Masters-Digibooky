package com.mavenmasters.digibooky.domain.users;

import com.mavenmasters.digibooky.domain.users.roles.UserRole;

public class User {

    private UserRole userRole;

    public User() {
        this.userRole = UserRole.USER;
    }

    public User(UserRole userRole) {
        this.userRole = userRole;
    }

    UserRole getRole() {
        return this.userRole;
    }

    ;

}
