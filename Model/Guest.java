package Model;

public class Guest {
    private String name;

    private int age;

    private String phone;

    private String email;

    private boolean student;

    public Guest(){};

    public Guest(String name, int age, String phone, String email, boolean student) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.student = student;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public boolean getStudent() {
        return student;
    }

}
