package com.mavenmasters.digibooky.service.dto;

import com.mavenmasters.digibooky.domain.book.Book;

public class BookMapper {

    public static BookDtoForUsers mapToDto(Book book) {

        return new BookDtoForUsers(
                book.getIsbn(),
                book.getTitle(),
                book.getSummary(),
                book.getAuthor());
    }

    public static BookDtoForMembers mapToDtoForMember(Book book, boolean isBorrowed, MemberDto memberDto) {
        return new BookDtoForMembers(
                book.getIsbn(),
                book.getTitle(),
                book.getSummary(),
                book.getAuthor(),
                isBorrowed,
                memberDto);
    }
}
