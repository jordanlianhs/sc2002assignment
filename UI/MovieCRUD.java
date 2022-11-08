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

		do {
			System.out.println("===Conifure Movie Listing UI===");
			System.out.println("(1) Create Movie");
			System.out.println("(2) Remove Movie");
			System.out.println("(3) Update Movie");
			System.out.println("(4) List Movies");
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
					File f = new File("./Database/MovieCollectionNew.txt");
					lineCounter l = new lineCounter();
					count = l.counter(f);
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
					SearchMovie.delMovie(rez[dChoice]);
					break;
				case 3:
					// Update a variable of movie

					String file1 = "./Database/MovieCollectionNew.txt";
					String tempFile1 = "./Database/temp1.txt";
					File oldFile1 = new File(file1);
					File newFile1 = new File(tempFile1);
			  
					FileWriter fw1 = new FileWriter(newFile1, true); // appends to movie.txt
					BufferedWriter bw1 = new BufferedWriter(fw1);
					PrintWriter pw1 = new PrintWriter(bw1);
					Scanner y = new Scanner(new File(file1));
					y.useDelimiter("[,\n]");
			  
					String text;
			  
					while (y.hasNextLine()) {
					  text = y.nextLine();
					  String[] elements = text.split(",");
					  String movietitle = elements[0];
					  String movieType = elements[1];
					  String movieStatus = elements[2];
					  String synopsis = elements[3];
					  String ageRating = elements[4];
					  String starRating = elements[5];
					  String duration = elements[6];
					  String movieReleaseDate = elements[7];
					  String movieEndDate = elements[8];
					  String director = elements[9];
					  String sales = elements[10];
					  String sizeOfCast = elements[11];
					  ArrayList<String> cast = new ArrayList<>();
					  for(int u=12; u<(Integer.valueOf(sizeOfCast)+12); u++){
						  cast.add(elements[u]);
					  }
					  String castStr = String.join(",", cast);


					// Scan for movie to update
					System.out.println("Which movie's details would you like to edit?");
					String choosedmovie = sc.nextLine();

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
					System.out.println("(9) Size Of Cast");
					System.out.println("(10) Cast");

					int choosed = sc.nextInt();

					String useless = sc.nextLine();
					String updateChoice;

					switch (choosed){
						case 1:
							//movieType
							System.out.println("What is the updated value?");
							updateChoice = sc.nextLine();
							if (movietitle.toLowerCase().equals(choosedmovie.toLowerCase())) {
								pw1.print(choosedmovie + "," + updateChoice + "," + movieStatus + "," + synopsis + "," + ageRating + "," + starRating + "," + duration
									+ "," + movieReleaseDate + "," + movieEndDate + "," + director + "," + sales + "," + sizeOfCast + "," + castStr + "\n");
								pw1.flush();
							}
					
							else {
								pw1.print(movietitle + "," + movieType + "," + movieStatus + "," + synopsis + "," + ageRating + "," + starRating + "," + duration
									+ "," + movieReleaseDate + "," + movieEndDate + "," + director + "," + sales + "," + sizeOfCast + "," + castStr + "\n");
								pw1.flush();
							}
							break;

						case 2:
							//movieStatus
							System.out.println("What is the updated value?");
							updateChoice = sc.nextLine();
							if (movietitle.toLowerCase().equals(choosedmovie.toLowerCase())) {
								pw1.print(choosedmovie + "," + movieType + "," + updateChoice + "," + synopsis + "," + ageRating + "," + starRating + "," + duration
									+ "," + movieReleaseDate + "," + movieEndDate + "," + director + "," + sales + "," + sizeOfCast + "," + castStr + "\n");
								pw1.flush();
							}
					
							else {
								pw1.print(movietitle + "," + movieType + "," + movieStatus + "," + synopsis + "," + ageRating + "," + starRating + "," + duration
									+ "," + movieReleaseDate + "," + movieEndDate + "," + director + "," + sales + "," + sizeOfCast + "," + castStr + "\n");
								pw1.flush();
							}
							break;

						case 3:
							//synopsis
							System.out.println("What is the updated value?");
							updateChoice = sc.nextLine();
							if (movietitle.toLowerCase().equals(choosedmovie.toLowerCase())) {
								pw1.print(choosedmovie + "," + movieType + "," + movieStatus + "," + updateChoice + "," + ageRating + "," + starRating + "," + duration
									+ "," + movieReleaseDate + "," + movieEndDate + "," + director + "," + sales + "," + sizeOfCast + "," + castStr + "\n");
								pw1.flush();
							}
					
							else {
								pw1.print(movietitle + "," + movieType + "," + movieStatus + "," + synopsis + "," + ageRating + "," + starRating + "," + duration
									+ "," + movieReleaseDate + "," + movieEndDate + "," + director + "," + sales + "," + sizeOfCast + "," + castStr + "\n");
								pw1.flush();
							}
							break;
						case 4:
							//ageRating
							System.out.println("What is the updated value?");
							updateChoice = sc.nextLine();
							if (movietitle.toLowerCase().equals(choosedmovie.toLowerCase())) {
								pw1.print(choosedmovie + "," + movieType + "," + movieStatus + "," + synopsis + "," + updateChoice + "," + starRating + "," + duration
									+ "," + movieReleaseDate + "," + movieEndDate + "," + director + "," + sales + "," + sizeOfCast + "," + castStr + "\n");
								pw1.flush();
							}
					
							else {
								pw1.print(movietitle + "," + movieType + "," + movieStatus + "," + synopsis + "," + ageRating + "," + starRating + "," + duration
									+ "," + movieReleaseDate + "," + movieEndDate + "," + director + "," + sales + "," + sizeOfCast + "," + castStr + "\n");
								pw1.flush();
							}
							break;
						case 5:
							//duration
							System.out.println("What is the updated value?");
							updateChoice = sc.nextLine();
							if (movietitle.toLowerCase().equals(choosedmovie.toLowerCase())) {
								pw1.print(choosedmovie + "," + movieType + "," + movieStatus + "," + synopsis + "," + ageRating + "," + starRating + "," + updateChoice
									+ "," + movieReleaseDate + "," + movieEndDate + "," + director + "," + sales + "," + sizeOfCast + "," + castStr + "\n");
								pw1.flush();
							}
					
							else {
								pw1.print(movietitle + "," + movieType + "," + movieStatus + "," + synopsis + "," + ageRating + "," + starRating + "," + duration
									+ "," + movieReleaseDate + "," + movieEndDate + "," + director + "," + sales + "," + sizeOfCast + "," + castStr + "\n");
								pw1.flush();
							}
							break;
						case 6:
							//movieReleaseDate
							System.out.println("What is the updated value?");
							updateChoice = sc.nextLine();
							if (movietitle.toLowerCase().equals(choosedmovie.toLowerCase())) {
								pw1.print(choosedmovie + "," + movieType + "," + movieStatus + "," + synopsis + "," + ageRating + "," + starRating + "," + duration
									+ "," + updateChoice + "," + movieEndDate + "," + director + "," + sales + "," + sizeOfCast + "," + castStr + "\n");
								pw1.flush();
							}
					
							else {
								pw1.print(movietitle + "," + movieType + "," + movieStatus + "," + synopsis + "," + ageRating + "," + starRating + "," + duration
									+ "," + movieReleaseDate + "," + movieEndDate + "," + director + "," + sales + "," + sizeOfCast + "," + castStr + "\n");
								pw1.flush();
							}
							break;
						case 7:
							//movieEndDate
							System.out.println("What is the updated value?");
							updateChoice = sc.nextLine();
							if (movietitle.toLowerCase().equals(choosedmovie.toLowerCase())) {
								pw1.print(choosedmovie + "," + movieType + "," + movieStatus + "," + synopsis + "," + ageRating + "," + starRating + "," + duration
									+ "," + movieReleaseDate + "," + updateChoice + "," + director + "," + sales + "," + sizeOfCast + "," + castStr + "\n");
								pw1.flush();
							}
					
							else {
								pw1.print(movietitle + "," + movieType + "," + movieStatus + "," + synopsis + "," + ageRating + "," + starRating + "," + duration
									+ "," + movieReleaseDate + "," + movieEndDate + "," + director + "," + sales + "," + sizeOfCast + "," + castStr + "\n");
								pw1.flush();
							}
							break;
						case 8:
							//director
							System.out.println("What is the updated value?");
							updateChoice = sc.nextLine();
							if (movietitle.toLowerCase().equals(choosedmovie.toLowerCase())) {
								pw1.print(choosedmovie + "," + movieType + "," + movieStatus + "," + synopsis + "," + ageRating + "," + starRating + "," + duration
									+ "," + movieReleaseDate + "," + movieEndDate + "," + updateChoice + "," + sales + "," + sizeOfCast + "," + castStr + "\n");
								pw1.flush();
							}
					
							else {
								pw1.print(movietitle + "," + movieType + "," + movieStatus + "," + synopsis + "," + ageRating + "," + starRating + "," + duration
									+ "," + movieReleaseDate + "," + movieEndDate + "," + director + "," + sales + "," + sizeOfCast + "," + castStr + "\n");
								pw1.flush();
							}
							break;
						case 9:
							//sizeOfCast
							System.out.println("What is the updated value?");
							updateChoice = sc.nextLine();
							if (movietitle.toLowerCase().equals(choosedmovie.toLowerCase())) {
								pw1.print(choosedmovie + "," + movieType + "," + movieStatus + "," + synopsis + "," + ageRating + "," + starRating + "," + duration
									+ "," + movieReleaseDate + "," + movieEndDate + "," + director + "," + sales + "," + updateChoice + "," + castStr + "\n");
								pw1.flush();
							}
					
							else {
								pw1.print(movietitle + "," + movieType + "," + movieStatus + "," + synopsis + "," + ageRating + "," + starRating + "," + duration
									+ "," + movieReleaseDate + "," + movieEndDate + "," + director + "," + sales + "," + sizeOfCast + "," + castStr + "\n");
								pw1.flush();
							}
							break;
						case 10:
							//castStr
							System.out.println("What is the updated value? (Separated by commas)");
							updateChoice = sc.nextLine();
							if (movietitle.toLowerCase().equals(choosedmovie.toLowerCase())) {
								pw1.print(choosedmovie + "," + movieType + "," + movieStatus + "," + synopsis + "," + ageRating + "," + starRating + "," + duration
									+ "," + movieReleaseDate + "," + movieEndDate + "," + director + "," + sales + "," + sizeOfCast + "," + castStr + "\n");
								pw1.flush();
							}
					
							else {
								pw1.print(movietitle + "," + movieType + "," + movieStatus + "," + synopsis + "," + ageRating + "," + starRating + "," + duration
									+ "," + movieReleaseDate + "," + movieEndDate + "," + director + "," + sales + "," + sizeOfCast + "," + castStr + "\n");
								pw1.flush();
							}
							break;
					}

			  
					//y.close();
					pw1.close();
					bw1.close();
					fw1.close();
			  
					oldFile1.delete();
					File dump1 = new File(file1);
					newFile1.renameTo(dump1);
				
				}


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
