package UI;

import java.util.*;
import UI.*;
import java.io.*;
import Model.*;
import java.time.*;
import java.time.format.*;

public class MovieCRUD {
	static Scanner sc = new Scanner(System.in); // Console
	static int count = 0;

	public static void main(String[] args) throws Exception {
		int choice;
		String date;

		do {
			System.out.println("===Configure Movie Listing UI===");
			System.out.println("(1) Create Movie");
			System.out.println("(2) Remove Movie");
			System.out.println("(3) Update Movie");
			System.out.println("(4) List Movies");
			System.out.println("(5) Quit Configure Movie UI");
			date = sc.nextLine();
			choice = Integer.valueOf(date);

			switch (choice) {
				case 1:
					// Create Movie
					CreateMovie.main(null);
					break;
				case 2:
					// Delete and entry
					File f = new File("./Database/MovieCollectionNew.txt");
					lineCounter l = new lineCounter();
					count = l.counter(f);
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
					sc.nextLine();
					// Delete Entry
					SearchMovie.delMovie(rez[dChoice]);
					break;
				case 3:
					// Update a variable of movie

					String file1 = "./Database/MovieCollectionNew.txt";
					File movieFile = new File(file1);

					Scanner y = new Scanner(movieFile);
					y.useDelimiter("[,\n]");

					ArrayList<Movie> movieArray = new ArrayList<Movie>();

					while (y.hasNextLine()) {
						// add list of movies to array
						String line = y.nextLine();
						String[] parts = line.split(",");
						Movie m = new Movie();
						m.readMovie(parts[0]);
						movieArray.add(m);

					}

					// Scan for movie to update
					System.out.println("Which movie's details would you like to edit?");
					String choosedmovie = sc.nextLine();

					boolean flag = false;
					int movieIndex;
					for (movieIndex = 0; movieIndex < movieArray.size(); movieIndex++) {
						if (flag = movieArray.get(movieIndex).getmovieName().toLowerCase()
								.equals(choosedmovie.toLowerCase())) {
							break;
						}
					}
					if (flag == false) {
						System.out.println("\nWrong input, movie name does not exist\n");
						break;
					}

					// Scan for update choice
					System.out.println("What would you like to update? (Key in int)");
					System.out.println("(1) Movie Type");
					System.out.println("(2) Movie Status");
					System.out.println("(3) Synopsis");
					System.out.println("(4) Age Rating");
					System.out.println("(5) Duration");
					System.out.println("(6) Movie Release Date");
					System.out.println("(7) Movie End Date");
					System.out.println("(8) Director");
					System.out.println("(9) Cast");

					int choosed = sc.nextInt();
					sc.nextLine();

					// String useless = sc.nextLine();
					String updateChoice;

					// date formatter for release and end dates
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

					switch (choosed) {
						case 1:
							// movieType
							System.out.println("What is the updated value?");
							updateChoice = sc.nextLine();

							movieArray.get(movieIndex).setType(MovieType.valueOf(updateChoice));
							break;

						case 2:
							// movieStatus
							System.out.println("What is the updated value?");
							updateChoice = sc.nextLine();
							movieArray.get(movieIndex).setMovieStatus(MovieStatus.valueOf(updateChoice));
							break;

						case 3:
							// synopsis
							System.out.println("What is the updated value?");
							updateChoice = sc.nextLine();
							movieArray.get(movieIndex).setSynopsis(updateChoice);
							break;
						case 4:
							// ageRating
							System.out.println("What is the updated value?");
							updateChoice = sc.nextLine();
							movieArray.get(movieIndex).setageRating(updateChoice);
							break;
						case 5:
							// duration
							System.out.println("What is the updated value?");
							updateChoice = sc.nextLine();
							movieArray.get(movieIndex).setDuration(Double.valueOf(updateChoice));
							break;
						case 6:
							// movieReleaseDate
							System.out.println("What is the updated value? (Enter as: yyyy-MM-dd)");
							updateChoice = sc.nextLine();
							movieArray.get(movieIndex).setMovieReleaseDate(LocalDate.parse(updateChoice, formatter));
							break;
						case 7:
							// movieEndDate
							System.out.println("What is the updated value? (Enter as: yyyy-MM-dd)");
							updateChoice = sc.nextLine();
							movieArray.get(movieIndex).setMovieEndDate(LocalDate.parse(updateChoice, formatter));
							break;
						case 8:
							// director
							System.out.println("What is the updated value?");
							updateChoice = sc.nextLine();
							movieArray.get(movieIndex).setDirector(updateChoice);
							break;
						case 9:
							// castStr
							System.out.println("What is the updated value? (Separated by commas)");
							updateChoice = sc.nextLine();
							String[] newCastSplit = updateChoice.split(",");
							ArrayList<String> newCast = new ArrayList<>(Arrays.asList(newCastSplit));
							movieArray.get(movieIndex).setCast(newCast);
							break;
					}
					// deletes old file
					PrintWriter writer = new PrintWriter(movieFile);
					writer.print("");
					writer.close();

					for (Movie movie : movieArray) {
						movie.writeMovie();
					}

					break;

				case 4:
					SearchMovie.listMovie();
					break;
				case 5:
					return;
				default:
					break;
			}
		} while (choice != 5);

	}
}
