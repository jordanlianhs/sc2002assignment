package Model;

import java.util.*;
import java.io.*;
public class Cineplex{
    private String locationName;

    private String cineplexCode;

    private ArrayList<Session> SessionList;

    //private List<String> cinemaCode = Arrays.asList(new String[3]);

    public Cineplex(String locationName, String cineplexCode) throws IOException{
        this.locationName = locationName;
        this.cineplexCode = cineplexCode;
        String fileName = "DataBase/SessionRecord" + cineplexCode + ".txt";

        Scanner sc = new Scanner(fileName);
        int i=0;
        while(sc.hasNextLine()){
            sc.nextLine();
            i++;
        }
        for(int j =0; j<i; j++){
            this.SessionList.add(new Session());
            this.SessionList.get(j).read(cineplexCode, j);
        }
        
        //Sessionsfrombackside.add(new Session());
        //Sessionsfrombackside.get(j).read(j);
    }

}