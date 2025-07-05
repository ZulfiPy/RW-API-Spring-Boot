package com.rw.dto;

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
        String Email,
        String livingAddress,
        String diversLicenseNumber,
        LocalDateTime createdAt,
        LocalDateTime lastEditedAt
) {
}
