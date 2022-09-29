package com.webapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.dao.BookDAO;
import com.webapp.model.Book;
import com.webapp.model.User;

@WebServlet("/NewBook")
public class NewBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDAO dao;
	private Book bk;
	private User us;
	
    public NewBookServlet() {
        super();
        dao = new BookDAO();
        bk = new Book();
        us = new User();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("NewBook.jsp").forward(request, response);
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String title = request.getParameter("title");
		String resume = request.getParameter("resume");
		String book = request.getParameter("book");
		
		request.getSession();
		long idUser = (Long) request.getSession().getAttribute("idUser");
		
		us.setIdUser(idUser);
		bk.setTitle(title);
		bk.setResume(resume);
		bk.setBook(book);
		dao.insert(bk, us);
		
		response.sendRedirect("/Library/Library");
		
	}

}
