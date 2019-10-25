package com.mavenmasters.digibooky.domain.book;

import java.util.UUID;

public class Book {
	private final UUID id;
	private final String isbn;
	private final String title;
	private final String summary;
	private final Author author;

	public Book(String isbn, String title, String summary, Author author) {
		this.id = UUID.randomUUID();
		this.isbn = isbn;
		this.title = title;
		this.summary = summary;
		this.author = author;
	}

	public Book(String isbn, String title, String authorLastName) {
		this.id = UUID.randomUUID();
		this.isbn = isbn;
		this.title = title;
		this.summary = "";
		this.author = new Author("", authorLastName);
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public Author getAuthor() {
		return author;
	}

	public String getSummary() {
		return summary;
	}

	public UUID getId() {
		return id;
	}
}
