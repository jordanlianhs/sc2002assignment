package UI;

import java.util.*;
import java.io.*;

/**
 * Login page for the admin and main menu for admin system
 */
public class AdminUI {

	public AdminUI(){};

	/**
	 * Main function driving the view
	 * 
	 * @param args null argument can be used to drive the function
	 * @throws Exception Throws Exception
	 */
	public void main(String[] args) {
		try{
			String id, pass;
			int choice = 0;
			int choice2 = 0;
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
					System.out.println("(1) Movie CRUD");
					System.out.println("(2) Session CRUD");
					System.out.println("(3) Configure System Settings");
					System.out.println("(4) List Top 5 ranking Movies and its settings");
					System.out.println("(5) Quit Admin Module");
					choice = sc.nextInt();
					sc.nextLine();
					switch (choice) {
						case 1:
							MovieCRUD.main(null);
							break;
						case 2:
							SessionCRUD.main(null);
							break;
						case 3:
							System.out.println("Select item to configure: ");
							System.out.println("(1) Manage Holidays ");
							System.out.println("(2) Configure Ticket Prices ");
							choice2 = sc.nextInt();
							sc.nextLine();
							if (choice2 == 1) {
								HolidayUI.main(null);
							} else if (choice2 == 2) {
								// Configure Ticket prices (not working)
								TicketPrice.configurePrice();
							} else {
								System.out.println("Invalid input!");
							}
							break;
						case 4:
							ListTop5UI.init();
							do {
								System.out.println("(1) List top 5 movies by ticket sales");
								System.out.println("(2) List top 5 movies by overall ratings");
								System.out.println("(3) Visibility settings for users");
								System.out.println("(4) Go back");
								System.out.println("Please enter your choice:");

								choice = sc.nextInt();
								switch (choice) {
									case 1:
										// list by sales
										ListTop5UI.listTop5Sales();
										break;
									case 2:
										// list by ratings
										ListTop5UI.listTop5Ratings();
										break;
									case 3:
										// change settings

										System.out.println("(1) Users can only list top 5 movies by ticket sales");
										System.out.println("(2) Users can only lsit top 5 movies by overall ratings");
										System.out.println("(3) Users can list both");
										System.out.println("(4) Go back");
										System.out.println("Please enter your choice:");

										choice = sc.nextInt();
										switch (choice) {
											case 1:
												// list by sales
												ListTop5UI.setSetting(2);
												break;
											case 2:
												// list by ratings
												ListTop5UI.setSetting(3);
												break;
											case 3:
												ListTop5UI.setSetting(1);
										}

										break;
								}

							} while (choice != 4);
							break;
						case 5:
							return; // go back to the MainUI
						default:
							System.out.println("\nInvalid input!\n");
							break;
					}
				} while (choice != 5);
				sc.close();
			}
		}catch(Exception e){
			System.out.println("APP CRASH");
		}
	}
	
		
	/**
	 * This function checks if the user has keyed in the correct admin information
	 * 
	 * @param usr  Username
	 * @param pass Password
	 * @return Flag that indicates the state of login
	 * @throws Exception Throws Exception
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
				System.out.println("Login as Administrator Successful\n");
				token = true;
			}
			ar.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return token;
	}
}
