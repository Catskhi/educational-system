package com.catskhi.school.core.usecases.guardian;

import com.catskhi.school.core.entity.Guardian;
import com.catskhi.school.core.gateway.GuardianGateway;

public class CreateGuardianUseCaseImpl implements CreateGuardianUseCase {
    private final GuardianGateway guardianGateway;

    public CreateGuardianUseCaseImpl(GuardianGateway guardianGateway) {
        this.guardianGateway = guardianGateway;
    }

    @Override
    public Guardian execute(Guardian guardian) {
        return guardianGateway.createGuardian(guardian);
    }
}
