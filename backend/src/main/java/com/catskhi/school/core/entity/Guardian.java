package com.catskhi.school.core.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public record Guardian(
    UUID id,
    String name,
    String cpf,
    String identity,
    String idIssuingAgency,
    String whatsappNumber,
    String phoneNumber,
    String email,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
}
