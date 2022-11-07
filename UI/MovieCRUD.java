package UI;

import java.util.*;
import UI.*;
import java.io.*;

public class MovieCRUD {
	static Scanner sc = new Scanner(System.in); // Console
	static int count = 0;

	public static void main(String[] args) throws Exception {
		int choice;
		String date;
		File f = new File("./Database/MovieCollectionNew.txt");
		lineCounter l = new lineCounter();
		count = l.counter(f);
		do {
			System.out.println("===Conifure Movie Listing UI===");
			System.out.println("(1) Create Movie");
			System.out.println("(2) Remove Movie");
			System.out.println("(3) Update Movie");
			System.out.println("(4) Delete Movies");
			System.out.println("(5) Quit Configure Movie UI");
			choice = sc.nextInt();
			sc.nextLine(); // Clear scanner buffer
			switch (choice) {
				case 1:
					// Create Movie
					CreateMovie.main(null);
					break;
				case 2:
					// Delete and entry
					SearchMovie SM = new SearchMovie();
					int dChoice;
					String rez[] = new String[count];
					// Parse file for input date
					System.out.println("Search for something to delete: ");
					date = sc.nextLine();

					rez = SearchMovie.getSearchedMovie(date); // Search for all entries with input term

					// Prints out all options for the user
					for (int i = 0; i < count; i++) {
						if (rez[i] == null) {
							break;
						}
						System.out.println(i + ": " + rez[i]);
					}

					// Scan for deletion choice
					System.out.println("Which would you like to delete?");

					dChoice = sc.nextInt();
					// Delete Entry
					SM.delMovie(rez[dChoice]);
					break;
				case 3:

				case 4:

				case 5:
					return;
				default:
					break;
			}
		} while (choice != 5);
	}
}
