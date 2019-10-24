package com.mavenmasters.digibooky.domain.db;

import com.mavenmasters.digibooky.domain.book.Author;
import com.mavenmasters.digibooky.domain.book.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BookDBTest {

    BookDB booksDatabase;
    Book bookWithKnownIsbn;

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
        Book book = (Book) booksDatabase.getAll().values().stream().findFirst().get();
        Assertions.assertEquals(book, booksDatabase.getById(book.getId()));
    }

    @Test
    void givenABookDB_whenSearchingSingleBookByISBN_thenReturnCorrectBook() {
        bookWithKnownIsbn = new Book("123456789", "The life of Brian", "This is a book summary", new Author("Tom", "Thompson"));
        booksDatabase.getAll().put(bookWithKnownIsbn.getId(), bookWithKnownIsbn);
        //book.setIsbn("123456789");
        //booksDatabase.getAll().put(book.getId(), book);
        Assertions.assertEquals(bookWithKnownIsbn, booksDatabase.getByISBN("123456..."));
    }
}