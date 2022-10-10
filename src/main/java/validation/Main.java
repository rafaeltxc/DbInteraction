package validation;

import com.webapp.dao.UserDAO;

public class Main {

	public static void main(String[] args) {
		
		UserDAO dao = new UserDAO();
		
		System.out.println(dao.getByNick("aslkdghfkladsjf"));
	
	}

}
