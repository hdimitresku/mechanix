package com.example.mechanic.persistence.repository;

import com.example.mechanic.persistence.entity.PartsEntity;
import com.example.mechanic.persistence.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ServiceRepository extends JpaRepository<ServiceEntity, Long> {

    Optional<List<ServiceEntity>> findAllByCar_Id(Long carId);

}
