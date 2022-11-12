package UI;

/**
 * MovieDetailsUser lists all movies (except those ENDOFSHOWING),
 * and asks for user input to find a movie and 
 * returns the details of said movie
 */
public class MovieDetailsUser extends MovieDetails{

    public MovieDetailsUser(){
        super.setUserView(true);
    }

}
