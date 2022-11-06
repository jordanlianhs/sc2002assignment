package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class Rating {


            else
            {
              newRating = String.valueOf((curAvgRating * numOfRatingsi + numOfStars) / (numOfRatingsi + 1));
            }
            
            numOfRatingsi += 1;
            String numOfRatings = String.valueOf(numOfRatingsi);
            String firstRating = String.valueOf(firstRatingf);


            // append rating.txt
            String tempFile = "./Database/temp.txt";
            File oldFile = new File("./Database/rating.txt");
            File newFile = new File(tempFile);
            String movietitle = "";
            String starRating = "";
            String oldNumOfRatings = "";
            String oldFirstRating = "";


            FileWriter fw = new FileWriter(tempFile, true); // appends to rating.txt
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            Scanner x = new Scanner(new File("./Database/rating.txt"));
            x.useDelimiter("[,\n]");
        
            while(x.hasNext()){
              movietitle = x.next();
              starRating = x.next();
              oldNumOfRatings = x.next();
              oldFirstRating = x.next();

              if (movietitle == movieName)
              {
                pw.println(movietitle + "," + newRating + "," + numOfRatings + "," + firstRating);
              }
        
              else{
                pw.println(movietitle + "," + starRating + "," + oldNumOfRatings + "," + oldFirstRating);
              }
        
              x.close();
              pw.flush();
              oldFile.delete();
              File dump = new File("./Database/rating.txt");
              newFile.renameTo(dump);
            }


            // append movie.txt
            String file1 = "Database/movie.txt";
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

            while(y.hasNext()){
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

              if (movietitle1 == movieName)
              {       
                pw.print(movieName + "," + movieType + "," + synopsis + "," + ageRating + "," + newRating + "," + duration + "," + movieReleaseDate + "," + movieEndDate + "," + director + "," + sizeofCast + "," + sales);
              }
        
              else{
                pw.print(movietitle1 + "," + movieType + "," + synopsis + "," + ageRating + "," + starRating1 + "," + duration + "," + movieReleaseDate + "," + movieEndDate + "," + director + "," + sizeofCast + "," + sales);
              }
        
              y.close();
              pw1.flush();
              oldFile1.delete();
              File dump = new File(file1);
              newFile1.renameTo(dump);
            }   
            
            sc.close();
      double firstRatingf = 0;

      String newRating;

      sc.useDelimiter(",");

      // Issue is that searching makes the scanner skip to the next line...
      while (sc.hasNext()) { // Finds the corresponding entry
        String st = sc.next().toLowerCase().toString();
        // System.out.println(st);
        String lowerName = movieName.toLowerCase();
        if (st.contains(lowerName)) {
          curAvgRating = Float.parseFloat(sc.next());
          numOfRatingsi = Integer.parseInt(sc.next());
          firstRatingf = Double.parseDouble(sc.next());
          // go to the rating column and get the orig rating
        }
      }

      // System.out.println("Current Avg: " + curAvgRating);
      // System.out.println("Num of Ratings: " + numOfRatingsi);
      // System.out.println("First Rating: " + firstRatingf);
      sc.close();

      // Default cases before new input (calculating avg rating)

      if (numOfRatingsi == 0) {
        newRating = "0"; // Change to NA and parse to check it
        firstRatingf = numOfStars;
      } else if (numOfRatingsi == 1) { // 2 total ratings
        newRating = String.valueOf((firstRatingf + numOfStars) / 2);
      } else { // More than 2 ratings
        newRating = String.valueOf((curAvgRating * numOfRatingsi + numOfStars) / (numOfRatingsi + 1));
      }
      numOfRatingsi += 1;

      String numOfRatings = String.valueOf(numOfRatingsi);
      String firstRating = String.valueOf(firstRatingf);

      // append rating.txt
      File newFile = new File("./Database/temp.txt"); // Construct new file which will be renamed to old
      File oldFile = new File("./Database/rating.txt");

      // String movietitle = "";
      // String starRating = "";
      // String oldNumOfRatings = "";
      // String oldFirstRating = "";

      FileWriter fw = new FileWriter(newFile, true); // appends to rating.txt
      BufferedWriter bw = new BufferedWriter(fw);
      PrintWriter pw = new PrintWriter(bw);
      Scanner x = new Scanner(new File("./Database/rating.txt"));
      x.useDelimiter("[,\n]");

      while (x.hasNext()) {
        String movietitle = x.next();
        String starRating = x.next();
        String oldNumOfRatings = x.next();
        String oldFirstRating = x.next();

        String line = (movietitle + "," + newRating + "," + numOfRatings + "," + firstRating + ",");

        if (movietitle.equals(movieName)) {
          System.out.println(line);
          pw.println(line);
          pw.flush();
        } else {
          pw.println(line);
          pw.flush();
        }

      }
      x.close();
      pw.close();
      fw.close();
      if (!oldFile.delete()) {
        System.out.println("Could not delete rating.txt");
      }
      if (!newFile.renameTo(oldFile)) {
        System.out.println("Could not rename File");
      }

      // File dump = new File("./Database/rating.txt");

      // // append movie.txt
      // String file1 = "./Database/movie.txt";
      // String tempFile1 = "./Database/temp1.txt";
      // File oldFile1 = new File(file1);
      // File newFile1 = new File(tempFile1);

      // String movietitle1 = "";
      // String movieType = "";
      // String synopsis = "";
      // String ageRating = "";
      // String starRating1 = "";
      // String duration = "";
      // String movieReleaseDate = "";
      // String movieEndDate = "";
      // String director = "";
      // String sizeofCast = "";
      // String sales = "";

      // FileWriter fw1 = new FileWriter(tempFile1, true); // appends to movie.txt
      // BufferedWriter bw1 = new BufferedWriter(fw1);
      // PrintWriter pw1 = new PrintWriter(bw1);
      // Scanner y = new Scanner(new File(file1));
      // y.useDelimiter("[,\n]");

      // while (y.hasNext()) {
      // movietitle1 = y.next();
      // movieType = y.next();
      // synopsis = y.next();
      // ageRating = y.next();
      // starRating1 = y.next();
      // duration = y.next();
      // movieReleaseDate = y.next();
      // movieEndDate = y.next();
      // director = y.next();
      // sizeofCast = y.next();
      // sales = y.next();

      // if (movietitle1 == movieName) {
      // pw.print(movieName + "," + movieType + "," + synopsis + "," + ageRating + ","
      // + newRating + "," + duration
      // + "," + movieReleaseDate + "," + movieEndDate + "," + director + "," +
      // sizeofCast + "," + sales);
      // }

      // else {
      // pw.print(movietitle1 + "," + movieType + "," + synopsis + "," + ageRating +
      // "," + starRating1 + "," + duration
      // + "," + movieReleaseDate + "," + movieEndDate + "," + director + "," +
      // sizeofCast + "," + sales);
      // }

      // // y.close();
      // }
      // pw1.flush();
      // oldFile1.delete();
      // File dump1 = new File(file1);
      // newFile1.renameTo(dump1);
      // // newFile1.delete();

      // // sc.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (NumberFormatException e) {
      e.printStackTrace();
    }

  }

}
