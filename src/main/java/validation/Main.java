package validation;


public class Main {

	public static void main(String[] args) {
		
        
		String info = "bom / dia";
    	String id = "";
    	
    	String reverse = "";
    	for(int i=0; i<info.length(); i++) {
    		reverse = info.charAt(i) + reverse;
    	}

    	for(int i=0; i<reverse.length(); i++) {
    		if(reverse.charAt(i) == '/') {
    			break;
    		}
    		id += reverse.charAt(i);
    	}
    	
    	System.out.println(id);
	}

}
