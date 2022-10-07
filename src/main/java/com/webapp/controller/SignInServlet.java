package com.webapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.dao.UserDAO;
import com.webapp.factory.DAOFactory;
import com.webapp.model.User;

@WebServlet("/SignIn")
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO dao;
	
    public SignInServlet() {
        super();
        dao = DAOFactory.getUserDAO();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("/SignIn.jsp").include(request, response);
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");
		
		User user = dao.getByNick(nickname);
		if(user.getPassword().equals(password)) {
			request.getSession(true);
			request.getSession().setAttribute("idUser", user.getIdUser());
			request.getSession().setAttribute("nickname", user.getNicknameUser());
						
			response.sendRedirect("/Library/User/" + nickname);
		}
	}

}
