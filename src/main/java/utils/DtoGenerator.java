package utils;

import dto.User;

import static utils.PropertiesReader.readProperty;

public class DtoGenerator {

    public static User generateUser() {
        return User.builder()
                .email(readProperty("user.email"))
                .username(readProperty("user.username"))
                .password(readProperty("user.password"))
                .build();
    }
}
