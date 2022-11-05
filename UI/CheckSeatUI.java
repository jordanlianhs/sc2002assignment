package UI;

import Model.*;
import java.util.Scanner;
import java.io.*;

public class CheckSeatUI {

	private Session sessiono;

	private Guest user;

	public CheckSeatUI(Guest user, Session SessionNo) {
		this.user = user;
		sessiono = SessionNo;
	}

	public void checkAvailableSeat() {
		sessiono.getSeatPlan().printLayout();
	}

	public void bookSeat() throws IOException {
		Scanner s = new Scanner(System.in);
		System.out.println("Choose your Seat");
		System.out.println("Enter row (A to J)");
		char seatR = s.next().charAt(0);
		System.out.println("Enter row (0 to 15)");
		int seatC = s.nextInt();
		sessiono.getSeatPlan().assign(seatR, seatC);
		// nid write back to SessionRecord?
		Booking book = new Booking(user, sessiono, "B3");
		book.writebookingstatement();

	}

	public void cancelSeat() {
		Scanner s = new Scanner(System.in);
		System.out.println("Choose your Seat");
		System.out.println("Enter row (A to J)");
		char seatR = s.next().charAt(0);
		System.out.println("Enter row (0 to 15)");
		int seatC = s.nextInt();
		sessiono.getSeatPlan().unassign(seatR, seatC);

	}

	public void main() throws IOException {
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
