package com.mavenmasters.digibooky.api.controller;

import com.mavenmasters.digibooky.service.AdminService;
import com.mavenmasters.digibooky.service.MemberService;
import com.mavenmasters.digibooky.service.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/users")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    private final MemberService memberService;
    private final AdminService adminService;

    @Autowired
    public UserController(MemberService memberService, AdminService adminService) {
        this.memberService = memberService;
        this.adminService = adminService;
        logger.info("New UserController has been created.");
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
//    @PreAuthorize("hasAnyRole")
    public MemberDto createMember(@RequestBody CreateMemberDto createMemberDto) {
        return memberService.createMember(createMemberDto);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
//    @PreAuthorize(value = "hasRole('UserRole.ADMIN')")
    public List<MemberDtoForAdmins> getAllMembers() {
        return memberService.getAllMembers();
    }

    @PostMapping(path = "/librarian", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
//    @PreAuthorize(value = "hasRole('UserRole.ADMIN')")
    public EmployeeDto registerNewLibrarian(@RequestBody CreateEmployeeDto createEmployeeDto) {
        return adminService.registerNewLibrarian(createEmployeeDto);
    }

    @PostMapping(path = "/admin", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
//    @PreAuthorize(value = "hasRole('UserRole.ADMIN')")
    public EmployeeDto registerNewAdmin(@RequestBody CreateEmployeeDto createEmployeeDto) {
        return adminService.registerNewAdmin(createEmployeeDto);
    }

}
