package UI;

import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Rating{

    Scanner sc = new Scanner(System.in);

    public static void main(String arg[]) {

		File file = new File("./Database/movie.txt");

		Scanner sc = new Scanner(file);
		sc.useDelimiter(",");

		while (sc.hasNext()) {
			String st = sc.nextLine().toLowerCase().toString();
            if (st.contains(Movie.getTitle())) {
				// go to the rating column and get the orig rating
			}


        System.out.println("Rate the movie " + Movie.getTitle() + " on a scale of 1 to 5: ");
        int rateMovie = s.nextInt();

        // new rating for that movie = (avg rating * num of ratings + rateMovie) / (num of ratings + 1)
        // num of ratings += 1

        // if num of ratings == 1 {display "NA"}

        

	}
}