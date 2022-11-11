package Model;

/**
 * Status of the movie
 */
public enum MovieStatus {
    /**
     * Coming soon (User + Admin)
     */
    COMINGSOON,
    /**
     * Preview (User + Admin)
     */
    PREVIEW,
    /**
     * Now Showing (User + Admin)
     */
    NOWSHOWING,
    /**
     * End of Shower (Admin)
     */
    ENDOFSHOWING
}
