package Model;

/**
 * Class about timing of movie in a cinema
 */
public class SeatingPlan {
	/**
	 * Seating plan of the session
	 */
	private Seat[][] seatPlan = new Seat[10][16];
	
	/**
	 * Seating plan constructor
	 */
	public SeatingPlan() {
		int count = 0;
		for(char alpha = 'J'; alpha >='A'; alpha--) {
			for(int i = 0; i<16; i++) {
				//String temp = Character.toString(alpha)+Integer.toString(i);
				seatPlan[count][i] = new Seat(alpha, i);
			}
			count++;
		}
		
	}

	/**
	 * Get specific seat in seating plan of session
	 * @param i is the row of seat
	 * @param j is the column of seat
	 * @return seat in the seating plan
	 */
	public Seat getSeat(int i,int j){
		return seatPlan[i][j];
	}
	
	/**
	 * Display the seating plan in the session
	 */
	public void printLayout() {
		int count = -1;
		for(char alpha = 'K'; alpha >='A'; alpha--) {	
			if(alpha=='K') {
				System.out.print(" ");
			}
			
			else {
				System.out.print(alpha);
			}
			for(int i = 0; i<16; i++) {
				if(alpha=='K') {
					if(i>8) {
						System.out.print(" "+ (i+1));
					}
					else {
						System.out.print(" "+ (i+1) + " ");
					}

				}
				
				else if(seatPlan[count][i].checkTaken() == true) {
					System.out.print(" x ");
				}
				
				else {
					System.out.print(" o ");
				}
				
				if(i==7) {
					System.out.print("   ");
				}
				
			}
			System.out.println();
			count++;
		}
	}
	
	/**
	 * Book specific seat in the seating plan of the session
	 * @param row1 is the row number of seat
	 * @param column1 is the column number of seat
	 */
	public void assign(char row1, int column1) {
		int count = 0;
		for(char alpha = 'J'; alpha >='A'; alpha--) {
			if(row1 == alpha) {
				break;
			}
			else {
				count++;
			}
		}
		
		seatPlan[count][column1-1].book();
	}
	
	/**
	 * Unbook specific seat in the seating plan of the session
	 * @param row1 is the row number of seat
	 * @param column1 is the column number of seat
	 */
	public void unassign(char row1, int column1) {
		int count = 0;
		for(char alpha = 'J'; alpha >='A'; alpha--) {
			if(row1 == alpha) {
				break;
			}
			else {
				count++;
			}
		}
		
		seatPlan[count][column1].clear();
	}
	
	
}
