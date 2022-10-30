
public class SeatingPlan {
	private Seat[][] seatPlan; 
	
	public SeatingPlan() {
		seatPlan = new Seat[10][16];
		int count = 0;
		for(char alpha = 'J'; alpha >='A'; alpha--) {
			for(int i = 0; i<16; i++) {
				//String temp = Character.toString(alpha)+Integer.toString(i);
				seatPlan[count][i] = new Seat(alpha, i);
				
			}
			count++;
		}
		
	}
	
	public void printLayout() {
		int count = 0;
		for(char alpha = 'K'; alpha >='A'; alpha--) {	
			if(alpha=='K') {
				System.out.print(" ");
			}
			
			else {
				System.out.print(alpha);
			}
			for(int i = 0; i<16; i++) {
				if(alpha=='K') {
					if(i>9) {
						System.out.print(" "+ i);
					}
					else {
						System.out.print(" "+ i + " ");
					}

				}
				else if(i<=1 && alpha>='F' && alpha<'K') {
					System.out.print("   ");
				}
				
				else if(i>=8 && i<=9 && alpha=='A') {
					System.out.print("   ");
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
		}
		count++;
	}
	
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
		
		seatPlan[count][column1].book();
	}
	
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
