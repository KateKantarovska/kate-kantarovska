package com.epam.spring.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "masters")
@DynamicUpdate
@DynamicInsert
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Master extends User {
  @ColumnDefault("0.0")
  private Float rating;

  @ToString.Exclude
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
          name = "masters_services",
          joinColumns = { @JoinColumn(name = "master_id") },
          inverseJoinColumns = { @JoinColumn(name = "service_category_id") }
  )
  private List<Category> categories;

  @ToString.Exclude
  @OneToMany(mappedBy = "master", fetch = FetchType.LAZY)
  private List<Review> reviews;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Master master)) return false;
    if (!super.equals(o)) return false;
    return Objects.equals(rating, master.rating) && Objects.equals(categories, master.categories);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), rating, categories);
  }
}
