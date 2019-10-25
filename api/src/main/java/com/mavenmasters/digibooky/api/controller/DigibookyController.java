package com.mavenmasters.digibooky.api.controller;


import com.mavenmasters.digibooky.service.BookService;
import com.mavenmasters.digibooky.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/digibooky")
public class DigibookyController {
    private final MemberService memberService;
    private final BookService bookService;

    @Autowired
    public DigibookyController(MemberService memberService, BookService bookService) {
        this.memberService = memberService;
        this.bookService = bookService;
    }



}
