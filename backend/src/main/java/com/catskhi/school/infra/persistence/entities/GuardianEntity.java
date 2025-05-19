package com.catskhi.school.infra.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "guardians")
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class GuardianEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false, unique = true)
    private String identity;

    @Column(name = "id_issuing_agency", nullable = false)
    private String idIssuingAgency;

    @Column(name = "whatsapp_number", nullable = true)
    private String whatsappNumber;

    @Column(name = "phone_number", nullable = true)
    private String phoneNumber;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        createdAt = now;
        updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
