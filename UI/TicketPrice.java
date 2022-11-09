package UI;

import Model.*;
import java.util.*;

import java.time.*;
import java.io.*;

public class TicketPrice {
    static File f = new File("./Database/TicketPrice.txt");
    static double SP2D, SP2DB, SP3D, SP3DB, senior, STU2D, STU3D, N2D, N3D, PH2D, PH3D, DBsurcharge, RegSurcharge,
            GoldSurcharge, PlatSurcharge;

    /**
     * Edits Ticket Prices
     * 
     * @param g
     * @param S
     * @return
     */
    public static void main(String[] args) throws Exception {
        TicketPrice.configurePrice();
    }

    public static void configurePrice() throws Exception {
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Scanning for user input
        Scanner s = new Scanner(System.in);
        int choice;
        do {
            System.out.println("What would you like to configure? Select an option");
            System.out.println("(1) Special Seat 2D \t| (2) Special Seat 2D BlockBuster");
            System.out.println("(3) Special Seat 3D \t| (4) Special Seat 3D BlockBuster");
            System.out.println("(5) Senior Citizen \t| (6) Student 2D");
            System.out.println("(7) Student 3D \t\t| (8) Normal 2D");
            System.out.println("(9) Normal 3D \t\t| (10) Holiday 2D");
            System.out.println("(11) Holiday 3D \t| (12) BlockBuster Surcharge");
            System.out.println("(13) Regular Cinema Surcharge \t| (14) Gold Cinema Surcharge");
            System.out.println("(15) PLatinum Cinema Surcharge \t| (16) List Prices");
            System.out.println("(17) Quit");
            choice = s.nextInt();
            s.nextLine();
            switch (choice) {
                case 1:
                    try {
                        FileWriter fw = new FileWriter(f, false);
                        System.out.println("Enter new value: ");
                        SP2D = s.nextDouble();
                        // s.nextLine();
                        fw.write(
                                SP2D + "," + SP2DB + "," + SP3D + "," + SP3DB + "," + senior + "," + STU2D + "," + STU3D
                                        + "," + N2D + "," + N3D + "," + PH2D + "," + PH3D + "," + DBsurcharge
                                        + System.lineSeparator());
                        fw.close();
                        System.out.println("Change applied!");
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Input!");
                    }
                    break;
                case 2:
                    try {
                        FileWriter fw = new FileWriter(f, false);
                        System.out.println("Enter new value: ");
                        SP2DB = s.nextDouble();
                        // s.nextLine();
                        fw.write(
                                SP2D + "," + SP2DB + "," + SP3D + "," + SP3DB + "," + senior + "," + STU2D + "," + STU3D
                                        + "," + N2D + "," + N3D + "," + PH2D + "," + PH3D + "," + DBsurcharge
                                        + System.lineSeparator());
                        fw.close();
                        System.out.println("Change applied!");
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Input!");
                    }
                    break;
                case 3:
                    try {
                        FileWriter fw = new FileWriter(f, false);
                        System.out.println("Enter new value: ");
                        SP3D = s.nextDouble();
                        // s.nextLine();
                        fw.write(
                                SP2D + "," + SP2DB + "," + SP3D + "," + SP3DB + "," + senior + "," + STU2D + "," + STU3D
                                        + "," + N2D + "," + N3D + "," + PH2D + "," + PH3D + "," + DBsurcharge
                                        + System.lineSeparator());
                        fw.close();
                        System.out.println("Change applied!");
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Input!");
                    }
                    break;
                case 4:
                    try {
                        FileWriter fw = new FileWriter(f, false);
                        System.out.println("Enter new value: ");
                        SP3DB = s.nextDouble();
                        // s.nextLine();
                        fw.write(
                                SP2D + "," + SP2DB + "," + SP3D + "," + SP3DB + "," + senior + "," + STU2D + "," + STU3D
                                        + "," + N2D + "," + N3D + "," + PH2D + "," + PH3D + "," + DBsurcharge
                                        + System.lineSeparator());
                        fw.close();
                        System.out.println("Change applied!");
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Input!");
                    }
                    break;
                case 5:
                    try {
                        FileWriter fw = new FileWriter(f, false);
                        System.out.println("Enter new value: ");
                        senior = s.nextDouble();
                        // s.nextLine();
                        fw.write(
                                SP2D + "," + SP2DB + "," + SP3D + "," + SP3DB + "," + senior + "," + STU2D + "," + STU3D
                                        + "," + N2D + "," + N3D + "," + PH2D + "," + PH3D + "," + DBsurcharge
                                        + System.lineSeparator());
                        fw.close();
                        System.out.println("Change applied!");
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Input!");
                    }
                    break;
                case 6:
                    try {
                        FileWriter fw = new FileWriter(f, false);
                        System.out.println("Enter new value: ");
                        STU2D = s.nextDouble();
                        // s.nextLine();
                        fw.write(
                                SP2D + "," + SP2DB + "," + SP3D + "," + SP3DB + "," + senior + "," + STU2D + "," + STU3D
                                        + "," + N2D + "," + N3D + "," + PH2D + "," + PH3D + "," + DBsurcharge
                                        + System.lineSeparator());
                        fw.close();
                        System.out.println("Change applied!");
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Input!");
                    }
                    break;
                case 7:
                    try {
                        FileWriter fw = new FileWriter(f, false);
                        System.out.println("Enter new value: ");
                        STU3D = s.nextDouble();
                        // s.nextLine();
                        fw.write(
                                SP2D + "," + SP2DB + "," + SP3D + "," + SP3DB + "," + senior + "," + STU2D + "," + STU3D
                                        + "," + N2D + "," + N3D + "," + PH2D + "," + PH3D + "," + DBsurcharge
                                        + System.lineSeparator());
                        fw.close();
                        System.out.println("Change applied!");
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Input!");
                    }
                    break;
                case 8:
                    try {
                        FileWriter fw = new FileWriter(f, false);
                        System.out.println("Enter new value: ");
                        N2D = s.nextDouble();
                        // s.nextLine();
                        fw.write(
                                SP2D + "," + SP2DB + "," + SP3D + "," + SP3DB + "," + senior + "," + STU2D + "," + STU3D
                                        + "," + N2D + "," + N3D + "," + PH2D + "," + PH3D + "," + DBsurcharge
                                        + System.lineSeparator());
                        fw.close();
                        System.out.println("Change applied!");
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Input!");
                    }
                    break;
                case 9:
                    try {
                        FileWriter fw = new FileWriter(f, false);
                        System.out.println("Enter new value: ");
                        N3D = s.nextDouble();
                        // s.nextLine();
                        fw.write(
                                SP2D + "," + SP2DB + "," + SP3D + "," + SP3DB + "," + senior + "," + STU2D + "," + STU3D
                                        + "," + N2D + "," + N3D + "," + PH2D + "," + PH3D + "," + DBsurcharge
                                        + System.lineSeparator());
                        fw.close();
                        System.out.println("Change applied!");
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Input!");
                    }
                    break;
                case 10:
                    try {
                        FileWriter fw = new FileWriter(f, false);
                        System.out.println("Enter new value: ");
                        PH2D = s.nextDouble();
                        // s.nextLine();
                        fw.write(
                                SP2D + "," + SP2DB + "," + SP3D + "," + SP3DB + "," + senior + "," + STU2D + "," + STU3D
                                        + "," + N2D + "," + N3D + "," + PH2D + "," + PH3D + "," + DBsurcharge
                                        + System.lineSeparator());
                        fw.close();
                        System.out.println("Change applied!");
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Input!");
                    }
                    break;
                case 11:
                    try {
                        FileWriter fw = new FileWriter(f, false);
                        System.out.println("Enter new value: ");
                        PH3D = s.nextDouble();
                        // s.nextLine();
                        fw.write(
                                SP2D + "," + SP2DB + "," + SP3D + "," + SP3DB + "," + senior + "," + STU2D + "," + STU3D
                                        + "," + N2D + "," + N3D + "," + PH2D + "," + PH3D + "," + DBsurcharge
                                        + System.lineSeparator());
                        fw.close();
                        System.out.println("Change applied!");
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Input!");
                    }
                    break;
                case 12:
                    try {
                        FileWriter fw = new FileWriter(f, false);
                        System.out.println("Enter new value: ");
                        DBsurcharge = s.nextDouble();
                        // s.nextLine();
                        fw.write(
                                SP2D + "," + SP2DB + "," + SP3D + "," + SP3DB + "," + senior + "," + STU2D + "," + STU3D
                                        + "," + N2D + "," + N3D + "," + PH2D + "," + PH3D + "," + DBsurcharge
                                        + System.lineSeparator());
                        fw.close();
                        System.out.println("Change applied!");
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Input!");
                    }
                    break;
                case 13:
                    break;
                case 14:
                    return;
                case 15:
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
                    System.out.println("Gold Surcharge: " + GoldSurcharge);
                    System.out.println("Platinum Surcharge: " + PlatSurcharge);
                    break;
                default:
                    break;
            }
        } while (choice != 17);
    }

    /**
     * Caculates Ticket Prices
     * 
     * @param g
     * @param S
     * @param B
     * @return
     */
    public double calculateTix(Guest g, Session S, Booking B) throws Exception {
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
