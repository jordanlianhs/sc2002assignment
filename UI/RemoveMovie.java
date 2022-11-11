package UI;

import java.util.*;
import java.util.concurrent.ExecutionException;

import UI.*;
import java.io.*;
import Model.*;
import java.time.*;
import java.time.format.*;

public class RemoveMovie {
    static int count = 0;
    static Scanner sc = new Scanner(System.in); // Console

    /**
     * Main function driving the view
     * 
     * @param args null argument can be used to drive the function
     * @throws Exception Throws Exception
     */
    public static void main(String[] args) throws Exception {
        File f = new File("./Database/MovieCollectionNew.txt");
        lineCounter l = new lineCounter();
        count = l.counter(f);
        int dChoice;
        String rez[] = new String[count];
        // Parse file for input date
        System.out.println("Search for movie name to delete: ");
        String date = sc.nextLine();

        rez = SearchMovie.getSearchedMovie(date); // Search for all entries with input term

        // Prints out all options for the user
        for (int i = 0; i < count; i++) {
            if (rez[i] == null) {
                break;
            }
            System.out.println(i + ": " + rez[i]);
        }

        // Scan for deletion choice
        System.out.println("Which would you like to delete?");

        dChoice = Integer.valueOf(sc.nextLine());

        // Delete Entry with the movie name
        RemoveSession.removeAllSession(rez[dChoice].split(",")[0]);
        SearchMovie.delMovie(rez[dChoice]);
        sc.close();
    }
}
