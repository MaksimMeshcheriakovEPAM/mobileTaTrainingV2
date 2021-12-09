package data;

import static java.lang.System.getProperty;

import entity.User;

public class UserData {

    public static final User testUser = new User()
        .setEmail(getProperty("email"))
        .setName(getProperty("username"))
        .setPassword(getProperty("password"));

}
