package com.mavenmasters.digibooky.service.dto;

import com.mavenmasters.digibooky.domain.book.Author;

import java.util.UUID;

public class BookDtoForMembers extends BookDtoForUsers {

    private final boolean isBorrowed;
    private final MemberDto memberDetails;

    public BookDtoForMembers(UUID bookuuid,String isbn, String title, String summary, Author author, boolean isBorrowed, MemberDto memberDetails) {
        super(bookuuid, isbn, title, summary, author);
        this.isBorrowed = isBorrowed;
        this.memberDetails = memberDetails;
    }

}
