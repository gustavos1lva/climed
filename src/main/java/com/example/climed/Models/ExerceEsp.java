package com.example.climed.Models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "exerce_esp")
public record ExerceEsp(
        @EmbeddedId
        ExerceEspKey id
) {}
