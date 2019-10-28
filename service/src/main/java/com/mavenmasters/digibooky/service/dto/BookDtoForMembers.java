package com.mavenmasters.digibooky.service.dto;

import com.mavenmasters.digibooky.domain.book.Author;

public class BookDtoForMembers extends BookDtoForUsers {

    private final boolean isBorrowed;
    private final MemberDto memberDetails;

    public BookDtoForMembers(String isbn, String title, String summary, Author author, boolean isBorrowed, MemberDto memberDetails) {
        super(isbn, title, summary, author);
        this.isBorrowed = isBorrowed;
        this.memberDetails = memberDetails;
    }

}
