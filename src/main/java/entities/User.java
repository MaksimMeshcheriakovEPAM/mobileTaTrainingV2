package entities;

public class User {

    public static final User TEST_USER =
            new User("test@mail.com", "Evgeniy", "12345678");

    public String email;
    public String username;
    public String password;

    public User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }
}