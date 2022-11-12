package UI;

public class MovieDetails {

    /**
     * New displayMovie object
     */
    private DisplayMovie displayMovie = new DisplayMovie();

    /**
     * UserView is true for use in UserUI and 
     * false for use in AdminUI
     */
    private boolean userView;

    /**
     * Constructor for MovieDetails
     * @param userView
     */
    public MovieDetails(boolean userView){}
    
    /**
     * MovieDetails asks for user input to find a movie and 
     * returns the details of said movie
     * 
     * @param args null
     * @throws Exception
     */
    public void main(){
        this.displayMovie.displayMovie(userView);
    }

    /**
     * @return true for user, and false for admin
     */
    public boolean getUserView(){
        return userView;
    }

    /**
     * Set the userView to true for user, false for admin
     * @param userView
     */
    public void setUserView(boolean userView){
        this.userView = userView;
    }

}
