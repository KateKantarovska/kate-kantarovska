package com.epam.spring.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "services")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Service {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category;

  private String name;
  private Integer price;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Service service)) return false;
    return Objects.equals(id, service.id) && Objects.equals(category, service.category) && Objects.equals(name, service.name) && Objects.equals(price, service.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, category, name, price);
  }
}
