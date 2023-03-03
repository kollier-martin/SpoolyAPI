package io.beansprout.spooly.models;

import io.beansprout.spooly.DTOs.ManufacturerDTO;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

@Getter
@Setter
@Entity
@ToString
@RequiredArgsConstructor
public class Manufacturer implements Serializable {
  public Manufacturer(ManufacturerDTO manufacturerDTO) {
    this.id = manufacturerDTO.getId();
    this.name = manufacturerDTO.getName();
    this.link = manufacturerDTO.getLink();
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(unique = true)
  @NotNull
  private String name;

  @Column @NotNull private String link;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Manufacturer that = (Manufacturer) o;
    return id != null && Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
