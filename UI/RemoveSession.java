package UI;
import java.util.*;
import java.io.*;
import Model.*;

/**
 * This is the main class of RemoveSession
 */
public class RemoveSession {
    static Scanner sc = new Scanner(System.in);
    /**
     * This is the main method of RemoveSession class
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Cineplex A = new Cineplex("Ang Mo Kio", "AMK");
        Cineplex B = new Cineplex("Bukit Batok", "BBK");
        Cineplex C = new Cineplex("Choa Chu Kang", "CCK");
        String cpCode;
		do{
			System.out.println("Enter Cineplex Code (AMK, BBK, CCK): ");
			cpCode = sc.next();
		}
		while(!cpCode.equals("AMK")&&!cpCode.equals("BBK")&&!cpCode.equals("CCK"));

        int number = 0;
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
            System.out.println("Choose your Session to delete");
            number = sc.nextInt();
        }
        while(number>count);
        if(number == 0){
            return;
        }
        temp.remove(number-1);
        size = temp.size();
        count =0;
        while(count <size){
            System.out.print((count+1)+" ");
            temp.get(count).printSession();
            count++;
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
        System.out.println("Session Deleted");
    }

    /**
     * This method remove every session with the specific movie name
     * @param moviename is the name of the movie
     * @throws Exception Throws exception
     */
    public static void removeAllSession(String moviename) throws Exception{
        Cineplex A = new Cineplex("Ang Mo Kio", "AMK");
        Cineplex B = new Cineplex("Bukit Batok", "BBK");
        Cineplex C = new Cineplex("Choa Chu Kang", "CCK");

        System.out.println("Deleting all sessions in the Cineplexes");
        String [] tempSession = {"AMK","BBK","CCK"};
        for(int i =0; i<3;i++){
            String cpCode;
            cpCode = tempSession[i];
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
            int count = 0;
            while(count <size){
                if(temp.get(count).getMovie().getmovieName().equals(moviename)){
                    temp.remove(count);
                    size--;
                    continue;
                }
                count++;
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
                System.out.println(cpCode + " Sessions Deleted");
            }
            else if(cpCode.equals("BBK")){
                while(count <size){
                    temp.get(count).writeSession("BBK");
                    count++;
                }
                System.out.println(cpCode + " Sessions Deleted");
            }
            else{
                while(count <size){
                    temp.get(count).writeSession("CCK");
                    count++;
                }
                System.out.println(cpCode + " Sessions Deleted");
            }
        }
    }
    
}
