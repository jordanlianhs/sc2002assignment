package UI;

import java.util.*;
import java.text.*;
import java.io.*;

public class HolidayUI {
	static Scanner sc = new Scanner(System.in); // Console
	static File file = new File("./Database/holiday.txt");
	static int count = 11; // To track num of elements in list

	public static void main(String[] args) throws Exception {
		int choice;
		String del;
		String holName, date;
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

					System.out.print("Enter the DATE of Holiday (DD/MM/YYYY): ");
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
					int deleteChoice;
					String rez[] = new String[count];
					// Parse file for input date
					// System.out.println("Enter the date of holiday to delete (dd/MM/YYYY): ");
					System.out.println("Enter the exact entry you want to delete: "); // Change this to check for date
					date = sc.nextLine();

					rez = findHol(date);

					for (int i = 0; i < rez.length; i++) {

						System.out.println(i + ": " + rez[i]);
					}
					System.out.println("Which would you like to delete?");
					deleteChoice = sc.nextInt();
					// Check Date
					// Search for all entries and select
					delHol(rez[deleteChoice]);

					// Remove entry from the file

					break;
				case 3:
					// Clear all holdays

					try {
						System.out.println("Are you sure you want to delete all Holidays? (Y/N)");
						del = sc.nextLine();
						del.toLowerCase();
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
						while (sc.hasNext()) {
							// Print the string
							System.out.print(sc.nextLine() + "\n\n"); // Display original capitalised version

						}
						if (file.length() == 0) {
							System.out.println("No entries!");
						}
						sc.close();

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

	public static boolean checkDate(String input) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
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

	// DELHOL WIP ()

	/**
	 * Deletes the input entry
	 * 
	 * @param n
	 * @throws Exception
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
	 * Finds all entries in the holiday list
	 * 
	 * @param n
	 * @return
	 */

	public static String[] findHol(String n) {
		String[] searchResults = new String[count];
		int i = 0;
		try {
			File file = new File("./Database/holiday.txt");
			Scanner sc = new Scanner(file);
			sc.useDelimiter(",");
			while (sc.hasNext()) {
				String st = sc.nextLine();// To get current string with all Capitalisation
				String st2 = st.toLowerCase().toString(); // Changes it to lowercase and string for searching
				n = n.toLowerCase(); // Convert input string toLower to compare
				// Print the string
				System.out.println(); // Just formatting line
				if (st2.contains(n)) {
					if (!st2.equals(null)) {
						System.out.println(st); // Display original capitalised version
						System.out.println();
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

	// GregorianCalendar [] hols = new GregorianCalendar[11];

	// public HolidayUI() {
	// //Initialise all holidays
	// //Year Month Day
	// hols[0] = new GregorianCalendar(2022, 0,1); //New Year
	// hols[1] = new GregorianCalendar(2022, 1,1); //CNY
	// hols[2] = new GregorianCalendar(2022, 1,2); //CNY
	// hols[3] = new GregorianCalendar(2022, 3,15); //Good Friday
	// hols[4] = new GregorianCalendar(2022, 4, 1); //Labour Day
	// hols[5] = new GregorianCalendar(2022, 4, 3); //Hari Raya Puasa
	// hols[6] = new GregorianCalendar(2022, 4,15); //Vesak Day
	// hols[7] = new GregorianCalendar(2022, 6,10); //Hari Raya Haji
	// hols[8] = new GregorianCalendar(2022, 7,9); //National Day
	// hols[9] = new GregorianCalendar(2022, 9,24); //Deepavali
	// hols[10] = new GregorianCalendar(2022, 11,25); //Christmas
	// }

	// public GregorianCalendar getHols(int i) {
	// return hols[i];
	// }

	// public int getLength() {
	// return hols.length;
	// }
}
