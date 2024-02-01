package com.example.mechanic.service;

import com.example.mechanic.dto.CarDTO;
import com.example.mechanic.persistence.entity.CarEntity;
import com.example.mechanic.persistence.repository.CarRepository;
import com.example.mechanic.utils.UniversalMapper;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class CarService {

    private final UniversalMapper mapper;
    private final CarRepository carRepository;


    public CarService(UniversalMapper mapper, CarRepository carRepository) {
        this.mapper = mapper;
        this.carRepository = carRepository;
    }

    public CarDTO addCar(CarDTO dto){
        carRepository.save(mapper.carDTOToCarEntity(dto));
        return dto;
    }

    public List<CarDTO> getAll(){
        return carRepository.findAll().stream().map(mapper::carEntityToCarDTO).toList();
    }

    public CarDTO getCarById(Long id){
        return mapper.carEntityToCarDTO(carRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST)));
    }

    public void updateCarById(Long carId, CarDTO dto){
        CarEntity entity = carRepository.findById(carId).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        mapper.updateCarEntity(entity, dto);
        carRepository.save(entity);
    }

}
