package com.example.demo.repository;

import com.example.demo.model.RentedEquipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentedEquipmentRepository extends JpaRepository<RentedEquipment, Long> {
}
