package com.mavenmasters.digibooky.domain.book;

public class Book {
	private final String ISBN;
	private final String title;
	private final Author author;

	public Book(String isbn, String title, Author author) {
		ISBN = isbn;
		this.title = title;
		this.author = author;
	}
}
