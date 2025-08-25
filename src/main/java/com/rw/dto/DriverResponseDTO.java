package com.rw.dto;

import com.rw.model.Vehicle;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record DriverResponseDTO(
        Long id,
        String firstName,
        String lastName,
        boolean isEstonianResident,
        Long personalID,
        LocalDate dateOfBirth,
        String phoneNumber,
        String email,
        String livingAddress,
        String driversLicenseNumber,
        Vehicle currentVehicle,
        LocalDateTime createdAt,
        LocalDateTime lastEditedAt
) {
}
