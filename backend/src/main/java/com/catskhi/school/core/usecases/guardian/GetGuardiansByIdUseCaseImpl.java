package com.catskhi.school.core.usecases.guardian;

import com.catskhi.school.core.entity.Guardian;
import com.catskhi.school.core.gateway.GuardianGateway;
import com.catskhi.school.infra.exception.NotFoundException;

import java.util.Optional;
import java.util.UUID;

public class GetGuardiansByIdUseCaseImpl implements GetGuardianByIdUseCase {
    private final GuardianGateway gateway;

    public GetGuardiansByIdUseCaseImpl(GuardianGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Guardian execute(UUID id) {
        return gateway.getGuardianById(id)
                .orElseThrow(() -> new NotFoundException("Guardian not found."));
    }
}
