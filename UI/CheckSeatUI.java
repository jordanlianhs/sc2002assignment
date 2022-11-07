package UI;

import Model.*;
import java.util.*;
import java.io.*;

public class CheckSeatUI {

	//private static Session sessiono= new Session();

	//private static Guest user = new Guest();

	//private static String cinemaCode = null;

	//public CheckSeatUI(Guest user, Session SessionNo, String cinemaCode) {
	//	this.user = user;
	//	sessiono = SessionNo;
	//	this.cinemaCode = cinemaCode;
	//}

	public static void checkAvailableSeat(Cineplex A, Cineplex B, Cineplex C) {
		//sessiono.getSeatPlan().printLayout();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter your Cineplex Code");
		String cpCode = s.next();
		int i = 0;
		int number = 0;
		ArrayList<Session> temp;
		if(cpCode.equals("AMK")){
			temp =  A.getSessionList();
		}

		else if(cpCode.equals("BBK")){
			temp =  A.getSessionList();
		}

		else{
			temp =  C.getSessionList();
		}
		int size = temp.size();
		int count =0;
		while(count <size){
			System.out.print(i+1);
			temp.get(count).printSession();
			count++;
		}
		
		System.out.println("Choose your Session");
		number = s.nextInt();

		temp.get(number-1).getSeatPlan().printLayout();
	}

	public static void bookSeat(Guest user, Cineplex A, Cineplex B, Cineplex C) throws IOException, Exception {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter your Cineplex Code");
		String cpCode = s.next();
		int i = 0;
		int number = 0;
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
			System.out.print(i+1);
			temp.get(count).printSession();
			count++;
		}
		
		System.out.println("Choose your Session");
		number = s.nextInt();
		
		
		System.out.println("Choose your Seat");
		System.out.println("Enter row (A to J)");
		char seatR = s.next().charAt(0);
		System.out.println("Enter row (0 to 15)");
		int seatC = s.nextInt();
		temp.get(number-1).getSeatPlan().assign(seatR, seatC);
		//skip sales part first
		//String movieNameToPay = temp.get(number-1).getMovie().getmovieName();

		

		Booking book = new Booking(user, temp.get(number-1), "B3", temp.get(number-1).getCinemaCode());
		book.writebookingstatement();
		TicketPrice calculator = new TicketPrice();
		double ticketPrice = calculator.calculateTix(user, temp.get(number-1), book);
		System.out.println("Ticket Price = $" + ticketPrice);
	}

	public static void cancelSeat(Cineplex A, Cineplex B, Cineplex C) {
		Scanner s = new Scanner(System.in);
		System.out.println("Choose your Seat");
		System.out.println("Enter row (A to J)");
		char seatR = s.next().charAt(0);
		System.out.println("Enter row (0 to 15)");
		int seatC = s.nextInt();
		//sessiono.getSeatPlan().unassign(seatR, seatC);

	}

	public static void main(String[] args, Guest user) throws IOException, Exception{
		Cineplex A = new Cineplex("Ang Mo Kio", "AMK");
        Cineplex B = new Cineplex("Bukit Batok", "BBK");
        Cineplex C = new Cineplex("Choa Chu Kang", "CCK");
		Scanner s = new Scanner(System.in);
		boolean k = true;

		while (k) {
			System.out.println("(1) View Available Seat");
			System.out.println("(2) Book Seat");
			System.out.println("(3) Cancel Seat");
			System.out.println("(4) Exit SeatUI");
			int choice = s.nextInt();

			switch (choice) {
				case 1:
					checkAvailableSeat(A,B,C);
					break;
				case 2:
					bookSeat(user,A,B,C);
					break;
				case 3:
					cancelSeat(A,B,C);
					break;
				case 4:
				    saveSeatBooking(A,B,C);
					System.out.println("Exit SeatUI");
					k = false;
					break;
			}

		}

	}

	public static void saveSeatBooking(Cineplex A, Cineplex B, Cineplex C) throws IOException,FileNotFoundException {

		// Note need to add options for deleting
		ArrayList<Session> temp1, temp2, temp3;
		temp1 =  A.getSessionList();
		temp2 =  B.getSessionList();
		temp3 =  C.getSessionList();

		String fileName1= "Database/SessionRecordAMK.txt";
		String fileName2= "Database/SessionRecordBBK.txt";
		String fileName3= "Database/SessionRecordCCK.txt";
		File file1 = new File(fileName1);
		File file2 = new File(fileName2);
		File file3 = new File(fileName3);
		file1.delete();
		file2.delete();
		file3.delete();
		
		
			int size = temp1.size();
			int count =0;
			while(count <size){
				temp1.get(count).writeSession("AMK");
				count++;
			}
			size = temp2.size();
			count =0;
			while(count <size){
				temp2.get(count).writeSession("BBK");
				count++;
			}
			size = temp3.size();
			count =0;
			while(count <size){
				temp1.get(count).writeSession("CCK");
				count++;
			}
		
	}

}
