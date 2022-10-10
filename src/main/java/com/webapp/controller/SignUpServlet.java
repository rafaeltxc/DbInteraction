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
	private User u;
 
    public SignUpServlet() {
        super();
        u = new User();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setAttribute("error", "");
    	request.getRequestDispatcher("/SignUp.jsp").forward(request, response);
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setIntHeader("Refresh", 1);
		
		String nickname = request.getParameter("nickname").strip();
		String password = request.getParameter("password").strip();
		
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
		
		String errorMessage = "";
		UserDAO dao = new UserDAO();
		if(dao.getByNick(nickname) != null) {
			errorMessage = "NickName already exists";
			request.setAttribute("error", errorMessage);
			request.getRequestDispatcher("/SignUp.jsp").forward(request, response);
			return;
		} else {
			u.setNicknameUser(nickname);
			u.setPassword(password);
			u.setBirthUser(instance);
			dao.insert(u);
			
			response.sendRedirect("/Library/SignIn");
			return;
		}
		
	}

}
