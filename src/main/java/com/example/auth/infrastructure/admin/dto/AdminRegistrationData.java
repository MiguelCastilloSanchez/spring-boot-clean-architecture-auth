package com.example.auth.infrastructure.admin.dto;

import com.example.auth.infrastructure.user.validation.formats.Name;
import com.example.auth.infrastructure.user.validation.unique.UniqueEmail;
import com.example.auth.infrastructure.user.validation.unique.UniqueUsername;
import com.example.auth.usecase.admin.dto.IAdminRegistrationData;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AdminRegistrationData(
        @UniqueUsername(message = "{Unique.user.username}")
        @NotBlank
        String username,

        @NotBlank
        String password,

        @NotBlank
        @Name(message = "{Name.user.name}")
        String name,

        @UniqueEmail(message = "{Unique.user.email}")
        @NotBlank
        @Email
        String email) implements IAdminRegistrationData { }