package com.mavenmasters.digibooky.service.dto;

import com.mavenmasters.digibooky.domain.book.Book;

public class BookMapper {

    public static BookDto mapToDto(Book book) {

        return new BookDto(
                book.getIsbn(),
                book.getTitle(),
                book.getSummary(),
                book.getAuthor());
    }
}
