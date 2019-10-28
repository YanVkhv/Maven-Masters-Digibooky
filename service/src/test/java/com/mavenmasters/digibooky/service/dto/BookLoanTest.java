package com.mavenmasters.digibooky.service.dto;

import com.mavenmasters.digibooky.domain.book.BookLoan;
import com.mavenmasters.digibooky.domain.db.BookLoanDB;
import com.mavenmasters.digibooky.domain.users.member.Email;
import com.mavenmasters.digibooky.domain.users.member.Member;
import com.mavenmasters.digibooky.service.BookLoanService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

class BookLoanTest {

    BookLoanService bookLoanService = new BookLoanService(new BookLoanDB());
    Member member = new Member("Mave", "Rick", new Email("blabla@bla.bla"), "fzoiufbz", "Brussels");

    /*@Test
    void givenABookLoan_whenReturningBook_thenReturnAppropriateMessage() {
        BookLoan bookLoan = new BookLoan(UUID.randomUUID(), "456789123", LocalDate.now().plusDays(1));
        bookLoanService.addBookLoan(BookLoanMapper.mapToDto(bookLoan));
        BookLoanDto bookLoanDto = bookLoanService.returnBookLoan(bookLoan);
        Assertions.assertEquals(bookLoanDto.getReturnMessage(), "Thank you for returning on time.");
    }

    @Test
    void givenABookLoan_whenReturningOverdueBook_thenReturnAppropriateMessage() {
        BookLoan bookLoan = new BookLoan(UUID.randomUUID(), "456789123", LocalDate.now().minusWeeks(3));
        bookLoanService.addBookLoan(BookLoanMapper.mapToDto(bookLoan));
        BookLoanDto bookLoanDto = bookLoanService.returnBookLoan(bookLoan);
        Assertions.assertEquals(bookLoanDto.getReturnMessage(), "You are 21 days late.");
    }*/

    @Test
    void givenAMemberWithBorrowedBooks_whenCallingGetBorrowedBooks_thenGetAllBorrowedBooksForThatMember() {
        bookLoanService.addBookLoan(new BookLoanDto(member.getId(), "fzoifjz", LocalDate.now(), false));
        bookLoanService.addBookLoan(new BookLoanDto(UUID.randomUUID(), "ddsdsd", LocalDate.now(), true));
        List<BookLoanDto> bookLoans = bookLoanService.getAllBorrowedBooks(member.getId());
        Assertions.assertEquals(1, bookLoans.size());
    }

    @Test
    void givenAMemberWithOverdueBooks_whenCallingGetOverdueBooks_thenGetAllOverdueBooksForThatMember() {
        BookLoan bookLoan = new BookLoan(member.getId(), "fzoifjz", LocalDate.now().minusWeeks(1));
        bookLoanService.addBookLoan(BookLoanMapper.mapToDto(bookLoan));
        List<BookLoanDto> overDueBooks = bookLoanService.getAllOverdueBooks();
        Assertions.assertEquals(overDueBooks.get(0).getBookIsbn(), bookLoan.getBookIsbn());
    }
}