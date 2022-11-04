package Model;

import java.time.LocalDateTime;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Booking {
    private Guest guest;

    //private LocalDateTime movietime;

    private Movie movie;

    private String ticketID;

    private int price;

    public Booking(Guest guest, Session session){
        this.guest = guest;
        this.movie = session.getMovie();
        //this.movietime = movie.getMovieTime;
        Random rand = new Random();
        this.ticketID = String.valueOf(rand.nextInt(10));
        this.price = 10;
    }

    public void writebookingstatement() throws IOException{
        try{
            File file = new File("Database/BookingStatement.txt");
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter br = new BufferedWriter(fr);
            PrintWriter pr = new PrintWriter(br);
            String shit = ticketID + "," + price + "," + movie.getmovieName();
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
