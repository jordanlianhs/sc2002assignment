package UI;

import java.util.*;
import java.text.*;
import java.io.*;

/**
 * HoidayUI implements the functions and the driver code to add/remove and list
 * holidays for
 * the ticketing system TicketPrice.java
 */

public class HolidayUI {
	static Scanner sc = new Scanner(System.in); // Console
	static File file = new File("./Database/holiday.txt");
	static int count = 0; // To track num of elements in list

	/**
	 * Driver for Creating/Deleting/Clearing Holidays
	 * 
	 * @param args Main arument args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		int choice;
		String del;
		String holName, date;
		lineCounter l = new lineCounter();
		count = l.counter(file);
		do {
			System.out.println("===HolidayUI===");
			System.out.println("(1) Create Holiday");
			System.out.println("(2) Delete Holiday");
			System.out.println("(3) Clear all Holidays");
			System.out.println("(4) List all holidays");
			System.out.println("(5) Quit HolidayUI");
			choice = sc.nextInt();
			sc.nextLine(); // Clear scanner buffer
			switch (choice) {
				case 1:
					FileWriter FR = new FileWriter(file, true);
					System.out.print("Enter the NAME of Holiday: ");
					holName = sc.nextLine();

					System.out.print("Enter the DATE of Holiday (YYYY-MM-DD): ");
					date = sc.nextLine();

					// Validate if its a valid date
					if (checkDate(date)) {
						// If it is, write to file holiday.txt
						FR.write(holName + "," + date + System.lineSeparator());
						System.out.println("Date added!");
						FR.close();
					}
					break;
				case 2:
					// Delete and entry
					int dChoice;
					String rez[] = new String[count];
					// Parse file for input date
					System.out.println("Search for something to delete: ");
					date = sc.nextLine();

					rez = searchHol(date); // Search for all entries with input term

					// Prints out all options for the user
					for (int i = 0; i < count; i++) {
						if (rez[i] == null) {
							break;
						}
						System.out.println(i + ": " + rez[i]);
					}

					// Scan for deletion choice
					System.out.println("Which would you like to delete?");

					dChoice = sc.nextInt();
					// Delete Entry
					delHol(rez[dChoice]);
					break;
				case 3:
					// Clear all holdays

					try {
						System.out.println("Are you sure you want to delete all Holidays? (Y/N)");
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
					}

					break;
				case 4:
					// List all Holidays
					try {
						File file = new File("./Database/holiday.txt");
						Scanner sc = new Scanner(file);

						sc.useDelimiter(",");
						System.out.println("===============");
						System.out.println("List of Holidays:");
						while (sc.hasNext()) {
							// Print the string
							System.out.println(sc.nextLine()); // Display original capitalised version
						}
						System.out.println("===============");
						if (file.length() == 0) {
							System.out.println("No entries!");
						}
						sc.close();
						System.out.println();

					} catch (FileNotFoundException e) {
						System.out.println("An error occurred.");
						e.printStackTrace();
					}
					break;
				case 5:
					// Stop holiday UI
					return;
				default:
					break;
			}
		} while (choice != 5);
	}

	/**
	 * Check for Valid Date format
	 * 
	 * @param input check the input string against a set date format
	 * @return returns true if the format is correct
	 * @exception parseException Signals that an error has been reached unexpectedly
	 *                           while parsing. input
	 */
	public static boolean checkDate(String input) throws Exception {
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
			System.out.println("INVALID DATE!");
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
	public static void delHol(String n) throws Exception {

		// Note need to add options for deleting
		try {

			File inputFile = new File("./Database/holiday.txt");
			if (!inputFile.isFile()) {
				System.out.println("File does not exist");
				return;
			}
			// Construct the new file that will later be renamed to the original filename.
			File tempFile = new File("./holidayTemp.txt");
			BufferedReader br = new BufferedReader(new FileReader("./Database/holiday.txt"));
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

	public static String[] searchHol(String n) {
		String[] searchResults = new String[count];
		int i = 0;
		try {
			File file = new File("./Database/holiday.txt");
			Scanner sc = new Scanner(file);
			// sc.useDelimiter(",");
			while (sc.hasNext()) {
				String st = sc.nextLine();// To get current string with all Capitalisation
				String st2 = st.toLowerCase().toString(); // Changes it to lowercase and string for searching
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
			// return searchResults;
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return searchResults;
	}

	/**
	 * Returns ALL holdays in holiday.txt as an array
	 * 
	 * @return String array containing 1 line per entry
	 */
	public static String[] getHols() {
		String[] arr = new String[count];
		int i = 0;
		try {
			File file = new File("./Database/holiday.txt");
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

	public static boolean findHol(String n) {
		try {
			File file = new File("./Database/holiday.txt");
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
