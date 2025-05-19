package com.catskhi.school.core.gateway;

import com.catskhi.school.core.entity.Guardian;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GuardianGateway {
    Guardian createGuardian(Guardian guardian);
    List<Guardian> getGuardians();
    Optional<Guardian> getGuardianById(UUID id);
    Guardian updateGuardian(UUID id, Guardian updatedGuardian);
    void deleteGuardian(UUID id);
}
