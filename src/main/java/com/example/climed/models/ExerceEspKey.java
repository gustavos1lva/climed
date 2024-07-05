package com.example.climed.models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public record ExerceEspKey(
        String crm,
        Long idEsp
) implements Serializable {
}
