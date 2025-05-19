package com.catskhi.school.infra.mappers.guardian;

import com.catskhi.school.core.entity.Guardian;
import com.catskhi.school.infra.dtos.guardians.request.GuardianRequest;
import com.catskhi.school.infra.dtos.guardians.response.GuardianResponse;
import com.catskhi.school.infra.persistence.entities.GuardianEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GuardianDtoMapper {
    GuardianDtoMapper INSTANCE = Mappers.getMapper(GuardianDtoMapper.class);
    GuardianResponse toGuardianResponse(Guardian guardian);
    Guardian toGuardian(GuardianRequest request);

    @Mapping(target = "updatedAt", expression = "java(LocalDateTime.now())")
    @Mapping(target = "createdAt", ignore = true)
    GuardianEntity updateEntityFromDomain(Guardian domain, @MappingTarget GuardianEntity entity);
}
