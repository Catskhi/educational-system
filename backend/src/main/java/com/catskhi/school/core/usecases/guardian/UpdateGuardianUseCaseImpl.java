package com.catskhi.school.core.usecases.guardian;

import com.catskhi.school.core.entity.Guardian;
import com.catskhi.school.core.gateway.GuardianGateway;

import java.util.UUID;

public class UpdateGuardianUseCaseImpl implements UpdateGuardianUseCase {
    private final GuardianGateway gateway;

    public UpdateGuardianUseCaseImpl(GuardianGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Guardian execute(UUID id, Guardian updatedGuardian) {
        return gateway.updateGuardian(id, updatedGuardian);
    }
}
