package com.example.auth.infrastructure.authentication.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

import com.example.auth.entity.user.model.User;
import com.example.auth.infrastructure.config.db.schema.UserSchema;
import com.example.auth.infrastructure.config.security.TokenService;
import com.example.auth.usecase.authentication.gateway.AuthenticationGateway;

@Component
public class AuthenticationServiceGateway implements AuthenticationGateway{

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public String authenticate(User user, String password) {
        UserSchema userSchema = new UserSchema(
            user.getUsername(), 
            user.getPassword(), 
            user.getName(), 
            user.getEmail(), 
            user.getRole()
        );
        var credentials = new UsernamePasswordAuthenticationToken(userSchema.getUsername(), password);
        var auth = this.authenticationManager.authenticate(credentials);
        var token = tokenService.generateToken((UserSchema) auth.getPrincipal());
        return token;
    }
    
}
