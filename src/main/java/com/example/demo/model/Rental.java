package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "rentals")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "rental_id"))
})
public class Rental extends BaseEntity {

  public enum Status {
    PENDING,
    PAID,
  }

  @Enumerated(EnumType.STRING)
  private Status status;

  private double cost;

  @ManyToOne
  @JoinColumn(name = "client_id")
  private Client client;

  @Temporal(TemporalType.DATE)
  @Column(nullable = false)
  @NotNull
  private Date dateOfReturn = new Date();

  @OneToMany(mappedBy = "rental", cascade = CascadeType.REMOVE, orphanRemoval = true)
  private List<RentedEquipment> rentedEquipments = new ArrayList<>();

  public Rental() {
  }

  public Rental(Status status, double cost, Client client, @NotNull Date dateOfReturn, List<RentedEquipment> rentedEquipments) {
    this.status = status;
    this.cost = cost;
    this.client = client;
    this.dateOfReturn = dateOfReturn;
    this.rentedEquipments = rentedEquipments;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public double getCost() {
    return cost;
  }

  public void setCost(double cost) {
    this.cost = cost;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public Date getDateOfReturn() {
    return dateOfReturn;
  }

  public void setDateOfReturn(Date dateOfReturn) {
    this.dateOfReturn = dateOfReturn;
  }

  public List<RentedEquipment> getRentedEquipments() {
    return rentedEquipments;
  }

  public void setRentedEquipments(List<RentedEquipment> rentedEquipments) {
    this.rentedEquipments = rentedEquipments;
  }
}
