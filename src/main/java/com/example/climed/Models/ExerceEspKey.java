package com.example.climed.Models;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public record ExerceEspKey(
        String crm,
        Long idEsp
) implements Serializable {}
