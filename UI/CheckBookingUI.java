package UI;

import java.util.*;
import java.io.*;

public class CheckBookingUI {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your email address");
        String emailName = sc.next();
        String text;
        int k=0;
        try {
			File file = new File("./Database/BookingStatement.txt");
			Scanner scanfile = new Scanner(file);

			while(scanfile.hasNextLine()){
                text = scanfile.nextLine();
                String[] elements = text.split(",");
                String eName = elements[0];
				String ticketID = elements[1];
				String price = elements[2];
				String movieName = elements[3];
				String seatNumber = elements[4];
                String cinemaCode = elements[5];
                //ystem.out.println("hey");
                if(eName.equals(emailName)){
                    k=1;
                    System.out.println(" TicketID: " + ticketID + " Price: " + price + " Movie: " + movieName + " Seat: " + seatNumber + "CinemaCode: " + cinemaCode);
                }
            }
            if(k==0){
                System.out.println("No Booking");
            }
			scanfile.close();

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
    
    }

    
}
