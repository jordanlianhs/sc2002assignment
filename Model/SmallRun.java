package Model;
import java.util.Scanner;
import java.io.IOException;
import java.time.LocalTime;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.*;

public class SmallRun {
    Scanner s = new Scanner(System.in);
    public static void main(String arg[]) throws IOException{
        ArrayList<String> casting = new ArrayList<>(Arrays.asList("wilson", "wilsonagain"));
        Movie Salakau = new Movie("Salakau", MovieType.THREE_D, "Malay vs Chinese", "Fucking Bad", 2, LocalDate.of(2002, 9, 17), LocalDate.of(2002, 12, 20), "Sakamoto", casting);
        Salakau.writeMovie();
        SeatingPlan myseat = new SeatingPlan();
        Session mysession = new Session(Salakau,LocalDateTime.of(2022, 2, 26, 6, 45), myseat);
        Guest Wilson = new Guest("Wilson", 22, "999", "Wilsonlim@com");

        Booking book = new Booking(Wilson, mysession);

        book.writebookingstatement();
    } 
}
