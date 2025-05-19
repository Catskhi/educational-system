package com.catskhi.school.infra.gateway;

import com.catskhi.school.core.entity.Guardian;
import com.catskhi.school.core.gateway.GuardianGateway;
import com.catskhi.school.infra.exception.NotFoundException;
import com.catskhi.school.infra.mappers.guardian.GuardianDtoMapper;
import com.catskhi.school.infra.mappers.guardian.GuardianEntityMapper;
import com.catskhi.school.infra.persistence.entities.GuardianEntity;
import com.catskhi.school.infra.persistence.repositories.GuardianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class GuardianRepositoryGateway implements GuardianGateway {

    private final GuardianRepository guardianRepository;
    private final GuardianEntityMapper entityMapper;
    private final GuardianDtoMapper dtoMapper;

    @Override
    public Guardian createGuardian(Guardian guardian) {
        GuardianEntity entity = entityMapper.toEntity(guardian);
        return entityMapper.toDomain(guardianRepository.save(entity));
    }

    @Override
    public List<Guardian> getGuardians() {
        return guardianRepository.findAll().stream().map(entityMapper::toDomain).toList();
    }

    @Override
    public Optional<Guardian> getGuardianById(UUID id) {
        return guardianRepository.findById(id).map(entityMapper::toDomain);
    }

    @Override
    public Guardian updateGuardian(UUID id, Guardian updatedGuardian) {
        GuardianEntity guardian = entityMapper.toEntity(getGuardianById(id)
                .orElseThrow(() -> new NotFoundException("Guardian not found.")));
        guardian.setName(updatedGuardian.name());
        guardian.setCpf(updatedGuardian.cpf());
        guardian.setIdIssuingAgency(updatedGuardian.idIssuingAgency());
        guardian.setWhatsappNumber(updatedGuardian.whatsappNumber());
        guardian.setPhoneNumber(updatedGuardian.phoneNumber());
        guardian.setPhoneNumber(updatedGuardian.phoneNumber());
        guardian.setUpdatedAt(LocalDateTime.now());

        return entityMapper.toDomain(guardianRepository.save(guardian));
    }

    @Override
    public void deleteGuardian(UUID id) {
        Guardian guardian = getGuardianById(id)
                .orElseThrow(() -> new NotFoundException("Guardian not found."));
        guardianRepository.deleteById(id);
    }
}
