package com.mavenmasters.digibooky.service.dto;

import com.mavenmasters.digibooky.domain.book.Book;

public class BookMapper {

    public static BookDtoForUsers mapToDto(Book book) {

        return new BookDtoForUsers(
                book.getId(),
                book.getIsbn(),
                book.getTitle(),
                book.getSummary(),
                book.getAuthor());
    }

    public static BookDtoForMembers mapToDtoForMember(Book book, boolean isBorrowed, MemberDto memberDto) {
        return new BookDtoForMembers(
                book.getId(),
                book.getIsbn(),
                book.getTitle(),
                book.getSummary(),
                book.getAuthor(),
                isBorrowed,
                memberDto);
    }

    public static Book mapDtoToBook(BookDtoForUsers book) {
        return new Book(book.getIsbn(), book.getTitle(), book.getSummary(), book.getAuthor());
    }
}
