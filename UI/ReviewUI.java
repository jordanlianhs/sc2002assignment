package UI;
import java.util.*;
import java.io.IOException;
import Model.*;

public class ReviewUI {
    Scanner s = new Scanner(System.in);
    public void main(String arg[]) throws IOException{
        System.out.println("Enter the name of movie to review");
        String moviename  = s.next();

        System.out.println("Enter your email address");
        String email = s.next();

        System.out.println("Number of stars for the movie");
        double stars = s.nextInt();

        System.out.println("Enter your comments");
        String comment = s.next();

        Review racket = new Review(moviename, email, stars, comment);
        racket.writereview();
    }
}
