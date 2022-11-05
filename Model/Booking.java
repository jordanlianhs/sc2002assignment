package Model;

import java.util.Random;
import java.io.*;

public class Booking {
    private Guest guest;

    //private LocalDateTime movietime;

    private Movie movie;

    private String seatNumber;

    private String ticketID;

    private int price;

    public Booking(Guest guest, Session session, String seatNumber){
        this.guest = guest;
        this.movie = session.getMovie();
        this.seatNumber = seatNumber;
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
            String shit = guest.getEmail() + "," + ticketID + "," + price + "," + movie.getmovieName() + "," + seatNumber;
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
