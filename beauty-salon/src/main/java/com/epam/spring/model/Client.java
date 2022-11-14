package com.epam.spring.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "clients")
@DynamicUpdate
@DynamicInsert
@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Client extends User {
  @ColumnDefault("0")
  private Integer balance;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Client client)) return false;
    if (!super.equals(o)) return false;
    return balance.equals(client.balance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), balance);
  }
}
