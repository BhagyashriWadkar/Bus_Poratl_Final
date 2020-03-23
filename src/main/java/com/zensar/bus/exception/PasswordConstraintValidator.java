package com.zensar.bus.exception;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.passay.LengthRule;
import org.passay.LowercaseCharacterRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.RuleResult;
import org.passay.SpecialCharacterRule;
import org.passay.UppercaseCharacterRule;
import org.passay.WhitespaceRule;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public void initialize(ValidPassword arg0) {
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        PasswordValidator validator = new PasswordValidator(Arrays.asList(
        		
        		 new LengthRule(8, 30), 
        		// at least one upper-case character
                 new UppercaseCharacterRule(1), 
                 // at least one lower-case character
                 new LowercaseCharacterRule(1),
              // at least one symbol (special character)
                 new SpecialCharacterRule(1),
              // no whitespace
                 new WhitespaceRule()));

        RuleResult result = validator.validate(new PasswordData(password));
        if (result.isValid()) {
            return true;
        }
        final String message = "Invalid password";
        
        context.buildConstraintViolationWithTemplate(message).addConstraintViolation().disableDefaultConstraintViolation();
 
		return false;
    }

	
}