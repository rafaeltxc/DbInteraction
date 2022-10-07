package com.webapp.repository;

import java.util.List;

import com.webapp.model.Book;
import com.webapp.model.User;

public interface BookRepository {

	public int insert(Book b, User u);
	
	public int update(Book b, User u);
	
	public long delete(long id);
	
	public List<Book> getAll();
	
	public Book getById(long id);
	
	public List<Book> getAllByIdUser(long id);
	
	public List<Book> getAllByName(String name, long id);
	
}
