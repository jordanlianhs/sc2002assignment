package Model;

import java.time.*;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.io.*;

public class Session {
	
	//date and time of session
	private LocalDateTime seshDateTime;
	
	//movie of the session
	private Movie movie;
	
	private String cinemaCode;
	//seating plan for session
	private SeatingPlan seatPlan = new SeatingPlan();
	
	//constructor
	public Session(){

	};

	public Session(Movie movie, LocalDateTime seshDateTime, String cinemaCode) {
		this.movie = movie;
		this.seshDateTime = seshDateTime;
		this.cinemaCode = cinemaCode;
		//this.seatPlan = seatPlan;
	}

	public LocalDateTime getSeshDateTime() {
		return seshDateTime;
	}

	public void setSeshDateTime(LocalDateTime seshDateTime) {
		this.seshDateTime = seshDateTime;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public SeatingPlan getSeatPlan(){
		return seatPlan;
	}

	public void setSeatPlan(SeatingPlan seatPlan){
		this.seatPlan = seatPlan;
	}

	public String getCinemaCode(){
		return cinemaCode;
	}

	public void setCinemaCode(String cinemaCode){
		this.cinemaCode = cinemaCode;
	}
	
	//get start time of movie sesh
	public LocalTime getStartTime() {
        return getSeshDateTime().toLocalTime();
    }
	
	public boolean isWeekend(){
        if(seshDateTime.getDayOfWeek() == DayOfWeek.SUNDAY || seshDateTime.getDayOfWeek() == DayOfWeek.SATURDAY){
            return true;
        }        
        else{
            return false;
        }
    }

	public void printSession(){
		System.out.println("Timing: " + seshDateTime + " Movie Name: " + movie.getmovieName() + " CinemaCode: " + cinemaCode);
	}

	public void writeSession(String cineplexNumber) throws IOException{
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

	public void writeSession2(String cineplexNumber) throws IOException{
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
            FileWriter fr = new FileWriter(file, false);
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
	public void read(String CineplexNumber, int octo) throws IOException {

		try {
			String text;
			String fileName= "Database/SessionRecord" + CineplexNumber +".txt";
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

			/*
			sc.useDelimiter(",");
			
			String bookingtime = sc.next();
			String movieName = sc.next();
			
			DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); 
			LocalDateTime bookingtiming = LocalDateTime.parse(bookingtime,formatter2);
			this.seshDateTime = bookingtiming;

			String ss;
			for(int i=0; i<10; i++){
				for(int j =0; j<16; j++){
					ss = sc.next();
					if(ss.equals("o")){
						seatPlan.getSeat(i,j).clear();
					} 
					else{
						seatPlan.getSeat(i,j).book();
					}
				}
			}
			
				String movieName = sc.next();
				String movieType = sc.next();
				String synopsis = sc.next();
				String ageRating = sc.next();
				String starRating = sc.next();
				String duration = sc.next();
				String movieReleaseDate = sc.next();
				String movieEndDate = sc.next();
				String director = sc.next();
				String sizeofCast = sc.next();
				String sales = sc.next();
			*/
				
				//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
				//LocalDate releaseDateTime = LocalDate.parse(movieReleaseDate, formatter);
				//LocalDate endDateTime = LocalDate.parse(movieEndDate, formatter);

				//ArrayList<String> cast = new ArrayList<>();
				//for(int u=0; u<Integer.valueOf(sizeofCast); u++){
				//	cast.add(sc.next());
				//}
				//read from movie.txt
				//Movie movieinstance = new Movie(movieName, MovieType.valueOf(movieType), synopsis, ageRating, Float.valueOf(starRating), Double.valueOf(duration), releaseDateTime, endDateTime, director, Integer.valueOf(sales), cast);

				//this.movie = movieinstance;

				scanfile.close();

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
