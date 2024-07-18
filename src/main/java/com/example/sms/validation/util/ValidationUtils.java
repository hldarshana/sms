package com.example.sms.validation.util;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ValidationUtils {

    private final Pattern phoneNumberPattern = Pattern.compile(
            "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$" +
            "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$" +
            "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$");

    public boolean isValidPhoneNumber(String phoneNumber){
        Matcher matcher = phoneNumberPattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
