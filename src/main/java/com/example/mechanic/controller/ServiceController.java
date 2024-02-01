package com.example.mechanic.controller;

import com.example.mechanic.dto.ServiceDTO;
import com.example.mechanic.service.RepairService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service")
public class ServiceController {

    private final RepairService repairService;

    public ServiceController(RepairService repairService) {
        this.repairService = repairService;
    }

    @PostMapping
    public ServiceDTO addService(@RequestBody ServiceDTO dto){
        return repairService.addService(dto);
    }

    @PostMapping("/car/{carId}")
    public ServiceDTO addServiceToCar(@RequestBody ServiceDTO dto, @PathVariable Long carId){
        return repairService.addServiceToCar(carId, dto);
    }
}
