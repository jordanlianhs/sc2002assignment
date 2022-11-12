package UI;

import Model.*;
import java.util.*;
import java.time.*;
import java.io.*;

/**
 * This class is used to retrieve and update Ticket prices for the various types
 * of tickets
 */
public class TicketPrice {
    /**
     * File name for ticket price database
     */
    private static File f = new File("./Database/TicketPrice.txt");
    /**
     * Ticket price values
     */
    private static double SP2D, SP2DB, SP3D, SP3DB, senior, STU2D, STU3D, N2D, N3D, PH2D, PH3D, DBsurcharge,
            RegSurcharge,
            GoldSurcharge, PlatSurcharge;

    /**
     * This is the main function that calls the method to configure the price
     * 
     * @param args null argument can be used to drive the function
     * @throws Exception throws exception
     */
    public void main(String[] args) {
        TicketPrice ticketPrice = new TicketPrice();
        ticketPrice.configurePrice();
    }

    /**
     * Scans user input and uses it to update the prices of the various tickets
     * 
     * @throws Exception throws exception
     */
    public void configurePrice() {
        // Initialise all the variables to their original values
        try {
            Scanner sc = new Scanner(f);
            sc.useDelimiter(",");
            while (sc.hasNext()) {
                // System.out.println(sc.next());
                SP2D = Double.parseDouble(sc.next());
                SP2DB = Double.parseDouble(sc.next());
                SP3D = Double.parseDouble(sc.next());
                SP3DB = Double.parseDouble(sc.next());
                senior = Double.parseDouble(sc.next());
                STU2D = Double.parseDouble(sc.next());
                STU3D = Double.parseDouble(sc.next());
                N2D = Double.parseDouble(sc.next());
                N3D = Double.parseDouble(sc.next());
                PH2D = Double.parseDouble(sc.next());
                PH3D = Double.parseDouble(sc.next());
                DBsurcharge = Double.parseDouble(sc.next());
                RegSurcharge = Double.parseDouble(sc.next());
                GoldSurcharge = Double.parseDouble(sc.next());
                PlatSurcharge = Double.parseDouble(sc.next());
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // Scanning for user input
        Scanner s = new Scanner(System.in);
        int choice = -1;

        do {
            try {
                System.out.println("What would you like to configure? Select an option");
                System.out.println("(1) Special Seat 2D \t\t| (2) Special Seat 2D BlockBuster");
                System.out.println("(3) Special Seat 3D \t\t| (4) Special Seat 3D BlockBuster");
                System.out.println("(5) Senior Citizen \t\t| (6) Student 2D");
                System.out.println("(7) Student 3D \t\t\t| (8) Normal 2D");
                System.out.println("(9) Normal 3D \t\t\t| (10) Holiday 2D");
                System.out.println("(11) Holiday 3D \t\t| (12) BlockBuster Surcharge");
                System.out.println("(13) Regular Cinema Surcharge \t| (14) Gold Cinema Surcharge");
                System.out.println("(15) Platinum Cinema Surcharge \t| (16) List Prices");
                System.out.println("(17) Quit \t\t\t|");
                choice = s.nextInt();
                s.nextLine();

                switch (choice) {
                    case 1:
                        try {
                            System.out.println("Enter new value (Special Seat 2D): ");
                            SP2D = s.nextDouble();
                            FileWriter fw = new FileWriter(f, false);

                            // s.nextLine();
                            fw.write(
                                    SP2D + "," + SP2DB + "," + SP3D + "," + SP3DB + "," + senior + "," + STU2D + ","
                                            + STU3D
                                            + "," + N2D + "," + N3D + "," + PH2D + "," + PH3D + "," + DBsurcharge + ","
                                            + RegSurcharge + "," + GoldSurcharge + "," + PlatSurcharge
                                            + System.lineSeparator());
                            fw.close();
                            System.out.println("Change applied!");
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid Input!");
                        }
                        break;
                    case 2:
                        try {
                            System.out.println("Enter new value (Special Seat 2D Blockbuster): ");
                            SP2DB = s.nextDouble();
                            FileWriter fw = new FileWriter(f, false);
                            // s.nextLine();
                            fw.write(
                                    SP2D + "," + SP2DB + "," + SP3D + "," + SP3DB + "," + senior + "," + STU2D + ","
                                            + STU3D
                                            + "," + N2D + "," + N3D + "," + PH2D + "," + PH3D + "," + DBsurcharge + ","
                                            + RegSurcharge + "," + GoldSurcharge + "," + PlatSurcharge
                                            + System.lineSeparator());
                            fw.close();
                            System.out.println("Change applied!");
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid Input!");
                        }
                        break;
                    case 3:
                        try {
                            System.out.println("Enter new value (Special Seat 3D): ");
                            SP3D = s.nextDouble();
                            FileWriter fw = new FileWriter(f, false);
                            // s.nextLine();
                            fw.write(
                                    SP2D + "," + SP2DB + "," + SP3D + "," + SP3DB + "," + senior + "," + STU2D + ","
                                            + STU3D
                                            + "," + N2D + "," + N3D + "," + PH2D + "," + PH3D + "," + DBsurcharge + ","
                                            + RegSurcharge + "," + GoldSurcharge + "," + PlatSurcharge
                                            + System.lineSeparator());
                            fw.close();
                            System.out.println("Change applied!");
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid Input!");
                        }
                        break;
                    case 4:
                        try {
                            System.out.println("Enter new value (Special Seat 3D Blockbuster): ");
                            SP3DB = s.nextDouble();
                            FileWriter fw = new FileWriter(f, false);
                            // s.nextLine();
                            fw.write(
                                    SP2D + "," + SP2DB + "," + SP3D + "," + SP3DB + "," + senior + "," + STU2D + ","
                                            + STU3D
                                            + "," + N2D + "," + N3D + "," + PH2D + "," + PH3D + "," + DBsurcharge + ","
                                            + RegSurcharge + "," + GoldSurcharge + "," + PlatSurcharge
                                            + System.lineSeparator());
                            fw.close();
                            System.out.println("Change applied!");
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid Input!");
                        }
                        break;
                    case 5:
                        try {
                            System.out.println("Enter new value (Senior Citizen): ");
                            senior = s.nextDouble();
                            FileWriter fw = new FileWriter(f, false);
                            // s.nextLine();
                            fw.write(
                                    SP2D + "," + SP2DB + "," + SP3D + "," + SP3DB + "," + senior + "," + STU2D + ","
                                            + STU3D
                                            + "," + N2D + "," + N3D + "," + PH2D + "," + PH3D + "," + DBsurcharge + ","
                                            + RegSurcharge + "," + GoldSurcharge + "," + PlatSurcharge
                                            + System.lineSeparator());
                            fw.close();
                            System.out.println("Change applied!");
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid Input!");
                        }
                        break;
                    case 6:
                        try {
                            System.out.println("Enter new value (Student 2D): ");
                            STU2D = s.nextDouble();
                            FileWriter fw = new FileWriter(f, false);
                            // s.nextLine();
                            fw.write(
                                    SP2D + "," + SP2DB + "," + SP3D + "," + SP3DB + "," + senior + "," + STU2D + ","
                                            + STU3D
                                            + "," + N2D + "," + N3D + "," + PH2D + "," + PH3D + "," + DBsurcharge + ","
                                            + RegSurcharge + "," + GoldSurcharge + "," + PlatSurcharge
                                            + System.lineSeparator());
                            fw.close();
                            System.out.println("Change applied!");
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid Input!");
                        }
                        break;
                    case 7:
                        try {
                            System.out.println("Enter new value (Student 3D): ");
                            STU3D = s.nextDouble();
                            FileWriter fw = new FileWriter(f, false);
                            // s.nextLine();
                            fw.write(
                                    SP2D + "," + SP2DB + "," + SP3D + "," + SP3DB + "," + senior + "," + STU2D + ","
                                            + STU3D
                                            + "," + N2D + "," + N3D + "," + PH2D + "," + PH3D + "," + DBsurcharge + ","
                                            + RegSurcharge + "," + GoldSurcharge + "," + PlatSurcharge
                                            + System.lineSeparator());
                            fw.close();
                            System.out.println("Change applied!");
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid Input!");
                        }
                        break;
                    case 8:
                        try {
                            System.out.println("Enter new value (Normal 2D): ");
                            N2D = s.nextDouble();
                            FileWriter fw = new FileWriter(f, false);
                            // s.nextLine();
                            fw.write(
                                    SP2D + "," + SP2DB + "," + SP3D + "," + SP3DB + "," + senior + "," + STU2D + ","
                                            + STU3D
                                            + "," + N2D + "," + N3D + "," + PH2D + "," + PH3D + "," + DBsurcharge + ","
                                            + RegSurcharge + "," + GoldSurcharge + "," + PlatSurcharge
                                            + System.lineSeparator());
                            fw.close();
                            System.out.println("Change applied!");
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid Input!");
                        }
                        break;
                    case 9:
                        try {
                            System.out.println("Enter new value (Normal 3D): ");
                            N3D = s.nextDouble();
                            FileWriter fw = new FileWriter(f, false);

                            // s.nextLine();
                            fw.write(
                                    SP2D + "," + SP2DB + "," + SP3D + "," + SP3DB + "," + senior + "," + STU2D + ","
                                            + STU3D
                                            + "," + N2D + "," + N3D + "," + PH2D + "," + PH3D + "," + DBsurcharge + ","
                                            + RegSurcharge + "," + GoldSurcharge + "," + PlatSurcharge
                                            + System.lineSeparator());
                            fw.close();
                            System.out.println("Change applied!");
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid Input!");
                        }
                        break;
                    case 10:
                        try {
                            System.out.println("Enter new value (Holiday 2D): ");
                            PH2D = s.nextDouble();
                            FileWriter fw = new FileWriter(f, false);

                            // s.nextLine();
                            fw.write(
                                    SP2D + "," + SP2DB + "," + SP3D + "," + SP3DB + "," + senior + "," + STU2D + ","
                                            + STU3D
                                            + "," + N2D + "," + N3D + "," + PH2D + "," + PH3D + "," + DBsurcharge + ","
                                            + RegSurcharge + "," + GoldSurcharge + "," + PlatSurcharge
                                            + System.lineSeparator());
                            fw.close();
                            System.out.println("Change applied!");
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid Input!");
                        }
                        break;
                    case 11:
                        try {
                            System.out.println("Enter new value (Holiday 3D): ");
                            PH3D = s.nextDouble();
                            FileWriter fw = new FileWriter(f, false);

                            // s.nextLine();
                            fw.write(
                                    SP2D + "," + SP2DB + "," + SP3D + "," + SP3DB + "," + senior + "," + STU2D + ","
                                            + STU3D
                                            + "," + N2D + "," + N3D + "," + PH2D + "," + PH3D + "," + DBsurcharge + ","
                                            + RegSurcharge + "," + GoldSurcharge + "," + PlatSurcharge
                                            + System.lineSeparator());
                            fw.close();
                            System.out.println("Change applied!");
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid Input!");
                        }
                        break;
                    case 12:
                        try {
                            System.out.println("Enter new value (Blockbuster Surcharge): ");
                            DBsurcharge = s.nextDouble();
                            FileWriter fw = new FileWriter(f, false);

                            // s.nextLine();
                            fw.write(
                                    SP2D + "," + SP2DB + "," + SP3D + "," + SP3DB + "," + senior + "," + STU2D + ","
                                            + STU3D
                                            + "," + N2D + "," + N3D + "," + PH2D + "," + PH3D + "," + DBsurcharge + ","
                                            + RegSurcharge + "," + GoldSurcharge + "," + PlatSurcharge
                                            + System.lineSeparator());
                            fw.close();
                            System.out.println("Change applied!");
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid Input!");
                        }
                        break;
                    case 13:
                        try {
                            System.out.println("Enter new value (Regular Cinema Surcharge): ");
                            RegSurcharge = s.nextDouble();
                            FileWriter fw = new FileWriter(f, false);

                            // s.nextLine();
                            fw.write(
                                    SP2D + "," + SP2DB + "," + SP3D + "," + SP3DB + "," + senior + "," + STU2D + ","
                                            + STU3D
                                            + "," + N2D + "," + N3D + "," + PH2D + "," + PH3D + "," + DBsurcharge + ","
                                            + RegSurcharge + "," + GoldSurcharge + "," + PlatSurcharge
                                            + System.lineSeparator());
                            fw.close();
                            System.out.println("Change applied!");
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid Input!");
                        }
                        break;
                    case 14:
                        try {
                            System.out.println("Enter new value (Gold Cinema Surcharge): ");
                            GoldSurcharge = s.nextDouble();
                            FileWriter fw = new FileWriter(f, false);

                            // s.nextLine();
                            fw.write(
                                    SP2D + "," + SP2DB + "," + SP3D + "," + SP3DB + "," + senior + "," + STU2D + ","
                                            + STU3D
                                            + "," + N2D + "," + N3D + "," + PH2D + "," + PH3D + "," + DBsurcharge + ","
                                            + RegSurcharge + "," + GoldSurcharge + "," + PlatSurcharge
                                            + System.lineSeparator());
                            fw.close();
                            System.out.println("Change applied!");
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid Input!");
                        }
                        return;
                    case 15:
                        try {
                            System.out.println("Enter new value (Platinum Cinema Surcharge): ");
                            PlatSurcharge = s.nextDouble();
                            FileWriter fw = new FileWriter(f, false);

                            // s.nextLine();
                            fw.write(
                                    SP2D + "," + SP2DB + "," + SP3D + "," + SP3DB + "," + senior + "," + STU2D + ","
                                            + STU3D
                                            + "," + N2D + "," + N3D + "," + PH2D + "," + PH3D + "," + DBsurcharge + ","
                                            + RegSurcharge + "," + GoldSurcharge + "," + PlatSurcharge
                                            + System.lineSeparator());
                            fw.close();
                            System.out.println("Change applied!");
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid Input!");
                        }
                        break;
                    case 16:
                        System.out.println("Special Seat 2D: " + SP2D);
                        System.out.println("Special Seat 2D Blockbuster: " + SP2DB);
                        System.out.println("Special Seat 3D: " + SP3D);
                        System.out.println("Special Seat 3D Blockbuster: " + SP3DB);
                        System.out.println("Senior: " + senior);
                        System.out.println("Student 2D: " + STU2D);
                        System.out.println("Student 3D: " + STU3D);
                        System.out.println("Normal 2D: " + N2D);
                        System.out.println("Normal 3D: " + N3D);
                        System.out.println("Holiday 2D: " + PH2D);
                        System.out.println("Holiday 3D: " + PH3D);
                        System.out.println("Blockbuster Surcharge: " + DBsurcharge);
                        System.out.println("Normal Cinema Surcharge: " + RegSurcharge);
                        System.out.println("Gold Cinema Surcharge: " + GoldSurcharge);
                        System.out.println("Platinum Cinema Surcharge: " + PlatSurcharge);
                        break;
                    case 17:
                        break;
                    default:
                        System.out.println("Invalid Input!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input!");
                s.nextLine();
            } catch (IOException e) {
                System.out.println("Invalid Input!");
                s.nextLine();
            }
        } while (choice != 17);
    }

    /**
     * Calculates Ticket Prices
     * 
     * @param g User who is booking the ticket
     * @param S Movie Session
     * @param B The user's movie booking
     * @return Calculated price
     */
    public double calculateTix(Guest g, Session S, Booking B) {
        try {
            Scanner sc = new Scanner(f);
            sc.useDelimiter(",");
            while (sc.hasNext()) {
                // System.out.println(sc.next());
                SP2D = Double.parseDouble(sc.next());
                SP2DB = Double.parseDouble(sc.next());
                SP3D = Double.parseDouble(sc.next());
                SP3DB = Double.parseDouble(sc.next());
                senior = Double.parseDouble(sc.next());
                STU2D = Double.parseDouble(sc.next());
                STU3D = Double.parseDouble(sc.next());
                N2D = Double.parseDouble(sc.next());
                N3D = Double.parseDouble(sc.next());
                PH2D = Double.parseDouble(sc.next());
                PH3D = Double.parseDouble(sc.next());
                DBsurcharge = Double.parseDouble(sc.next());
                RegSurcharge = Double.parseDouble(sc.next());
                GoldSurcharge = Double.parseDouble(sc.next());
                PlatSurcharge = Double.parseDouble(sc.next());
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        double price = 0;
        boolean stu = g.getStudent(); // Student?
        boolean weekend = S.isWeekend(); // Weekend?
        MovieType type = S.getMovie().getType(); // Get the movie Type
        int age = g.getAge(); // Get the age of the guest

        // Ammending price based on SPECIAL seats
        String seat = B.getSeatNumber();
        if ((seat.contains("A") || seat.contains("B") || seat.contains("C")) && type == MovieType.THREE_D) {
            return price = SP3D;
        } else if (seat.contains("A") || seat.contains("B") || seat.contains("C") && type == MovieType.THREE_D_BB) {
            return price = SP3DB;
        } else if ((seat.contains("A") || seat.contains("B") || seat.contains("C")) && type == MovieType.TWO_D) {
            return price = SP2D;
        } else if (seat.contains("A") || seat.contains("B") || seat.contains("C") && type == MovieType.TWO_D_BB) {
            return price = SP2DB;
        } else {
            // Normal Seat
            // Prices based on Age
            if (weekend == true || isHoliday(S)) { // If its IS a weekend OR a Holiday
                if (type == MovieType.THREE_D) {
                    price = PH3D;
                } else if (type == MovieType.TWO_D) { // Using 2D as normal/Digital Movies
                    price = PH2D;
                }
            } else { // If it is NOT a weekend
                // Non PH/Weekend
                if (age > 55) { // Senior Citizen
                    price = senior;
                } else { // Not a senior
                    if (stu) {// Student Price
                        if (type == MovieType.THREE_D) {
                            price = STU3D;
                        } else if (type == MovieType.TWO_D) { // Using 2D as normal/Digital Movies
                            price = STU2D;
                        }
                    } else {
                        if (type == MovieType.THREE_D) {
                            price = N3D;
                        } else if (type == MovieType.TWO_D) { // Using 2D as normal/Digital Movies
                            price = N2D;
                        }
                    }
                }
            }

            if (type == MovieType.TWO_D_BB || type == MovieType.THREE_D_BB) { // If its a blockbuster
                price += DBsurcharge;
            }
            if (S.getCinemaCode() == "ONE") {
                price += RegSurcharge;
            } else if (S.getCinemaCode() == "TWO") {
                price += GoldSurcharge;
            } else if (S.getCinemaCode() == "THR") {
                price += PlatSurcharge;
            }

        }
        return price;
    }

    /**
     * This function checks if the date that the user is trying to book is a holiday
     * 
     * @param S Movie Session
     * @return True if holiday, false if it is not
     */
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
