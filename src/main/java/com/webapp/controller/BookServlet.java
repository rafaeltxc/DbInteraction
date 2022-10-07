package com.webapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.dao.BookDAO;
import com.webapp.factory.DAOFactory;

@WebServlet(name = "book", urlPatterns = {"/Book/*"})
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BookDAO dao;
    String info;
       
    public BookServlet() {
        super();
        dao = DAOFactory.getBookDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession(false);
		String nickname = (String) request.getSession().getAttribute("nickname");
		long idBook;
    	
    	info = request.getPathInfo();
    	String tempId = "";
    	
    	String reverse = "";
    	for(int i=0; i<info.length(); i++) {
    		reverse = info.charAt(i) + reverse;
    	}

    	for(int i=0; i<reverse.length(); i++) {
    		if(reverse.charAt(i) == '/') {
    			break;
    		}
    		tempId += reverse.charAt(i);
    	}
    	
    	if(tempId.length() > 1) {
        	String reversedId = "";
        	for(int i=0; i<tempId.length(); i++) {
        		reversedId = tempId.charAt(i) + reversedId;
        	}
        	
        	idBook = Long.parseLong(reversedId);
    	} else {
    		idBook = Long.parseLong(tempId);
    	}
    	String title = (String) dao.getById(idBook).getTitle();
    	String resume = (String) dao.getById(idBook).getResume();
    	String text = (String) dao.getById(idBook).getBook();
    	
    	request.getSession().setAttribute("idBook", idBook);
    	request.getSession().setAttribute("title", title);
    	request.getSession().setAttribute("resume", resume);
    	request.getSession().setAttribute("book", text);
    	
    	request.setAttribute("text", text);
    	request.setAttribute("title", title);
    	request.setAttribute("idBook", idBook);
    	request.getRequestDispatcher("/Book.jsp").forward(request, response);
    	
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
