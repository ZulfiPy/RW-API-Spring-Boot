package com.rw.dto;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TermRequestDTO(
        @NotBlank(message = "Title is required")
        @Size(max = 50, message = "Title must not exceed 50 characters")
        String title,

        @NotBlank(message = "Category is required")
        @Size(max = 50, message = "Category must not exceed 50 characters.")
        String category,

        @NotBlank(message = "Content is required")
        String content
) {
}
