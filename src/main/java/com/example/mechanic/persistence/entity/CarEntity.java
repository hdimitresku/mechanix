package com.example.mechanic.persistence.entity;

import com.example.mechanic.enums.Make;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "car")
public class CarEntity extends BaseEntity {

    @Column(name = "make")
    private Make make;

    @Column(name = "model")
    private String model;

    @Column(name = "vin", nullable = false)
    private String vin;

    @Column(name = "plate_no", nullable = false)
    private String plateNo;

    @Column(name = "owner")
    private String owner;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ServiceEntity> services;


    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Make getMake() {
        return make;
    }

    public void setMake(Make make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<ServiceEntity> getServices() {
        return services;
    }
}
