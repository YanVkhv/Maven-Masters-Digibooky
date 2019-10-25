package com.mavenmasters.digibooky.service;

import com.mavenmasters.digibooky.domain.db.MemberDB;
import com.mavenmasters.digibooky.domain.users.member.Member;
import com.mavenmasters.digibooky.service.dto.CreateMemberDto;
import com.mavenmasters.digibooky.service.dto.MemberDto;
import com.mavenmasters.digibooky.service.dto.MemberDtoForAdmins;
import com.mavenmasters.digibooky.service.dto.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {

    private final MemberDB members;

    @Autowired
    public MemberService() {
        this.members = new MemberDB();
    }

    public MemberDto createMember(CreateMemberDto createMemberDto) {
        if (members.containsEmailOrInss(createMemberDto.getEmail(), createMemberDto.getInss())) {
            throw new IllegalArgumentException("This email and/or INSS number already exist(s) in our database.");
        }
        Member member = MemberMapper.createMemberDtoToMember(createMemberDto);
        members.addMember(member);
        return MemberMapper.memberToMemberDto(member);
    }

    public List<MemberDtoForAdmins> getAllMembers() {
        return members.getAll()
                .values()
                .stream()
                .map(MemberMapper::memberToMemberDtoForAdmins)
                .collect(Collectors.toList());

    }
}
