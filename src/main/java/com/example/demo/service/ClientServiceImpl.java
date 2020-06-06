package com.example.demo.service;

import com.example.demo.exception.ResourceExistsException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ServerStatusMessages;
import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements IClientService {

  // Required dependencies
  private final ClientRepository repository;

  // Constructor-based dependency injection
  @Autowired
  public ClientServiceImpl(ClientRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<Client> findAll() {
    return repository.findAll();
  }

  @Override
  public void create(Client client) {
    if (!this.identificationExists(client.getIdentification()) && !this.phoneExists(client.getPhone()))
      repository.save(client);
  }

  @Override
  public Client findById(Long id) {
    Client client = repository.findById(id).orElse(null);

    if (client == null)
      throw new ResourceNotFoundException();

    return client;
  }

  private boolean identificationExists(String identification) {
    Client client = repository.findClientByIdentification(identification);

    if (client != null)
      throw new ResourceExistsException();

    return false;
  }

  private boolean phoneExists(String phone) {
    Client client = repository.findClientByPhone(phone);

    if (client != null)
      throw new ResourceExistsException();

    return false;
  }

}
