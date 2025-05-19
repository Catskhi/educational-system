package com.catskhi.school.infra.persistence.repositories;

import com.catskhi.school.infra.persistence.entities.GuardianEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface GuardianRepository extends JpaRepository<GuardianEntity, UUID> {
    @Transactional
    @Modifying
    @Query("update GuardianEntity g set g.name = ?1, g.cpf = ?2 where g.name = ?3")
    void updateNameAndCpfByName(String name, String cpf, String name1);
}
