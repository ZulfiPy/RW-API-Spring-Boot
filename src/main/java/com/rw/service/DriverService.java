package com.rw.service;

import com.rw.repository.DriverRepository;
import com.rw.model.Driver;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

    public final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public Driver insertDriver(Driver driver) {
        System.out.println(driver);
//        Driver savedDriver = driverRepository.save(driver);
        return null;
    }
}

