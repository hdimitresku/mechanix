package com.example.mechanic.persistence.repository;

import com.example.mechanic.persistence.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarEntity, Long> {
}
