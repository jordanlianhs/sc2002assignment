package Model;

import java.time.*;
import java.util.*;

import java.io.*;

import java.time.format.DateTimeFormatter;

/**
 * Class for Movies
 */
public class Movie {
        
    /**
     * This movie's title
     */
    private String movieName;

    /**
     * This movie's type
     */
    private MovieType movieType;

    /**
     * This movie's type
     */
    private MovieStatus movieStatus;

    /**
     * This movie's synopsis
     */
    private String synopsis;

    /**
     * This movie's ageRating
     */
    private String ageRating;

    /**
     * This movie's starRating
     */
    private float starRating;

    /**
     * This movie's duration
     */
    private double duration;

    /**
     * This movie's release date
     */
    private LocalDate movieReleaseDate;

    /**
     * This movie's end date
     */
    private LocalDate movieEndDate;

    /**
     * This movie's director
     */
    private String director;

    /** 
     * This movie's list of cast 
     */
    private List<String> cast;

    /**
     * This is the number of tickets sold 
     */
    private int sales;


    /**
     * Constructor for movie class
     * @param movieName is the name of the mvoie
     * @param movieType is the type of the movie
     * @param movieStatus is the status of the movie
     * @param synopsis is the synopsis of the movie
     * @param ageRating is the age rating of the movie
     * @param starRating is the star rating of the movie
     * @param duration is the duration of the movie
     * @param movieReleaseDate is the movie release date of the movie
     * @param movieEndDate is the movie end date of the movie
     * @param director is the director of the movie
     * @param sales is the sales of the movie
     * @param cast is the cast of the movie
     */
    public Movie(String movieName, MovieType movieType, MovieStatus movieStatus, String synopsis, String ageRating, float starRating, double duration, LocalDate movieReleaseDate, LocalDate movieEndDate, String director, int sales, List<String> cast) {
        this.movieName = movieName;
        this.movieType = movieType;
        this.movieStatus = movieStatus;
        this.synopsis = synopsis;
        this.ageRating = ageRating;
        this.starRating = starRating;
        this.duration = duration;
        this.movieReleaseDate = movieReleaseDate;
        this.movieEndDate = movieEndDate;
        this.director = director;
        this.cast = cast;
        this.sales = sales;
    }

    /**
     * constructor of the movie class
     */
    public Movie(){};
    

    /**
     * @return name of movie
     */
    public String getmovieName() {
        return this.movieName;
    }

    /**
     * set name of movie
     * @param movieName is to set the new name of the movie
     */
    public void setmovieName(String movieName) {
        this.movieName = movieName;
    }

    /**
     * @return type of movie
     */
    public MovieType getType() {
        return this.movieType;
    }

    /**
     * set the movie type
     * @param movieType set the type of the movie
     */
    public void setType(MovieType movieType) {
        this.movieType = movieType;
    }

     /**
     * @return status of movie
     */
    public MovieStatus getMovieStatus() {
        return this.movieStatus;
    }

    /**
     * set status of movie
     * @param movieStatus is the new movie status to be set to the movie
     */
    public void setMovieStatus(MovieStatus movieStatus) {
        this.movieStatus = movieStatus;
    }

    /**
     * @return synopsis of movie
     */
    public String getSynopsis() {
        return this.synopsis;
    }

    /**
     * Set the synopsis of the movie
     * @param synopsis is the new synopsis of the movie
     */
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    /**
     * @return agerating of movie
     */
    public String getageRating() {
        return this.ageRating;
    }

    /**
     * Set age rating of the movie
     * @param agerating is the new age rating of movie to be set
     */
    public void setageRating(String ageRating) {
        this.ageRating = ageRating;
    }

    /**
     * @return starRating of the movie
     */
    public float getstarRating() {
        return this.starRating;
    }

     /**
    * set the new star rating of the rating
     * @param starRating is the new star rating of the movie
     */
    public void setstarRating(float starRating) {
        this.starRating = starRating;
    }

    /**
     * @return duration of the movie
     */
    public double getDuration() {
        return this.duration;
    }

