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
	
	//seating plan for session
	private SeatingPlan seatPlan = new SeatingPlan();
	
	//constructor
	public Session(){

	};

	public Session(Movie movie, LocalDateTime seshDateTime) {
		this.movie = movie;
		this.seshDateTime = seshDateTime;
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

	public SeatingPlan getSeatPlan() {
		return seatPlan;
	}

	public void setSeatPlan(SeatingPlan seatPlan) {
		this.seatPlan = seatPlan;
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

	public void writeSession() throws IOException{
        try{
            File file = new File("Database/SessionRecords.txt");
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter br = new BufferedWriter(fr);
            PrintWriter pr = new PrintWriter(br);
			String something = "";
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
			DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); 
            String shit = seshDateTime.format(formatter2) + "," + something ;
            pr.print(shit);
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
		movie.writeMovie();
	}

	public void read(int octo) throws IOException {
		try {
			File file = new File("./Database/SessionRecords.txt");
			Scanner sc = new Scanner(file);

			sc.useDelimiter(",");
			for(int line = 0; line<octo; line++){
				sc.nextLine();
			}

			String bookingtime = sc.next();
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

				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
				LocalDate releaseDateTime = LocalDate.parse(movieReleaseDate, formatter);
				LocalDate endDateTime = LocalDate.parse(movieEndDate, formatter);

				ArrayList<String> cast = new ArrayList<>();
				for(int u=0; u<Integer.valueOf(sizeofCast); u++){
					cast.add(sc.next());
				}
				Movie movieinstance = new Movie(movieName, MovieType.valueOf(movieType), synopsis, ageRating, Float.valueOf(starRating), Double.valueOf(duration), releaseDateTime, endDateTime, director, Integer.valueOf(sales), cast);
				this.movie = movieinstance;

				sc.close();

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
