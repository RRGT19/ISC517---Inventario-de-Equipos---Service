package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "subfamilies")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "subfamily_id"))
})
public class SubFamily extends BaseEntity {

  @NotBlank(message = "El nombre de la subfamilia no puede estar en blanco")
  @Column(nullable = false)
  private String name;

  @JsonIgnoreProperties("subFamilies")
  @ManyToOne(optional = false)
  @JoinColumn(name = "family_id", nullable = false)
  private Family family;

  public SubFamily() {
  }

  public SubFamily(@NotBlank(message = "El nombre de la subfamilia no puede estar en blanco") String name, Family family) {
    this.name = name;
    this.family = family;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Family getFamily() {
    return family;
  }

  public void setFamily(Family family) {
    this.family = family;
  }
}
