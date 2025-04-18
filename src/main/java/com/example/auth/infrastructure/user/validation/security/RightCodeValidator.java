package com.example.auth.infrastructure.user.validation.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class RightCodeValidator implements ConstraintValidator<RightCode, String>{

    @Value("${security.admins.code}")
    private String expectedCode;

    @Override
    public boolean isValid(String code, ConstraintValidatorContext context) {

        if(code.equals(expectedCode)){
            return true;
        }
        
        return false;
    }
}
