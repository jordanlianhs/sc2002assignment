package UI;
import java.util.*;
import Model.*;

public class UserUI {
    /**
	 * The main function for this view
	 * @param args for the main function
	 * @throws Exception to throw the exception
	 */
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		/**
		 * to keep track of when to exit the used module
		 */
        System.out.println("USER PAGE");
        System.out.println("****************");

        System.out.println("Enter your name");
        String name = sc.next();
        System.out.println("Enter your age");
        int age = sc.nextInt();
        System.out.println("Enter your phone number");
        String phone = sc.next();
        System.out.println("Enter your email");
        String email = sc.next();
        System.out.println("Are you a student? (Enter 'true' or 'false')");
        boolean student = sc.nextBoolean();

        Guest user = new Guest(name, age, phone, email, student);
        
		int exit = 0;
		while(exit != 1) {
			
			int choice = -1;
			while(choice > 7 || choice < 0) {
                System.out.println("USER PAGE");
                System.out.println("****************");
                
				System.out.println("1. Search all movies");
				System.out.println("2. Movie details");
				System.out.println("3. Book seat(s)");
				System.out.println("4. Check Booking History");
				System.out.println("5. Top movies");
				System.out.println("6. Review movie");
				System.out.println("7. Go Back");
				System.out.print("Please enter your choice: ");
				choice = sc.nextInt();
				System.out.println();
			
			
                if(choice == 1) {
                    SearchMovie.main(null);
                }else if (choice == 2) {
                    MovieDetails.main(null);
                }else if(choice == 3) {
                    CheckSeatUI.main (null,user);
                }else if(choice == 4) {
                    CheckBookingUI.main(null);
                }else if(choice == 5) {
                    ListTop5UI.init();
                    ListTop5UI.main();
                }else if(choice == 6) {
                    ReviewUI.main(null,user);
                }else if(choice == 7){
                    return;
                }
                else{
                    System.out.println("\nWrong input!\n");
                    System.out.println("Please try again!\n");
                }
            }
		}
		
	}
}
