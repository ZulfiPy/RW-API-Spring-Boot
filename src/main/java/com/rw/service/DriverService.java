package com.rw.service;

import com.rw.dto.DriverRequestDTO;
import com.rw.dto.DriverResponseDTO;
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

    public List<DriverResponseDTO> getAllDrivers() {
        return driverRepository.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .toList();
    }

    public DriverResponseDTO insertDriver(DriverRequestDTO driverRequestDTO) {
        Driver driver = mapToEntity(driverRequestDTO);
        Driver savedDriver = driverRepository.save(driver);
        return mapToResponseDTO(savedDriver);
    }

    private DriverResponseDTO mapToResponseDTO(Driver driver) {
        return new DriverResponseDTO(
                driver.getId(),
                driver.getFirstName(),
                driver.getLastName(),
                driver.isEstonianResident(),
                driver.getPersonalID(),
                driver.getDateOfBirth(),
                driver.getPhoneNumber(),
                driver.getEmail(),
                driver.getLivingAddress(),
                driver.getDriversLicenseNumber(),
                driver.getCreatedAt(),
                driver.getLastEditedAt()
        );
    }

    private Driver mapToEntity(DriverRequestDTO driverRequestDTO) {
        return new Driver(
                driverRequestDTO.firstName(),
                driverRequestDTO.lastName(),
                driverRequestDTO.isEstonianResident(),
                driverRequestDTO.personalID(),
                driverRequestDTO.dateOfBirth(),
                driverRequestDTO.phoneNumber(),
                driverRequestDTO.email(),
                driverRequestDTO.livingAddress(),
                driverRequestDTO.driversLicenseNumber()
        );
    }
}

