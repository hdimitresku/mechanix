package com.example.mechanic.service;

import com.example.mechanic.dto.PartsDTO;
import com.example.mechanic.persistence.entity.PartsEntity;
import com.example.mechanic.persistence.repository.PartsRepository;
import com.example.mechanic.utils.UniversalMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class PartsService {

    private final PartsRepository partsRepository;
    private final UniversalMapper mapper;

    @Autowired
    public PartsService(PartsRepository partsRepository, UniversalMapper mapper) {
        this.partsRepository = partsRepository;
        this.mapper = mapper;
    }

    public void addParts(List<PartsDTO> dtos){
        List<PartsEntity> entities = dtos.stream().map(mapper::partsDtoToEntity).toList();
        entities = partsRepository.saveAll(entities);
    }

    public List<PartsDTO> getPartsByServiceId(Long serviceId){
        return partsRepository.findAllByServiceId(serviceId)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND))
                .stream()
                .map(mapper::partsEntityToDto)
                .toList();
    }
}
