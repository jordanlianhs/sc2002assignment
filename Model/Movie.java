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





    
    public static void main(String[] args) {
        System.out.println("Hello world");
    }
}
