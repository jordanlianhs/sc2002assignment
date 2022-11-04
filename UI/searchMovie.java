package UI;

import java.util.*;
import java.io.*;

public class searchMovie {

	public static void main(String[] args) throws Exception {
		String input;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Enter \"esc\" to quit searching UI");
			System.out.print("Enter a search term: ");

			input = sc.nextLine();
			searchMovie look = new searchMovie();
			look.find(input);
		} while (!input.toLowerCase().equals("esc"));
	}

	public void find(String n) throws Exception {
		try {
			File file = new File("./Database/MovieCollection.txt");
			Scanner sc = new Scanner(file);

			sc.useDelimiter(",");
			while (sc.hasNext()) {
				String st = sc.nextLine();// To get current string with all Capitalisation
				String st2 = st.toLowerCase().toString(); // Changes it to lowercase and string for searching
				n = n.toLowerCase(); // Convert input string toLower to compare
				// Print the string
				System.out.println(); // Just formatting line
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
}
