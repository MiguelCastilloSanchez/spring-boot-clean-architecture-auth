package com.example.auth.entity.user.exception;

public class UserNotFoundException extends Exception {

    public UserNotFoundException() {
        super("O usuário não foi encontrado!");
    }
}
