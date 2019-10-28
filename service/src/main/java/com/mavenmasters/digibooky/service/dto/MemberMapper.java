package com.mavenmasters.digibooky.service.dto;

import com.mavenmasters.digibooky.domain.users.member.Email;
import com.mavenmasters.digibooky.domain.users.member.Member;

public class MemberMapper {

    public static Member createMemberDtoToMember(CreateMemberDto createMemberDto) {
        return new Member(createMemberDto.getFirstName()
                , createMemberDto.getLastName()
                , new Email(createMemberDto.getEmail())
                , createMemberDto.getInss()
                , createMemberDto.getCity());
    }

    public static MemberDto memberToMemberDto(Member member) {
        return new MemberDto().setUuid(member.getId())
                .setInss(member.getInss())
                .setEmail(member.getEmail())
                .setFirstName(member.getFirstName())
                .setLastName(member.getLastName())
                .setCity(member.getCity());
    }

    public static MemberDtoForAdmins memberToMemberDtoForAdmins(Member member) {
        return new MemberDtoForAdmins().setUuid(member.getId())
                .setEmail(member.getEmail())
                .setFirstName(member.getFirstName())
                .setLastName(member.getLastName())
                .setCity(member.getCity());
    }

}

