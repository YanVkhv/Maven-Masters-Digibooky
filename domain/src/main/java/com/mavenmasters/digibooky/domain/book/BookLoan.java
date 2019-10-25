package com.mavenmasters.digibooky.domain.book;

import java.time.LocalDate;
import java.util.UUID;

public class BookLoan {
    private final UUID id, memberId;
    private final String bookIsbn;
    private final LocalDate dueDate;

    private static final LocalDate DEFAULT_LENDING_TIME = LocalDate.now().plusWeeks(3);

    public BookLoan(UUID memberId, String bookIsbn, LocalDate dueDate) {
        this.id = UUID.randomUUID();
        this.memberId = memberId;
        this.bookIsbn = bookIsbn;
        this.dueDate = dueDate;
    }

    public BookLoan(UUID memberId, String bookIsbn) {
        this(memberId, bookIsbn, DEFAULT_LENDING_TIME);
    }

    public UUID getId() {
        return id;
    }
}
