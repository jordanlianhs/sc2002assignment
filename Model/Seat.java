package Model;

/**
 * Class of Seats in the cinema
 */
public class Seat {

	/**
	 * row of seat
	 */
	private char row;

	/**
	 * column of seat
	 */
	private int column;
	
	/**
	 * whether seat is taken
	 */
	private boolean taken = false;
	
	public Seat(char row1, int column1) {
		row = row1;
		column = column1;
	}
	
	/**
	 * @return row of seat
	 */
	public char getSeatrow() {
		return row;
	}
	
	/**
	 * @return column of seat
	 */
	public int getSeatColumn() {
		return column;
	}
	/**
	 * @return whether seat is taken
	 */
	public boolean checkTaken() {
		return taken;
	}

	/**
	 * book seat
	 */
	public void book() {
		taken = true;
	}
	
	/**
	 * book unbook seat
	 */
	public void clear() {
		taken = false;
	}
}
