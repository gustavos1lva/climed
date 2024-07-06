package com.example.climed.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "medico")
@Builder
@Getter
@Setter
public final class Medico {
    @Id private Long crm;
    private String nomeMedico;
    private String telefoneMedico;
    private Double percentual;
    @JsonIgnore @OneToMany(mappedBy = "medico") private Set<Agenda> agendas;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "exerce_esp", joinColumns = @JoinColumn(name = "crm"), inverseJoinColumns = @JoinColumn(name = "id_esp"))
    private Set<Especialidade> especialidades;

    public Medico(final Long crm, final String nomeMedico, final String telefoneMedico, final Double percentual, final Set<Agenda> agendas,
            final Set<Especialidade> especialidades) {
        this.crm = crm;
        this.nomeMedico = nomeMedico;
        this.telefoneMedico = telefoneMedico;
        this.percentual = percentual;
        this.agendas = agendas;
        this.especialidades = especialidades;
    }

    public Medico() {
        /* empty on purpose */
    }

    @Override
    public String toString() {
        return "Medico[" +
                "crm=" + crm + ", " +
                "nomeM=" + nomeMedico + ", " +
                "telefoneM=" + telefoneMedico + ", " +
                "percentual=" + percentual + ", " +
                "agendas=" + agendas + ']';
    }

}
