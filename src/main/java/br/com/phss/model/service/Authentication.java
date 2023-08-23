package br.com.phss.model.service;

import br.com.phss.model.User;

import java.util.Objects;

public class Authentication {
    public static boolean authetication(User user, String password) {
        return user != null && Objects.equals(password, user.getPassword());
    }
}
