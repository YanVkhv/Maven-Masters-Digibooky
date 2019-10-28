package com.mavenmasters.digibooky.domain.db;

import com.mavenmasters.digibooky.domain.book.BookLoan;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.UUID;

@Repository
public class BookLoanDB implements Database {
    private HashMap<UUID, BookLoan> bookLoans;

    public BookLoanDB() {
        this.bookLoans = new HashMap<>();
    }

    @Override
    public HashMap<UUID, BookLoan> getAll() {
        return this.bookLoans;
    }

    @Override
    public BookLoan getById(UUID id) {
        return bookLoans.entrySet().stream().filter(uuidBookLoanEntry -> uuidBookLoanEntry.getKey().equals(id))
                .findFirst()
                .get()
                .getValue();
    }

    public BookLoan addBookLoan(BookLoan bookLoan) {
        this.bookLoans.put(bookLoan.getId(), bookLoan);
        return bookLoan;
    }

    public BookLoan returnBookLoan(UUID bookLoanId) {
        BookLoan bookLoan = this.getById(bookLoanId);
        bookLoan.setReturned(true);
        bookLoans.put(bookLoan.getId(), bookLoan);
        return bookLoan;
    }
}
