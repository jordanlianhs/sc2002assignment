package UI;

import java.util.*;

/** 
 * Main UI used to drive the program 
*/
public class MainUI {
    /**
     * New AdminUI object driving the view
     */
    private AdminUI adminUI = new AdminUI();

    /**
     * New UserUI object driving the view
     */
    private UserUI userUI = new UserUI();

    /**
     * Main function driving the view
     */
    public void main(){

        boolean exit = false;
        while (!exit) {

            Scanner sc = new Scanner(System.in);
            System.out.println("-----------------------------------");
            System.out.println("========|Welcome to MOBLIMA|=======");
            System.out.println("-----------------------------------");

            System.out.println("1: Admin Module");
            System.out.println("2: User Module");
            System.out.println("3: Exit");
            System.out.print("Please enter the module you want to access: ");

            switch (sc.nextInt()) {
                case 1:
                    this.adminUI.main();
                    break;
                case 2:
                    this.userUI.main();
                    break;
                case 3:
                    exit = true;
                    System.out.println("\nExiting MOBLIMA....");
                    sc.close();
                    break;
                default:
                    System.out.println("\nWrong input!\n");
                    break;
            }
        }
    }
}
