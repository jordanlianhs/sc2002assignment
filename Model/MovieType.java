package Model;

/**
 * Types of movies
 */
public enum MovieType {

    /**
     * 2D movies, 3D Movies, 2D Blockbuster Movies, 3D BlockBuster movies.
     */
    TWO_D("2D"), THREE_D("3D"), TWO_D_BB("2D_BLOCKBUSTER"), THREE_D_BB("3D_BLOCKBUSTER");

    private final String type;

    /**
     * This instance of movietype
     */
    private MovieType(String type) {
        this.type = type;
    }

    /**
     * Returns the type of movie as a String
     * 
     * @return movieType
     */
    public String getType() {
        return this.type;
    }
}
