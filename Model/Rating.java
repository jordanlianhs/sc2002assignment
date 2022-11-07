package Model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class Rating {

  /**
   * this Rating's movie name
   */
  private String movieName;

  /**
   * this Review's number of stars
   */
  private double numOfStars;

  public Rating(String moviename, double numOfStars) {
    this.movieName = moviename;
    this.numOfStars = numOfStars;
  }

  public String getMovieName() {
    return this.movieName;
  }

  public void setMovieName(String moviename) {
    this.movieName = moviename;
  }

  public double getNumOfStars() {
    return this.numOfStars;
  }

  public void setNumOfStars(double numOfStars) {
    this.numOfStars = numOfStars;
  }

  public void editAvgRating() throws IOException {
    try {
      File ratingFile = new File("./Database/rating.txt");
      Scanner sc = new Scanner(ratingFile);
      sc.useDelimiter("[,\n]");

      double curAvgRating = 0;
      int numOfRatingsi = 0;
      double firstRatingd = 0;
      String newRating;


      while (sc.hasNext()) {
        String st = sc.next().toLowerCase().toString();
        if (st.contains(movieName.toLowerCase())) {
          // go to the rating column and get the orig rating
          curAvgRating = Double.parseDouble(sc.next());
          numOfRatingsi = Integer.parseInt(sc.next());
          firstRatingd = Double.parseDouble(sc.next());
        }
      }

      // Default cases before new input (calculating ag rating)

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
      //appendMovieTXT(movieName, newRating);

      sc.close();
    } 
    
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    catch (IOException e) {
      e.printStackTrace();
    }

  }


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

      FileWriter fw = new FileWriter(tempFile, true); // appends to rating.txt
      BufferedWriter bw = new BufferedWriter(fw);
      PrintWriter pw = new PrintWriter(bw);
      Scanner x = new Scanner(new File(file));
      x.useDelimiter("[,\n]");

      while (x.hasNext()) {
        movietitle = x.next();
        starRating = x.next();
        oldNumOfRatings = x.next();
        oldFirstRating = x.next();

        if (movietitle.toLowerCase().equals(movieName.toLowerCase())) {
          pw.println(movietitle + "," + newRating + "," + numOfRatings + "," + firstRating);
        }

        else {
          pw.print(movietitle + "," + starRating + "," + oldNumOfRatings + "," + oldFirstRating);
        }

      }
      x.close();
      pw.flush();
      pw.close();
      if (oldFile.delete()) System.out.println("deleted");
      File dump = new File(file);
      newFile.renameTo(dump);
      
      //if (newFile.delete()) System.out.println("deleted");
    }

    catch (Exception e) {
      System.out.println("Rating File Error");
    }


  }

  public static void appendMovieTXT(String movieName, String newRating)
  {
    try {
      // append movie.txt
      String file1 = "./Database/movie.txt";
      String tempFile1 = "./Database/temp1.txt";
      File oldFile1 = new File(file1);
      File newFile1 = new File(tempFile1);

      String movietitle1 = "";
      String movieType = "";
      String synopsis = "";
      String ageRating = "";
      String starRating1 = "";
      String duration = "";
      String movieReleaseDate = "";
      String movieEndDate = "";
      String director = "";
      String sizeofCast = "";
      String sales = "";

      FileWriter fw1 = new FileWriter(tempFile1, true); // appends to movie.txt
      BufferedWriter bw1 = new BufferedWriter(fw1);
      PrintWriter pw1 = new PrintWriter(bw1);
      Scanner y = new Scanner(new File(file1));
      y.useDelimiter("[,\n]");

      while (y.hasNext()) {
        movietitle1 = y.next();
        movieType = y.next();
        synopsis = y.next();
        ageRating = y.next();
        starRating1 = y.next();
        duration = y.next();
        movieReleaseDate = y.next();
        movieEndDate = y.next();
        director = y.next();
        sizeofCast = y.next();
        sales = y.next();

        if (movietitle1.toLowerCase().equals(movieName.toLowerCase())) {
          pw1.print(movieName + "," + movieType + "," + synopsis + "," + ageRating + "," + newRating + "," + duration
              + "," + movieReleaseDate + "," + movieEndDate + "," + director + "," + sizeofCast + "," + sales);
        }

        else {
          pw1.print(movietitle1 + "," + movieType + "," + synopsis + "," + ageRating + "," + starRating1 + "," + duration
              + "," + movieReleaseDate + "," + movieEndDate + "," + director + "," + sizeofCast + "," + sales);
        }

      }
      y.close();
      pw1.flush();
      pw1.close();
      oldFile1.delete();
      File dump1 = new File(file1);
      newFile1.renameTo(dump1);
    }

    catch (Exception e) {
      System.out.println("Movie File Error");
    }

  }


}