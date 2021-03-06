package entity;

/**
 * Юзер
 */
public class User {
    private int id;
    private String email;
    private String lastName;
    private String firstName;
    private String password;

    public User(int id, String email, String lastName, String firstName, String password){
        this.id = id;
        this.email = email;
        this.lastName = lastName;
        this.firstName = firstName;
        this.password = password;
    }

    public User(String email, String firstName, String lastName, String password){
        this.email = email;
        this.lastName = lastName;
        this.firstName = firstName;
        this.password = password;
    }

    @Override
    public String toString(){
        String me = this.firstName + " " +  this.lastName + " " + this.email + " " + this.password;
        return me;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() { return firstName;   }
    public String getLastName() { return lastName;   }
    public String getFullName() {return firstName + " " + lastName; }



    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }
    public void setLastName(String name) { this.lastName = name;   }



    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
