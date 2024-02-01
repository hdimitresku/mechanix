package com.example.mechanic.dto;

import com.example.mechanic.dto.PartsDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;

public class ServiceDTO extends BaseDTO {

    private String workDone;
    private Double hoursWorked;
    private Date startDate;
    private Date handleDate;
    private Double totalCost;
    private String notes;
    @JsonIgnore
    private CarDTO car;
    private List<PartsDTO> parts;

    // Constructors, getters, and setters

    public ServiceDTO() {
        // Default constructor
    }

    public ServiceDTO(Long id, String workDone, Double hoursWorked, Date startDate, Date handleDate,
                      Double totalCost, String notes, List<PartsDTO> parts) {
        this.id = id;
        this.workDone = workDone;
        this.hoursWorked = hoursWorked;
        this.startDate = startDate;
        this.handleDate = handleDate;
        this.totalCost = totalCost;
        this.notes = notes;
        this.parts = parts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWorkDone() {
        return workDone;
    }

    public void setWorkDone(String workDone) {
        this.workDone = workDone;
    }

    public Double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(Double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getHandleDate() {
        return handleDate;
    }

    public void setHandleDate(Date handleDate) {
        this.handleDate = handleDate;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<PartsDTO> getParts() {
        return parts;
    }

    public CarDTO getCar() {
        return car;
    }

    public void setCar(CarDTO car) {
        this.car = car;
    }

    public void setParts(List<PartsDTO> parts) {
        this.parts = parts;
    }


}
