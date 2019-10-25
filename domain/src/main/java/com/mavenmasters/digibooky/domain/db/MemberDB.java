package com.mavenmasters.digibooky.domain.db;

import com.mavenmasters.digibooky.domain.users.member.Email;
import com.mavenmasters.digibooky.domain.users.member.Member;

import java.util.HashMap;
import java.util.UUID;

public class MemberDB implements Database<UUID, Member> {

    private HashMap<UUID, Member> members = new HashMap<>();

    @Override
    public HashMap<UUID, Member> getAll() {
        return members;
    }

    @Override
    public Member getById(UUID id) {
        return members.get(id);
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
