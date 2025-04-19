package com.example.auth.infrastructure.authentication.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

import com.example.auth.entity.user.model.User;
import com.example.auth.infrastructure.config.security.TokenService;
import com.example.auth.usecase.authentication.gateway.AuthenticationGateway;

@Component
public class AuthenticationServiceGateway implements AuthenticationGateway{

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public String authenticate(User user) {
        var credentials = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
        var auth = this.authenticationManager.authenticate(credentials);
        var token = tokenService.generateToken((User) auth.getPrincipal());
        return token;
    }
    
}
