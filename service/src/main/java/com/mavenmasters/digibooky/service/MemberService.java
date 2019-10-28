package com.mavenmasters.digibooky.service;

import com.mavenmasters.digibooky.domain.db.MemberDB;
import com.mavenmasters.digibooky.domain.users.member.Email;
import com.mavenmasters.digibooky.domain.users.member.Member;
import com.mavenmasters.digibooky.service.dto.CreateMemberDto;
import com.mavenmasters.digibooky.service.dto.MemberDto;
import com.mavenmasters.digibooky.service.dto.MemberDtoForAdmins;
import com.mavenmasters.digibooky.service.dto.MemberMapper;
import com.mavenmasters.digibooky.service.exceptions.DuplicateEmailOrInssException;
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
//        members.addMember(new Member("First","Last",new Email("test@testmail.test"),"123456789","City"));
    }

    public MemberDto createMember(CreateMemberDto createMemberDto) {
        if (members.containsEmailOrInss(createMemberDto.getEmail(), createMemberDto.getInss())) {
            throw new DuplicateEmailOrInssException();
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
