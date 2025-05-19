package com.catskhi.school.infra.beans;

import com.catskhi.school.core.gateway.GuardianGateway;
import com.catskhi.school.core.usecases.guardian.*;
import com.catskhi.school.infra.dtos.guardians.request.GuardianRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GuardiansBeanConfiguration {
    @Bean
    public CreateGuardianUseCase createGuardian(GuardianGateway guardianGateway) {
        return new CreateGuardianUseCaseImpl(guardianGateway);
    }

    @Bean
    public GetGuardiansUseCase getGuardians(GuardianGateway guardianGateway) {
        return new GetGuardiansUseCaseImpl(guardianGateway);
    }

    @Bean
    public GetGuardianByIdUseCase getGuardianById(GuardianGateway guardianGateway) {
        return new GetGuardiansByIdUseCaseImpl(guardianGateway);
    }

    @Bean
    public UpdateGuardianUseCase updateGuardianUseCase(GuardianGateway guardianGateway) {
        return new UpdateGuardianUseCaseImpl(guardianGateway);
    }

    @Bean
    public DeleteGuardianUseCase deleteGuardian(GuardianGateway guardianGateway) {
        return new DeleteGuardianUseCaseImpl(guardianGateway);
    }
}
