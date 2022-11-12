package Model;

import java.util.*;
import java.io.*;

/**
 * Class for Cineplexes 
 */
public class Cineplex{
    /**
     * Name of location
     */
    private String locationName;

    /**
     * Code of cineplex
     */
    private String cineplexCode;

    /**
     * Array list of movie sessions
     */
    private ArrayList<Session> sessionList;

    /**
     * Getter for location name
     * @return Location name
     */
    public String getLocationName(){
        return this.locationName;
    }

    /**
     * Getter for cineplex code
     * @return Cineplex code
     */
    public String getCinePlexCode(){
        return this.cineplexCode;
    }

    /**
     * Getter for session list
     * @return Array list of movie sessions
     */
    public ArrayList<Session> getSessionList(){
        return sessionList;
    }

    

    /**
     * Constructor for Cineplex class
     * @param locationName Location Name
     * @param cineplexCode Cineplex Code
     * @throws IOException Throws IOException
     */
    public Cineplex(String locationName, String cineplexCode){
        try{
            this.locationName = locationName;
            this.cineplexCode = cineplexCode;
            this.sessionList = new ArrayList<>();
            String fileName = "DataBase/SessionRecord" + cineplexCode + ".txt";
            File Document = new File(fileName);
            
    
            Scanner sc = new Scanner(Document);
            int i=0;
            while(sc.hasNextLine()){
                sc.nextLine();            
                i++;
            }
            
            for(int j =0; j<i; j++){
                this.sessionList.add(new Session());
                this.sessionList.get(j).read(cineplexCode, j);
            }
            

        }catch(IOException e){
            e.printStackTrace();
        }
    }

}