package Model;

import java.util.Scanner;

public class CheckSeatUI {
	
	static Scanner s = new Scanner(System.in);
	private Session sessiono;
	
	public CheckSeatUI(Session SessionNo) {
		sessiono = SessionNo;
	}
	
	public void checkAvailableSeat() {
		sessiono.getSeatPlan().printLayout();
	}
	
	public void bookSeat() {
		System.out.println("Choose your Seat");
		System.out.println("Enter row (A to J)");
		char seatR = s.next().charAt(0);
		System.out.println("Enter row (0 to 15)");
		int seatC = s.nextInt();
		sessiono.getSeatPlan().assign(seatR, seatC);
	}
	
	public void cancelSeat() {
		System.out.println("Choose your Seat");
		System.out.println("Enter row (A to J)");
		char seatR = s.next().charAt(0);
		System.out.println("Enter row (0 to 15)");
		int seatC = s.nextInt();
		sessiono.getSeatPlan().unassign(seatR, seatC);
	}
	
	
	public void main(String arg[]) {
		boolean k = true;

		while(k) {
			System.out.println("(1) View Available Seat");
			System.out.println("(2) Book Seat");
			System.out.println("(3) Cancel Seat");
			System.out.println("(4) Exit SeatUI");
			int choice = s.nextInt();
			
			switch(choice) {
			case 1:
				checkAvailableSeat();
				break;
			case 2:
				bookSeat();
				break;
			case 3:
				cancelSeat();
				break;
			case 4:
				System.out.println("Exit SeatUI");
				k = false;
				break;
			}
			
		}

	}
}