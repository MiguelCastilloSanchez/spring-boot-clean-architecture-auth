package com.example.auth.infrastructure.admin.dto;

import com.example.auth.infrastructure.user.validation.formats.RightName;
import com.example.auth.infrastructure.user.validation.unique.UniqueEmail;
import com.example.auth.infrastructure.user.validation.unique.UniqueUsername;
import com.example.auth.usecase.admin.dto.IAdminUpdateData;

import jakarta.validation.constraints.Email;

public record AdminUpdateData(
        @UniqueUsername(message = "{Unique.user.username}")
        String username,

        String password,

        @RightName(message = "{Name.user.name}")
        String name,

        @UniqueEmail(message = "{Unique.user.email}")
        @Email
        String email) implements IAdminUpdateData {
}
