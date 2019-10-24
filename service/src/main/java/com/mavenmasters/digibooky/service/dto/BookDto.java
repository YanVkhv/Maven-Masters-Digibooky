package com.mavenmasters.digibooky.service.dto;

import com.mavenmasters.digibooky.domain.book.Author;

public class BookDto {
    private final String isbn;
    private final String title;
    private final String summary;
    private final Author author;

    public BookDto(String isbn, String title, String summary, Author author) {
        this.isbn = isbn;
        this.title = title;
        this.summary = summary;
        this.author = author;
    }


}
