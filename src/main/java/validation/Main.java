package validation;

import com.webapp.dao.UserDAO;
import com.webapp.model.User;

public class Main {

	public static void main(String[] args) {
		
		User u = new User();
		UserDAO uDAO = new UserDAO();	
		
		System.out.println(uDAO.existsNickname("aaa"));
		
	}

}
