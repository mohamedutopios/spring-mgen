package org.example.apirestvalidation.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ContactIdValidator implements ConstraintValidator<ValidContactId, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s == null || s.isEmpty()){
            return false;
        }
        return s.matches("C-\\d{3}");
    }
}
