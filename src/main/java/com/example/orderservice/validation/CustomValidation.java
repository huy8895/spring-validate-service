package com.example.orderservice.validation;

import com.example.orderservice.dto.SaveType;
import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CustomValidationValidator.class)
public @interface CustomValidation {
    String message() default "Invalid value";
    SaveType[] saveType() default {};
    Class<?>[] groups() default {};
    Class<?>[] payload() default {};
}
