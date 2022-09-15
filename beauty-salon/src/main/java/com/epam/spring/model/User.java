package com.epam.spring.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@MappedSuperclass
@DynamicUpdate
@DynamicInsert
@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class User implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Integer id;
  @Column(unique = true)
  protected String email;

  @ToString.Exclude
  protected String password;
  protected String phoneNumber;
  protected String name;
  protected String surname;

  @Column(columnDefinition = "boolean default true")
  protected Boolean active;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof User user)) return false;
    return Objects.equals(id, user.id) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(phoneNumber, user.phoneNumber) && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(active, user.active);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, email, password, phoneNumber, name, surname, active);
  }
}
