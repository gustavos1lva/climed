package com.example.climed.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "agenda")
public record Agenda(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long idAgenda,

        String diaSemana,
        String horaInicio,
        String horaFim,

        @ManyToOne
        @JoinColumn(name = "crm", referencedColumnName = "crm")
        Medico medico
) {}
