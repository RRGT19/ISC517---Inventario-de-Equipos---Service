package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Equipment;
import com.example.demo.model.Rental;
import com.example.demo.model.RentedEquipment;
import com.example.demo.repository.EquipmentRepository;
import com.example.demo.repository.RentalRepository;
import com.example.demo.repository.RentedEquipmentRepository;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentalServiceImpl implements IRentalService {

  // Required dependencies
  private final RentalRepository repository;
  private final RentedEquipmentRepository rentedEquipmentRepository;
  private final EquipmentRepository equipmentRepository;

  // Constructor-based dependency injection
  @Autowired
  public RentalServiceImpl(
          RentalRepository repository,
          RentedEquipmentRepository rentedEquipmentRepository,
          EquipmentRepository equipmentRepository
  ) {
    this.repository = repository;
    this.rentedEquipmentRepository = rentedEquipmentRepository;
    this.equipmentRepository = equipmentRepository;
  }

  @Override
  public List<Rental> findAll() {
    return repository.findAll();
  }

  @Override
  public List<Rental> findRentalsByStatusOrderByCreatedAt(Rental.Status status) {
    return repository.findRentalsByStatusOrderByCreatedAt(status);
  }

  @Override
  public void create(Rental rental) {
    // 1. Create rental
    rental.setStatus(Rental.Status.PENDING);
    rental.setCost(0);
    repository.save(rental);

    // 2. Set rental to the equipments
    for (RentedEquipment rentedEquipment : rental.getRentedEquipments()) {
      rentedEquipment.setReturned(false);
      rentedEquipment.setRental(rental);
      // Update stock
      Optional<Equipment> equipment = equipmentRepository.findById(rentedEquipment.getEquipment().getId());
      if (equipment.isPresent()) {
        if (equipment.get().getStock() > 0) {
          equipment.get().setStock(equipment.get().getStock() - 1);
          equipmentRepository.save(equipment.get());
        }
      }
    }

    // 3. Save
    rentedEquipmentRepository.saveAll(rental.getRentedEquipments());
  }

  @Override
  public Rental findById(Long id) {
    Rental rental = repository.findById(id).orElse(null);

    if (rental == null)
      throw new ResourceNotFoundException();

    return rental;
  }

  @Override
  public void delete(Long id) {
    Rental rental = repository.findById(id).orElse(null);

    if (rental == null)
      throw new ResourceNotFoundException();

    repository.deleteById(id);
  }

  @Override
  public void deliverEquipment(Long rentalId, Long equipmentId) {
    Optional<Rental> rental = repository.findById(rentalId);

    if (rental.isPresent()) {
      for (RentedEquipment rentedEquipment : rental.get().getRentedEquipments()) {
        if (rentedEquipment.getId().equals(equipmentId)) {
          // Mark equipment as returned
          rentedEquipment.setReturned(true);

          // Update the cost of the rental
          double cost = rental.get().getCost();
          cost += calculateEquipmentCost(rental.get().getId(), rentedEquipment.getId());
          rental.get().setCost(cost);
        }
      }

      if (thereIsPendingEquipments(rental.get().getRentedEquipments()))
        rental.get().setStatus(Rental.Status.PENDING);
      else
        rental.get().setStatus(Rental.Status.PAID);

      // Save all
      repository.save(rental.get());
    } else {
      throw new ResourceNotFoundException();
    }
  }

  private boolean thereIsPendingEquipments(List<RentedEquipment> rentedEquipments) {
    boolean isOnePending = false;

    for (RentedEquipment rentedEquipment : rentedEquipments) {
      if (!rentedEquipment.isReturned()) {
        isOnePending = true;
        break;
      }
    }

    return isOnePending;
  }

  private double calculateEquipmentCost(Long rentalId, Long equipmentId) {
    Optional<Rental> rental = repository.findById(rentalId);
    Optional<RentedEquipment> rentedEquipment = rentedEquipmentRepository.findById(equipmentId);
    double cost = 0;

    if (rentedEquipment.isPresent() && rental.isPresent()) {
      try {
        // Setting dates
        LocalDate createdAt = LocalDate.fromDateFields(rental.get().getCreatedAt());
        LocalDate now = LocalDate.now();

        // Get days difference
        int days = Days.daysBetween(createdAt, now).getDays();

        // Calculate cost by days
        cost = rentedEquipment.get().getEquipment().getPriceByDay() * days;

      } catch (Exception e) {
        return 0;
      }
    }

    return cost;
  }
}
