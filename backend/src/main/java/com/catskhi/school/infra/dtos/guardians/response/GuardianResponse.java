package com.catskhi.school.infra.dtos.guardians.response;

import java.time.LocalDateTime;
import java.util.UUID;

public record GuardianResponse(
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
