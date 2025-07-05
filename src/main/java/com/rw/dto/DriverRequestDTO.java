package com.rw.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record DriverRequestDTO(
        @NotBlank(message = "First name is required")
        @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
        String firstName,

        @NotBlank(message = "Last name is required")
        @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
        String lastName,

        Boolean isEstonianResident,

        @Min(value = 10000000000L, message = "Personal ID must be 11 digits")
        @Max(value = 99999999999L, message = "Personal ID must be 11 digits")
        Long personalID,

        @Past(message = "Date of birth must be in the past")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
        LocalDate dateOfBirth,

        @NotBlank(message = "Phone number is required")
        String phoneNumber,

        @NotBlank(message = "Email is required")
        @Email(message = "Email should be valid")
        String email,

        @NotBlank(message = "Living address is required")
        @Size(min = 10, max = 200, message = "Living address must be between 10 and 200 characters")
        String livingAddress,

        @NotBlank(message = "Driver's license must follow Estonian format (e.g., E<E/V/T>123456")
        String driversLicenseNumber
) {
}