    /**
     * Set the new duration of the movie
     * @param duration duration of the movie
     */
    public void setDuration(double duration) {
        this.duration = duration;
    }

    /**
     * @return the release date of the movie
     */
    public LocalDate getMovieReleaseDate() {
        return this.movieReleaseDate;
    }

    /**
     * Set the release date of the movie
     * @param movieReleaseDate is the new release date of the movie
     */
    public void setMovieReleaseDate(LocalDate movieReleaseDate) {
        this.movieReleaseDate = movieReleaseDate;
    }

    /**
     * @return the movie end date
     */
    public LocalDate getMovieEndDate() {
        return this.movieEndDate;
    }

    /**
     * Set the end date of the movie
     * @param movieEndDate is the new end date of the movie
     */
    public void setMovieEndDate(LocalDate movieEndDate) {
        this.movieEndDate = movieEndDate;
    }

    /**
     * @return director of the movie
     */
    public String getDirector() {
        return this.director;
    }

     /**
     * Set the director of the movie
     * @param movieReleaseDate is the new director of the movie
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * @return cast of the movies in an array
     */
    public List<String> getCast() {
        return this.cast;
    }

    /**
     * Set the cast of the movie
     * @param cast is the new cast of the movie
     */
    public void setCast(List<String> cast) {
        this.cast = cast;
    }

    /**
     * @return sales of the movie
     */
    public int getSales() {
        return sales;
    }

    /**
     * Set the sales of the movie
     * @param sales is the sales of the movie
     */
    public void setSales(int sales) {
        this.sales = sales;
    }

    /**
     * Writes movie information into movie database
     */
    public void writeMovie(){
        try{
            File file = new File("Database/MovieCollectionNew.txt");
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter br = new BufferedWriter(fr);
            PrintWriter pr = new PrintWriter(br);
            String castString= String.join(",", this.getCast());

            String shit = movieName + "," + movieType.toString() + "," + movieStatus.toString() + "," + synopsis + "," + ageRating + "," + starRating
            + "," + duration + "," + movieReleaseDate.toString() + "," + movieEndDate.toString() 
            + "," + director + "," + sales + "," + this.getCast().size()  + "," + castString; 
            pr.println(shit);
            pr.close();
            br.close();
            fr.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Reads movie information from movie database
     * @param movieMingZhi Name of the movie to read in
     */
    public void readMovie(String movieMingZhi){
        String text;
        try {
			File file = new File("./Database/MovieCollectionNew.txt");
			Scanner scanfile = new Scanner(file);

			while(scanfile.hasNextLine()){
                text = scanfile.nextLine();
                String[] elements = text.split(",");
                String movieName = elements[0];
                String movieType = elements[1];
                String movieStatus = elements[2];
                String synopsis = elements[3];
                String ageRating = elements[4];
                String starRating = elements[5];
                String duration = elements[6];
                String movieReleaseDate = elements[7];
                String movieEndDate = elements[8];
                String director = elements[9];
                String sales = elements[10];
                String sizeOfCast = elements[11];
                ArrayList<String> cast = new ArrayList<>();
                for(int u=12; u<(Integer.valueOf(sizeOfCast)+12); u++){
                    cast.add(elements[u]);
                }
                if(movieName.equals(movieMingZhi)){
                    this.movieName = movieName;
                    this.movieType = MovieType.valueOf(movieType);
                    this.movieStatus = MovieStatus.valueOf(movieStatus);
                    this.synopsis = synopsis;
                    this.ageRating = ageRating;
                    this.starRating = Float.valueOf(starRating);
                    this.duration = Double.valueOf(duration);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
                    LocalDate releaseDateTime = LocalDate.parse(movieReleaseDate, formatter);
                    LocalDate endDateTime = LocalDate.parse(movieEndDate, formatter);
                    this.movieReleaseDate = releaseDateTime;
                    this.movieEndDate = endDateTime;
                    this.director = director;
                    this.sales = Integer.valueOf(sales);
                    this.cast = cast;
                    break;
                }
            }
			scanfile.close();

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
    
    }
}

