package UI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Model.Movie;
import Model.MovieStatus;
import Model.MovieType;
import Model.Rating;

/**
 * This class initialises movie variables and writes an entry into the
 * MovieCollectionNew.txt file.
 */
public class CreateMovie {
    /**
     * Movie Object
     */
    private Movie movie;

    /**
     * Main function driving the view
     * 
     * @param args null argument can be used to drive the function
     * @throws Exception Throws Exception
     */
    public void main(){
        Scanner sc = new Scanner(System.in);
        String movieName;
        MovieType movieType;
        MovieStatus movieStatus;
        String synopsis;
        String ageRating;
        float starRating;
        double duration;
        LocalDate movieReleaseDate;
        LocalDate movieEndDate;
        String director;
        int sales;
        ArrayList<String> cast = new ArrayList<String>();
        String temp;

        System.out.println("-----------------------------------");
        System.out.println("Create Movie");
        System.out.println("-----------------------------------");

        System.out.print("Movie Name: ");
        movieName = sc.nextLine();

        System.out.println();
        System.out.println("What is the movie type? ");
        System.out.println("1: 2D");
        System.out.println("2: 3D");
        System.out.println("3: 2D Blockbuster");
        System.out.println("4: 3D Blockbuster");
        System.out.println("Enter your option:");
        temp = sc.nextLine();
        switch (Integer.valueOf(temp)) {
            case 1:
                movieType = MovieType.TWO_D;
                break;
            case 2:
                movieType = MovieType.THREE_D;
                break;
            case 3:
                movieType = MovieType.TWO_D_BB;
                break;
            case 4:
                movieType = MovieType.THREE_D_BB;
                break;
            default:
                System.out.println("\nWrong input!");
                System.out.println("Returning to Movie CRUD UI....");
                return;
        }

        System.out.println();
        System.out.println("Movie Status: ");
        System.out.println("1: Coming soon!");
        System.out.println("2: Preview");
        System.out.println("3: Now showing");
        System.out.println("4: End of showing");
        System.out.println("Enter your option:");
        temp = sc.nextLine();
        switch (Integer.valueOf(temp)) {
            case 1:
                movieStatus = MovieStatus.COMINGSOON;
                break;
            case 2:
                movieStatus = MovieStatus.PREVIEW;
                break;
            case 3:
                movieStatus = MovieStatus.NOWSHOWING;
                break;
            case 4:
                movieStatus = MovieStatus.ENDOFSHOWING;
                break;
            default:
                System.out.println("Wrong input!");
                return;
        }

        System.out.println();
        System.out.print("Movie Synopsis: ");
        synopsis = sc.nextLine();

        System.out.println();
        System.out.print("Movie Age Rating: ");
        ageRating = sc.nextLine();

        starRating = -1;

        System.out.println();
        System.out.print("Movie Duration: ");
        temp = sc.nextLine();
        duration = Double.valueOf(temp);

        System.out.println();
        System.out.print("Release Date of the Movie (yyyy-MM-dd): ");
        temp = sc.nextLine();
        if (checkDate(temp)) {
            movieReleaseDate = LocalDate.parse(temp);
        } else {
            System.out.println("Wrong input!");
            return;
        }

        System.out.println();
        System.out.print("End Date of the Movie (yyyy-MM-dd): ");
        temp = sc.nextLine();
        if (checkDate(temp)) {
            movieEndDate = LocalDate.parse(temp);
        } else {
            System.out.println("Wrong input!");
            return;
        }

        System.out.println();
        System.out.print("Director: ");
        director = sc.nextLine();

        sales = 0;

        System.out.println();
        System.out.println("Movie Cast (Separate cast by commas): ");
        temp = sc.nextLine();
        String[] tempArr = temp.split("\\s*,\\s*");
        for (String s : tempArr) {
            cast.add(s);
        }

        movie = new Movie(movieName, movieType, movieStatus, synopsis, ageRating, starRating, duration, movieReleaseDate, movieEndDate, director, sales, cast);
        movie.writeMovie();

        Rating rating = new Rating(movieName, starRating);
        rating.createMovieRating();

        System.out.println("Movie Created Successfully!!!");
        System.out.println();
    }

    /**
     * Function to check if the date is valid
     * 
     * @param date Date to be checked
     * @return Returns true if the date is valid
     */
    public boolean checkDate(String input){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(input);
            System.out.println("Date input: " + date); // This is just for debugging

        } catch (ParseException e) {
            System.out.println("INVALID DATE!");
            return false;
        }
        return true;
    }
}
