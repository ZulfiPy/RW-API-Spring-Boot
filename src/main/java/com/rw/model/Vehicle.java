package com.rw.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String plateNumber;
    private String VIN;
    private String make;
    private String model;
    private LocalDateTime registered;
    private String body;
    private String fuelType;
    private String transmission;
    private String gearbox;
    private String driveTrain;

    @OneToOne(mappedBy = "currentVehicle")
    private Driver assignedDriver;

    private LocalDateTime createdAt;
    private LocalDateTime lastEditedAt;

    // new fields for owner and driver

    public Vehicle() {

    }

    public Vehicle(String plateNumber, String VIN, String make, String model, LocalDateTime registered, String body, String fuelType, String transmission, String gearbox, String driveTrain) {
        this.plateNumber = plateNumber;
        this.VIN = VIN;
        this.make = make;
        this.model = model;
        this.registered = registered;
        this.body = body;
        this.fuelType = fuelType;
        this.transmission = transmission;
        this.gearbox = gearbox;
        this.driveTrain = driveTrain;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDateTime getRegistered() {
        return registered;
    }

    public void setRegistered(LocalDateTime registered) {
        this.registered = registered;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public String getDriveTrain() {
        return driveTrain;
    }

    public void setDriveTrain(String driveTrain) {
        this.driveTrain = driveTrain;
    }

    public Driver getAssignedDriver() {
        return assignedDriver;
    }

    public void setAssignedDriver(Driver assignedDriver) {
        this.assignedDriver = assignedDriver;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getLastEditedAt() {
        return lastEditedAt;
    }

    public void setLastEditedAt(LocalDateTime lastEditedAt) {
        this.lastEditedAt = lastEditedAt;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        lastEditedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        lastEditedAt = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(id, vehicle.id) && Objects.equals(VIN, vehicle.VIN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, VIN);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", plateNumber='" + plateNumber + '\'' +
                ", VIN='" + VIN + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", registered=" + registered +
                ", createdAt=" + createdAt +
                ", lastEditedAt=" + lastEditedAt +
                '}';
    }
}
