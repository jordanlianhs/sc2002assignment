package Model;

import java.time.*;
import java.util.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;

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
    private ArrayList<String> cast;

    /**
     * This movie's list of reviews
     */
    //private ArrayList<Review> reviews; 

    private int sales;


    
    /*

    public Movie(String movieName, MovieType movieType, String synopsis, String ageRating, double duration, LocalDate movieReleaseDate, LocalDate movieEndDate, String director, ArrayList<String> cast, ArrayList<Review> reviews, int sales) {
        this.movieName = movieName;
        this.movieType = movieType;
        this.synopsis = synopsis;
        this.ageRating = ageRating;
        this.duration = duration;
        this.movieReleaseDate = movieReleaseDate;
        this.movieEndDate = movieEndDate;
        this.director = director;
        this.cast = cast;
        this.reviews = reviews;
        this.sales = sales;
    }
    */
    public Movie(String movieName, MovieType movieType, String synopsis, String ageRating, float starRating, double duration, LocalDate movieReleaseDate, LocalDate movieEndDate, String director, int sales, ArrayList<String> cast) {
        this.movieName = movieName;
        this.movieType = movieType;
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
    


    public String getmovieName() {
        return this.movieName;
    }

    public void setmoveiName(String movieName) {
        this.movieName = movieName;
    }

    public MovieType getType() {
        return this.movieType;
    }

    public void setType(MovieType movieType) {
        this.movieType = movieType;
    }

    public String getSynopsis() {
        return this.synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getageRating() {
        return this.ageRating;
    }

    public void setageRating(String ageRating) {
        this.ageRating = ageRating;
    }

    public float getstarRating() {
        return this.starRating;
    }

    public void setstarRating(float starRating) {
        this.starRating = starRating;
    }
    public double getDuration() {
        return this.duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public LocalDate getMovieReleaseDate() {
        return this.movieReleaseDate;
    }

    public void setMovieReleaseDate(LocalDate movieReleaseDate) {
        this.movieReleaseDate = movieReleaseDate;
    }

    public LocalDate getMovieEndDate() {
        return this.movieEndDate;
    }

    public void setMovieEndDate(LocalDate movieEndDate) {
        this.movieEndDate = movieEndDate;
    }

    public String getDirector() {
        return this.director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public ArrayList<String> getCast() {
        return this.cast;
    }

    public void setCast(ArrayList<String> cast) {
        this.cast = cast;
    }
    /* 
    public ArrayList<Review> getReviews() {
        return this.reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }
    */
    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public void writeMovie(){
        try{
            File file = new File("Database/SessionRecords.txt");
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter br = new BufferedWriter(fr);
            PrintWriter pr = new PrintWriter(br);
            String cast= String.join(",", this.getCast());
            //String review= String.join(",", this.getReviews());
            String shit = movieName + "," + movieType.toString() + "," + synopsis + "," + ageRating + "," + String.valueOf(starRating)
            + "," + String.valueOf(duration) + "," + movieReleaseDate.toString() + "," + movieEndDate.toString() 
            + "," + director + "," + this.getCast().size() + "," + String.valueOf(sales) + "," + cast; 
            pr.println(shit+",");
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
    }
    
    public static void main(String[] args) {
        System.out.println("Hello world");
    }
}

