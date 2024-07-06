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
public final class Agenda {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long idAgenda;
    private String diaSemana;
    private String horaInicio;
    private String horaFim;
    @ManyToOne @JoinColumn(name = "crm"/*, referencedColumnName = "crm"*/) private Medico medico;

    public Agenda(
            Long idAgenda,

            String diaSemana,
            String horaInicio,
            String horaFim,

            Medico medico
    ) {
        this.idAgenda = idAgenda;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.medico = medico;
    }

    public Agenda() {
        /* empty on purpose */
    }

    public Long getIdAgenda() {
        return idAgenda;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public Medico getMedico() {
        return medico;
    }

    @Override
    public String toString() {
        return "Agenda[" +
                "idAgenda=" + idAgenda + ", " +
                "diaSemana=" + diaSemana + ", " +
                "horaInicio=" + horaInicio + ", " +
                "horaFim=" + horaFim + ", " +
                "medico=" + medico + ']';
    }

}
