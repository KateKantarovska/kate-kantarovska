package com.epam.spring.model;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "reviews")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Review {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "client_id")
  private Client client;

  @ManyToOne
  @JoinColumn(name = "master_id")
  private Master master;

  private String text;

  private Integer rating;

  @ColumnDefault("true")
  private Boolean visible;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Review review)) return false;
    return Objects.equals(id, review.id) && Objects.equals(client, review.client) && Objects.equals(master, review.master) && Objects.equals(text, review.text) && Objects.equals(rating, review.rating) && Objects.equals(visible, review.visible);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, client, master, text, rating, visible);
  }
}
