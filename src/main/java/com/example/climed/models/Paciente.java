package com.example.climed.models;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

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
) {
}
