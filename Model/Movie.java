package Model;

import java.time.*;
import java.util.*;


public class Movie {
    /** This is the movie's unique ID
    */
    private int id;
    
    /**
     * This movie's title
     */
    private String title;

    /**
     * This movie's type
     */
    private MovieType type;

    /**
     * This movie's synopsis
     */
    private String synopsis;

    /**
     * This movie's rating
     */
    private String rating;

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
    private ArrayList<Review> reviews; 


    public Movie(int id, String title, MovieType type, String synopsis, String rating, double duration, LocalDate movieReleaseDate, LocalDate movieEndDate, String director, ArrayList<String> cast, ArrayList<Review> reviews) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.synopsis = synopsis;
        this.rating = rating;
        this.duration = duration;
        this.movieReleaseDate = movieReleaseDate;
        this.movieEndDate = movieEndDate;
        this.director = director;
        this.cast = cast;
        this.reviews = reviews;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MovieType getType() {
        return this.type;
    }

    public void setType(MovieType type) {
        this.type = type;
    }

    public String getSynopsis() {
        return this.synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getRating() {
        return this.rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
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

    public ArrayList<Review> getReviews() {
        return this.reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    
    
    public static void main(String[] args) {
        System.out.println("Hello world");
    }
}

