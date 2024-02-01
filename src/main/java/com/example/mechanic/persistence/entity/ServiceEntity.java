package com.example.mechanic.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;


@Entity
@Table(name = "service")
public class ServiceEntity extends BaseEntity {

    @Column(name = "work_done")
    private String workDone;

    @Column(name = "hours_worked")
    private Double hoursWorked;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "handle_date")
    private Date handleDate;

    @Column(name = "total_cost")
    private Double totalCost;

    @Column(name = "notes")
    private String notes;

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private CarEntity car;

    @OneToMany(mappedBy = "serviceId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PartsEntity> parts;

    public void setParts(List<PartsEntity> parts) {
        this.parts = parts;
    }

    public List<PartsEntity> getParts() {
        return parts;
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

    public Double setTotalCost() {
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

    public CarEntity getCar() {
        return car;
    }

    public void setCar(CarEntity car) {
        this.car = car;
    }


}
