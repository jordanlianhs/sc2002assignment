package Model;

/**
 * Class containing information about person
 */
public class Person {
    /**
     * Name of person
     */
    private String name;

    /**
     * Empty Constructor for Person class
     */
    public Person(){};

    /**
     * Constructor for Person class
     * @param name is the name of person
     */
    public Person(String name) {
        this.name = name;
    }

    /**
     * Getter for name
     * @return name of person
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name
     * @param name
     */
    public void setName(String name){
        this.name = name;
    }

}

