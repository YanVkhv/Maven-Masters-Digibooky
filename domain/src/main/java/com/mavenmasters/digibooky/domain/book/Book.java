package com.mavenmasters.digibooky.domain.book;

import java.util.UUID;

public class Book {
	private final UUID id;
	private final String isbn;
	private  String title;
	private  String summary;
	private  Author author;
	private boolean isDeleted;
	private boolean isAvailable;

	public Book(String isbn, String title, String summary, Author author) {
		this.id = UUID.randomUUID();
		this.isbn = isbn;
		this.title = title;
		this.summary = summary;
		this.author = author;
		this.isDeleted = false;
		this.isAvailable = true;
	}

	public Book(String isbn, String title, String authorLastName) {
		this.id = UUID.randomUUID();
		this.isbn = isbn;
		this.title = title;
		this.summary = "";
		this.author = new Author("", authorLastName);
		this.isDeleted = false;
		this.isAvailable = true;
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

	public boolean isDeleted() {
		return isDeleted;
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

	public void setDeleted(boolean deleted) {
		isDeleted = deleted;
	}

}
