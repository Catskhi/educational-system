-- V1__create_guardian_table.sql

CREATE TABLE guardians (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    identity VARCHAR(20),
    id_issuing_agency VARCHAR(50),
    whatsapp_number VARCHAR(20),
    phone_number VARCHAR(20),
    email VARCHAR(255) UNIQUE,
    created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP
);
