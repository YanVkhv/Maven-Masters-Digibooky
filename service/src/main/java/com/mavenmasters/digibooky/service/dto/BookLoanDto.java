package com.mavenmasters.digibooky.service.dto;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class BookLoanDto {
    private UUID memberUUID;
    private String bookIsbn;
    private LocalDate dueDate;
    private boolean isReturned;
    private String returnMessage;


    public BookLoanDto(UUID memberUUID, String bookIsbn, LocalDate dueDate, boolean isReturned) {
        this.memberUUID = memberUUID;
        this.bookIsbn = bookIsbn;
        this.dueDate = dueDate;
        this.isReturned = isReturned;
        this.returnMessage = generateAppropriateMessage();
    }

    private String generateAppropriateMessage() {
        if (dueDate.isBefore(LocalDate.now())) {
            return "You are " + ChronoUnit.DAYS.between(dueDate, LocalDate.now()) + " days late.";
        }
        return "Thank you for returning on time.";
    }

    public String getReturnMessage() {
        return returnMessage;
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

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }


}
