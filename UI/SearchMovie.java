package UI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This class provides fundamental functions to access txt files. Finding a
 * movie, Searching for a movie (Returns an array of results),
 * and deleting an entry in the txt file.
 */
public class SearchMovie implements SearchInterface, DisplayInterface {
	/**
	 * File name for movie database
	 */
	static File file = new File("./Database/MovieCollectionNew.txt"); // Edit this if you wana to change directory

	/**
	 * The main function for this view, searches the movie the user wants to find
	 */
	public void main() {
		String input;
		Scanner sc = new Scanner(System.in);

		do {

			System.out.println("\nEnter \"esc\" to quit movie search UI");
			System.out.print("Enter a search term: ");
			input = sc.nextLine();
			find(input);
		} while (!input.toLowerCase().equals("esc"));

	}

	/**
	 * Finds a movie entry excluding those that are coming soon or no longer showing
	 * 
	 * @param n Input String search term
	 * @throws Exception Throw FilenotFound exception
	 */
	public void find(String n) {
		try {
			Scanner sc = new Scanner(file);

			sc.useDelimiter(",");
			System.out.println("The movie details are as follows: \n");
			while (sc.hasNext()) {
				String st = sc.nextLine(); // To get current string with all Capitalisation
				String st2 = st.toLowerCase().toString(); // Changes it to lowercase and string for searching
				n = n.toLowerCase(); // Convert input string toLower to compare
				String[] stToken1 = st.split(",");

				if (st.contains("ENDOFSHOWING")) {
					continue;
				}

				// Print the string
				if (st2.contains(n)) {
					// System.out.println(st); // Display original capitalised version
					// System.out.println();

					display(stToken1);

					System.out.println();
					System.out.println();
				}
			}
			sc.close();

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public void display(String[] stToken1) {
		int i = 0;
		for (String s : stToken1) {
			if (s.equals("-1.0") || s.equals("-1")) {
				s = "NA";
			}
			switch (i) {
				case 0:
					System.out.print("Movie:  ");
					break;
				case 1:
					System.out.print("\nMovie Type:  ");
					break;
				case 2:
					System.out.print("\nMovie Status:  ");
					break;
				case 3:
					System.out.print("\nSynopsis:  ");
					break;
				case 4:
					System.out.print("\nAge Rating:  ");
					break;
				case 5:
					System.out.print("\nStar Rating:  ");
					break;
				case 6:
					System.out.print("\nMovie Duration:  ");
					break;
				case 7:
					System.out.print("\nRelease Date:  ");
					break;
				case 8:
					System.out.print("\nEnd Date:  ");
					break;
				case 9:
					System.out.print("\nDirector:  ");
					break;
				case 10:
					System.out.print("\nSales:  ");
					break;
				case 11:
					System.out.print("\nCast Size:  ");
					break;
				case 12:
					System.out.print("\nCast:  ");
					break;
				default:
					break;

			}

			if (i < 13) {
				System.out.print(s);
				i++;
			} else
				System.out.print(", " + s);
		}
	}

	/**
	 * Function returns the result array of entries that have matching elements with
	 * the search term
	 * 
	 * @param n String search term
	 * @return returns an array containing the list of results
	 */
	public String[] getSearchedMovie(String n) {
		// Stores in index i of an array
		lineCounter l = new lineCounter();
		int count = l.counter(file); // Count is the total num of elements in file
		String[] searchResults = new String[count];
		int i = 0;
		try {
			Scanner sc = new Scanner(file);

			// sc.useDelimiter(",");
			while (sc.hasNext()) {
				String st = sc.nextLine();// To get current string with all Capitalisation
				String st2 = st.toLowerCase().toString(); // Changes it to lowercase and string for searching
				n = n.toLowerCase(); // Convert input string toLower to compare
				// Print the string

				if (st2.contains(n)) {
					if (!st2.equals(null)) {
						searchResults[i] = st;
						i++;
					}
				}
			}
			sc.close();
			// return searchResults;
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return searchResults;
	}

	/**
	 * Function deletes an entry in the file with the exact as the one being input
	 * 
	 * @param n Exact Input string to be deleted
	 */
	public void delMovie(String n) {
		// Note need to add options for deleting
		try {

			File inputFile = file; // Its the same file as the above (Line 7)
			if (!inputFile.isFile()) {
				System.out.println("File does not exist");
				return;
			}
			// Construct the new file that will later be renamed to the original filename.
			File tempFile = new File("./movieTemp.txt");
			BufferedReader br = new BufferedReader(new FileReader("./Database/MovieCollectionNew.txt"));
			PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
			String line = null;

			// Read from the original file and write to the new
			// unless content matches data to be removed.
			while ((line = br.readLine()) != null) {
				if (!line.trim().equals(n)) {
					pw.println(line);
					pw.flush();
				}
			}
			pw.close();
			br.close();

			// Delete the original file
			if (!inputFile.delete()) {
				System.out.println("Could not delete file");
				return;
			} else {
				System.out.println("Deleted: " + n);
			}
			// Rename the new file to the filename the original file had.
			if (!tempFile.renameTo(inputFile))
				System.out.println("Could not rename file");

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
