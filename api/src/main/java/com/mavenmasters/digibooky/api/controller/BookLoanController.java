package com.mavenmasters.digibooky.api.controller;

import com.mavenmasters.digibooky.service.BookLoanService;
import com.mavenmasters.digibooky.service.dto.BookLoanDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books/loans")
public class BookLoanController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    private final BookLoanService bookLoanService;

    @Autowired
    public BookLoanController(BookLoanService bookLoanService) {
        this.bookLoanService = bookLoanService;
    }

    //TODO @PreAuthorize(ROLE_LIBRARIAN)
    @PostMapping(path = "/loans/add")
    @ResponseStatus(HttpStatus.CREATED)
    public BookLoanDto BookLoanDto (@RequestBody BookLoanDto bookLoanDto) {
        return bookLoanService.addBookLoan(bookLoanDto);
    }
}
