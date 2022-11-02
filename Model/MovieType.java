package Model;

public enum MovieType {
    TWO_D("2D"), THREE_D("3D"), FOUR_D("4D"), BLOCKBUSTER("Blockbuster");
    private final String type;

    private MovieType(String type){
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}
