package UI;

import java.time.*;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.io.*;
import Model.*;

public class CreateSession {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        String temp;
        LocalDateTime seshDateTime;
        Movie movie = new Movie();
        String cinemaCode;
        //SeatingPlan seatPlan = new SeatingPlan();


        System.out.println("-----------------------------------");
		System.out.println("Create Session");
		System.out.println("-----------------------------------");
		
        
		System.out.print("Enter Session Date Time (YYYY-MM-DD hh:mm): ");
        temp = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        seshDateTime = LocalDateTime.parse(temp, formatter);

        do{
            System.out.print("Enter movie name: ");
            temp = sc.nextLine();
            movie.readMovie(temp);
            if(movie.getmovieName()==null){
                System.out.println("Movie Name does not exist");
            }
        }while(movie.getmovieName() == null);

        System.out.print("Enter Cinema Code (ONE, TWO, THR): ");
        temp = sc.nextLine();
        cinemaCode = temp;

        System.out.print("Enter Cineplex Code (AMK, BBK, CCK): ");
        temp = sc.nextLine();

        Session wata = new Session(movie, seshDateTime, cinemaCode);
        wata.writeSession(temp);
    
    }

}
