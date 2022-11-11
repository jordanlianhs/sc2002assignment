package UI;
import java.util.*;
import Model.*;

/**
 * This is the main class of DisplaySession
 */
public class DisplaySession {
	private Cineplex A;
    private Cineplex B;
    private Cineplex C;
	/**
	 *  This is the main method to display the list of sessions in the selected cineplex
	 * @param cineplexCode
	 * @throws Exception
	 */
    public void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        A = new Cineplex("Ang Mo Kio", "AMK");
        B = new Cineplex("Bukit Batok", "BBK");
        C = new Cineplex("Choa Chu Kang", "CCK");
		
        String cpCode;
        System.out.println("-----------------------------------");
        System.out.println("Display Session");
        System.out.println("-----------------------------------");
    
		do{
			System.out.println("Enter Cineplex Code (AMK, BBK, CCK): ");
			cpCode = sc.next();
		}
		while(!cpCode.equals("AMK")&&!cpCode.equals("BBK")&&!cpCode.equals("CCK"));


		ArrayList<Session> temp;
		if(cpCode.equals("AMK")){
			temp =  A.getSessionList();
		}

		else if(cpCode.equals("BBK")){
			temp =  B.getSessionList();
		}

		else{
			temp =  C.getSessionList();
		}
		int size = temp.size();
		int count =0;
		while(count <size){
			System.out.print((count+1) + " ");
			temp.get(count).printSession();
			count++;
		}
    }
}
