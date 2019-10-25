package com.mavenmasters.digibooky.domain.db;

import com.mavenmasters.digibooky.domain.member.Email;
import com.mavenmasters.digibooky.domain.member.Member;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
        members.put(member.getUuid(), member);
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
