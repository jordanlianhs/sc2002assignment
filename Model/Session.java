package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalTime;
import java.time.DayOfWeek;

public class Session {
	
	//date and time of session
	private LocalDateTime seshDateTime;
	
	//movie of the session
	private Movie movie;
	
	//seating plan for session
	private SeatingPlan seatPlan;
	
	//constructor
	public Session(Movie movie, LocalDateTime seshDateTime, SeatingPlan seatPlan) {
		this.movie = movie;
		this.seshDateTime = seshDateTime;
		this.seatPlan = seatPlan;
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
	
}
