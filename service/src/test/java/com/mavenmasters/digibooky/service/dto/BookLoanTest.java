package com.mavenmasters.digibooky.service.dto;

class BookLoanTest {

    /*BookLoanService bookLoanService = new BookLoanService(new BookLoanDB());
    Member member = new Member("Mave", "Rick", new Email("blabla@bla.bla"), "fzoiufbz", "Brussels");

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

    @Test
    void givenAMemberWithBorrowedBooks_whenCallingGetBorrowedBooks_thenGetAllBorrowedBooksForThatMember() {
        BookLoan loan1 = new BookLoan(member.getId(), "fzoifjz", LocalDate.now());
        bookLoanService.addBookLoan(loan1);
        BookLoan loan2 = new BookLoan(member.getId(), "ddsdsd", LocalDate.now());
        bookLoanService.addBookLoan(loan2);
        Assertions.assertTrue(bookLoanService.getAllBorrowedBooksForMemberId(member.getId()).contains(loan1));
        Assertions.assertTrue(bookLoanService.getAllBorrowedBooksForMemberId(member.getId()).contains(loan2));
    }


    @Test
    void givenAMemberWithOverdueBooks_whenCallingGetOverdueBooks_thenGetAllOverdueBooksForThatMember() {
        BookLoan bookLoan = new BookLoan(member.getId(), "fzoifjz", LocalDate.now().minusWeeks(1));
        bookLoanService.addBookLoan(bookLoan);
        List<BookLoanDto> overDueBooks = bookLoanService.getAllOverdueBooks();
        Assertions.assertEquals(overDueBooks.get(0).getBookIsbn(), bookLoan.getBookIsbn());
    }*/
}