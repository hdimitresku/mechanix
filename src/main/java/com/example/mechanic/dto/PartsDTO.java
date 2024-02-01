package com.example.mechanic.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PartsDTO {

    private Long id;
    private String name;
    private String serialNumber;
    private Double price;
    @JsonIgnore
    private Long serviceId;

    public PartsDTO() {
    }

    public PartsDTO(Long id, String name, String serialNumber, Double price, Long serviceId) {
        this.id = id;
        this.name = name;
        this.serialNumber = serialNumber;
        this.price = price;
        this.serviceId = serviceId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }
}
