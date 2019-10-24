package com.mavenmasters.digibooky.domain.db;

import com.mavenmasters.digibooky.domain.book.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BookDBTest {

    BookDB booksDatabase;

    @BeforeEach
    void init() {
        booksDatabase = new BookDB();
    }


    @Test
    void givenABookDB_whenCreated_thenContains10Books() {
        Assertions.assertEquals(10, booksDatabase.getAll().size());
    }

    @Test
    void givenABookDB_whenGettingAllBooks_thenReturnBooksWithISBNTitleAuthorLastNameAndAuthorFirstName() {
        List<Book> result = new ArrayList(booksDatabase.getAll().values());
        for (Book book : result) {
            Assertions.assertNotEquals("", book.getIsbn().trim());
            Assertions.assertEquals("The life of Brian", book.getTitle());
            Assertions.assertEquals("Tom", book.getAuthor().getFirstName());
            Assertions.assertEquals("Thompson", book.getAuthor().getLastName());
            Assertions.assertEquals("This is a book summary", book.getSummary());
        }
    }

    @Test
    void givenABookDB_whenSearchingSingleBookByUUID_thenReturnCorrectBook() {
        Book b = (Book) booksDatabase.getAll().values().stream().findFirst().get();
        Assertions.assertEquals(b, booksDatabase.getById(b.getId()));
    }
}