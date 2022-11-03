package UI;

import java.util.*;
import java.io.*;

public class searchMovie {
	String title;

	public searchMovie() {
	};

	public void find(String n) throws Exception {
		try {
			File file = new File("./Database/movie.txt");
			Scanner sc = new Scanner(file);

			sc.useDelimiter(",");
			while (sc.hasNext()) {
				String st = sc.nextLine();// To get current string with all Capitalisation
				String st2 = st.toLowerCase().toString(); // Changes it to lowercase and string for searching
				// Print the string
				if (st2.contains(n)) {
					System.out.print(st + "\n\n"); // Display original capitalised version

				}
			}
			sc.close();

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
