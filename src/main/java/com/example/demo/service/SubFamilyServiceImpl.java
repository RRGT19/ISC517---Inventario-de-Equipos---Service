package com.example.demo.service;

import com.example.demo.exception.ResourceExistsException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ServerStatusMessages;
import com.example.demo.model.SubFamily;
import com.example.demo.repository.SubFamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubFamilyServiceImpl implements ISubFamilyService {

  // Required dependencies
  private final SubFamilyRepository repository;

  // Constructor-based dependency injection
  @Autowired
  public SubFamilyServiceImpl(SubFamilyRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<SubFamily> findAll() {
    return repository.findAll();
  }

  @Override
  public void create(SubFamily subFamily) {
    if (!this.exists(subFamily.getName()))
      repository.save(subFamily);
  }

  @Override
  public SubFamily findById(Long id) {
    SubFamily subFamily = repository.findById(id).orElse(null);

    if (subFamily == null)
      throw new ResourceNotFoundException();

    return subFamily;
  }

  private boolean exists(String name) {
    SubFamily subFamily = repository.findSubFamilyByName(name);

    if (subFamily != null)
      throw new ResourceExistsException();

    return false;
  }

}
