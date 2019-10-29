package com.mavenmasters.digibooky.domain.users.member;

import com.mavenmasters.digibooky.domain.users.RegisteredUser;
import com.mavenmasters.digibooky.domain.users.roles.UserRole;

public class Member extends RegisteredUser {

    private final String inss;
    private String city;
    private int overdueFines;


    public Member(String firstName, String lastName, Email email, String inss, String city) {
        super(UserRole.MEMBER, firstName, lastName, email);
        this.city = city;
        this.inss = inss;
    }

    public String getInss() {
        return inss;
    }

    public String getCity() {
        return city;
    }

    public int getOverdueFines() {
        return overdueFines;
    }

    public void setOverdueFines(int overdueFines) {
        this.overdueFines = overdueFines;
    }

    public void addOverdueFine(int overdueFine){
        this.overdueFines += overdueFine;
    }
}
