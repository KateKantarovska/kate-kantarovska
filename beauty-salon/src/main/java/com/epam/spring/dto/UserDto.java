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

  @Email(groups = OnCreate.class)
  protected String email;

  @NotBlank(groups = OnCreate.class)
  protected String password;

  @PhoneNumber(groups = OnCreate.class)
  protected String phoneNumber;

  @NotNull(groups = OnCreate.class)
  @Size(min = 3, max = 30)
  protected String name;

  @NotNull(groups = OnCreate.class)
  @Size(min = 3, max = 30)
  protected String surname;

  protected Boolean active;
}
