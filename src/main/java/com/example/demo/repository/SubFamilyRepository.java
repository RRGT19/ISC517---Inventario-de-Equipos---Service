package com.example.demo.repository;

import com.example.demo.model.Family;
import com.example.demo.model.SubFamily;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubFamilyRepository extends JpaRepository<SubFamily, Long> {
  SubFamily findSubFamilyByName(String name);
}
