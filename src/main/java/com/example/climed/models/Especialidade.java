package com.example.climed.models;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "especialidade")
public record Especialidade(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long idEsp,

        String nomeE,
        Integer indice,

        @OneToMany(mappedBy = "especialidade")
        Set<Consulta> consultas
) {
}