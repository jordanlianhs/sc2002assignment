package Model;

public enum MovieType {
    TWO_D("2D"), THREE_D("3D"), TWO_D_BB("2D_BLOCKBUSTER"), THREE_D_BB("3D_BLOCKBUSTER");
    private final String type;

    private MovieType(String type){
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}
