package UI;

import java.time.*;
import java.util.*;

import java.io.*;
import Model.*;

public class DisplaySession {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        Cineplex A = new Cineplex("Ang Mo Kio", "AMK");
        Cineplex B = new Cineplex("Bukit Batok", "BBK");
        Cineplex C = new Cineplex("Choa Chu Kang", "CCK");
        String cpCode;
        System.out.println("-----------------------------------");
        System.out.println("Display Session");
        System.out.println("-----------------------------------");
    
        System.out.print("Enter Cineplex Code (AMK, BBK, CCK): ");
        cpCode = sc.nextLine();

		int i = 0;
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
			System.out.print((count+1) + " ");
			temp.get(count).printSession();
			count++;
		}
    }
}
