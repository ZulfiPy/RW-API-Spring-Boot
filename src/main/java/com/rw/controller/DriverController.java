package com.rw.controller;

import com.rw.dto.DriverRequestDTO;
import com.rw.dto.DriverResponseDTO;
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
    public List<DriverResponseDTO> getDrivers() {
        return driverService.getAllDrivers();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DriverResponseDTO addDriver(@Valid @RequestBody DriverRequestDTO driverRequestDTO) {
        return driverService.insertDriver(driverRequestDTO);
    }
}
