package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Rating{

    static Scanner s = new Scanner(System.in);

    public static void main(String arg[]) {



        System.out.println("Rate the movie " + Movie.getTitle + " on a scale of 1 to 5: ");
        int rateMovie = s.nextInt();

        // new rating for that movie = (avg rating * num of ratings + rateMovie) / (num of ratings + 1)
        // num of ratings += 1

        // if num of ratings == 1 {display "NA"}

	}
}