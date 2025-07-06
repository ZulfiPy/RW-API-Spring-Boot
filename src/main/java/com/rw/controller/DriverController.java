package com.rw.controller;

import com.rw.dto.DriverRequestDTO;
import com.rw.dto.DriverResponseDTO;
import com.rw.model.Driver;
import com.rw.service.DriverService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/drivers")
public class DriverController {

    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping
    public ResponseEntity<List<DriverResponseDTO>> getDrivers() {
        List<DriverResponseDTO>  drivers = driverService.getAllDrivers();
        return ResponseEntity.ok(drivers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DriverResponseDTO> getDriverById(@PathVariable Long id) {
        DriverResponseDTO driver = driverService.getDriverById(id);
        return ResponseEntity.ok(driver);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<DriverResponseDTO> addDriver(@Valid @RequestBody DriverRequestDTO driverRequestDTO) {
        DriverResponseDTO driver = driverService.insertDriver(driverRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(driver);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteDriverId(@PathVariable Long id) {
        driverService.deleteDriverById(id);
        return ResponseEntity.noContent().build();
    }
}
