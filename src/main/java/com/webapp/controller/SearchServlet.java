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

@WebServlet(name = "searchServlet", urlPatterns = "/User/Search/*")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDAO dao;

	public SearchServlet() {
        super();
        dao = DAOFactory.getBookDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession(false);
		long idUser = (Long) request.getSession().getAttribute("idUser");
		
		String search = request.getParameter("search");
		
		List<Book> bookList = dao.getAllByName(search, idUser);
		Collections.reverse(bookList);
		
		request.setAttribute("list", bookList);
		request.getRequestDispatcher("/User.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
