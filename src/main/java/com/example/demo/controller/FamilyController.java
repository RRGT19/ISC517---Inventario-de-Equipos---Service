package com.example.demo.controller;

import com.example.demo.exception.ResourceExistsException;
import com.example.demo.model.Family;
import com.example.demo.service.FamilyServiceImpl;
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
// Declares that the url for all the apis in this controller will start with "/families".
@RequestMapping(value = "/families")
public class FamilyController {

  // Required dependencies
  private final FamilyServiceImpl service;

  // Constructor-based dependency injection
  @Autowired
  public FamilyController(FamilyServiceImpl service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<Family>> findAll() {
    return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Family> create(@Valid @RequestBody Family family) throws ResourceExistsException {
    service.create(family);
    return new ResponseEntity<>(family, HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Family> findById(@PathVariable Long id) {
    return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
  }

}
