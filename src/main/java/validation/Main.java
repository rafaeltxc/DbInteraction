package validation;

import java.util.ArrayList;
import java.util.List;

import com.webapp.dao.UserDAO;
import com.webapp.model.User;

public class Main {

	public static void main(String[] args) {
		
		List<String> myList = new ArrayList<>();
		 
        // Adding elements to the List
        // Custom inputs
        myList.add("A");
        myList.add("B");
        myList.add("C");
        myList.add("D");
	
        for (String i : myList) {
        	System.out.println(i);
        }
        
	}

}
