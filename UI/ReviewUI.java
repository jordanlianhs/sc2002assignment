package UI;

import java.util.*;
import java.io.IOException;
import Model.*;

public class ReviewUI {
        public static void main(String arg[], Guest user) throws IOException {
                Scanner s = new Scanner(System.in);
                System.out.println("Enter the name of movie to review");
                String moviename = s.nextLine();

                System.out.println("Number of stars for the movie");
                String temp = s.nextLine();
                double stars = Double.valueOf(temp);

                System.out.println("Enter your comments");
                String comment = s.nextLine();

                Review review = new Review(moviename, user.getEmail(), stars, comment);
                review.writereview();

                Rating star = new Rating(moviename, stars);
                star.editAvgRating();

        }
}
