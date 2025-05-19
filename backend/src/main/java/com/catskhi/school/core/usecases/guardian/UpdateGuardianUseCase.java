package com.catskhi.school.core.usecases.guardian;

import com.catskhi.school.core.entity.Guardian;

import java.util.UUID;

public interface UpdateGuardianUseCase {
    Guardian execute(UUID id, Guardian updatedGuardian);
}
