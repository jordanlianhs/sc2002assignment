package UI;

import java.time.*;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.io.*;
import Model.*;

/**
 * This class is used to create a new session
 */
public class CreateSession {
    private Movie movie;
    /**
     * This is the main method to create a new session
     * @param args null argument can be used to drive the function
     * @throws Exception Throws Exception
     */
    public void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String temp;
        LocalDateTime seshDateTime;
        movie = new Movie();
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

        do{
			System.out.println("Enter Cinema Code (ONE, TWO, THR): ");
			temp = sc.next();
		}
		while(!temp.equals("ONE")&&!temp.equals("TWO")&&!temp.equals("THR"));

        cinemaCode = temp;

        do{
			System.out.println("Enter Cineplex Code (AMK, BBK, CCK): ");
			temp = sc.next();
		}
		while(!temp.equals("AMK")&&!temp.equals("BBK")&&!temp.equals("CCK"));

        Session wata = new Session(movie, seshDateTime, cinemaCode);
        wata.writeSession(temp);
    
    }

}
