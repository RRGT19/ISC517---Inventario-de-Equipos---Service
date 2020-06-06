package com.example.demo.service;

import com.example.demo.exception.ResourceExistsException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ServerStatusMessages;
import com.example.demo.model.Family;
import com.example.demo.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilyServiceImpl implements IFamilyService {

  // Required dependencies
  private final FamilyRepository repository;

  // Constructor-based dependency injection
  @Autowired
  public FamilyServiceImpl(FamilyRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<Family> findAll() {
    return repository.findAll();
  }

  @Override
  public void create(Family family) {
    if (!this.exists(family.getName()))
      repository.save(family);
  }

  @Override
  public Family findById(Long id) {
    Family family = repository.findById(id).orElse(null);

    if (family == null)
      throw new ResourceNotFoundException();

    return family;
  }

  private boolean exists(String name) {
    Family family = repository.findFamilyByName(name);

    if (family != null)
      throw new ResourceExistsException();

    return false;
  }
}
