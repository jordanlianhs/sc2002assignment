package Model;

/**
 * Class containing information about guest
 */
public class Guest extends Person {
    /**
     * Age of guest
     */
    private int age;

    /**
     * Phone number of guest
     */
    private String phone;

    /**
     * Email of guest
     */
    private String email;

    /**
     * Whether guest is user
     */
    private boolean student;

    /**
     * Empty Constructor for Guest class
     */
    public Guest(){};

    /**
     * Constructor for Guest class
     * @param name is the name of guest
     * @param age is the age of guest
     * @param phone is the phone number of guest
     * @param email is the email of the guest
     * @param student is whether guest is student
     */
    public Guest(String name, int age, String phone, String email, boolean student) {
        super.setName(name);
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.student = student;
    }

    /**
     * Getter for age
     * @return age of guest
     */
    public int getAge() {
        return age;
    }

    /**
     * Getter for phone number
     * @return phone number of guest
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Getter for email
     * @return email address of guest
     */
    public String getEmail() {
        return email;
    }

    /**
     * Getter for student
     * @return whether guest is student
     */
    public boolean getStudent() {
        return student;
    }

}
