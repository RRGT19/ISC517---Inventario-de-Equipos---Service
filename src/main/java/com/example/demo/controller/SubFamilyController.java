package com.example.demo.controller;

import com.example.demo.exception.ResourceExistsException;
import com.example.demo.model.SubFamily;
import com.example.demo.service.SubFamilyServiceImpl;
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
// Declares that the url for all the apis in this controller will start with "/subfamilies".
@RequestMapping(value = "/subfamilies")
public class SubFamilyController {

  // Required dependencies
  private final SubFamilyServiceImpl service;

  // Constructor-based dependency injection
  @Autowired
  public SubFamilyController(SubFamilyServiceImpl service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<SubFamily>> findAll() {
    return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<SubFamily> create(@Valid @RequestBody SubFamily subFamily) throws ResourceExistsException {
    service.create(subFamily);
    return new ResponseEntity<>(subFamily, HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<SubFamily> findById(@PathVariable Long id) {
    return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
  }

}
