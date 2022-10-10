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
	
    public SignInServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setAttribute("invalidUser", "");
    	request.setAttribute("invalidPassword", "");
    	request.getRequestDispatcher("/SignIn.jsp").include(request, response);
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setIntHeader("Refresh", 1);
		
		String nickname = request.getParameter("nickname").strip();
		String password = request.getParameter("password").strip();
		
		String invalidUser = "";
		String invalidPassword = "";
		
		UserDAO dao = new UserDAO();
		User user = dao.getByNick(nickname);
		if(user == null) {
			invalidUser = "Invalid user";
			request.setAttribute("invalidUser", invalidUser);
			request.getRequestDispatcher("/SignIn.jsp").forward(request, response);
			return;
		} 
		
		if(user.getPassword().equals(password)) {
			request.getSession(true);
			request.getSession().setAttribute("idUser", user.getIdUser());
			request.getSession().setAttribute("nickname", user.getNicknameUser());
						
			response.sendRedirect("/Library/User/" + nickname);
			return;
		} else {
			invalidPassword = "Invalid password";
			request.setAttribute("invalidPassword", invalidPassword);
			request.getRequestDispatcher("/SignIn.jsp").forward(request, response);
			return;
		}
		
		
	}

}
