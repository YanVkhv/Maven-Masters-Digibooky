package com.mavenmasters.digibooky.service;

import com.mavenmasters.digibooky.domain.db.MemberDB;
import com.mavenmasters.digibooky.domain.member.Email;
import com.mavenmasters.digibooky.domain.member.Member;
import com.mavenmasters.digibooky.service.dto.CreateMemberDto;
import com.mavenmasters.digibooky.service.dto.MemberDto;
import com.mavenmasters.digibooky.service.dto.MemberMapper;

public class MemberService {

    private final MemberDB members;


    public MemberService() {
        this.members = new MemberDB();
    }

    public MemberDto createMember(CreateMemberDto createMemberDto){
        if (members.containsEmailOrInss(createMemberDto.getEmail(),createMemberDto.getInss())){
            throw new IllegalArgumentException("This email and/or INSS number already exist(s) in our database.");
        }
        Member member = MemberMapper.createMemberDtoToMember(createMemberDto);
        members.addMember(member);
        return MemberMapper.memberToMemberDto(member);
    }
}
