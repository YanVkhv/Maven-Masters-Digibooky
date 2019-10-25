package com.mavenmasters.digibooky.service.dto;

import com.mavenmasters.digibooky.domain.book.Author;

public class BookDto {
    private String isbn;
    private String title;
    private String summary;
    private Author author;

    public BookDto(String isbn, String title, String summary, Author author) {
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

    @Override
    public String toString() {
        return String.format("Book Details:\t\n%s\t\n%s\t\n%s\t\n%s", getIsbn(), getTitle(), getSummary(), getAuthor());
    }
}
