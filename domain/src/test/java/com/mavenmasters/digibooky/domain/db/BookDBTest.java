package com.mavenmasters.digibooky.domain.db;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BookDBTest {

    Database books = new BookDB();

    @Test
    void givenABookDB_whenCreated_thenContains10Books() {
        Assertions.assertEquals(10, books.getAll().size());
    }
}