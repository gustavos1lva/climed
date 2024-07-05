package com.example.climed.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "consulta")
public record Consulta(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long idCon,

        @ManyToOne
        @JoinColumn(name = "crm", referencedColumnName = "crm")
        Medico medico,

        @ManyToOne
        @JoinColumn(name = "idEsp", referencedColumnName = "idEsp")
        Especialidade especialidade,

        @ManyToOne
        @JoinColumn(name = "idPac", referencedColumnName = "idPac")
        Paciente paciente,

        Date data,

        String horaInicCon,

        String horaFimCon,

        Boolean pagou,

        Double valorPago,

        String formaPagamento,

        @OneToOne(mappedBy = "consulta")
        Diagnostico diagnostico
) {
}
