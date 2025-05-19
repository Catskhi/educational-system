package com.catskhi.school.infra.dtos.guardians.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record GuardianRequest(
        @NotBlank(message = "Name is required")
        String name,

        @NotBlank(message = "CPF is required")
        //        @Pattern(regexp = "\\d{11}", message = "CPF must be 11 digits")
        String cpf,

        @NotBlank(message = "Identity document is required")
        String identity,

        @NotBlank(message = "Issuing agency is required")
        String idIssuingAgency,

        @Pattern(regexp = "\\+?\\d{10,14}", message = "Invalid phone number format")
        String whatsappNumber,

        String phoneNumber, // Optional (no validation)

        @NotBlank(message = "Email is required")
        @Email(message = "Email must be valid")
        String email
) {
}
