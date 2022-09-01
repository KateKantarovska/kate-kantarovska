package com.epam.spring.exception;

public class EntityNotFoundException extends RuntimeException {
  private static final String MESSAGE = "%s has not been found";

  public EntityNotFoundException(String entityName) {
    super(String.format(MESSAGE, entityName));
  }
}
