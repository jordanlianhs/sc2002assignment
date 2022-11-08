package Model;

import java.io.*;
import java.text.*;
import java.util.*;
import UI.*;
import java.time.*;

public class Booking {
    private Guest guest;

    // private LocalDateTime movietime;

    private Movie movie;

    private String seatNumber;

    private String ticketID;

    private String cinemaCode;

    private double price;


    public Booking(Guest guest, Session session, String seatNumber, String cinemaCode) {

        this.guest = guest;
        this.movie = session.getMovie();
        this.seatNumber = seatNumber;
        // this.movietime = movie.getMovieTime;
        this.cinemaCode = cinemaCode;
        // timestamp is formatted current time
        String timestamp = new SimpleDateFormat("YYYYMMddHHmm").format(new Date());

        this.ticketID = cinemaCode + timestamp;
        
        //price
        File f = new File("./Database/TicketPrice.txt");
        Double SP2D  = 0.0, SP2DB = 0.0, SP3D = 0.0, SP3DB  = 0.0, senior  = 0.0, STU2D  = 0.0, STU3D = 0.0, N2D = 0.0, N3D = 0.0, PH2D = 0.0, PH3D = 0.0, surcharge = 0.0;
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
                surcharge = Double.parseDouble(sc.next());
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        double temp = 0;
        boolean stu = guest.getStudent(); // Student?
        boolean weekend = session.isWeekend(); // Weekend?
        MovieType type = session.getMovie().getType(); // Get the movie Type
        int age = guest.getAge(); // Get the age of the guest
  
        // Ammending temp based on SPECIAL seats
        String seat = seatNumber;
        if ((seat.contains("A") || seat.contains("B") || seat.contains("C")) && type == MovieType.THREE_D) {
            temp = SP3D;
        } else if (seat.contains("A") || seat.contains("B") || seat.contains("C") && type == MovieType.THREE_D_BB) {
            temp = SP3DB;
        } else if ((seat.contains("A") || seat.contains("B") || seat.contains("C")) && type == MovieType.TWO_D) {
            temp = SP2D;
        } else if (seat.contains("A") || seat.contains("B") || seat.contains("C") && type == MovieType.TWO_D_BB) {
            temp = SP2DB;
        } else {
            // Normal Seat
            // temps based on Age
            if (weekend == true || isHoliday(session)) { // If its IS a weekend OR a Holiday
                if (type == MovieType.THREE_D) {
                    temp = PH3D;
                } else if (type == MovieType.TWO_D) { // Using 2D as normal/Digital Movies
                    temp = PH2D;
                }
            } else { // If it is NOT a weekend
                // Non PH/Weekend
                if (age > 55) { // Senior Citizen
                    temp = senior;
                } else { // Not a senior
                    if (stu) {// Student temp
                        if (type == MovieType.THREE_D) {
                            temp = STU3D;
                        } else if (type == MovieType.TWO_D) { // Using 2D as normal/Digital Movies
                            temp = STU2D;
                        }
                    } else {
                        if (type == MovieType.THREE_D) {
                            temp = N3D;
                        } else if (type == MovieType.TWO_D) { // Using 2D as normal/Digital Movies
                            temp = N2D;
                        }
                    }
                }
            }

            if (type == MovieType.TWO_D_BB || type == MovieType.THREE_D_BB) { // If its a blockbuster
                temp += surcharge;
            }
        }
        this.price = temp;
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

    public void writebookingstatement() throws IOException {
        try {
            File file = new File("Database/BookingStatement.txt");
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter br = new BufferedWriter(fr);
            PrintWriter pr = new PrintWriter(br);
            String statement = guest.getEmail() + "," + guest.getPhone() + "," 
            + String.valueOf(price) + "," + ticketID + "," + movie.getmovieName()
            + "," + seatNumber + "," + cinemaCode;
            pr.println(statement);
            pr.close();
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getTicketID() {
        return ticketID;
    }

    public String getSeatNumber() {
        return seatNumber;
    }
}
