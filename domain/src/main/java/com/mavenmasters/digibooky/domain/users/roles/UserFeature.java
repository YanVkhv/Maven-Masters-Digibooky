package com.mavenmasters.digibooky.domain.users.roles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public enum UserFeature {
    CREATE_MEMBER(UserRole.USER),
    GET_ALL_MEMBERS(UserRole.ADMIN);

    private UserRole[] userRoles;

    UserFeature(UserRole... userRoles) {
        this.userRoles = userRoles;
    }

    public List<UserRole> getUserRoles() {
        return new ArrayList<>(Arrays.asList(userRoles));
    }

    public static List<UserFeature> getUserFeaturesForRoles(List<String> rolesOfUserAsString){
        List<UserRole> rolesOfUser = rolesOfUserAsString.stream()
                .map(UserRole::valueOf)
                .collect(Collectors.toList());
        return Arrays.stream(UserFeature.values())
                .filter(userFeature -> !Collections.disjoint(userFeature.getUserRoles(), rolesOfUser))
                .collect(Collectors.toList());
    }
}
