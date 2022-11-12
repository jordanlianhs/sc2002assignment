package UI;

import java.util.*;
import java.io.*;

/**
 * This class provides fundamental functions to access txt files. Finding a
 * movie, Searching for a movie (Returns an array of results),
 * and deleting an entry in the txt file.
 */
public class SearchMovie {
	/**
	 * File name for movie database
	 */
	static File file = new File("./Database/MovieCollectionNew.txt"); // Edit this if you wana to change directory

	/**
	 * The main function for this view, searches the movie the user wants to find
	 */
	public void main(){
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
	public void find(String n){
		try {
			Scanner sc = new Scanner(file);

			sc.useDelimiter(",");
			System.out.println("The movie details are as follows: \n");
			while (sc.hasNext()) {
				String st = sc.nextLine(); // To get current string with all Capitalisation
				String st2 = st.toLowerCase().toString(); // Changes it to lowercase and string for searching
				n = n.toLowerCase(); // Convert input string toLower to compare

				if (st.contains("ENDOFSHOWING")) {
					continue;
				}

				// Print the string
				if (st2.contains(n)) {
					System.out.println(st); // Display original capitalised version
					System.out.println();
				}
			}
			sc.close();

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
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
