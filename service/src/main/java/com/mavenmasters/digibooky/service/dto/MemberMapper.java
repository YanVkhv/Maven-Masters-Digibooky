package com.mavenmasters.digibooky.service.dto;

import com.mavenmasters.digibooky.domain.users.member.Member;
import com.mavenmasters.digibooky.domain.users.roles.UserRole;

public class MemberMapper {

    public static Member createMemberDtoToMember(CreateMemberDto createMemberDto) {
        return new Member(createMemberDto.getFirstName()
                , createMemberDto.getLastName()
                , createMemberDto.getEmail()
                , createMemberDto.getInss()
                , createMemberDto.getCity());
    }

    public static MemberDto memberToMemberDto(Member member) {
        return new MemberDto().setUuid(member.getUuid())
                .setInss(member.getInss())
                .setEmail(member.getEmail())
                .setFirstName(member.getFirstName())
                .setLastName(member.getLastName())
                .setCity(member.getCity());
    }

    public static MemberDtoForAdmins memberToMemberDtoForAdmins(Member member) {
        return new MemberDtoForAdmins().setUuid(member.getUuid())
                .setEmail(member.getEmail())
                .setFirstName(member.getFirstName())
                .setLastName(member.getLastName())
                .setCity(member.getCity());
    }

}

