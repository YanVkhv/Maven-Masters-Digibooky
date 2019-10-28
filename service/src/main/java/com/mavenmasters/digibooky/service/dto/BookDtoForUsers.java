package com.mavenmasters.digibooky.service.dto;

import com.mavenmasters.digibooky.domain.book.Author;

import java.util.UUID;

public class BookDtoForUsers {
    private UUID bookuuid;
    private String isbn;
    private String title;
    private String summary;
    private Author author;

    public BookDtoForUsers(UUID bookuuid, String isbn, String title, String summary, Author author) {
        this.bookuuid = bookuuid;
        this.isbn = isbn;
        this.title = title;
        this.summary = summary;
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public Author getAuthor() {
        return author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public UUID getBookuuid() {
        return bookuuid;
    }

    public void setBookuuid(UUID bookuuid) {
        this.bookuuid = bookuuid;
    }
}
