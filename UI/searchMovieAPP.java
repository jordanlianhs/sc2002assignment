package UI;

import java.util.*;

public class searchMovieAPP {

	public static void main(String[] args) throws Exception {
		String input;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a search term");
		input = sc.nextLine();
		searchMovie look = new searchMovie();
		look.find(input);
	}
}
