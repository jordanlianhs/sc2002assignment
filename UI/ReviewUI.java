package UI;
import java.util.*;
import java.io.IOException;
import Model.*;

public class ReviewUI {
    public static void main(String arg[]) throws IOException{
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the name of movie to review");
        String moviename  = s.nextLine();

        System.out.println("Enter your email address");
        String email = s.nextLine();

        System.out.println("Number of stars for the movie");
        double stars = s.nextDouble();
        
        String test = s.nextLine();

        System.out.println("Enter your comments");
        String comment = s.nextLine();

        Review racket = new Review(moviename, email, stars, comment);
        racket.writereview();

        Rating star = new Rating(moviename, stars);
        star.editAvgRating();

        s.close();
    }
}
