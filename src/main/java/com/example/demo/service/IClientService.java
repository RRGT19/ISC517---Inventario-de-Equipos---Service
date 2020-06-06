package com.example.demo.service;

import com.example.demo.model.Client;

import java.util.List;

public interface IClientService {
  void create(Client client);
  Client findById(Long id);
  List<Client> findAll();
}
