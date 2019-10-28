package com.mavenmasters.digibooky.domain.db;

import com.mavenmasters.digibooky.domain.users.member.Email;
import com.mavenmasters.digibooky.domain.users.member.Member;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.UUID;

@Repository
public class MemberDB implements Database {

    private HashMap<UUID, Member> members = new HashMap<>();

    @Override
    public HashMap<UUID, Member> getAll() {
        return members;
    }

    @Override
    public Object getById(UUID id) {
        return null;
    }

    public Member addMember(Member member) {
        members.put(member.getId(), member);
        return member;
    }

    public boolean containsEmailOrInss(Email email, String inss) {
        for (Member member : members.values()) {
            if (member.getEmail().equals(email) || member.getInss() == inss) {
                return true;
            }
        }
        return false;
    }
}
