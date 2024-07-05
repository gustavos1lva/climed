package com.example.climed.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "diagnostico")
public record Diagnostico(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long idDiagnostico,

        String tratamentoRecomendado,
        String remediosReceitados,
        String observacoes,

        @OneToOne
        @JoinColumn(name = "idCon", referencedColumnName = "idCon")
        Consulta consulta,

        @ManyToOne
        @JoinColumn(name = "idDoenca", referencedColumnName = "idDoenca")
        Doenca doenca
) {
}
