package com.example.demo.controller;

import com.example.demo.exception.ResourceExistsException;
import com.example.demo.model.Client;
import com.example.demo.model.Equipment;
import com.example.demo.model.Family;
import com.example.demo.service.ClientServiceImpl;
import com.example.demo.service.EquipmentServiceImpl;
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
// Declares that the url for all the apis in this controller will start with "/equipments".
@RequestMapping(value = "/equipments")
public class EquipmentController {

  // Required dependencies
  private final EquipmentServiceImpl service;

  // Constructor-based dependency injection
  @Autowired
  public EquipmentController(EquipmentServiceImpl service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<Equipment>> findAll() {
    return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<HttpStatus> create(@Valid @RequestBody Equipment equipment) throws ResourceExistsException {
    service.create(equipment);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PutMapping
  public ResponseEntity<HttpStatus> update(@Valid @RequestBody Equipment equipment) throws ResourceExistsException {
    service.update(equipment);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Equipment> findById(@PathVariable Long id) {
    return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> delete(@PathVariable Long id) throws ResourceExistsException {
    service.delete(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

}
