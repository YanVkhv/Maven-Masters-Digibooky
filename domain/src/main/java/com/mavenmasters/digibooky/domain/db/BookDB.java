package com.mavenmasters.digibooky.domain.db;

import com.mavenmasters.digibooky.domain.book.Author;
import com.mavenmasters.digibooky.domain.book.Book;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BookDB implements Database {

    private HashMap<UUID, Book> books;

    public BookDB() {
        this.books = this.generateBooks();
    }

    private HashMap<UUID, Book> generateBooks() {
        HashMap<UUID, Book> books = new HashMap<>();
        for (int i = 0; i < 10; i++) {

            Book book = new Book(this.generateRandomISBN(), "The life of Brian", "This is a book summary", new Author("Tom", "Thompson"));
            books.put(book.getId(), book);
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

    public Book getByISBN(String isbn) {
        return books.values().stream()
                .filter(book -> book.getIsbn().contains(isbn))
                .findFirst()
                .get();
    }

    @Override
    public Map<UUID, Book> getAll() {
        return books;
    }

    @Override
    public Book getById(UUID id) {
        return books.get(id);
    }
}
