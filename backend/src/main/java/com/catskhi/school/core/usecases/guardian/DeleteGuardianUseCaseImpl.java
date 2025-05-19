package com.catskhi.school.core.usecases.guardian;

import com.catskhi.school.core.gateway.GuardianGateway;

import java.util.UUID;

public class DeleteGuardianUseCaseImpl implements DeleteGuardianUseCase {
    private final GuardianGateway guardianGateway;

    public DeleteGuardianUseCaseImpl(GuardianGateway guardianGateway) {
        this.guardianGateway = guardianGateway;
    }

    @Override
    public void execute(UUID id) {
        guardianGateway.deleteGuardian(id);
    }
}
