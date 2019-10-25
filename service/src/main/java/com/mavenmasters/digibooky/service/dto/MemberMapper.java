package com.mavenmasters.digibooky.service.dto;

import com.mavenmasters.digibooky.domain.member.Member;

public class MemberMapper {

    public static Member createMemberDtoToMember(CreateMemberDto createMemberDto) {
        return new Member(createMemberDto.getInss()
                , createMemberDto.getEmail()
                , createMemberDto.getFirstName()
                , createMemberDto.getLastName()
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

