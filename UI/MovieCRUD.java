package UI;

import java.util.*;


/**
 * This is the UI to Create, Remove, Update and List movies
 */
public class MovieCRUD {
	/** */
	private CreateMovie createMovie = new CreateMovie();

	/** */
	private RemoveMovie removeMovie = new RemoveMovie();

	/**
	 * 
	 */
	private UpdateMovie updateMovie = new UpdateMovie();

	/** */
	private DisplayMovie displayMovie = new DisplayMovie();

	/**
	 * Main function driving the view
	 * @param args null argument can be used to drive the function
	*/
	public void main(){
		Scanner sc = new Scanner(System.in); // Console
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
					createMovie.main();
					break;
				case 2:
					removeMovie.main();
					break;					
				case 3:
					updateMovie.main();
					break;					
				case 4:
					displayMovie.main();
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
