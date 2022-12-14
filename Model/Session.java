package Model;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import java.util.Scanner;

/**
 * Class about a session of a cinema
 */
public class Session {
	
	/**
	 * date and time of session
	 */
	private LocalDateTime seshDateTime;
	
	/**
	 * movie of the session
	 */
	private Movie movie;
	
	/**
	 * cinema of the session
	 */
	private String cinemaCode;
	
	/**
	 * seating plan of the session
	 */
	private SeatingPlan seatPlan = new SeatingPlan();
	
	/**
	 * Empty Constructor of session class
	 */
	public Session(){};

	/**
	 * Constructor of session class
	 */
	public Session(Movie movie, LocalDateTime seshDateTime, String cinemaCode) {
		this.movie = movie;
		this.seshDateTime = seshDateTime;
		this.cinemaCode = cinemaCode;
	}

	/**
	 * get date and time of session
	 * @return timing of session
	 */
	public LocalDateTime getSeshDateTime() {
		return seshDateTime;
	}

	/**
	 * set timing of session
	 */
	public void setSeshDateTime(LocalDateTime seshDateTime) {
		this.seshDateTime = seshDateTime;
	}

	/**
	 * get movie of session
	 * @return movie of session
	 */
	public Movie getMovie() {
		return movie;
	}

	/**
	 * set movie of session
	 * @param movie is the movie that is going to be set for the session
	 */
	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	/**
	 * get seating plan of session
	 * @return seating plan of session
	 */
	public SeatingPlan getSeatPlan(){
		return seatPlan;
	}

	/**
	 * set seating plan of session
	 * @param seatPlan is the seat plan that is going to be set for the session
	 */
	public void setSeatPlan(SeatingPlan seatPlan){
		this.seatPlan = seatPlan;
	}

	/**
	 * 
	 * @return cinema of the session
	 */
	public String getCinemaCode(){
		return cinemaCode;
	}

	/**
	 * set cinema of session
	 * @param cinemaCode is the cinema of the session
	 */
	public void setCinemaCode(String cinemaCode){
		this.cinemaCode = cinemaCode;
	}
	
	/**
	 * get start time of session
	 * @return start time of the session
	 */
	public LocalTime getStartTime() {
        return getSeshDateTime().toLocalTime();
    }
	
	/**
	 * check if session is on weekend
	 * @return whether session occurs during a weekend
	 */
	public boolean isWeekend(){
        if(seshDateTime.getDayOfWeek() == DayOfWeek.SUNDAY || seshDateTime.getDayOfWeek() == DayOfWeek.SATURDAY){
            return true;
        }        
        else{
            return false;
        }
    }

	/**
	 * print session of the movie
	 */
	public void printSession(){
		String cinemaType = " ";
		if(cinemaCode.equals("ONE")){
			cinemaType = "Normal";
		}

		else if(cinemaCode.equals("TWO")){
			cinemaType = "Gold";
		}

		else{
			cinemaType = "Platinum";
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		System.out.println("Timing: " + seshDateTime.format(formatter) + " Movie Name: " + movie.getmovieName() + " CinemaType: " + cinemaType);
	}

	/**
	 * write session into database
	 * @param cineplexNumber is the cineplex the session is in
	 */
	public void writeSession(String cineplexNumber){
        try{
			//String fileName= "Database/SessionRecord" + CineplexNumber +".txt";
            //File file = new File(fileName);
			File file;
			if(cineplexNumber.equals("AMK")){
				file = new File("Database/SessionRecordAMK.txt");
			}
			else if(cineplexNumber.equals("BBK")){
				file = new File("Database/SessionRecordBBK.txt");
			}
			else{
				file = new File("Database/SessionRecordCCK.txt");
			}
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter br = new BufferedWriter(fr);
            PrintWriter pr = new PrintWriter(br);
			String something = "";
			something+= movie.getmovieName() + ",";
			DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			something += seshDateTime.format(formatter2) + ",";
			something += cinemaCode + ",";
			for(int i=0; i<10; i++){
				for(int j=0; j<16; j++){
					if(seatPlan.getSeat(i,j).checkTaken()==false){
						something+="o";
					}
					else{
						something+="x";
					}
					something+=",";
				}
			}
            pr.println(something);
            pr.close();
            br.close();
            fr.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }

        catch(IOException e){
            e.printStackTrace();
        }
		//movie.writeMovie();
	}
	
	/**
	 * Read session from the database
	 * @param cineplexNumber is the cineplex where the session is in
	 * @param octo is the line number of the file for the session to be read
	 * @throws IOException if file is not found
	 */
	public void read(String cineplexNumber, int octo) throws IOException {

		try {
			String text;
			String fileName= "Database/SessionRecord" + cineplexNumber +".txt";
			File file = new File(fileName);
			Scanner scanfile = new Scanner(file);
			for(int i=0; i<octo; i++){
				scanfile.nextLine();
			}
            text = scanfile.nextLine();
            String[] elements = text.split(",");
            String  movieName = elements[0];
            String seshDateTime = elements[1];
            String cinemaCode = elements[2];
			String ss;
			for(int i=0; i<10; i++){
				for(int j =0; j<16; j++){
					ss = elements[3+i*16+j];
					if(ss.equals("o")){
						seatPlan.getSeat(i,j).clear();
					} 
					else{
						seatPlan.getSeat(i,j).book();
					}
				}
			}
            Movie m = new Movie();
			m.readMovie(movieName); 
            this.movie = m;
            
			DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); 
			LocalDateTime bookingtiming = LocalDateTime.parse(seshDateTime,formatter2);
			this.seshDateTime = bookingtiming;

			this.cinemaCode = cinemaCode;
			scanfile.close();

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
