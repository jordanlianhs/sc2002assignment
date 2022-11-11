package UI;

import java.time.*;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.io.*;
import Model.*;

/**
 * This is the main class of UpdateSession
 */
public class UpdateSession {
    
    /**
     * This is the main method of UpdateSession class
     * @param args
     * @throws Exception
     */
    public void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        Cineplex A = new Cineplex("Ang Mo Kio", "AMK");
        Cineplex B = new Cineplex("Bukit Batok", "BBK");
        Cineplex C = new Cineplex("Choa Chu Kang", "CCK");
        String cpCode, lol;
        do{
			System.out.println("Enter Cineplex Code (AMK, BBK, CCK): ");
			cpCode = sc.next();
		}
		while(!cpCode.equals("AMK")&&!cpCode.equals("BBK")&&!cpCode.equals("CCK"));
    
        int i = 0;
        int number = 0;
        LocalDateTime seshDateTime;
        Movie movie = new Movie();
        String cinemaCode;

        ArrayList<Session> temp;
        if(cpCode.equals("AMK")){
            temp =  A.getSessionList();
        }

        else if(cpCode.equals("BBK")){
            temp =  B.getSessionList();
        }

        else{
            temp =  C.getSessionList();
        }
        int size = temp.size();
        int count =0;
        while(count <size){
            System.out.print((count+1)+" ");
            temp.get(count).printSession();
            count++;
        }
        do{
            System.out.println("Choose your Session to update");
            number = sc.nextInt();
        }
        while(number>count);
        if(number == 0){
            return;
        }
        do{
            try{
                System.out.println("Choose what to update: ");
                System.out.println("1. Session Time");
                System.out.println("2. Movie");
                System.out.println("3. Cinema");
                i = sc.nextInt();
                break;
            }catch (Exception e) {
					System.out.println("Enter an integer!");
					System.out.println();
					sc.nextLine();
					continue;
				}
        }while(true);


        if(i==1){
            System.out.print("Enter New Session Date Time (YYYY-MM-DD hh:mm): ");
            sc.nextLine();
            lol = sc.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            seshDateTime = LocalDateTime.parse(lol, formatter);
            temp.get(number-1).setSeshDateTime(seshDateTime);
        }

        else if(i==2){
            int c = 0;
            do{
                System.out.println("Enter New Movie Name: ");
                lol = sc.next();
                movie.readMovie(lol);
                if(movie.getmovieName()!=null){
                    c=1;
                }
                else{
                    System.out.println("Movie Name does not exist");
                }
            }while(c==0);
            
            movie.readMovie(lol);
            temp.get(number-1).setMovie(movie);
        }

        else{
            do{
                System.out.println("Enter Cinema Code (ONE, TWO, THR): ");
                lol = sc.next();
            }
            while(!lol.equals("ONE")&&!lol.equals("TWO")&&!lol.equals("THR"));
            cinemaCode = lol;
            temp.get(number-1).setCinemaCode(cinemaCode);
        }


        String fileName;
        if(cpCode.equals("AMK")){
            fileName= "Database/SessionRecordAMK.txt";
        }
        else if(cpCode.equals("BBK")){
            fileName= "Database/SessionRecordBBK.txt";
        }
        else{
            fileName= "Database/SessionRecordCCK.txt";
        }
		

		//File file = new File(fileName);
		//file.delete();
        PrintWriter writer = new PrintWriter(fileName);
        writer.print("");
        writer.close();
		
		size = temp.size();
		count = 0;

        if(cpCode.equals("AMK")){
            while(count <size){
                temp.get(count).writeSession("AMK");
                //System.out.println(size);
                count++;
            }
        }
        else if(cpCode.equals("BBK")){
            while(count <size){
                temp.get(count).writeSession("BBK");
                count++;
            }
        }
        else{
            while(count <size){
                temp.get(count).writeSession("CCK");
                count++;
            }
        }
        System.out.println("Session Updated");
    }
    
}
