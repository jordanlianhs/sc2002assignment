package Model;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.*;

public class SmallRun {
    //Scanner s = new Scanner(System.in);
    public static void main(String arg[]) throws IOException{
        ArrayList<String> casting = new ArrayList<>(Arrays.asList("wilson", "wilsonagain"));
        Movie Salakau = new Movie("Salakau", MovieType.THREE_D, "Malay vs Chinese", "Fucking Bad",10, 2, LocalDate.of(2002, 9, 17), LocalDate.of(2002, 12, 20), "Sakamoto", 500, casting);
        //Salakau.writeMovie();
        
        Session mysession = new Session(Salakau,LocalDateTime.of(2022, 2, 26, 6, 45));
        Guest Wilson = new Guest("Wilson", 22, "999", "Wilsonlim@com");

        Booking book = new Booking(Wilson, mysession, "A2");
        mysession.writeSession();
        book.writebookingstatement();
    } 
}
