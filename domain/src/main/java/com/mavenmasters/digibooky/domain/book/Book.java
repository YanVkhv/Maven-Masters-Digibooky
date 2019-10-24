package com.mavenmasters.digibooky.domain.book;

public class Book {
	private final String isbn;
	private final String title;
	private final Author author;

	public Book(String isbn, String title, Author author) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}
}
