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
