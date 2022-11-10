package Model;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

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

    public Review(){
    }

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

    public void search(String n) throws Exception{
        
        try {
			File file = new File("Database/Review.txt");
			Scanner sc = new Scanner(file);

			sc.useDelimiter(",");
			System.out.println("The movie reviews are as follows: ");
			while (sc.hasNext()) {
				String st = sc.nextLine(); // To get current string with all Capitalisation
				String st2 = st.toLowerCase().toString(); // Changes it to lowercase and string for searching
				n = n.toLowerCase(); // Convert input string toLower to compare
                String[] stToken = st2.split(",");
				// Print the string
				System.out.println(); // Just formatting line
				if (stToken[0].equals(n)) {
					System.out.println(st); // Display original capitalised version
					// System.out.println();
				}
                else{
                    System.out.print("");
                }
			}
			sc.close();

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
    }

    
}
