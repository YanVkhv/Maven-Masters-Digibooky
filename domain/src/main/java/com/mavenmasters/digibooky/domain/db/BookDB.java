package com.mavenmasters.digibooky.domain.db;

import com.mavenmasters.digibooky.domain.book.Author;
import com.mavenmasters.digibooky.domain.book.Book;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

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
        Optional<Book> toReturnBook = books.values().stream()
                .filter(book -> !book.isDeleted())
                .filter(book -> book.getIsbn().matches(isbn))
                .findFirst();

        if (!toReturnBook.isPresent()) {
            toReturnBook = books.values().stream()
                    .filter(book -> !book.isDeleted())
                    .filter(book -> book.getIsbn().contains(isbn))
                    .findFirst();
        }
        return toReturnBook.isPresent() ? toReturnBook.get() : null;
    }

    @Override
    public Map<UUID, Book> getAll() {
        return books.values().stream()
                .filter(book -> !book.isDeleted())
                .collect(Collectors.toMap(Book::getId, book -> book));
    }

    @Override
    public Book getById(UUID id) {
        Book toReturnBook = books.get(id);
        return toReturnBook.isDeleted() ? null : toReturnBook;
    }

    public Book getByTitle(String title) {
        Optional<Book> toReturnBook = books.values().stream()
                .filter(book -> !book.isDeleted())
                .filter(book -> book.getTitle().matches(title))
                .findFirst();

        if (!toReturnBook.isPresent()) {
            toReturnBook = books.values().stream()
                    .filter(book -> !book.isDeleted())
                    .filter(book -> book.getTitle().contains(title))
                    .findFirst();
        }
        return toReturnBook.isPresent() ? toReturnBook.get() : null;
    }

    public Book getByAuthor(String name) {
        Optional<Book> toReturnBook = books.values().stream()
                .filter(book -> !book.isDeleted())
                .filter(book -> book.getAuthor().getFullName().matches(name))
                .findFirst();

        if (!toReturnBook.isPresent()) {
            toReturnBook = books.values().stream()
                    .filter(book -> !book.isDeleted())
                    .filter(book -> book.getAuthor().getFullName().contains(name))
                    .findFirst();
        }
        return toReturnBook.isPresent() ? toReturnBook.get() : null;
    }

    public Book addBook(Book book) {
        if (book != null && !book.getTitle().trim().isEmpty() && !book.getIsbn().trim().isEmpty() && !book.getAuthor().getLastName().trim().isEmpty()) {
            books.put(book.getId(), book);
        }
        return book;
    }

    public Book updateBook(Book book) {
        Book bookToUpdate = this.getById(book.getId());
        if (bookToUpdate != null) {
            bookToUpdate.setAuthor(book.getAuthor());
            bookToUpdate.setTitle(book.getTitle());
            bookToUpdate.setSummary(book.getSummary());
            if (!book.getTitle().trim().isEmpty() && !book.getIsbn().trim().isEmpty() && !book.getAuthor().getLastName().trim().isEmpty()) {
                books.put(bookToUpdate.getId(), book);
            }
        }
        return book;
    }

    public Book deleteBook(UUID id) {
        Book bookToDelete = this.getById(id);
        if (bookToDelete != null) {
            bookToDelete.setDeleted(true);
            books.put(bookToDelete.getId(), bookToDelete);
        }
        return bookToDelete;
    }

}
