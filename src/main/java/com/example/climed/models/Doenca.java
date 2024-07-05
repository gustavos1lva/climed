package com.example.climed.models;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "doenca")
public record Doenca(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long idDoenca,

        String nomeD,

        @OneToMany(mappedBy = "doenca")
        Set<Diagnostico> diagnosticos
) {
}
