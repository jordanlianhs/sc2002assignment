package UI;

import java.util.*;

public class AdminUI {
	/**
	 * Main function driving the view
	 * 
	 * @param args null argument can be used to drive the function
	 * @throws Exception Throws Exception
	 */
	public void AdminUI() throws Exception {
		String id, pass;
		Scanner sc = new Scanner(System.in);
		System.out.println("ADMIN LOGIN PAGE");

		System.out.println("****************");
		System.out.print("Username: ");
		id = sc.nextLine();
		System.out.print("Password: ");
		pass = sc.nextLine();
		auth(id, pass);

		System.out.println();
		// AdminFunctions.main(null);
		System.out.println();
	}

	/**
	 * This function checks if the user has keyed in the correct admin information
	 * 
	 * @return Flag that indicates the state of login
	 */
	public int auth(String usr, String pass) {
		int token = 0;
		// Scanner sc = new Scanner(System.in);
		do {

			if (!usr.equals("admin") || !pass.equals("123")) {
				System.out.println("Username or Password is incorrect!");
				token = 0;
				break;
			} else {
				System.out.println("Login as Administrator Successful");
				token = 1;
			}

		} while (token != 1);
		return token;
	}
}
