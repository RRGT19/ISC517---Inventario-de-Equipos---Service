package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "equipments")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "equipment_id"))
})
public class Equipment extends BaseEntity {

  @NotBlank(message = "El nombre del equipo no puede estar en blanco")
  @Column(nullable = false)
  private String name;

  @PositiveOrZero
  @Column(nullable = false)
  private int stock;

  @NotNull
  @Column(nullable = false)
  private double priceByDay;

  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "subfamily_id")
  private SubFamily subFamily;

  @Lob // Specifies that the database should store the property as Large Object.
  @Column(columnDefinition = "BLOB") // Defines the column type for the property.
  private byte[] photo;

  public Equipment() {
  }

  public Equipment(@NotBlank(message = "El nombre del equipo no puede estar en blanco") String name, @PositiveOrZero int stock, @NotNull double priceByDay, SubFamily subFamily, byte[] photo) {
    this.name = name;
    this.stock = stock;
    this.priceByDay = priceByDay;
    this.subFamily = subFamily;
    this.photo = photo;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  public double getPriceByDay() {
    return priceByDay;
  }

  public void setPriceByDay(double priceByDay) {
    this.priceByDay = priceByDay;
  }

  public SubFamily getSubFamily() {
    return subFamily;
  }

  public void setSubFamily(SubFamily subFamily) {
    this.subFamily = subFamily;
  }

  public byte[] getPhoto() {
    return photo;
  }

  public void setPhoto(byte[] photo) {
    this.photo = photo;
  }
}
