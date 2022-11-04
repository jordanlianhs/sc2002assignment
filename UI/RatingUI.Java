package UI;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Rating{

    Scanner sc = new Scanner(System.in);

    public static void main(String arg[]) {

		File file = new File("./Database/movie.txt");

		Scanner sc = new Scanner(file);
		sc.useDelimiter(",");

		while (sc.hasNext()) {
			String st = sc.nextLine().toLowerCase().toString();
            if (st.contains(Movie.getTitle())) {
				// go to the rating column and get the orig rating
			}


        System.out.println("Rate the movie " + Movie.getTitle() + " on a scale of 1 to 5: ");
        int rateMovie = s.nextInt();

        // new rating for that movie = (avg rating * num of ratings + rateMovie) / (num of ratings + 1)
        // num of ratings += 1

        // if num of ratings == 1 {display "NA"}

        
    String newRating = "";

    editRating(file, movieTitle, newRating);


	}
}


public static void editRating(String file, String movieTitle, String newRating)
{
  String tempFile = "./Database/temp.txt";
  File oldFile = new File(file);
  File newFile = new File(tempFile);
  String avgRating = "";

  try
  {
    FileWriter fw = new FileWriter(tempFile, true); // appends to movie.txt
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter pw = new PrintWriter(bw);
    x = new Scanner(new File(file));
    x.useDelimeter("[,\n]");

    int i=0;
    while(x.hasNext()){
      item = x.next();
      if (i=0 && //found movie title)
      {
        /* eg
         * genre = x.next;
         * actors = x.next;
         * avgRating = x.next;
         */

        pw.print(//movie title + "," + genre + "," + actors + "," + avgRating);

        i=4; // change index to point to aft avgRating
        continue;
      }

      else{
        pw.print("," + item);
        if (i = //num of items in line-1)
        {
          pw.print("\n");
          i=0;
          continue;
        }
        i++;
      }

      x.close();
      pw.flush();
      oldFile.delete();
      File dump = new File(file);
      newFile.renameTo(dump);

    }
  }

}