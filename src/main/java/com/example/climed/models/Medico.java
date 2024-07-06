package com.example.climed.models;

import java.util.Objects;
import java.util.Set;

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
    @OneToMany(mappedBy = "medico") private Set<Agenda> agendas;

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
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(obj == null || obj.getClass() != this.getClass())
            return false;
        var that = (Medico)obj;
        return Objects.equals(this.crm, that.crm) &&
                Objects.equals(this.nomeMedico, that.nomeMedico) &&
                Objects.equals(this.telefoneMedico, that.telefoneMedico) &&
                Objects.equals(this.percentual, that.percentual) &&
                Objects.equals(this.agendas, that.agendas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(crm, nomeMedico, telefoneMedico, percentual, agendas);
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
