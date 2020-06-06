package com.example.demo.service;

import com.example.demo.model.Equipment;

import java.util.List;

public interface IEquipmentService {
  List<Equipment> findAll();

  void create(Equipment equipment);
  void update(Equipment equipment);

  Equipment findById(Long id);

  void delete(Long id);
}
