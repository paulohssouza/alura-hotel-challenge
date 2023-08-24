package br.com.phss.model.service;

import br.com.phss.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticationTest {

    private final User user = new User("teste", "teste");
    @Test
    void autheticationSuccess() {
        assertTrue(Authentication.authetication(user, "teste"));
    }

    @Test
    void authenticationFailureUserNull() {
        assertFalse(Authentication.authetication(null, "teste"));
    }

    @Test
    void authenticationFailurePasswordIncorrect() {
        assertFalse(Authentication.authetication(user, "password"));
    }
}