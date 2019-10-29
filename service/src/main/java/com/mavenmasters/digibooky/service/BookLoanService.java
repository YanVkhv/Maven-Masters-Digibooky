package com.mavenmasters.digibooky.service;

import com.mavenmasters.digibooky.domain.book.BookLoan;
import com.mavenmasters.digibooky.domain.db.BookLoanDB;
import com.mavenmasters.digibooky.service.dto.BookLoanDto;
import com.mavenmasters.digibooky.service.dto.BookLoanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookLoanService {
    private final BookLoanDB bookLoanDB;

    @Autowired
    public BookLoanService(BookLoanDB bookLoanDB) {
        this.bookLoanDB = bookLoanDB;
    }

    public BookLoan addBookLoan(BookLoan bookLoan) {
        return this.bookLoanDB.addBookLoan(bookLoan);
    }

    public BookLoan returnBookLoan(BookLoan bookLoan) {
        return this.bookLoanDB.returnBookLoan(bookLoan.getId());
    }

    public List<BookLoan> getAllBorrowedBooksForMemberId(UUID memberId) {
        return bookLoanDB.getAll().values().stream()
                .filter(bookLoan -> bookLoan.getMemberId().equals(memberId))
                .collect(Collectors.toList());
    }

    public List<BookLoan> getAllOverdueBooks() {
        return bookLoanDB.getAll().values().stream()
                .filter(bookLoan -> bookLoan.getDueDate().isBefore(LocalDate.now()))
                .collect(Collectors.toList());
    }

    public BookLoan getNonReturnedBookLoanByBookUuid(UUID bookId) {
        return bookLoanDB.getNonReturnedBookLoanByBookUuid(bookId);
    }
}
