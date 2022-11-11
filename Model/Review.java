package Model;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

/**
 * Class for the Reviews for movies
 */
public class Review {
     /**
      * this Review's username (email)
      */
      private String username;
    

      private String movieName;
      /**
       * this Review's number of stars
       */
      private double numOfStars;
  
      /**
       * this Review's additional comment (optional)
       */
      private String additionalComment;


    /**
     * Constructor for Review Class
     */
    public Review(){
    }

    /**
     * Constructor for Review Class
     * @param moviename Name of the movie
     * @param username Username of reviewer
     * @param numOfStars Number of stars that reviewer gave
     * @param additionalComment Additional comment by reviewer
     */
    public Review(String moviename, String username, double numOfStars, String additionalComment) {
        this.movieName = moviename;
        this.username = username;
        this.numOfStars = numOfStars;
        this.additionalComment = additionalComment;
    }

    /**
     * 
     * @return Movie Name
     */
    public String getMovieName() {
        return this.movieName;
    }

    /**
     * Sets movie name
     * @param moviename New movie name
     */
    public void setMovieName(String moviename) {
        this.movieName = moviename;
    }

    /**
     * 
     * @return Reviewer's username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Sets reviewer's username
     * @param username New Username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 
     * @return Number of stars given by reviewer
     */
    public double getNumOfStars() {
        return this.numOfStars;
    }

    /**
     * Sets Number of stars given by Reviewer
     * @param numOfStars New number of stars
     */
    public void setNumOfStars(double numOfStars) {
        this.numOfStars = numOfStars;
    }

    /**
     * 
     * @return Additional comment by reviewer
     */
    public String getAdditionalComment() {
        return this.additionalComment;
    }

    /**
     * Sets Additional comment
     * @param additionalComment New additional comment
     */
    public void setAdditionalComment(String additionalComment) {
        this.additionalComment = additionalComment;
    }

    /**
     * Writes the review to the Review.txt database
     * @throws IOException Throws IOException
     */
    public void writereview(){
        try{
            File file = new File("Database/Review.txt");
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter br = new BufferedWriter(fr);
            PrintWriter pr = new PrintWriter(br);

            File fileMovie = new File("./Database/MovieCollectionNew.txt");
            String movieCorrect = "";
            Scanner sc = new Scanner(fileMovie); 
            sc.useDelimiter("[,\n]");

            while (sc.hasNext()) {
                    String st = sc.next().toString();
                    if (st.toLowerCase().equals(movieName.toLowerCase())) {
                            movieCorrect = st;
                            break;
                    }
            }
            sc.close();

            String shit = movieCorrect + "," + username + "," + String.valueOf(numOfStars) + "," + additionalComment;
            pr.println(shit);
            pr.close();
            br.close();
            fr.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }

        catch(IOException e){
            e.printStackTrace();
        }

    }

    /**
     * Searches for reviews for a particular movie
     * @param n Movie Name
     * @throws Exception Throws Exception
     */
    public void search(String n){
        
        try {
			File file = new File("Database/Review.txt");
			Scanner sc = new Scanner(file);

			sc.useDelimiter(",");
			System.out.println("The movie reviews are as follows: \n");
			while (sc.hasNext()) {
				String st = sc.nextLine(); // To get current string with all Capitalisation
				String st2 = st.toLowerCase().toString(); // Changes it to lowercase and string for searching
				n = n.toLowerCase(); // Convert input string toLower to compare
                String[] stToken = st2.split(",");
				if (stToken[0].equals(n)) {
					System.out.println(st); // Display original capitalised version
					System.out.println();
				}
                
			}
			sc.close();

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
    }

    
}
