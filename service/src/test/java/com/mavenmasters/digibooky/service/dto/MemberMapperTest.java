package com.mavenmasters.digibooky.service.dto;

import com.mavenmasters.digibooky.domain.exceptions.InvalidEmailAddressException;
import com.mavenmasters.digibooky.domain.users.member.Email;
import com.mavenmasters.digibooky.domain.users.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class MemberMapperTest {

    @Test
    void createMemberDtoToMemberTestHappyPath() {
        CreateMemberDto createMemberDto = new CreateMemberDto().setCity("city").setInss("isnn").setEmail("new@member.com").setFirstName("firstname");

        Member member = MemberMapper.createMemberDtoToMember(createMemberDto);

        Assertions.assertThat(member.getCity()).isEqualTo(createMemberDto.getCity());
        Assertions.assertThat(member.getCity()).isEqualTo(createMemberDto.getCity());
        Assertions.assertThat(member.getFirstName()).isEqualTo(createMemberDto.getFirstName());
    }

    @Test
    void createMemberDtoToMemberTestEmailWrong() {
        CreateMemberDto createMemberDto = new CreateMemberDto().setCity("city").setInss("isnn").setEmail("newmember.com").setFirstName("firstname");

        Assertions.assertThatThrownBy(() -> MemberMapper.createMemberDtoToMember(createMemberDto)).isExactlyInstanceOf(InvalidEmailAddressException.class);
    }

    @Test
    void memberToMemberDtoTestHappyPath() {
        Member member = new Member("first", "last", new Email("new@member.com"), "inss", "city");
        MemberDto memberDto = MemberMapper.memberToMemberDto(member);

        Assertions.assertThat(memberDto.getCity()).isEqualTo(member.getCity());
        Assertions.assertThat(memberDto.getFirstName()).isEqualTo(member.getFirstName());
        Assertions.assertThat(memberDto.getInss()).isEqualTo(member.getInss());
        Assertions.assertThat(memberDto.getLastName()).isEqualTo(member.getLastName());
        Assertions.assertThat(memberDto.getEmail()).isEqualTo(member.getEmail());
        Assertions.assertThat(memberDto.getUuid().equals(member.getId()));
    }

    @Test
    void memberToMemberDtoForAdminsTestHappyPath() {
        Member member = new Member("first", "last", new Email("new@member.com"), "inss", "city");
        MemberDtoForAdmins memberDto = MemberMapper.memberToMemberDtoForAdmins(member);

        Assertions.assertThat(memberDto.getCity()).isEqualTo(member.getCity());
        Assertions.assertThat(memberDto.getFirstName()).isEqualTo(member.getFirstName());
        Assertions.assertThat(memberDto.getLastName()).isEqualTo(member.getLastName());
        Assertions.assertThat(memberDto.getEmail()).isEqualTo(member.getEmail());
        Assertions.assertThat(memberDto.getUuid().equals(member.getId()));
    }
}