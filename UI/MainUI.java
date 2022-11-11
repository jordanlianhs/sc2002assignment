package UI;

import java.util.*;

/** 
 * Main UI used to drive the program 
*/
public class MainUI {
    private AdminUI adminUI = new AdminUI();
    private UserUI userUI = new UserUI();

    /**
     * Main function driving the view
     * 
     * @param args null argument can be used to drive the function
     * @throws Exception Throws Exception
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
                    this.adminUI.main(null);
                    break;
                case 2:
                    this.userUI.main(null);
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
