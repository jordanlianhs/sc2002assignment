package UI;

import java.util.*;
import java.io.*;

public class MovieDetails {
    /**
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
		String input;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("\nEnter \"esc\" to quit movie details UI");
			System.out.print("Enter a movie name: ");
			input = sc.nextLine();
			MovieDetails look = new MovieDetails();
			look.details(input);
		} while (!input.toLowerCase().equals("esc"));
	}

    public void details(String input) throws Exception{
        try{
            File file = new File("./Database/MovieCollection.txt");
			Scanner sc = new Scanner(file).useDelimiter(",");

            while(sc.hasNext()){
                String st = sc.nextLine();// To get current string with all Capitalisation
				String st2 = st.toLowerCase().toString(); // Changes it to lowercase and string for searching
                
                String[] stToken = st2.split(",");

                if(stToken[0].equals(input.toLowerCase())){
                    System.out.println("The movie details requested are as follows : ");
                    System.out.println(st);
                    break;
                }
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
    }

}
