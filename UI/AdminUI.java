package UI;

import java.util.*;

public class AdminUI {
	/**
	 * Main function driving the view
	 * 
	 * @param args null argument can be used to drive the function
	 * @throws Exception Throws Exception
	 */
	public static void main(String[] args) throws Exception {
		String id, pass;
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("ADMIN LOGIN PAGE");

		System.out.println("****************");
		System.out.print("Username: ");
		id = sc.nextLine();
		System.out.print("Password: ");
		pass = sc.nextLine();

		System.out.println();
		// AdminFunctions.main(null);
		System.out.println();

		// If login successful
		if (auth(id, pass) == true) {
			do {
				System.out.println("===Admin System===");
				System.out.println("(1) Manage Holidays");
				System.out.println("(5) Quit Admin Module");
				choice = sc.nextInt();
				switch (choice) {
					case 1:
						HolidayUI.main(null);
						break;
					case 5:
						return;
					default:
						break;
				}
			} while (choice != 5);
		} else
			return;
	}

	/**
	 * This function checks if the user has keyed in the correct admin information
	 * 
	 * @return Flag that indicates the state of login
	 */
	public static boolean auth(String usr, String pass) {
		boolean token;
		// Scanner sc = new Scanner(System.in);

		if (!usr.equals("admin") || !pass.equals("123")) {
			System.out.println("Username or Password is incorrect!");
			token = false;
		} else {
			System.out.println("Login as Administrator Successful");
			token = true;
		}

		return token;
	}
}
