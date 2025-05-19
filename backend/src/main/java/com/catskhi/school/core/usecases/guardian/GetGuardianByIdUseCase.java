package com.catskhi.school.core.usecases.guardian;

import com.catskhi.school.core.entity.Guardian;

import java.util.Optional;
import java.util.UUID;

public interface GetGuardianByIdUseCase {
    Guardian execute(UUID id);
}
