package com.example.auth.infrastructure.user.validation.formats;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = RightNameValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RightName {
  String message() default "Input a valid name.";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
