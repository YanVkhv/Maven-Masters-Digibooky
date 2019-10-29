package com.mavenmasters.digibooky.service.dto;

import com.mavenmasters.digibooky.service.BookLoanService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class BookLoanDto {
    private UUID memberUUID;
    private String bookIsbn;
    private LocalDate dueDate;
    private boolean isReturned;


    public BookLoanDto(UUID memberUUID, String bookIsbn, LocalDate dueDate, boolean isReturned) {
        this.memberUUID = memberUUID;
        this.bookIsbn = bookIsbn;
        this.dueDate = dueDate;
        this.isReturned = isReturned;

    }

    public UUID getMemberUUID() {
        return memberUUID;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean isReturned() {
        return isReturned;
    }

}
