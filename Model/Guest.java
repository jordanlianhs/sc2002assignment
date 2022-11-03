package Model;

public class Guest {
    private String name;

    private int age;

    private String phone;

    private String email;

    

    public Guest(String name, int age, String phone, String email){
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }
    
    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public String getPhone(){
        return phone;
    }

    public String getEmail(){
        return email;
    }

}
