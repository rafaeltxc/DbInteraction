package com.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.webapp.connector.ConnectionManager;
import com.webapp.model.Book;
import com.webapp.model.User;
import com.webapp.repository.BookRepository;

public class BookDAO implements BookRepository {

	private Connection con;
	private Book bk;
	
	public int insert(Book b, User u) {
		try {
			ConnectionManager.getInstance();
			con = ConnectionManager.getConnection();
			PreparedStatement stmt = con.prepareStatement("INSERT INTO tbl_book (title_book, resume_book, book, fk_id_user) VALUES (?, ?, ?, ?)");
			stmt.setString(1, b.getTitle());
			stmt.setString(2, b.getResume());
			stmt.setString(3, b.getBook());
			stmt.setLong(4, u.getIdUser());
			return stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int update(Book b, User u) {
		try {
			ConnectionManager.getInstance();
			con = ConnectionManager.getConnection();
			PreparedStatement stmt = con.prepareStatement("UPDATE tbl_book SET "
					+ "title_book = ?, "
					+ "resume_book = ?, "
					+ "book = ? "
					+ "WHERE fk_id_user = ? "
					+ "AND id_book = ?");
			stmt.setString(1, b.getTitle());
			stmt.setString(2, b.getResume());
			stmt.setString(3, b.getBook());
			stmt.setLong(4, u.getIdUser());
			stmt.setLong(5, b.getIdBook());
			return stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public long delete(long id) {
		try {
			con = ConnectionManager.getConnection();
			PreparedStatement stmt = con.prepareStatement("DELETE FROM tbl_book WHERE id_book = ?");
			stmt.setLong(1, id);
			return stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<Book> getAll() {
		List<Book> lst = new ArrayList<>();
		
		try {
			ConnectionManager.getInstance();
			con = ConnectionManager.getConnection();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM tbl_book");
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Book bk = new Book();
				bk.setIdBook(rs.getLong("id_bok"));
				bk.setTitle(rs.getString("title_book"));
				bk.setResume(rs.getString("resume_book"));
				bk.setBook(rs.getString("book"));
				
				lst.add(bk);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lst;
	}
	
	public Book getById(long id) {
		try {
			ConnectionManager.getInstance();
			con = ConnectionManager.getConnection();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM tbl_book WHERE id_book = ?");
			stmt.setLong(1, id);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				long idBook = rs.getLong("id_book");
				String title = rs.getString("title_book");
				String resume = rs.getString("resume_book");
				String book = rs.getString("book");
				
				bk = new Book(idBook, title, resume, book);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bk;
	}
	
	public List<Book> getAllByIdUser(long id) {
		List<Book> lst = new ArrayList<>();
		try {
			ConnectionManager.getInstance();
			con = ConnectionManager.getConnection();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM tbl_book WHERE fk_id_user = ?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				long idBook = rs.getLong("id_book");
				String title = rs.getString("title_book");
				String resume = rs.getString("resume_book");
				String book = rs.getString("book");
			
				bk = new Book(idBook, title, resume, book);
				lst.add(bk);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lst;
	}
	
	public List<Book> getAllByName(String name, long id) {
		List<Book> lst = new ArrayList<>();
		try {
			ConnectionManager.getInstance();
			con = ConnectionManager.getConnection();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM tbl_book WHERE title_book LIKE ? AND fk_id_user = ?");
			stmt.setString(1, "%" + name + "%");
			stmt.setLong(2, id);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				long idBook = rs.getLong("id_book");
				String title = rs.getString("title_book");
				String resume = rs.getString("resume_book");
				String book = rs.getString("book");
			
				bk = new Book(idBook, title, resume, book);
				lst.add(bk);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lst;
	}
	
}
