package com.example.demo.controller;

import com.example.demo.exception.ResourceExistsException;
import com.example.demo.model.Client;
import com.example.demo.service.ClientServiceImpl;
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
// Declares that the url for all the apis in this controller will start with "/clients".
@RequestMapping(value = "/clients")
public class ClientController {

  // Required dependencies
  private final ClientServiceImpl service;

  // Constructor-based dependency injection
  @Autowired
  public ClientController(ClientServiceImpl service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<Client> create(@Valid @RequestBody Client client) throws ResourceExistsException {
    service.create(client);
    return new ResponseEntity<>(client, HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Client> findById(@PathVariable Long id) {
    return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<Client>> findAll() {
    return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
  }


}
