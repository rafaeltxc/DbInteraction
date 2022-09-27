package com.webapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Book {

	private Long idBook;
	private String title;
	private String resume;
	private String book;	
	private User idUser;
	
	public Book(Long idBook, String title, String resume, String book) {
		super();
		this.idBook = idBook;
		this.title = title;
		this.resume = resume;
		this.book = book;
	}
}
