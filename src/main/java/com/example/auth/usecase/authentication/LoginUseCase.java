package com.example.auth.usecase.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.auth.entity.user.exception.UserNotFoundException;
import com.example.auth.entity.user.gateway.UserGateway;
import com.example.auth.entity.user.model.User;
import com.example.auth.usecase.authentication.dto.IAuthenticationData;
import com.example.auth.usecase.authentication.gateway.AuthenticationGateway;

@Service
public class LoginUseCase {

    @Autowired
    private UserGateway userGateway;

    @Autowired
    private AuthenticationGateway authenticationGateway;

    public String execute(IAuthenticationData data) throws UserNotFoundException{

        User user = userGateway.findByUsername(data.username()).orElseThrow(UserNotFoundException::new);

        return this.authenticationGateway.authenticate(user);
    }
}
