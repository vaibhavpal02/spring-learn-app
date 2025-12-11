package com.vaibhavpal.springlearnapp.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;
@Documented
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmployeeRoleValidator.class)  // validator class
public @interface EmployeeRoleValidation {

    String message() default "Role of employee must be ADMIN or USER";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
