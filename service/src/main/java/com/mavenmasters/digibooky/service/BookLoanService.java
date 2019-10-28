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

    public BookLoanDto addBookLoan(BookLoan bookLoan) {
        return BookLoanMapper.mapToDto(this.bookLoanDB.addBookLoan(bookLoan));
    }

    public BookLoanDto returnBookLoan(BookLoan bookLoan) {
        return BookLoanMapper.mapToDto(this.bookLoanDB.returnBookLoan(bookLoan.getId()));
    }

    public List<BookLoanDto> getAllBorrowedBooks(UUID id) {
        return bookLoanDB.getAll().values().stream()
                .filter(bookLoan -> bookLoan.getMemberId().equals(id))
                .map(BookLoanMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public List<BookLoanDto> getAllOverdueBooks() {
        return bookLoanDB.getAll().values().stream()
                .filter(bookLoan -> bookLoan.getDueDate().isBefore(LocalDate.now()))
                .map(BookLoanMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public BookLoan getNonReturnedBookLoanByBookUuid(UUID id) {
        return bookLoanDB.getNonReturnedBookLoanByBookUuid(id);
    }
}
