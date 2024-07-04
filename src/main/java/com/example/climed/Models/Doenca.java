package com.example.climed.Models;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "doenca")
public record Doenca(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long idDoenca,

        String nomeD,

        @OneToMany(mappedBy = "doenca")
        Set<Diagnostico> diagnosticos
) {}
