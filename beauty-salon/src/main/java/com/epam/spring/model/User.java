package com.epam.spring.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@NoArgsConstructor
@SuperBuilder
public abstract class User implements Serializable {
  protected Integer id;
  protected String email;
  protected String password;
  protected String phoneNumber;
  protected String name;
  protected String surname;
  protected Boolean active;
}
