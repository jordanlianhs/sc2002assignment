package UI;

import Model.*;
import java.util.*;
import java.io.*;

public class CheckSeatUI {

	private static Session sessiono= new Session();

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
		if(cpCode.equals("ABC")){
			temp =  A.getSessionList();
		}

		else if(cpCode.equals("BBC")){
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

	public static void bookSeat(Guest user, Cineplex A, Cineplex B, Cineplex C) throws IOException {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter your Cineplex Code");
		String cpCode = s.next();
		int i = 0;
		int number = 0;
		ArrayList<Session> temp;
		if(cpCode.equals("ABC")){
			temp =  A.getSessionList();
		}

		else if(cpCode.equals("BBC")){
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
		
		
		System.out.println("Choose your Seat");
		System.out.println("Enter row (A to J)");
		char seatR = s.next().charAt(0);
		System.out.println("Enter row (0 to 15)");
		int seatC = s.nextInt();
		temp.get(number-1).getSeatPlan().assign(seatR, seatC);
		// nid write back to SessionRecord?
		Booking book = new Booking(user, temp.get(number-1), "B3", temp.get(number-1).getCinemaCode());
		book.writebookingstatement();

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

	public static void main(String[] args, Guest user, Cineplex A, Cineplex B, Cineplex C) throws IOException {
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
					bookSeat(user, A,B,C);
					break;
				case 3:
					cancelSeat(A,B,C);
					break;
				case 4:
					System.out.println("Exit SeatUI");
					k = false;
					break;
			}

		}

	}
}
