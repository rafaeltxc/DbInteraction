package com.webapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.dao.BookDAO;
import com.webapp.factory.DAOFactory;
import com.webapp.model.Book;
import com.webapp.model.User;

@WebServlet(name = "updateBook", urlPatterns = "/UpdateBook/*")
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDAO dao;
	private Book bk;
	private User us;
    
    public UpdateBookServlet() {
        super();
        dao = DAOFactory.getBookDAO();
        bk = new Book();
        us = new User();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession(false);
    	String title = (String) request.getSession().getAttribute("title");
    	String resume = (String) request.getSession().getAttribute("resume");
    	String book = (String) request.getSession().getAttribute("book");
		
		request.getRequestDispatcher("/UpdateBook.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String title = request.getParameter("title");
		String resume = request.getParameter("resume");
		String book = request.getParameter("book");
		
		request.getSession();
		long idBook = (Long) request.getSession().getAttribute("idBook");
		long idUser = (Long) request.getSession().getAttribute("idUser");
		String nickname = (String) request.getSession().getAttribute("nickname");
		
		bk.setIdBook(idBook);
		bk.setTitle(title);
		bk.setResume(resume);
		bk.setBook(book);
		us.setIdUser(idUser);
		dao.update(bk, us);
		
		response.sendRedirect("/Library/User/" + nickname);
		
	}

}
