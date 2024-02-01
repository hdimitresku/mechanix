package com.example.mechanic.utils;

import com.example.mechanic.dto.CarDTO;
import com.example.mechanic.dto.PartsDTO;
import com.example.mechanic.dto.ServiceDTO;
import com.example.mechanic.persistence.entity.CarEntity;
import com.example.mechanic.persistence.entity.PartsEntity;
import com.example.mechanic.persistence.entity.ServiceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UniversalMapper {


    CarDTO carEntityToCarDTO(CarEntity entity);

    CarEntity carDTOToCarEntity(CarDTO dto);

    PartsDTO partsEntityToDto(PartsEntity entity);

    PartsEntity partsDtoToEntity(PartsDTO dto);

    @Mapping(target = "car", ignore = true)
    ServiceDTO serviceEntityToDto(ServiceEntity entity);

    ServiceEntity serviceDtoToEntity(ServiceDTO dto);

    @Mapping(target = "services", ignore = true)
    void updateCarEntity(@MappingTarget CarEntity entity, CarDTO dto);


}
