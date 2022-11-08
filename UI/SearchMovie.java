package UI;

import java.util.*;
import java.io.*;

public class SearchMovie {
	static File file = new File("./Database/MovieCollectionNew.txt"); // Edit this if you wana to change directory

	/**
	 * The main function for this view, searches the movie the user wants
	 * 
	 * @param args for the main function
	 * @throws Exception to throw the exception
	 * 
	 */
	public static void main(String[] args) throws Exception {
		String input;
		Scanner sc = new Scanner(System.in);

		do {

			System.out.println("\nEnter \"esc\" to quit movie search UI");
			System.out.print("Enter a search term: ");
			input = sc.nextLine();
			SearchMovie look = new SearchMovie();
			look.find(input);
		} while (!input.toLowerCase().equals("esc"));
	}

	/**
	 * Lists all movies
	 */

	public static void listMovie() {
		try {
			File file = new File("./Database/MovieCollectionNew.txt");
			Scanner sc = new Scanner(file);

			sc.useDelimiter(",");
			System.out.println("\nList of Movies: ");
			while (sc.hasNext()) {
				String st = sc.nextLine(); // To get current string with all Capitalisation
				System.out.println(st);
			}
			sc.close();

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	/**
	 * Finds a movie entry
	 * 
	 * @param n
	 * @throws Exception
	 */
	public static void find(String n) throws Exception {
		try {
			// File file = new File("./Database/MovieCollectionNew.txt");
			Scanner sc = new Scanner(file);

			sc.useDelimiter(",");
			System.out.println("The movie details are as follows: ");
			while (sc.hasNext()) {
				String st = sc.nextLine(); // To get current string with all Capitalisation
				String st2 = st.toLowerCase().toString(); // Changes it to lowercase and string for searching
				n = n.toLowerCase(); // Convert input string toLower to compare
				// Print the string
				if (st2.contains(n)) {
					System.out.println(st); // Display original capitalised version
					// System.out.println();
				}
			}
			sc.close();

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static String[] getSearchedMovie(String n) {
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

	public static void delMovie(String n) {
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
