package UI;

import java.util.*;
import UI.*;
import Model.*;

public class SessionCRUD {
    static Scanner sc = new Scanner(System.in); // Console

    public static void main(String[] args) throws Exception {

		int choice;
		String del;
		String holName, date;
		do {
			System.out.println("===Configure Session Listing UI===");
			System.out.println("(1) Create Session");
			System.out.println("(2) Remove Session");
			System.out.println("(3) Update Session");
			System.out.println("(4) Display Session");
			System.out.println("(5) Quit Configure Movie UI");
			choice = sc.nextInt();
			sc.nextLine(); // Clear scanner buffer
			switch (choice) {
                case 1:
					CreateSession.main(null);
                    break;
                case 2:
                    RemoveSession.main(null);
                    break;
                case 3:

                case 4:
                    DisplaySession.main(null);
                    break;
                case 5:
					return;
                default:
                    break;
            }
        }while(choice != 5);

    }
}
