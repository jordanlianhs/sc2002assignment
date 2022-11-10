package UI;

import java.util.*;
import java.io.IOException;
import Model.*;
import java.io.File;

public class ReviewUI {
        public static void main(String arg[], Guest user) throws IOException {
                Scanner s = new Scanner(System.in);
                
                // check if movie exists
                File file = new File("./Database/MovieCollectionNew.txt");
                String moviename;

                int i;
                
                do{
                        System.out.println("Enter the name of movie to review:");
                        moviename = s.nextLine(); 
                        Scanner sc = new Scanner(file); 
                        sc.useDelimiter("[,\n]");
                        i = 0;

                        while (sc.hasNext()) {
                                String st = sc.next().toLowerCase().toString();
                                if (st.equals(moviename.toLowerCase())) {
                                        i = 1;
                                        break;
                                }
                        }

                        if (i==0) System.out.println("Movie does not exist!\n");
                        sc.close();

                } while(i==0);

                System.out.println("Number of stars for the movie:");
                String temp = s.nextLine();
                double stars = Double.valueOf(temp);

                System.out.println("Enter your comments:");
                String comment = s.nextLine();

                Review review = new Review(moviename, user.getEmail(), stars, comment);
                review.writereview();

                Rating star = new Rating(moviename, stars);
                star.editAvgRating();

        }
}
