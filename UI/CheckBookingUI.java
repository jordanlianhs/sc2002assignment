package UI;

import java.util.*;
import java.io.*;
import Model.*;

/**
 * Using the Check Booking UI, the user can check the booking details of a session
 */
public class CheckBookingUI {
    /**
     * This is the main method to check for bookings
     * @param args null argument can be used to drive the function
     * @exception Throws Exception
     */
    public void main (){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your email address");
        String emailName = sc.next();
        String text;
        int k=0;
        try {
			File file = new File("./Database/BookingStatement.txt");
			Scanner scanfile = new Scanner(file);
            String cinemaType = " ";
			while(scanfile.hasNextLine()){
                text = scanfile.nextLine();
                String[] elements = text.split(",");
                String eName = elements[0];
                String phone = elements[1];
				String price = elements[2];
				String ticketID = elements[3];
				String movieName = elements[4];
				String seatNumber = elements[5];
                String cinemaCode = elements[6];
                
                //ystem.out.println("hey");
                if(eName.equals(emailName)){
                    k=1;
                    if(cinemaCode.equals("ONE")){
                        cinemaType = "Normal";
                    }

                    else if(cinemaCode.equals("TWO")){
                        cinemaType = "Gold";
                    }

                    else{
                        cinemaType = "Platinum";
                    }
                    System.out.println(" TicketID: " + ticketID+ " Movie: " + movieName  + " Price: " + price 
                    + " CinemaCode: " + cinemaCode + " CinemaType: " + cinemaType + " Seat: " + seatNumber  + " Phone: " + phone);
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
