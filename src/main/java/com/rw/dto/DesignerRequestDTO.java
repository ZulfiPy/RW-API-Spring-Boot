package com.rw.dto;

import jakarta.validation.constraints.NotBlank;


public record DesignerRequestDTO(
        @NotBlank(message = "Name is required")
        String name,

        @NotBlank(message = "Design tools are required")
        String designTools
) {
}
