package UI;
import java.util.*;
import Model.*;

/**
 * This is the UI for users
 */
public class UserUI {
    private SearchMovie searchMovie = new SearchMovie();
    private MovieDetails movieDetails = new MovieDetails();
    private CheckSeatUI checkSeatUI = new CheckSeatUI();
    private CheckBookingUI checkBookingUI = new CheckBookingUI();
    private ListTop5UI listTop5UI = new ListTop5UI();
    private ReviewUI reviewUI = new ReviewUI();

    /**
	 * The main function for this view
	 * @param args for the main function
	 * @throws Exception to throw the exception
	 */
	public void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		/**
		 * to keep track of when to exit the used module
		 */
        System.out.println("USER PAGE");
        System.out.println("****************");

        System.out.println("Enter your name");
        String name = sc.nextLine();
        System.out.println("Enter your age");
        int age = Integer.parseInt(sc.nextLine());
        System.out.println("Enter your phone number");
        String phone = sc.nextLine();
        System.out.println("Enter your email");
        String email = sc.nextLine();
        System.out.println("Are you a student? (Enter 'true' or 'false')");
        boolean student = Boolean.valueOf(sc.nextLine());

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
				choice = Integer.parseInt(sc.nextLine());
				System.out.println();
			
			
                if(choice == 1) {
                    this.searchMovie.main(null);
                }else if (choice == 2) {
                    this.movieDetails.main(null);
                }else if(choice == 3) {
                    this.checkSeatUI.main (null,user);
                }else if(choice == 4) {
                    this.checkBookingUI.main(null);
                }else if(choice == 5) {
                    this.listTop5UI.init();
                    this.listTop5UI.main();
                }else if(choice == 6) {
                    this.reviewUI.main(null,user);
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
