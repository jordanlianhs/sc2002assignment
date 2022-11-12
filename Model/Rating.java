package Model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * Class for the Ratings of movies
 */
public class Rating {

  /**
   * This Rating's movie name
   */
  private String movieName;

  /**
   * This Rating's number of stars
   */
  private double numOfStars;

  /**
   * Constructor for Rating Class
   * 
   * @param moviename for the movie title
   * @param numOfStars for the average user rating
   */
  public Rating(String moviename, double numOfStars) {
    this.movieName = moviename;
    this.numOfStars = numOfStars;
  }

  /**
   * Getter for movie name
   * @return movie name
   */
  public String getMovieName() {
    return this.movieName;
  }

  /**
   * Setter for movie name
   * @param moviename
   */
  public void setMovieName(String moviename) {
    this.movieName = moviename;
  }

  /**
   * getter for number of stars
   * @return Number of stars for rating
   */
  public double getNumOfStars() {
    return this.numOfStars;
  }

  /**
   * setter for number of stars
   * @param numOfStars new number of stars
   */
  public void setNumOfStars(double numOfStars) {
    this.numOfStars = numOfStars;
  }

  /**
   * Calculates Average rating and calls methods to update rating and movie database
   */
  public void editAvgRating(){
    try {
      File ratingFile = new File("./Database/rating.txt");
      Scanner sc = new Scanner(ratingFile);
      sc.useDelimiter("[,\n]");

      double curAvgRating = 0;
      int numOfRatingsi = 0;
      double firstRatingd = 0;
      String newRating;


      while (sc.hasNext()) {
        String st = sc.next().toLowerCase();
        if (st.contains(movieName.toLowerCase())) {
          // go to the rating column and get the orig rating
          curAvgRating = Double.parseDouble(sc.next());
          numOfRatingsi = Integer.parseInt(sc.next());
          firstRatingd = Double.parseDouble(sc.next());
        }
      }

      sc.close();

      // Default cases before new input (calculating avg rating)

      if (numOfRatingsi == 0) {
        newRating = "-1";
        firstRatingd = numOfStars;
      } 
      else if (numOfRatingsi == 1) { // 2 total ratings
        curAvgRating = (firstRatingd + numOfStars) / 2;
        newRating = String.format("%.1f", curAvgRating);
      } 
      else { // More than 2 ratings
        curAvgRating = (curAvgRating * numOfRatingsi + numOfStars) / (numOfRatingsi + 1);
        newRating = String.format("%.1f", curAvgRating);
      }
      numOfRatingsi += 1;

      String numOfRatings = String.valueOf(numOfRatingsi);
      String firstRating = String.valueOf(firstRatingd);

      appendRatingTXT(movieName, newRating, numOfRatings, firstRating);
      appendMovieTXT(movieName, newRating);

    } 
    catch (IOException e) {
      e.printStackTrace();
    }

  }

  /**
   * Creates movie rating for new movies, initialises values of new rating to -1, number of ratings to 0 and first rating to -1
   */
  public void createMovieRating(){
    try {
      File file = new File("./Database/rating.txt");
      FileWriter fr = new FileWriter(file, true);
      BufferedWriter br = new BufferedWriter(fr);
      PrintWriter pr = new PrintWriter(br);
      pr.println(movieName + "," + -1 + "," + 0 + "," + -1);
      pr.close();
      br.close();
      fr.close();
    }

    catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Updates rating database
   * @param movieName Movie Name
   * @param newRating New Rating
   * @param numOfRatings Number of ratings
   * @param firstRating First rating
   */
  public static void appendRatingTXT(String movieName, String newRating, String numOfRatings, String firstRating)
  {
    try {
      // append rating.txt
      String file = "./Database/rating.txt";
      String tempFile = "./Database/temp.txt"; // Construct new file which will be renamed to old
      File oldFile = new File(file);
      File newFile = new File(tempFile);

      String movietitle = "";
      String starRating = "";
      String oldNumOfRatings = "";
      String oldFirstRating = "";

      FileWriter fw = new FileWriter(newFile, true); // appends to rating.txt
      BufferedWriter bw = new BufferedWriter(fw);
      PrintWriter pw = new PrintWriter(bw);
      Scanner x = new Scanner(oldFile);
      x.useDelimiter("[,\n]");

      while (x.hasNext()) {
        movietitle = x.next();
        starRating = x.next();
        oldNumOfRatings = x.next();
        oldFirstRating = x.next();

        if (movietitle.equalsIgnoreCase(movieName)) {
          pw.print(movietitle + "," + newRating + "," + numOfRatings + "," + firstRating + "\n");
          pw.flush();
        }

        else {
          pw.print(movietitle + "," + starRating + "," + oldNumOfRatings + "," + oldFirstRating + "\n");
          pw.flush();
        }

      }
      x.close();
      pw.close();
      bw.close();
      fw.close();

      if(oldFile.delete()){
        File dump = new File(file);
        if(!newFile.renameTo(dump)){
          System.out.println("Error");
        }
      }
      else{
        System.out.println("Error");
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }


  }

  /**
   * Updates movie database with new rating
   * @param movieName Movie Name
   * @param newRating New Rating
   */
  public static void appendMovieTXT(String movieName, String newRating)
  {
    try {
      // append MovieCollectionNew.txt
      String file1 = "./Database/MovieCollectionNew.txt";
      String tempFile1 = "./Database/temp1.txt";
      File oldFile1 = new File(file1);
      File newFile1 = new File(tempFile1);

      FileWriter fw1 = new FileWriter(newFile1, true); // appends to movie.txt
      BufferedWriter bw1 = new BufferedWriter(fw1);
      PrintWriter pw1 = new PrintWriter(bw1);
      Scanner y = new Scanner(new File(file1));
      y.useDelimiter("[,\n]");

      String text;

      while (y.hasNextLine()) {
        text = y.nextLine();
        String[] elements = text.split(",");
        String movietitle1 = elements[0];
        String movieType = elements[1];
        String movieStatus = elements[2];
        String synopsis = elements[3];
        String ageRating = elements[4];
        String starRating1 = elements[5];
        String duration = elements[6];
        String movieReleaseDate = elements[7];
        String movieEndDate = elements[8];
        String director = elements[9];
        String sales = elements[10];
        String sizeOfCast = elements[11];
        ArrayList<String> cast = new ArrayList<>();
        for(int u=12; u<(Integer.valueOf(sizeOfCast)+12); u++){
            cast.add(elements[u]);
        }
        String castStr = String.join(",", cast);

        if (movietitle1.toLowerCase().equals(movieName.toLowerCase())) {
          pw1.print(movietitle1 + "," + movieType + "," + movieStatus + "," + synopsis + "," + ageRating + "," + newRating + "," + duration
              + "," + movieReleaseDate + "," + movieEndDate + "," + director + "," + sales + "," + sizeOfCast + "," + castStr + "\n");
          pw1.flush();
        }

        else {
          pw1.print(movietitle1 + "," + movieType + "," + movieStatus + "," + synopsis + "," + ageRating + "," + starRating1 + "," + duration
              + "," + movieReleaseDate + "," + movieEndDate + "," + director + "," + sales + "," + sizeOfCast + "," + castStr + "\n");
          pw1.flush();
        }

      }

      y.close();
      pw1.close();
      bw1.close();
      fw1.close();

      if(oldFile1.delete()){
        File dump1 = new File(file1);
        if(!newFile1.renameTo(dump1)){
          System.out.println("Error");
        }
      }
      else{
        System.out.println("Error");
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }

  }


}