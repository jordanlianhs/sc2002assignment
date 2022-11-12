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
	
	/**
	 * Constructor of seat class
	 * @param row1 is the row of seat
	 * @param column1 is the column of seay
	 */
	public Seat(char row1, int column1) {
		row = row1;
		column = column1;
	}
	
	/**
	 * get row of seat
	 * @return row of seat
	 */
	public char getSeatrow() {
		return row;
	}
	
	/**
	 * get column of seat
	 * @return column of seat
	 */
	public int getSeatColumn() {
		return column;
	}
	/**
	 * check whether seat is taken
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
