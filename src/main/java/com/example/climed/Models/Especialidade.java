package com.example.climed.Models;

import jakarta.persistence.*;
import java.util.Set;

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
) {}