package UI;
import java.util.*;
public class HolidayUI {
	
	GregorianCalendar [] hols = new GregorianCalendar[11];
	
	public HolidayUI() {
		//Initialise all holidays
		//Year Month Day
		hols[0] =  new GregorianCalendar(2022, 0,1); //New Year
		hols[1] =  new GregorianCalendar(2022, 1,1); //CNY
		hols[2] =  new GregorianCalendar(2022, 1,2); //CNY
		hols[3] =  new GregorianCalendar(2022, 3,15); //Good Friday
		hols[4] =  new GregorianCalendar(2022, 4, 1); //Labour Day
		hols[5] =  new GregorianCalendar(2022, 4, 3); //Hari Raya Puasa
		hols[6] =  new GregorianCalendar(2022, 4,15); //Vesak Day
		hols[7] =  new GregorianCalendar(2022, 6,10); //Hari Raya Haji
		hols[8] =  new GregorianCalendar(2022, 7,9); //National Day
		hols[9] =  new GregorianCalendar(2022, 9,24); //Deepavali
		hols[10] =  new GregorianCalendar(2022, 11,25); //Christmas
	}
	
	public GregorianCalendar getHols(int i) {
		return hols[i];
	}
	
	public int getLength() {
		return hols.length;
	}
}
	