package com.webapp.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.dao.BookDAO;
import com.webapp.factory.DAOFactory;
import com.webapp.model.Book;

@WebServlet(name = "userServlet", urlPatterns = {"/User", "/User/*"})
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BookDAO dao;
	
    public UserServlet() {
        super();
        dao = DAOFactory.getBookDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if(request.getSession().getAttribute("idUser") == null) {
			response.sendRedirect("/Library/SignIn");
			return;
		}
			
		request.getSession(false);
		long idUser = (Long) request.getSession().getAttribute("idUser");
		
		List<Book> bookList = dao.getAllByIdUser(idUser);
		Collections.reverse(bookList);
		
		request.setAttribute("list", bookList);
		request.getRequestDispatcher("/User.jsp").forward(request, response);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);		
	}

}
