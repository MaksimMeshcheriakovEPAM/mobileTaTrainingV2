package com.epam.tc.hw02.support;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private String email;
    private String login;
    private String password;
}
