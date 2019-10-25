package com.mavenmasters.digibooky.api.controller;


import com.mavenmasters.digibooky.service.MemberService;
import com.mavenmasters.digibooky.service.dto.CreateMemberDto;
import com.mavenmasters.digibooky.service.dto.MemberDto;
import com.mavenmasters.digibooky.service.dto.MemberDtoForAdmins;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/digibooky/users")
public class UserController {
    private final MemberService memberService;

    @Autowired
    public UserController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping(path = "/{createMemberDto}")
    public MemberDto createMember(@PathVariable CreateMemberDto createMemberDto) {
        return memberService.createMember(createMemberDto);
    }

    @GetMapping
    public List<MemberDtoForAdmins> getAllMembers() {
        return memberService.getAllMembers();
    }

}
