package com.mavenmasters.digibooky.service;

import com.mavenmasters.digibooky.domain.book.BookLoan;
import com.mavenmasters.digibooky.domain.db.BookLoanDB;
import com.mavenmasters.digibooky.service.dto.BookLoanDto;
import com.mavenmasters.digibooky.service.dto.BookLoanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookLoanService {
    private final BookLoanDB bookLoanDB;

    @Autowired
    public BookLoanService(BookLoanDB bookLoanDB) {
        this.bookLoanDB = bookLoanDB;
    }

    public BookLoanDto addBookLoan(BookLoan bookLoan) {
        return BookLoanMapper.mapToDto(this.bookLoanDB.addBookLoan(bookLoan));
    }

    public BookLoanDto returnBookLoan(BookLoan bookLoan) {
        return BookLoanMapper.mapToDto(this.bookLoanDB.returnBookLoan(bookLoan.getId()));
    }
}
