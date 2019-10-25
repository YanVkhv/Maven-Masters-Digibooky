package com.mavenmasters.digibooky.service;

import com.mavenmasters.digibooky.domain.db.BookLoanDB;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookServiceTest {
    BookLoanDB bookLoanDB;

    @BeforeEach
    void setup() {
        bookLoanDB = new BookLoanDB();
    }

    @Test
    void givenANewBookLoanDB_whenCreated_thenContainsNoBookLoans() {
        Assertions.assertEquals(0, bookLoanDB.getAll().size());
    }

}