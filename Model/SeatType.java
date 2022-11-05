package Model;

public enum SeatType {
    NORMAL("Normal"), COUPLE("Couple"),ELITE("Elite"),ULTIMA("Ultima");
    private final String type;

    private SeatType(String type){
        this.type = type;
    }

    public String getSeatType(){
        return this.type;
    }
}
