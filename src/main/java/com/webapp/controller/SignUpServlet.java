package com.webapp.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.dao.UserDAO;
import com.webapp.factory.DAOFactory;
import com.webapp.model.User;

@WebServlet("/SignUp")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO dao;
	private User u;
 
    public SignUpServlet() {
        super();
        dao = DAOFactory.getUserDAO();
        u = new User();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("/SignUp.jsp").forward(request, response);
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year"); 
		
		String stringDate = year + "-" + month + "-" + day; 
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar instance = Calendar.getInstance();
		try {
			instance.setTime(format.parse(stringDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		u.setNicknameUser(nickname);
		u.setPassword(password);
		u.setBirthUser(instance);
		dao.insert(u);
		
		response.sendRedirect("/Library/SignIn");
			
	}

}
