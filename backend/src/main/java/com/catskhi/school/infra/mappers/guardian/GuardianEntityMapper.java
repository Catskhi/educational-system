package com.catskhi.school.infra.mappers.guardian;

import com.catskhi.school.core.entity.Guardian;
import com.catskhi.school.infra.persistence.entities.GuardianEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GuardianEntityMapper {
    GuardianEntityMapper INSTANCE = Mappers.getMapper(GuardianEntityMapper.class);

    @Mapping(source = "name", target = "name")
    Guardian toDomain(GuardianEntity entity);
    @Mapping(source = "name", target = "name")
    GuardianEntity toEntity(Guardian guardian);
}
