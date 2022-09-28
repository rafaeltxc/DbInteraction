package com.webapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.dao.BookDAO;
import com.webapp.model.Book;

@WebServlet("/Library")
public class LibraryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BookDAO dao;
	
    public LibraryServlet() {
        super();
        dao = new BookDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idUser = 1;
		
		List<Book> bookList = dao.getAllByIdUser(idUser);
		
		request.setAttribute("nickname", "test");
		request.setAttribute("lst", bookList);
		request.getRequestDispatcher("Library.jsp").forward(request, response);
	}

}
