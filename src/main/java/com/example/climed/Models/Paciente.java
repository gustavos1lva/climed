package com.example.climed.Models;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "paciente")
public record Paciente(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long idPac,

        String cpf,
        String nomeP,
        String telefonePac,
        String endereco,
        Integer idade,
        String sexo,

        @OneToMany(mappedBy = "paciente")
        Set<Consulta> consultas
) {}
