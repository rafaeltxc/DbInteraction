package com.webapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.dao.BookDAO;
import com.webapp.factory.DAOFactory;

@WebServlet(name = "deleteBook", urlPatterns = "/deleteBook/*")
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDAO dao;
       
    public DeleteBookServlet() {
        super();
        dao = DAOFactory.getBookDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession(false);
		String nickname = (String) request.getSession().getAttribute("nickname");
		long idBook = Long.parseLong(request.getParameter("id"));
		
		try {
			dao.delete(idBook);
			response.sendRedirect("/Library/User/" + nickname);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
