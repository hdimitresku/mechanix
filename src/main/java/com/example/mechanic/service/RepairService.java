package com.example.mechanic.service;

import com.example.mechanic.dto.PartsDTO;
import com.example.mechanic.dto.ServiceDTO;
import com.example.mechanic.persistence.entity.PartsEntity;
import com.example.mechanic.persistence.entity.ServiceEntity;
import com.example.mechanic.persistence.repository.ServiceRepository;
import com.example.mechanic.utils.UniversalMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class RepairService {

    private final ServiceRepository serviceRepository;
    private final UniversalMapper mapper;
    private final CarService carService;
    private final PartsService partsService;

    @Autowired
    public RepairService(ServiceRepository serviceRepository, UniversalMapper mapper, CarService carService, PartsService partsService) {
        this.serviceRepository = serviceRepository;
        this.mapper = mapper;
        this.carService = carService;
        this.partsService = partsService;
    }

    public ServiceDTO addService(ServiceDTO dto) {
        ServiceEntity entity = mapper.serviceDtoToEntity(dto);
        serviceRepository.save(entity);
        return dto;
    }

    public ServiceDTO addServiceToCar(Long carId, ServiceDTO dto) {
        dto.setCar(carService.getCarById(carId));
        return mapper.serviceEntityToDto(associateServiceWithParts(dto, dto.getParts()));
    }

    public List<ServiceDTO> getServicesByCar(Long carId) {
        List<ServiceDTO> dtos = serviceRepository.findAllByCar_Id(carId)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND))
                .stream()
                .map(mapper::serviceEntityToDto)
                .toList();
        dtos.forEach(dto -> dto.setParts(partsService.getPartsByServiceId(dto.getId())));
        return dtos;
    }

    private ServiceEntity associateServiceWithParts(ServiceDTO serviceDTO, List<PartsDTO> parts) {

        ServiceEntity serviceEntity = serviceRepository.save(mapper.serviceDtoToEntity(serviceDTO));
        serviceEntity.getParts().forEach(part -> part.setServiceId(serviceEntity.getId()));
        serviceRepository.save(serviceEntity);

        return serviceEntity;

    }
}
