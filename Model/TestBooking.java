package Model;
import java.io.IOException;
public class TestBooking {
    public static void main(String arg[]) throws IOException {
        Guest Wilson = new Guest("Wilson", 22, "999", "Wilsonlim@com");

        Booking book = new Booking(Wilson);

        book.writebookingstatement();
    }

}
