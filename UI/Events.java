package UI;

import java.util.*;
import java.text.*;
import java.io.*;

/**
 * HoidayUI implements the functions and the driver code to add/remove and list
 * Events for
 * the ticketing system TicketPrice.java
 */

public class Events {
    private File file = new File("./Database/Events.txt");
    private int count = 0; // To track num of elements in list

    public Events() {
    }

    /**
     * Driver for Creating/Deleting/Clearing Event
     * 
     * @param args Main arument args (null)
     * @throws Exception throws exceptions
     */

    public void main() {
        Scanner sc = new Scanner(System.in); // Console
        int choice;
        String del;
        String EventName = "", date = "";
        lineCounter l = new lineCounter();
        count = l.counter(file);

        do {
            System.out.println("===EventsUI===");
            System.out.println("(1) Create Event");
            System.out.println("(2) Delete EVent");
            System.out.println("(3) Clear all Events");
            System.out.println("(4) List all Events");
            System.out.println("(5) Quit EventsUI");
            choice = sc.nextInt();
            sc.nextLine(); // Clear scanner buffer
            switch (choice) {
                case 1:
                    boolean dateCheck = false;
                    do {
                        try {
                            FileWriter FR = new FileWriter(file, true);

                            System.out.println("Enter the NAME of Event: ");
                            System.out.println("Type \"cancel\" to exit");
                            EventName = sc.nextLine();

                            if (EventName.toLowerCase().equals("cancel")) { // break switch
                                break;
                            }

                            System.out.println("Enter the DATE of Event (YYYY-MM-DD): ");
                            date = sc.nextLine();

                            // Validate if its a valid date
                            if (dateCheck = checkDate(date)) {
                                // If it is, write to file Event.txt
                                FR.write(EventName + "," + date + System.lineSeparator());
                                System.out.println("Date added!");
                                FR.close();
                            } else {
                                System.out.println("Invalid Date!");
                                System.out.println();
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid Input!");
                            System.out.println();
                        } catch (IOException ex) {
                            System.out.println("Error!");
                        }
                    } while (dateCheck != true);
                    break;
                case 2:
                    // Delete and entry
                    int dChoice = -1;
                    boolean quit = false; // Flag to quit out of the case (Used beause of error checking)
                    String rez[] = new String[count];

                    // Parse file for input date
                    do {// Check if the searched items are null
                        System.out.println("Search for something to delete: ");
                        System.out.println("Type \"cancel\" to exit");
                        date = sc.nextLine();

                        if (date.toLowerCase().equals("cancel")) { // Exit flag to break while, break swicth
                            quit = true;
                            break; // break out of while loop
                        }

                        rez = searchEvent(date); // Search for all entries with input term
                                                 // If nothing is found
                        if (rez == null) {
                            System.out.println("No entries match your search!");
                            System.out.println();
                            continue;
                        }
                    } while (rez == null);

                    // Checking if quit flag is true
                    if (quit == true) {
                        break; // break out of switch statement
                    }

                    // Prints out all options for the user if rez!= null
                    int i;
                    for (i = 0; i < count; i++) {
                        if (rez[i] == null) {
                            break;
                        }
                        System.out.println(i + ": " + rez[i]);
                    }

                    do {
                        try {
                            // Scan for deletion choice
                            System.out.println("Which would you like to delete?");
                            System.out.println("Type \"-1\" to exit");
                            dChoice = sc.nextInt();

                            if (dChoice < 0 || dChoice > i) {
                                System.out.println("Invalid index range! Enter a valid index.");
                                sc.nextLine(); // Clear buffer in the event that there is an invalid input
                                continue;
                            }
                            break;
                        } catch (Exception e) {
                            System.out.println("Enter an integer!");
                            System.out.println();
                            sc.nextLine();
                            continue;
                        }
                    } while (true);

                    if (dChoice == -1) { // If its the initialised value, just break;
                        sc.nextLine(); // Clear buffer in the event that there is an invalid input
                        break;
                    }
                    // Delete Entry
                    delEvent(rez[dChoice]);
                    break;
                case 3:
                    // Clear all events

                    try {
                        System.out.println("Are you sure you want to delete all Events? (Y/N)");
                        del = sc.nextLine();
                        del = del.toLowerCase();
                        if (del.equals("y")) {
                            // Deletes all entries
                            FileWriter DR = new FileWriter(file, false);
                            DR.write(""); // Overwrites everything
                            DR.close();
                            System.out.println("All entries deleted.");
                            break;
                        } else {
                            System.out.println("Deletion canceled, wrong input.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("INVALID INPUT!");
                    } catch (IOException x) {
                        System.out.println("Error!");
                    }

                    break;
                case 4:
                    // List all Events
                    try {
                        File file = new File("./Database/Events.txt");
                        Scanner sc1 = new Scanner(file);

                        sc1.useDelimiter(",");
                        System.out.println("===============");
                        System.out.println("List of Events:");
                        while (sc1.hasNext()) {
                            // Print the string
                            System.out.println(sc1.nextLine()); // Display original capitalised version
                        }
                        System.out.println("===============");
                        if (file.length() == 0) {
                            System.out.println("No entries!");
                        }
                        sc1.close();
                        System.out.println();

                    } catch (FileNotFoundException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    // Stop Events UI
                    return;
                default:
                    break;
            }
        } while (choice != 5);
        sc.close();
    }

    /**
     * Check for Valid Date format
     * 
     * @param input check the input string against a set date format
     * @return returns true if the format is correct
     * @exception parseException Signals that an error has been reached unexpectedly
     *                           while parsing. input
     */
    public boolean checkDate(String input) {
        // if (input.matches("\\d{2}-\\d{2}-\\d{4}")) {
        // System.out.println("Date Input: " + input); // Debugging Purposes
        // return true;
        // } else
        // return false;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(input);
            System.out.println("Date input: " + date); // This is just for debugging
        } catch (ParseException e) {
            // e.printStackTrace();
            // System.out.println("INVALID DATE!");
            return false;
        }
        return true;
    }

    /**
     * Deletes the input entry (entries with the same name)
     * 
     * @param n Input String to be deleted (Exact match)
     * @throws Exception if a file cannot be found or the wrong path is initialised
     */
    public void delEvent(String n) {

        // Note need to add options for deleting
        try {

            File inputFile = file;// new File("./Database/Events.txt");
            if (!inputFile.isFile()) {
                System.out.println("File does not exist");
                return;
            }
            // Construct the new file that will later be renamed to the original filename.
            File tempFile = new File("./EventsTemp.txt");
            BufferedReader br = new BufferedReader(new FileReader("./Database/Events.txt"));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
            String line = null;

            // Read from the original file and write to the new
            // unless content matches data to be removed.
            while ((line = br.readLine()) != null) {
                if (!line.trim().equals(n)) {
                    pw.println(line);
                    pw.flush();
                }
            }
            pw.close();
            br.close();

            // Delete the original file
            if (!inputFile.delete()) {
                System.out.println("Could not delete file");
                return;
            } else {
                System.out.println("Deleted: " + n);
            }
            // Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(inputFile))
                System.out.println("Could not rename file");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    /**
     * Searches for all entries containing the input string then returns all results
     * as an array (Lenient Search)
     * 
     * @param n Input search string
     * @return Array of entries that match the search term
     */

    public String[] searchEvent(String n) {
        String[] searchResults = new String[count];
        int i = 0;
        try {
            // File file = new File("./Database/Events.txt");
            Scanner sc = new Scanner(file);
            String st = null;
            String st2 = null;
            // sc.useDelimiter(",");
            while (sc.hasNext()) {
                st = sc.nextLine();// To get current string with all Capitalisation
                st2 = st.toLowerCase().toString(); // Changes it to lowercase and string for searching
                n = n.toLowerCase(); // Convert input string toLower to compare
                // Print the string

                if (st2.contains(n)) {
                    if (!st2.equals(null)) {
                        searchResults[i] = st;
                        i++;
                    }
                }
            }

            sc.close();
            if (searchResults[0] == null) {
                // System.out.println("return Null");
                return null;
            }
            // return searchResults;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return searchResults;
    }

    /**
     * Returns ALL events in Events.txt as an array
     * 
     * @return String array containing 1 line per entry
     */
    public String[] getEvents() {
        String[] arr = new String[count];
        int i = 0;
        try {
            // File file = new File("./Database/Events.txt");
            Scanner sc = new Scanner(file);
            // sc.useDelimiter(",");
            while (sc.hasNext()) {
                arr[i] = sc.nextLine();
                i++;
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return arr;
    }

    /**
     * Strictly Finds a specific date
     * 
     * @param n Input string to find
     * @return If the specific date is found, return true, else return false
     */

    public boolean findEvent(String n) {
        try {
            // File file = new File("./Database/Events.txt");
            Scanner sc = new Scanner(file);
            // sc.useDelimiter(",");
            while (sc.hasNext()) {
                String st = sc.nextLine();// To get current string with all Capitalisation
                String st2 = st.toLowerCase().toString(); // Changes it to lowercase and string for searching
                n = n.toLowerCase(); // Convert input string toLower to compare
                // Print the string

                if (st2.contains(n)) { // Makes this a strict search
                    if (!st2.equals(null)) {
                        return true;
                    }
                }
            }
            sc.close();
            // return searchResults;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return false;

        }
        return false;
    }
}
