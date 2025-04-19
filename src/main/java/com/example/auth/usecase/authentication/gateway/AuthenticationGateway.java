package com.example.auth.usecase.authentication.gateway;

import com.example.auth.entity.user.model.User;

public interface AuthenticationGateway {
    String authenticate(User user);
}
