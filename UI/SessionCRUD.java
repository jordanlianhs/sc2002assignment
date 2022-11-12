package UI;

import java.util.*;
import UI.*;
import Model.*;

/**
 * Class that will run all UI about Session, Create, Remove, Update and Display
 */
public class SessionCRUD {
    /**
     * CreateSession object
     */
    private CreateSession createSession = new CreateSession();
    /**
     * RemoveSession object
     */
    private RemoveSession removeSession = new RemoveSession();
    /**
     * UpdateSession object
     */
    private UpdateSession updateSession = new UpdateSession();
    /**
     * DisplaySession object
     */
    private DisplaySession displaySession = new DisplaySession();

    /**
     * Main function running SessionCRUD class
     * @param args
     * @throws Exception
     */
    public void main(){
        Scanner sc = new Scanner(System.in); // Console

		int choice;
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
					this.createSession.main(null);
                    break;
                case 2:
                    this.removeSession.main();
                    break;
                case 3:
                    this.updateSession.main(null);
                    break;
                case 4:
                    this.displaySession.main(null);
                    break;
                case 5:
					return;
                default:
                    break;
            }
        }while(choice != 5);

    }
}
