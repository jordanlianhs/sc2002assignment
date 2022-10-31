package Model;

public class Seat {
	private char row;
	
	private int column;
	
	private boolean taken = false;
	
	public Seat(char row1, int column1) {
		row = row1;
		column = column1;
	}
	
	public char getSeatrow() {
		return row;
	}
	
	public int getSeatColumn() {
		return column;
	}
	public boolean checkTaken() {
		return taken;
	}
	
	public void book() {
		taken = true;
	}
	
	public void clear() {
		taken = false;
	}
}
