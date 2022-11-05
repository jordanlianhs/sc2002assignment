package Model;

import java.util.Random;
import java.io.*;
import java.text.*;
import java.util.*;

public class Booking {
    private Guest guest;

    //private LocalDateTime movietime;

    private Movie movie;

    private String seatNumber;

    private String ticketID;    

    private String cinemaCode;

    //private int price;

    public Booking(Guest guest, Session session, String seatNumber, String cinemaCode){
        this.guest = guest;
        this.movie = session.getMovie();
        this.seatNumber = seatNumber;
        //this.movietime = movie.getMovieTime;
        this.cinemaCode = cinemaCode;
        //timestamp is formatted current time
        String timestamp = new SimpleDateFormat("YYYYMMddHHmm").format(new Date());
        
        this.ticketID = cinemaCode + timestamp;
        System.out.println(ticketID);
        //price hardcoded
        //this.price = 10;
    }

    public void writebookingstatement() throws IOException{
        try{
            File file = new File("Database/BookingStatement.txt");
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter br = new BufferedWriter(fr);
            PrintWriter pr = new PrintWriter(br);
            String statement = guest.getEmail() + "," +guest.getPhone() + "," + ticketID + "," + movie.getmovieName() + "," + seatNumber + "," + cinemaCode;
            pr.println(statement);
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

    public String getTicketID() {
        return ticketID;
    }
}
