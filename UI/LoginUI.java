package UI;
import java.util.*;

public class LoginUI {
	Scanner sc = new Scanner(System.in);
	String usr, pass;
	int token = 0;
	public LoginUI() {}//Constructor
    public int auth() {
    	do {
	    	System.out.println("***Login UI***");
	    	System.out.println("Username: ");
	    	usr = sc.nextLine();
	    	System.out.println("Password: ");
	    	pass = sc.nextLine();
	    	
	    	if (usr != "admin" || pass != "123321") {
	    		System.out.println("Username or Password is incorrect!");
	    		usr = null; //Resetting login credentials
	    		pass = null;
	    		token = 0;
	    	}else {
	    		System.out.println("Login as Administrator Successful");
	    		token = 1;
	    	}
	    
    	}while(token!=1);
    	return token;
    }
}
