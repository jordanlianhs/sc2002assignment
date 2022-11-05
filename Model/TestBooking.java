package Model;
import java.io.IOException;
public class TestBooking {
    public static void main(String arg[]) throws IOException {
        Guest Wilson = new Guest("Wilson", 22, "999", "Wilsonlim@com");

        //test ticketID
        Booking book = new Booking(Wilson, new Session(), "A2", "CYD");
        System.out.println(book.getTicketID());

    }

}
