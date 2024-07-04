package com.example.climed.Models;

import jakarta.persistence.*;
import java.util.Date;

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
) {}
