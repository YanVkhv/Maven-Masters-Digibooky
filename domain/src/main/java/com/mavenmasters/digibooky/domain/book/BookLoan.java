package com.mavenmasters.digibooky.domain.book;

import java.time.LocalDate;
import java.util.UUID;

public class BookLoan {
    private final UUID id, memberId;
    private final String bookIsbn;
    private final LocalDate dueDate;
    private boolean isReturned;

    private static final LocalDate DEFAULT_LENDING_TIME = LocalDate.now().plusWeeks(3);

    public BookLoan(UUID memberId, String bookIsbn, LocalDate dueDate) {
        this.id = UUID.randomUUID();
        this.memberId = memberId;
        this.bookIsbn = bookIsbn;
        this.dueDate = dueDate;
        this.isReturned = false;
    }

    public BookLoan(UUID memberId, String bookIsbn) {
        this(memberId, bookIsbn, DEFAULT_LENDING_TIME);
    }

    public UUID getId() {
        return id;
    }

    public void setReturned(boolean returned) {
        isReturned = returned;
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

    public UUID getMemberId() {
        return memberId;
    }
}
