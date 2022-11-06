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
			System.out.println("(2) Remove Movie");
			System.out.println("(3) Update Movie");
			System.out.println("(4) Delete Movies");
			System.out.println("(5) Quit Configure Movie UI");
			choice = sc.nextInt();
			sc.nextLine(); // Clear scanner buffer
			switch (choice) {
                case 1:
					CreateMovie.main(null);
                case 2:
				
                case 3:

                case 4:

                case 5:
					return;
                default:
                    break;
            }
        }while(choice != 5);

    }
}
