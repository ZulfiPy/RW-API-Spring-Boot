package com.rw.dto;

import java.time.LocalDateTime;

public record TermResponseDTO(
        Long id,
        String title,
        String category,
        String content,
        boolean isActive,
        boolean customTerm,
        LocalDateTime createdAt,
        LocalDateTime lastEditedAt
) {
}
