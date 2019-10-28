package com.mavenmasters.digibooky.service;

import com.mavenmasters.digibooky.domain.book.BookLoan;
import com.mavenmasters.digibooky.domain.db.BookLoanDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookLoanService {
    private final BookLoanDB bookLoanDB;

    @Autowired
    public BookLoanService(BookLoanDB bookLoanDB) {
        this.bookLoanDB = bookLoanDB;
    }

    public BookLoan addBookLoan(BookLoan bookLoan) {
        this.bookLoanDB.addBookLoan(bookLoan);
        return bookLoan;
    }
}
