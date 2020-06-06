package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "families")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "family_id"))
})
public class Family extends BaseEntity {

  @NotBlank(message = "El nombre de la familia no puede estar en blanco")
  @Column(unique = true, nullable = false)
  private String name;

  @OneToMany(mappedBy = "family")
  private Set<SubFamily> subFamilies = new HashSet<>();

  public Family() {
  }

  public Family(@NotBlank(message = "El nombre de la familia no puede estar en blanco") String name, Set<SubFamily> subFamilies) {
    this.name = name;
    this.subFamilies = subFamilies;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<SubFamily> getSubFamilies() {
    return subFamilies;
  }

  public void setSubFamilies(Set<SubFamily> subFamilies) {
    this.subFamilies = subFamilies;
  }

}
