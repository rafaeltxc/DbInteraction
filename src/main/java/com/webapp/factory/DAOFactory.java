package com.webapp.factory;

import com.webapp.dao.BookDAO;
import com.webapp.dao.UserDAO;

public abstract class DAOFactory {

	public static UserDAO getUserDAO() {
		return new UserDAO();
	}
	
	public static BookDAO getBookDAO() {
		return new BookDAO();
	}
	
}
