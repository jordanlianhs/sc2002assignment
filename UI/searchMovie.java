package UI;

import java.util.*;
import java.io.*;

public class searchMovie {
	String title;

	// Input your diretory of DATABASE here
	public searchMovie() {
	};

	public void find(String n) throws Exception {
		try {
			File file = new File("./Database/movie.txt");
			Scanner sc = new Scanner(file);

			sc.useDelimiter(",");
			while (sc.hasNext()) {
				String st = sc.nextLine().toLowerCase().toString();
				// Print the string
				if (st.contains(n)) {
					System.out.print(st);
				}
			}
			sc.close();

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
