package com.mavenmasters.digibooky.service;

import com.mavenmasters.digibooky.domain.users.member.Email;
import com.mavenmasters.digibooky.service.dto.CreateMemberDto;
import com.mavenmasters.digibooky.service.dto.MemberDto;
import com.mavenmasters.digibooky.service.dto.MemberDtoForAdmins;
import com.mavenmasters.digibooky.service.dto.MemberMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemberServiceTest {

    private final MemberService memberService = new MemberService();

    @BeforeEach
    void createStandardMember() {
        CreateMemberDto standardMember = new CreateMemberDto()
                .setInss("inss")
                .setEmail("test@test.com")
                .setLastName("Lastname")
                .setFirstName("FirstName")
                .setCity("City");
        memberService.createMember(standardMember);
    }

    @Test
    void testCreateMemberHappyPath() {
        CreateMemberDto createMemberDto = new CreateMemberDto()
                .setInss("123")
                .setEmail("dsqgdsqg@dsqfgdsgf.sd")
                .setLastName("lazgtzate")
                .setFirstName("FirstName")
                .setCity("cityyyyy");
        MemberDto memberDto = memberService.createMember(createMemberDto);
        Assertions.assertEquals(createMemberDto.getInss(), memberDto.getInss());
        Assertions.assertEquals(createMemberDto.getEmail(), memberDto.getEmail());
        Assertions.assertEquals(createMemberDto.getFirstName(),memberDto.getFirstName());
        Assertions.assertEquals(createMemberDto.getLastName(), memberDto.getLastName());
        Assertions.assertEquals(createMemberDto.getCity(), memberDto.getCity());
    }

    @Test
    void testIfInssOfNewUserIsNotUnique_thenExceptionIsThrown() {
        CreateMemberDto createMemberDto = new CreateMemberDto()
                .setInss("inss")
                .setEmail("dsqgdsqg@dsqfgdsgf.sd")
                .setLastName("lazgtzate")
                .setFirstName("FirstName")
                .setCity("cityyyyy");
        Assertions.assertThrows(IllegalArgumentException.class, () -> memberService.createMember(createMemberDto));
    }

    @Test
    void testIfEmailOfNewUserIsNotUnique_thenExceptionIsThrown() {
        CreateMemberDto createMemberDto = new CreateMemberDto()
                .setInss("123")
                .setEmail("test@test.com")
                .setLastName("lazgtzate")
                .setFirstName("FirstName")
                .setCity("cityyyyy");
        Assertions.assertThrows(IllegalArgumentException.class, () -> memberService.createMember(createMemberDto));
    }

    @Test
    void givenMemberDBWithThreeMembers_whenAdminAsksList_thenListOfAllMembersIsReturned() {
        CreateMemberDto secondMember = new CreateMemberDto().setInss("secondinss").setEmail("second@test.com").setLastName("Lastname").setFirstName("FirstName").setCity("City");
        memberService.createMember(secondMember);
        CreateMemberDto thirdMember = new CreateMemberDto().setInss("thirdinss").setEmail("third@test.com").setLastName("Lastname").setFirstName("FirstName").setCity("City");
        memberService.createMember(thirdMember);
        List<MemberDtoForAdmins> listOfMembersForAdmin = memberService.getAllMembers();
        Assertions.assertTrue(listOfMembersForAdmin.contains(MemberMapper.memberToMemberDtoForAdmins(MemberMapper.createMemberDtoToMember(secondMember))));
        Assertions.assertTrue(listOfMembersForAdmin.contains(MemberMapper.memberToMemberDtoForAdmins(MemberMapper.createMemberDtoToMember(thirdMember))));
    }
}