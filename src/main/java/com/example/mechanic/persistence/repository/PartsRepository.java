package com.example.mechanic.persistence.repository;

import com.example.mechanic.persistence.entity.PartsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PartsRepository extends JpaRepository<PartsEntity, Long> {

    Optional<List<PartsEntity>> findAllByServiceId(Long serviceId);
}
