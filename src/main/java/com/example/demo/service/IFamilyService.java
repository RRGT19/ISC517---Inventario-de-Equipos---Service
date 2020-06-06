package com.example.demo.service;

import com.example.demo.model.Family;

import java.util.List;

public interface IFamilyService {
  List<Family> findAll();
  void create(Family family);
  Family findById(Long id);
}
