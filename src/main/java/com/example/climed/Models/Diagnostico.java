package com.example.climed.Models;

import jakarta.persistence.*;

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
) {}
