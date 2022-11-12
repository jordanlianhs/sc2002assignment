package UI;

public class MovieDetails {
    private DisplayMovie displayMovie = new DisplayMovie();

    private boolean userView;

    public MovieDetails(boolean userView){}
    
    /**
     * MovieDetails asks for user input to find a movie and returns the details of
     * said movie
     * 
     * @param args null
     * @throws Exception
     */
    public void main(){
        this.displayMovie.displayMovie(userView);
    }

    public boolean getUserView(){
        return userView;
    }

    public void setUserView(boolean userView){
        this.userView = userView;
    }

}
