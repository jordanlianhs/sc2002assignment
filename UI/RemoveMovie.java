package UI;

import java.util.*;
import java.io.*;

/**
 * This is the main class of RemoveMovie
 */
public class RemoveMovie {

    private RemoveSession rm;
    private SearchMovie sm;
    static int count = 0; // To count the number of movies in the file
    

    /**
     * Main function driving the view
     * 
     * @param args null argument can be used to drive the function
     * @throws Exception Throws Exception
     */
    public void main(String[] args){
        Scanner sc = new Scanner(System.in); // Console
        File f = new File("./Database/MovieCollectionNew.txt");
        lineCounter l = new lineCounter();
        count = l.counter(f);
        int dChoice;
        String[] rez = new String[count];
        // Parse file for input date
        System.out.println("Search for movie name to delete: ");
        String date = sc.nextLine();
        
        sm = new SearchMovie();
        rez = sm.getSearchedMovie(date); // Search for all entries with input term

        // Prints out all options for the user
        boolean check = false;
        for (int i = 0; i < count; i++) {
            if (rez[i] == null) {
                break;
            }
            check = true;
            System.out.println(i + ": " + rez[i]);
        }

        if (check) {
            // Scan for deletion choice
            System.out.println("Which would you like to delete?");

            dChoice = Integer.valueOf(sc.nextLine());

            // Delete Entry with the movie name
            rm = new RemoveSession();
            rm.removeAllSession(rez[dChoice].split(",")[0]);
            
            sm.delMovie(rez[dChoice]);
        } else
            System.out.println("\nNo movie found\n");
    }
}
