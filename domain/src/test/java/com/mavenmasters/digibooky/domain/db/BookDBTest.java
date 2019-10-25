package com.mavenmasters.digibooky.domain.db;

import com.mavenmasters.digibooky.domain.book.Author;
import com.mavenmasters.digibooky.domain.book.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
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
                Assertions.assertEquals("This is a book summary", book.getSummary());
                Assertions.assertEquals("The life of Brian", book.getTitle());
                Assertions.assertEquals("Tom", book.getAuthor().getFirstName());
                Assertions.assertEquals("Thompson", book.getAuthor().getLastName());
        }
    }

    @Test
    void givenABookDB_whenSearchingSingleBookByUUID_thenReturnCorrectBook() {
        Book book = (Book) booksDatabase.getAll().values().stream().findFirst().get();
        Assertions.assertEquals(book, booksDatabase.getById(book.getId()));
    }

    @Test
    void givenABookDB_whenSearchingSingleBookByISBN_thenReturnCorrectBook() {
        Book bookWithKnownIsbnTitleAndAuthor = new Book("123456789", "The life of Andy", "This is a book summary", new Author("Brad", "Pitt"));
        booksDatabase.addBook(bookWithKnownIsbnTitleAndAuthor);
        Assertions.assertEquals(bookWithKnownIsbnTitleAndAuthor, booksDatabase.getByISBN("123456[0-9]{2,3}"));
    }

    @Test
    void givenABookDB_whenSearchingSingleBookByTitle_thenReturnCorrectBook() {
        Book bookWithKnownIsbnTitleAndAuthor = new Book("123456789", "The life of Andy", "This is a book summary", new Author("Brad", "Pitt"));
        booksDatabase.addBook(bookWithKnownIsbnTitleAndAuthor);
        Assertions.assertEquals(bookWithKnownIsbnTitleAndAuthor, booksDatabase.getByTitle("The life of ...."));
    }

    @Test
    void givenABookDB_whenSearchingSingleBookByAuthor_thenReturnCorrectBook() {
        Book bookWithKnownIsbnTitleAndAuthor = new Book("123456789", "The life of Andy", "This is a book summary", new Author("Brad", "Pitt"));
        booksDatabase.addBook(bookWithKnownIsbnTitleAndAuthor);
        Assertions.assertEquals(bookWithKnownIsbnTitleAndAuthor, booksDatabase.getByAuthor("Brad ...."));
    }

    @Test
    void givenABookDB_whenAddingNewBook_thenDatabaseContainsCorrectBook() {
        Book newBook = new Book("894361", "New Book", "", new Author("", "Vkhv"));
        booksDatabase.addBook(newBook);
        Assertions.assertEquals(booksDatabase.getByAuthor(" Vkh."), newBook);
    }

    @Test
    void givenABookDB_whenUpdatingExistingBook_thenOldBookIsUpdatedByNewBook() {
        Book bookWithKnownIsbnTitleAndAuthor = new Book("123456789", "The life of Andy", "This is a book summary", new Author("Brad", "Pitt"));
        booksDatabase.addBook(bookWithKnownIsbnTitleAndAuthor);
        bookWithKnownIsbnTitleAndAuthor.setTitle("The life of Tom");
        booksDatabase.updateBook(bookWithKnownIsbnTitleAndAuthor);
        Assertions.assertEquals("The life of Tom", booksDatabase.getById(bookWithKnownIsbnTitleAndAuthor.getId()).getTitle());
    }

    @Test
    void givenABookDB_whenDeletingBookByID_thenDatabaseNoLongerContainsThatBook() {
        Book bookWithKnownIsbnTitleAndAuthor = new Book("123456789", "The life of Andy", "This is a book summary", new Author("Brad", "Pitt"));
        booksDatabase.addBook(bookWithKnownIsbnTitleAndAuthor);
        booksDatabase.deleteBook(bookWithKnownIsbnTitleAndAuthor.getId());
        Assertions.assertEquals(null, booksDatabase.getById(bookWithKnownIsbnTitleAndAuthor.getId()));
    }

}