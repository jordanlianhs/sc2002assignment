package UI;
import java.util.*;
import UI.*;

public class MovieCRUD {
	static Scanner sc = new Scanner(System.in); // Console
    public static void main(String[] args) throws Exception {
		int choice;
		String del;
		String holName, date;
		do {
			System.out.println("===Conifure Movie Listing UI===");
			System.out.println("(1) Create Movie");
			System.out.println("(2) Delete Movie");
			System.out.println("(3) Clear all Movie");
			System.out.println("(4) List all Movies");
			System.out.println("(5) Quit Configure Movie UI");
			choice = sc.nextInt();
			sc.nextLine(); // Clear scanner buffer
			switch (choice) {
                case 1:
					
                case 2:

                case 3:

                case 4:

                case 5:

                default:
                    break;
            }
        }while(choice != 5);

    }
}
