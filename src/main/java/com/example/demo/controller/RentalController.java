package com.example.demo.controller;

import com.example.demo.exception.ResourceExistsException;
import com.example.demo.model.Rental;
import com.example.demo.service.RentalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * A {@link RestController} that handles all incoming HTTP requests from the client and returns an appropriate response.
 */
@RestController
// Declares that the url for all the apis in this controller will start with "/rentals".
@RequestMapping(value = "/rentals")
public class RentalController {

  // Required dependencies
  private final RentalServiceImpl service;

  // Constructor-based dependency injection
  @Autowired
  public RentalController(RentalServiceImpl service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<Rental>> findAll() {
    return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<HttpStatus> create(@Valid @RequestBody Rental rental) throws ResourceExistsException {
    service.create(rental);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Rental> findById(@PathVariable Long id) {
    return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
    service.delete(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping("/deliverEquipment/{rentalId}/{equipmentId}")
  public ResponseEntity<HttpStatus> deliverEquipment(@PathVariable Long rentalId, @PathVariable Long equipmentId) {
    service.deliverEquipment(rentalId, equipmentId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping("/findAllPending")
  public List<Rental> findAllByStatus() {
    return service.findRentalsByStatusOrderByCreatedAt(Rental.Status.PENDING);
  }

}
