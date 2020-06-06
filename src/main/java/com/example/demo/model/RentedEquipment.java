package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "rented_equipments")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "rented_equipment_id"))
})
public class RentedEquipment extends BaseEntity {

  private boolean isReturned;

  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "equipment_id")
  private Equipment equipment;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "rental_id", nullable = false)
  private Rental rental;

  public RentedEquipment() {
  }

  public RentedEquipment(boolean isReturned, Equipment equipment, Rental rental) {
    this.isReturned = isReturned;
    this.equipment = equipment;
    this.rental = rental;
  }

  public boolean isReturned() {
    return isReturned;
  }

  public void setReturned(boolean returned) {
    isReturned = returned;
  }

  public Equipment getEquipment() {
    return equipment;
  }

  public void setEquipment(Equipment equipment) {
    this.equipment = equipment;
  }

  public Rental getRental() {
    return rental;
  }

  public void setRental(Rental rental) {
    this.rental = rental;
  }
}
