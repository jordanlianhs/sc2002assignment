package UI;

public class MovieDetailsUser extends MovieDetails{
    
    private DisplayMovie displayMovie = new DisplayMovie();

    public MovieDetailsUser(){
        super(true);
    }
    /**
     * MovieDetailsUser lists all movies (except those ENDOFSHOWING),
     * and asks for user input to find a movie and returns the details of
     * said movie
     * 
     * @param args null
     * @throws Exception
     */
    public void main(){
        this.displayMovie.displayMovie(true);
    }
}
