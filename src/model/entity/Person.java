package model.entity;

public class Person {

    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Person(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Person(String email, String username, String password) {
        Email = email;
        this.username = username;
        this.password = password;

    }

    public Person(long id) {
        this.id = id;
    }

    public Person(long id, String username, String password, String email) {
        this.id = id;

        this.username = username;

        this.password = password;
        Email = email;
    }

    private String username;
    private String password;
    private String Email;
}
