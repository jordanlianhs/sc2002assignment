package UI;
import java.util.*;

public class AdminUI {
	/**
	 * Main function driving the view
	 * @param args null argument can be used to drive the function
	 * @throws Exception Throws Exception
	 */
	public static void main(String[] args) throws Exception {
		String id, pass;
		Scanner sc = new Scanner(System.in);
		System.out.println("ADMIN LOGIN PAGE\n");
		
		do {
			System.out.print("ID: ");
			id = sc.next();
			System.out.print("Password: ");
			pass = sc.next();
		} 
		while(auth(id, pass) == 0);
		
		System.out.println();
		//AdminFunctions.main(null);
		System.out.println();
		sc.close();
	}

	/**
	 * This function checks if the user has keyed in the correct admin information
	 * @return Flag that indicates the state of login
	 */
    public static int auth(String usr, String pass) {
		int token = 0;
		Scanner sc = new Scanner(System.in);
    	do {
	    	System.out.println("***Login UI***");
	    	System.out.println("Username: ");
	    	usr = sc.next();
	    	System.out.println("Password: ");
	    	pass = sc.next();
	    	
	    	if (!usr.equals("admin")  || !pass.equals("123") ) {
	    		System.out.println("Username or Password is incorrect!");
	    		token = 0;
	    	}else {
	    		System.out.println("Login as Administrator Successful");
	    		token = 1;
	    	}
	    
    	}while(token!=1);
    	return token;
    }
}
