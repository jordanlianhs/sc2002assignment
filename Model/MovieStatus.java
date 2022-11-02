package Model;

public enum MovieStatus {
    COMING_SOON("Coming soon"),
    PREVIEW("Preview"),
    NOW_SHOWING("Now showing"),
    END_OF_SHOWING("End of showing");

    private final String status;

    private MovieStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}
