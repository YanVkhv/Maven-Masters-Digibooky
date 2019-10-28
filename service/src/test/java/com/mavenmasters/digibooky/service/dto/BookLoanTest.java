package com.mavenmasters.digibooky.service.dto;

import com.mavenmasters.digibooky.domain.book.BookLoan;
import com.mavenmasters.digibooky.domain.db.BookLoanDB;
import com.mavenmasters.digibooky.service.BookLoanService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

class BookLoanTest {

    BookLoanService bookLoanService = new BookLoanService(new BookLoanDB());

    @Test
    void givenABookLoan_whenReturningBook_thenReturnAppropriateMessage() {
        BookLoan bookLoan = new BookLoan(UUID.randomUUID(), "456789123", LocalDate.now().plusDays(1));
        bookLoanService.addBookLoan(bookLoan);
        BookLoanDto bookLoanDto = bookLoanService.returnBookLoan(bookLoan);
        Assertions.assertEquals(bookLoanDto.getReturnMessage(), "Thank you for returning on time.");
    }

    @Test
    void givenABookLoan_whenReturningOverdueBook_thenReturnAppropriateMessage() {
        BookLoan bookLoan = new BookLoan(UUID.randomUUID(), "456789123", LocalDate.now().minusWeeks(3));
        bookLoanService.addBookLoan(bookLoan);
        BookLoanDto bookLoanDto = bookLoanService.returnBookLoan(bookLoan);
        Assertions.assertEquals(bookLoanDto.getReturnMessage(), "You are 21 days late.");
    }
}