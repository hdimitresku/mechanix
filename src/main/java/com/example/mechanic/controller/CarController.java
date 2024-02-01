package com.example.mechanic.controller;

import com.example.mechanic.dto.CarDTO;
import com.example.mechanic.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public CarDTO addCar(@RequestBody CarDTO carDTO){
        return carService.addCar(carDTO);
    }

    @GetMapping("/list")
    public List<CarDTO> getAllCars(){
        return carService.getAll();
    }

    @GetMapping("/{id}")
    public CarDTO getOne(@PathVariable Long id){
       return carService.getCarById(id);
    }

    @PutMapping("/{id}")
    public void updateCarById(@PathVariable Long id, @RequestBody CarDTO car){
        carService.updateCarById(id, car);
    }

}
