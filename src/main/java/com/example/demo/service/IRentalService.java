package com.example.demo.service;

import com.example.demo.model.Rental;

import java.util.List;

public interface IRentalService {
  List<Rental> findAll();
  List<Rental> findRentalsByStatusOrderByCreatedAt(Rental.Status status);

  void create(Rental rental);

  Rental findById(Long id);

  void delete(Long id);

  void deliverEquipment(Long rentalId, Long equipmentId);
}
