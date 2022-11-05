package UI;

import java.util.*;
import java.io.*;

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

		// If login successful
		if (auth(id, pass)) {
			do {
				System.out.println("===Admin System===");
				System.out.println("(1) Manage Holidays");
				System.out.println("(2) Movie CRUD"); 
				System.out.println("(3) Seat CRUD");
				System.out.println("(4) Configure System Settings");
				System.out.println("(5) Go Back");
				System.out.println("(6) Quit Admin Module");
				choice = sc.nextInt();
				sc.nextLine();
				switch (choice) {
					case 1:
						HolidayUI.main(null);
						break;
					case 2:
						
						break;
					case 3:
					
						break;
					case 4:

						break;
					case 5:
						MainUI.main(null);
						break;
					case 6:
						return;
					default:
						break;
				}
			} while (choice != 6);
		} else
			return;
	}

	/**
	 * This function checks if the user has keyed in the correct admin information
	 * 
	 * @return Flag that indicates the state of login
	 */
	public static boolean auth(String usr, String pass) throws Exception {
		boolean token = false;

		try {
			File adminFile = new File("./Database/admin.txt");
			Scanner ar = new Scanner(adminFile); // adminreader, ar

			ar.useDelimiter(",");
			String UN = ar.next();
			String PW = ar.next();

			// System.out.println(UN + " " + PW);

			if (!usr.equals(UN) || !pass.equals(PW)) {
				System.out.println("Username or Password is incorrect!");
				token = false;
			} else {
				System.out.println("Login as Administrator Successful");
				token = true;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return token;
	}
}
