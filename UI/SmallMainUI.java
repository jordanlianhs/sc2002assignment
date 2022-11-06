package UI;
import java.util.*;
import java.io.*;
import Model.*;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class SmallMainUI{
    public static void main(String args[]) throws IOException{
        //initialise shit from database
        ArrayList<Session> Sessionsfrombackside = new ArrayList<>();
        int i=0;
        Scanner sc = new Scanner("./Database/SessionRecords.txt");
        while(sc.hasNextLine()){
            i++;
            sc.nextLine();
        }
        for(int j =0; j<i; j++){
            Sessionsfrombackside.add(new Session());
            Sessionsfrombackside.get(j).read("ABC", 04);
        }


        //login to user
        Guest Xiaoming = new Guest("Xiaoming", 50, "1234", "Xiaoming@gmail.com", false);
        //book movie
        CheckSeatUI curCheckSeat = new CheckSeatUI(Xiaoming, Sessionsfrombackside.get(0), "cinemacode");
        curCheckSeat.main();
        //check booking
        CheckBookingUI curBooking = new CheckBookingUI();
        curBooking.main();

        //Booking book = new Booking(Xiaoming, Sessionsfrombackside.get(0), "B3");
        //book.writebookingstatement();
    
        //Session mysession = new Session(Salakau,LocalDateTime.of(2022, 2, 26, 6, 45));
        
    }


}
