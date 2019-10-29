package com.mavenmasters.digibooky.service.dto;

import com.mavenmasters.digibooky.service.BookLoanService;

import java.time.LocalDate;
import java.util.UUID;

public class ReturnBookLoanDTO extends BookLoanDto {
    private String returnMessage;

    public ReturnBookLoanDTO(UUID memberUUID, String bookIsbn, LocalDate dueDate, boolean isReturned, String returnMessage) {
        super(memberUUID, bookIsbn, dueDate, isReturned);
        this.returnMessage = returnMessage;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }
}
