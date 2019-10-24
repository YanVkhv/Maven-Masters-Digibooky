package com.mavenmasters.digibooky.domain.db;

import com.mavenmasters.digibooky.domain.book.Author;
import com.mavenmasters.digibooky.domain.book.Book;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BookDB implements Database {

    private Map<String, Book> books;

    public BookDB() {
        this.books = this.generateBooks();
    }

    private Map<String, Book> generateBooks() {
        HashMap<String, Book> books = new HashMap<>();
        for (int i = 0; i < 10; i++) {

            Book book = new Book(this.generateRandomISBN(), "The life of Brian", new Author("Tom", "Thompson"));
            books.put(book.getIsbn(), book);
        }
        return books;
    }

    private String generateRandomISBN() {
        while (true) {
            long numb = (long) (Math.random() * 100000000 * 1000000);
            if (String.valueOf(numb).length() == 13)
                return Long.toString(numb);
        }
    }

    @Override
    public Map<String, Book> getAll() {
        return books;
    }

    public Book getBookByISBN(String isbn) {
        return books.get(isbn);
    }
}
