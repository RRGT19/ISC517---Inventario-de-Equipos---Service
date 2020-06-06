package com.example.demo.service;

import com.example.demo.model.SubFamily;

import java.util.List;

public interface ISubFamilyService {
  List<SubFamily> findAll();

  void create(SubFamily subFamily);

  SubFamily findById(Long id);
}
