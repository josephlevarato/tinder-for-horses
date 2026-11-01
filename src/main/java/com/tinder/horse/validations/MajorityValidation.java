package com.tinder.horse.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MajorityValidation implements ConstraintValidator<IsMajor, Object> {
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        LocalDate threshold = LocalDate.now().minusYears(18);

        if (value instanceof LocalDate) {
            return ((LocalDate) value).isBefore(threshold);
        } else if (value instanceof LocalDateTime) {
            return ((LocalDateTime) value).toLocalDate().isBefore(threshold);
        } else if (value instanceof java.util.Date) {
            LocalDate date = ((java.util.Date) value)
                .toInstant()
                .atZone(java.time.ZoneId.systemDefault())
                .toLocalDate();
            return date.isBefore(threshold);
        }

        return false;
    }
}
