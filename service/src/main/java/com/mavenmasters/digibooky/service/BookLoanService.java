package com.mavenmasters.digibooky.service;

import com.mavenmasters.digibooky.domain.book.BookLoan;
import com.mavenmasters.digibooky.domain.db.BookLoanDB;
import com.mavenmasters.digibooky.service.dto.BookLoanDto;
import com.mavenmasters.digibooky.service.dto.BookLoanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookLoanService {
    private final BookLoanDB bookLoanDB;
    private final MemberService memberService;

    @Autowired
    public BookLoanService(BookLoanDB bookLoanDB, MemberService memberService) {
        this.bookLoanDB = bookLoanDB;
        this.memberService = memberService;
    }

    public BookLoanDto addBookLoan(BookLoanDto bookLoanDto) {
        return BookLoanMapper.mapToDto(this.bookLoanDB.addBookLoan(BookLoanMapper.mapDtoToBookLoan(bookLoanDto)));
    }

    public BookLoanDto returnBookLoan(BookLoan bookLoan) {

        return BookLoanMapper.mapToReturnBookLoanDto(this.bookLoanDB.returnBookLoan(bookLoan.getId()),generateAppropriateMessage(bookLoan));
    }

    public List<BookLoanDto> getAllBorrowedBooksForMemberId(UUID memberId) {
        return bookLoanDB.getAll().values().stream()
                .filter(bookLoan -> bookLoan.getMemberId().equals(memberId))
                .map(BookLoanMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public List<BookLoanDto> getAllOverdueBooks() {
        return bookLoanDB.getAll().values().stream()
                .filter(bookLoan -> bookLoan.getDueDate().isBefore(LocalDate.now()))
                .map(bookLoan1 -> BookLoanMapper.mapToDto(bookLoan1))
                .collect(Collectors.toList());
    }

    public BookLoan getNonReturnedBookLoanByBookUuid(UUID bookId) {
        return bookLoanDB.getNonReturnedBookLoanByBookUuid(bookId);
    }

    private String generateAppropriateMessage(BookLoan bookLoan) {
        if (bookLoan.getDueDate().isBefore(LocalDate.now())) {
            return "You are " + calculateDaysOverdue(bookLoan) + " days late. Your overdue fine is " + calculateOverdueFine(bookLoan) + ".";
        }
        return "Thank you for returning on time.";
    }

    private int calculateDaysOverdue(BookLoan bookLoan) {
        return Math.toIntExact(ChronoUnit.DAYS.between(bookLoan.getDueDate(), LocalDate.now()));
    }

    private int calculateOverdueFine(BookLoan bookLoan) {
        return 5 + 2 * calculateDaysOverdue(bookLoan)/7;
    }
}
