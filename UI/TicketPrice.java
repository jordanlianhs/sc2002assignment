package UI;

import Model.*;
import java.util.*;
import java.time.*;

public class TicketPrice {

    /**
     * Calculate the ticket price based on Customer Type, Day of the week, Pub
     * Holiday, Movie Type, Seat Type
     * 
     * @param args
     */

    // public static void main(String[] args) {
    // ArrayList<String> casting = new ArrayList<>(Arrays.asList("wilson",
    // "wilsonagain"));

    // Guest G = new Guest("Bob", 21, "999", "bob@gmail.com", true); // Student
    // Guest oldG = new Guest("Greg", 62, "789", "greg@gmail.com", false); // Senior

    // Movie m = new Movie("Story of my Life", MovieType.TWO_D, "SYNOPSIS", "PG13",
    // 4, 60, LocalDate.of(2022, 9, 17),
    // LocalDate.of(2022, 10, 17), "WILSON",
    // 100, casting);
    // Movie m1 = new Movie("Story of my Life", MovieType.THREE_D, "SYNOPSIS",
    // "PG13", 4, 60,
    // LocalDate.of(2022, 9, 17),
    // LocalDate.of(2022, 10, 17), "WILSON",
    // 100, casting);

    // Session S = new Session(m, LocalDateTime.of(2022, 01, 1, 23, 00));
    // Session S1 = new Session(m1, LocalDateTime.of(2022, 10, 3, 23, 00));

    // System.out.println("Price of ticket = " + calculateTix(G, m, S));
    // System.out.println("Price of Senior Ticket: " + calculateTix(oldG, m1, S1));

    // // System.out.println(isHoliday(S)); //Debugging stuff
    // // System.out.println(isHoliday(S1));

    // }

    /**
     * Calculates ticket prices
     * 
     * @param g
     * @param M
     * @param S
     * @return
     */

    public double calculateTix(Guest g, Movie M, Session S) { // Still need to include the Cinema Class and Seat
                                                              // Type
        // Holiday
        double price = 0;
        boolean stu = g.getStudent(); // Student?
        boolean weekend = S.isWeekend(); // Weekend?
        MovieType type = M.getType(); // Get the movie Type
        int age = g.getAge(); // Get the age of the guest

        if (weekend == true || isHoliday(S)) { // If its IS a weekend OR a Holiday
            if (type == MovieType.THREE_D) {
                price = 11;
            } else if (type == MovieType.TWO_D) { // Using 2D as normal/Digital Movies
                price = 15;
            }
        } else { // If it is NOT a weekend
            // Non PH/Weekend
            if (age > 55) { // Senior Citizen
                price = 4;
            } else { // Not a senior
                if (stu = true) {// Student Price
                    if (type == MovieType.THREE_D) {
                        price = 9;
                    } else if (type == MovieType.TWO_D) { // Using 2D as normal/Digital Movies
                        price = 7;
                    }
                } else {
                    if (type == MovieType.THREE_D) {
                        price = 11;
                    } else if (type == MovieType.TWO_D) { // Using 2D as normal/Digital Movies
                        price = 8.5;
                    }
                }
            }
        }
        if (type == MovieType.BLOCKBUSTER) {
            price++;
        }
        return price;
    }

    public boolean isHoliday(Session S) {
        LocalDateTime dateTime = S.getSeshDateTime(); // To check for holidays
        String DT = dateTime.toLocalDate().toString(); // Converti to JUST date, then to string, so i can search

        // System.out.println("DT: " + DT); //For debugging

        if (HolidayUI.findHol(DT)) {
            return true;
        } else
            return false;
    }
}
