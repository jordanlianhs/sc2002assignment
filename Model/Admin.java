package Model;

/**
 * Class containing information about admin
 */
public class Admin extends Person{
    /**
     * Password of admin
     */
    private String password;

    /**
     * Empty Constructor for Admin class
     */
    public Admin(){};

    /**
     * Constructor for Admin class
     * @param name is the name of admin
     */
    public Admin(String name, String password) {
        super.setName(name);
        this.password = password;
    }

    /**
     * Getter for password
     * @return password of admin
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter for password
     * @param password
     */
    public void setPassword(String password){
        this.password = password;
    }

}
