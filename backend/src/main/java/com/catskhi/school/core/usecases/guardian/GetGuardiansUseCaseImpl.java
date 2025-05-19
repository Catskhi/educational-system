package com.catskhi.school.core.usecases.guardian;

import com.catskhi.school.core.entity.Guardian;
import com.catskhi.school.core.gateway.GuardianGateway;

import java.util.List;

public class GetGuardiansUseCaseImpl implements GetGuardiansUseCase {
    private final GuardianGateway guardianGateway;

    public GetGuardiansUseCaseImpl(GuardianGateway guardianGateway) {
        this.guardianGateway = guardianGateway;
    }

    @Override
    public List<Guardian> execute() {
        return guardianGateway.getGuardians();
    }
}
