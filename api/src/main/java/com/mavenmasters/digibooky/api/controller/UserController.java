package com.mavenmasters.digibooky.api.controller;

import com.mavenmasters.digibooky.service.AdminService;
import com.mavenmasters.digibooky.service.MemberService;
import com.mavenmasters.digibooky.service.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/digibooky/users")
public class UserController {
    private final MemberService memberService;
    private final AdminService adminService;

    @Autowired
    public UserController(MemberService memberService, AdminService adminService) {
        this.memberService = memberService;
        this.adminService = adminService;
    }

    @PostMapping(path = "/{createMemberDto}")
    @PreAuthorize("hasAnyRole")
    public MemberDto createMember(@PathVariable CreateMemberDto createMemberDto) {
        return memberService.createMember(createMemberDto);
    }

    @GetMapping
    @PreAuthorize(value = "hasRole('UserRole.ADMIN')")
    public List<MemberDtoForAdmins> getAllMembers() {
        return memberService.getAllMembers();
    }

    @PostMapping(path = "/librarian/{createEmployeeDto}")
    @PreAuthorize(value = "hasRole('UserRole.ADMIN')")
    public EmployeeDto registerNewLibrarian(@PathVariable CreateEmployeeDto createEmployeeDto){
        return adminService.registerNewLibrarian(createEmployeeDto);
    }

    @PostMapping(path = "/admin/{createEmployeeDto}")
    @PreAuthorize(value = "hasRole('UserRole.ADMIN')")
    public EmployeeDto registerNewAdmin(@PathVariable CreateEmployeeDto createEmployeeDto){
        return adminService.registerNewAdmin(createEmployeeDto);
    }

}
