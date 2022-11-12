package UI;
import java.util.*;
import java.io.*;
import Model.*;

/**
 * This is the main class of RemoveSession
 */
public class RemoveSession {
    private Cineplex A;
    private Cineplex B;
    private Cineplex C;

    /**
     * This is the main method of RemoveSession class
     * @param args
     * @throws Exception
     */
    public void main(){
        try{
            Scanner sc = new Scanner(System.in);

            A = new Cineplex("Ang Mo Kio", "AMK");
            B = new Cineplex("Bukit Batok", "BBK");
            C = new Cineplex("Choa Chu Kang", "CCK");
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
                try{
                    do{
                        System.out.println("Choose your Session to delete");
                        number = sc.nextInt();
                    }
                    while(number>count);
                    break;
                }catch (Exception e) {
                        System.out.println("Enter an integer!");
                        System.out.println();
                        sc.nextLine();
                        continue;
                    }
            }while(true);
    
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
        catch(Exception e){
            System.out.println("IO Error");
        }
    }

    /**
     * This method remove every session with the specific movie name
     * @param moviename is the name of the movie
     */
    public void removeAllSession(String moviename){
        try{
            A = new Cineplex("Ang Mo Kio", "AMK");
            B = new Cineplex("Bukit Batok", "BBK");
            C = new Cineplex("Choa Chu Kang", "CCK");
    
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
                    if(temp.get(count).getMovie().getmovieName().equalsIgnoreCase(moviename)){
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
        catch(Exception e){
            System.out.println("IO Error");
        }
        
    }
    
}
