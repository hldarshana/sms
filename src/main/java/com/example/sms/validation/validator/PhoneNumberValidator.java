package com.example.sms.validation.validator;

import com.example.sms.validation.annotation.PhoneNumber;
import com.example.sms.validation.util.ValidationUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {

    private final ValidationUtils validationUtils;

    @Autowired
    PhoneNumberValidator(ValidationUtils validationUtils){
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            if (value != null) {
                if(!validationUtils.isValidPhoneNumber(value)){
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}