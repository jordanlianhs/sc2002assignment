package Model;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.*;

public class CineplexRun {
    public static void main(String arg[]) throws IOException{
        Cineplex Apple = new Cineplex("angmokio", "ABC");
        Cineplex Banana = new Cineplex("bishan", "BBC");
        Cineplex Chicken = new Cineplex("choachukang", "CCB");

        //login to user
        Guest Xiaoming = new Guest("Xiaoming", 50, "1234", "Xiaoming@gmail.com", false);
        
        
        
        //book movie
        CheckSeatUI curCheckSeat = new CheckSeatUI(Xiaoming, Sessionsfrombackside.get(0), "cinemacode");
        curCheckSeat.main();
        //check booking
        CheckBookingUI curBooking = new CheckBookingUI();
        curBooking.main();

    }
}
