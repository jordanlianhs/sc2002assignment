package UI;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Model.Admin;

/**
 * Login page for the admin and main menu for admin system
 */
public class AdminUI {

	/**
	 * New MovieCRUD object driving the view
	 */
	private MovieCRUD movieCRUD = new MovieCRUD();
	/**
	 * New SessionCRUD object driving the view
	 */
	private SessionCRUD sessionCRUD = new SessionCRUD();
	/**
	 * New ListTop5UI object driving the view
	 */
	private ListTop5UI listTop5UI= new ListTop5UI();
	/**
	 * New HolidayUI object driving the view
	 */
	private HolidayUI holidayUI = new HolidayUI();
	/**
	 * New TicketPrice object driving the view
	 */
	private TicketPrice ticketPrice = new TicketPrice();

	/**
	 * Array list of admins
	 */
	private ArrayList<Admin> adminList = new ArrayList<Admin>();

	/**
	 * Main function driving the view
	 */
	public void main() {

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
							this.movieCRUD.main();
							break;
						case 2:
							this.sessionCRUD.main();
							break;
						case 3:
							System.out.println("Select item to configure: ");
							System.out.println("(1) Manage Holidays ");
							System.out.println("(2) Configure Ticket Prices ");
							choice2 = sc.nextInt();
							sc.nextLine();
							if (choice2 == 1) {
								this.holidayUI.main();
							} else if (choice2 == 2) {
								// Configure Ticket prices (not working)
								this.ticketPrice.configurePrice();
							} else {
								System.out.println("Invalid input!");
							}
							break;
						case 4:
							this.listTop5UI.init();
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
										this.listTop5UI.listTop5Sales();
										break;
									case 2:
										// list by ratings
										this.listTop5UI.listTop5Ratings();
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
												this.listTop5UI.setSetting(2);
												break;
											case 2:
												// list by ratings
												this.listTop5UI.setSetting(3);
												break;
											case 3:
												this.listTop5UI.setSetting(1);
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

	}
	
		
	/**
	 * This function checks if the user has keyed in the correct admin information
	 * 
	 * @param usr  Username
	 * @param pass Password
	 * @return Flag that indicates the state of login
	 */
	public boolean auth(String usr, String pass) {
		boolean token = false;

		try {
			File adminFile = new File("./Database/admin.txt");
			Scanner ar = new Scanner(adminFile); // adminreader, ar

			ar.useDelimiter(",");
			while(ar.hasNextLine()){
				String line = ar.nextLine();
				String[] parts = line.split(",");
				String username = parts[0];
				String password = parts[1];
				adminList.add(new Admin(username, password));
			}
			

			for(Admin admin : adminList){
				if(usr.equals(admin.getName()) && pass.equals(admin.getPassword())){
					System.out.println("Login as Administrator Successful\n");
					token = true;
					ar.close();
					return token;
				}
			}
			System.out.println("Username or Password is incorrect!");
			token = false;
			ar.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return token;
	}
}
