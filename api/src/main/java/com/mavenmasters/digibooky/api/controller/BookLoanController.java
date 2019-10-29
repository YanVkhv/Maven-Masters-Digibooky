package com.mavenmasters.digibooky.api.controller;

import com.mavenmasters.digibooky.service.BookLoanService;
import com.mavenmasters.digibooky.service.dto.BookLoanDto;
import com.mavenmasters.digibooky.service.dto.BookLoanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/books")
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
    public BookLoanDto addBookLoanDto(@RequestBody BookLoanDto bookLoanDto) {
        bookLoanService.addBookLoan(BookLoanMapper.mapDtoToBookLoan(bookLoanDto));
        return bookLoanDto;
    }

    //TODO GetAllBorrowedBooksForMemberId
    @GetMapping(path = "/loans/getAll/{memberId}")
    @ResponseStatus(HttpStatus.OK)
    public List<BookLoanDto> getAllBorrowedBooksForMemberId(@PathVariable String memberId) {
        return bookLoanService.getAllBorrowedBooksForMemberId(UUID.fromString(memberId));
    }

    //TODO getAllOverdueBooks
    @GetMapping(path = "/loans/getAllOverdue")
    @ResponseStatus(HttpStatus.OK)
    public List<BookLoanDto> getAllOverdueBooks() {
        return bookLoanService.getAllOverdueBooks();
    }

    //TODO returnBookLoan
    @PostMapping(path = "/loans/returnBookLoan")
    @ResponseStatus(HttpStatus.OK)
    public BookLoanDto returnBookLoan(@RequestBody BookLoanDto bookLoanDto) {
        bookLoanService.returnBookLoan(BookLoanMapper.mapDtoToBookLoan(bookLoanDto));
        return bookLoanDto;
    }

    //TODO getNonReturnedBookLoanByBookUuid
    @GetMapping(path = "/loans/getBookLoanById/{bookId}")
    @ResponseStatus(HttpStatus.OK)
    public BookLoanDto getNonReturnedBookLoanByBookUuid(@PathVariable String bookId) {
        return BookLoanMapper.mapToDto(bookLoanService.getNonReturnedBookLoanByBookUuid(UUID.fromString(bookId)));
    }
}
