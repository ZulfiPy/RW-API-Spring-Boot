package com.rw.controller;

import com.rw.model.Driver;
import com.rw.service.DriverService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/drivers")
public class DriverController {

    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping
    public List<Driver> getDrivers() {
        return driverService.getAllDrivers();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Driver addDriver(@Valid @RequestBody Driver driverRequest) {
        System.out.println(driverRequest);
        return driverService.insertDriver(driverRequest);
    }
}
