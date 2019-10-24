package com.mavenmasters.digibooky.domain.db;

import com.mavenmasters.digibooky.domain.book.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class BookDBTest {

    Database books;

    @BeforeEach
    void init() {
        books = new BookDB();
    }


    @Test
    void givenABookDB_whenCreated_thenContains10Books() {
        Assertions.assertEquals(10, books.getAll().size());
    }

    @Test
    void givenABookDB_whenGettingAllBooks_thenReturnBooksWithISBNTitleAuthorLastNameAndAuthorFirstName() {
        List<Book> result = new ArrayList(books.getAll().values());
        for (Book book : result) {
            Assertions.assertNotEquals("", book.getIsbn().trim());
            Assertions.assertEquals("The life of Brian", book.getTitle());
            Assertions.assertEquals("Tom", book.getAuthor().getFirstName());
            Assertions.assertEquals("Thompson", book.getAuthor().getLastName());
        }
    }
}