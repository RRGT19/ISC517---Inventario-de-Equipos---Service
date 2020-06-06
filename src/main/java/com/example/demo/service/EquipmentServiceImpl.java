package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ServerStatusMessages;
import com.example.demo.model.Equipment;
import com.example.demo.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentServiceImpl implements IEquipmentService {

  // Required dependencies
  private final EquipmentRepository repository;

  // Constructor-based dependency injection
  @Autowired
  public EquipmentServiceImpl(EquipmentRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<Equipment> findAll() {
    return repository.findAll();
  }

  @Override
  public void create(Equipment equipment) {
    try {
      repository.save(equipment);
    } catch (Exception e) {
      throw new ResourceNotFoundException();
    }
  }

  @Override
  public void update(Equipment equipment) {
    Optional<Equipment> current = repository.findById(equipment.getId());

    if (current.isPresent()) repository.save(equipment);
    else throw new ResourceNotFoundException();
  }

  @Override
  public Equipment findById(Long id) {
    Equipment equipment = repository.findById(id).orElse(null);

    if (equipment == null)
      throw new ResourceNotFoundException();

    return equipment;
  }

  @Override
  public void delete(Long id) {
    Equipment equipment = repository.findById(id).orElse(null);

    if (equipment == null)
      throw new ResourceNotFoundException();

    repository.deleteById(id);
  }
}
