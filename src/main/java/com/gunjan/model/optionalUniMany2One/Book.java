package com.gunjan.model.optionalUniMany2One;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	@GeneratedValue @Id
	private int id;
	
	private String isbn;
	private String title;
	private String author;
	
	@ManyToOne (cascade = {CascadeType.PERSIST})
	@JoinTable (name = "book_publisher")
	private Publisher publisher;
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	
}
