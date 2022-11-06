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


    public void editAvgRating() throws IOException{
        try{
            File file = new File("./Database/rating.txt");
            Scanner sc = new Scanner(file);
            sc.useDelimiter(",");
            
            float curAvgRating=0;
            int numOfRatingsi=0;
            double firstRatingf=0;
            String newRating;

            while (sc.hasNext()) {
              String st = sc.next().toLowerCase().toString();
              if (st.contains(movieName)) {
              // go to the rating column and get the orig rating
                curAvgRating = Float.parseFloat(sc.next());
                numOfRatingsi = Integer.parseInt(sc.next());
                firstRatingf = Float.parseFloat(sc.next());
              }
            }

            if (numOfRatingsi == 0) 
            {
              newRating = "NA";
              firstRatingf = numOfStars;
            }

            else if (numOfRatingsi == 1)
            {
              newRating = String.valueOf((firstRatingf + numOfStars) / 2);
            }

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
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }

        catch(IOException e){
            e.printStackTrace();
        }

    }

    
}


