package UI;

import java.util.*;


/**
 * This is the UI to Create, Remove, Update and List movies
 */
public class MovieCRUD {
	static Scanner sc = new Scanner(System.in); // Console

	/**
	 * Main function driving the view
	 * 
	 * @param args null argument can be used to drive the function
	 * @throws Exception Throws Exception
	 */
	public static void main(String[] args) throws Exception {
		int choice;

		do {
			System.out.println("===Configure Movie Listing UI===");
			System.out.println("(1) Create Movie");
			System.out.println("(2) Remove Movie");
			System.out.println("(3) Update Movie");
			System.out.println("(4) List Movies");
			System.out.println("(5) Quit Configure Movie UI");
			choice = Integer.parseInt(sc.nextLine());

			switch (choice) {
				case 1:
					CreateMovie.main(null);
					break;
				case 2:
					RemoveMovie.main(null);
					break;					
				case 3:
					UpdateMovie.main(null);
					break;					
				case 4:
					DisplayMovie.main(null);
					break;
				case 5:
					return;
				default:
					System.out.println("\nInvalid input!\n");
					break;
			}
		} while (choice != 5);

	}
}
