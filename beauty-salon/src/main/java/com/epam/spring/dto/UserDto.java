package com.epam.spring.dto;

import com.epam.spring.dto.group.OnCreate;
import com.epam.spring.dto.group.OnUpdate;
import com.epam.spring.dto.validation.PhoneNumber;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class UserDto implements Serializable {
  @Null(groups = OnCreate.class)
  @NotNull(groups = OnUpdate.class)
  protected Integer id;
  @Email
  protected String email;
  @NotBlank
  protected String password;
  @PhoneNumber
  protected String phoneNumber;
  @NotNull
  @Size(min = 3, max = 30)
  protected String name;
  @NotNull
  @Size(min = 3, max = 30)
  protected String surname;
  protected Boolean active;
}
