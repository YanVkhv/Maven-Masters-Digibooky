package com.mavenmasters.digibooky.domain.db;

import org.junit.Before;

import static org.junit.jupiter.api.Assertions.*;

class BookDBTest {

    Database books;

    @Before
    void setup() {
        books = new BookDB();
    }


}