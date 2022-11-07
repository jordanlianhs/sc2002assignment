package Model;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;

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


    public Review(String moviename, String username, double numOfStars, String additionalComment) {
        this.movieName = moviename;
        this.username = username;
        this.numOfStars = numOfStars;
        this.additionalComment = additionalComment;
    }

    public String getMovieName() {
        return this.movieName;
    }

    public void setMovieName(String moviename) {
        this.movieName = moviename;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getNumOfStars() {
        return this.numOfStars;
    }

    public void setNumOfStars(double numOfStars) {
        this.numOfStars = numOfStars;
    }

    public String getAdditionalComment() {
        return this.additionalComment;
    }

    public void setAdditionalComment(String additionalComment) {
        this.additionalComment = additionalComment;
    }

    public void writereview() throws IOException{
        try{
            File file = new File("Database/Review.txt");
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter br = new BufferedWriter(fr);
            PrintWriter pr = new PrintWriter(br);
            String shit = movieName + "," + username + "," + String.valueOf(numOfStars) + "," + additionalComment;
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

    
}
