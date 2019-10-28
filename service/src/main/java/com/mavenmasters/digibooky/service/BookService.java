package com.mavenmasters.digibooky.service;


import com.mavenmasters.digibooky.domain.book.Book;
import com.mavenmasters.digibooky.domain.db.BookDB;
import com.mavenmasters.digibooky.service.dto.BookDto;
import com.mavenmasters.digibooky.service.dto.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class BookService {
    private final BookDB bookDB;

    @Autowired
    public BookService() {
        this.bookDB = new BookDB();
    }

    public BookDto getDetailsOfBook(UUID uuid) {
        return BookMapper.mapToDto(this.bookDB.getById(uuid));
    }

    public BookDto getBookByTitle(String title) {
        return BookMapper.mapToDto(this.bookDB.getByTitle(title));
    }

    public BookDto getBookByISBN(String isbn) {
        return BookMapper.mapToDto(this.bookDB.getByISBN(isbn));
    }

    public BookDto getBookByAuthor(String name) {
        return BookMapper.mapToDto(this.bookDB.getByAuthor(name));
    }

    public List<BookDto> getAllBooks() {
        return this.bookDB.getAll()
                .values()
                .stream()
                .map(BookMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public BookDto addBook(Book book) {
        return BookMapper.mapToDto(this.bookDB.addBook(book));
    }

    public BookDto deleteBook(UUID uuid) {
        return BookMapper.mapToDto(this.bookDB.deleteBook(uuid));
    }

    public BookDto updateBook(Book book) {
        return BookMapper.mapToDto(this.bookDB.updateBook(book));
    }

}
