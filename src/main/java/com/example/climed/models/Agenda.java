package com.example.climed.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

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
) {
}
