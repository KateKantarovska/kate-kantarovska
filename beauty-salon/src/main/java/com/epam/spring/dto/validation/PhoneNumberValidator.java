package com.epam.spring.dto.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {
  @Override
  public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
    return value != null && value.matches("\\+?\\d{10,15}");
  }
}
