package com.rw.service;

import com.rw.dto.DriverRequestDTO;
import com.rw.dto.DriverResponseDTO;
import com.rw.exception.DriverNotFoundException;
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

    public DriverResponseDTO getDriverById(Long id) {
        Driver driver = driverRepository.findById(id).orElseThrow(() -> new DriverNotFoundException("Driver not found with the provided id: " + id));
        return mapToResponseDTO(driver);
    }

    public DriverResponseDTO insertDriver(DriverRequestDTO driverRequestDTO) {
        Driver driver = mapToEntity(driverRequestDTO);
        Driver savedDriver = driverRepository.save(driver);
        return mapToResponseDTO(savedDriver);
    }

    public void deleteDriverById(Long id) {
        if (!driverRepository.existsById(id)) {
            throw new DriverNotFoundException("Driver not found with the provided id: " + id);
        }
        driverRepository.deleteById(id);
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

