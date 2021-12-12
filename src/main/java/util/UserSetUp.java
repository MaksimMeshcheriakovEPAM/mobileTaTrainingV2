package util;

import entity.User;

public class UserSetUp {
    private static String username;
    private static String email;
    private static String password;

    public UserSetUp() {
        username = ConfProperty.getProperty("login");
        password = ConfProperty.getProperty("password");
        email = ConfProperty.getProperty("email");
    }

    public User getUser () {
        return new User(email, username, password);
    }
}
