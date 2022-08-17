package com.epam.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class UserDto implements Serializable {
  protected Integer id;
  protected String email;
  protected String password;
  protected String phoneNumber;
  protected String name;
  protected String surname;
  protected Boolean active;
}
