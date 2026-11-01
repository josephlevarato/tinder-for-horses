package com.tinder.horse.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MajorityValidation.class)
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface IsMajor {
    String message() default "Date must be at least 18 years in the past";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
