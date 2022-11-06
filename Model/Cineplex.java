package Model;

import java.util.*;
import java.io.*;
public class Cineplex{
    private String locationName;

    private String cineplexCode;

    private ArrayList<Session> sessionList;

    public String getLocationName(){
        return this.locationName;
    }

    public String getCinePlexCode(){
        return this.cineplexCode;
    }

    public ArrayList<Session> getSessionList(){
        return sessionList;
    }

    //private List<String> cinemaCode = Arrays.asList(new String[3]);

    public Cineplex(String locationName, String cineplexCode) throws IOException{
        this.locationName = locationName;
        this.cineplexCode = cineplexCode;
        this.sessionList = new ArrayList<>();
        String fileName = "DataBase/SessionRecord" + cineplexCode + ".txt";

        Scanner sc = new Scanner(fileName);
        int i=0;
        while(sc.hasNextLine()){
            sc.nextLine();
            i++;
        }
        for(int j =0; j<i; j++){
            this.sessionList.add(new Session());
            this.sessionList.get(j).read(cineplexCode, j);
        }
        
        //Sessionsfrombackside.add(new Session());
        //Sessionsfrombackside.get(j).read(j);
    }

}