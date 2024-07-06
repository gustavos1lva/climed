package com.example.climed.models;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "medico")
public final class Medico {
    @Id private Long crm;
    private String nomeMedico;
    private String telefoneMedico;
    private Double percentual;
    @OneToMany(mappedBy = "medico") private Set<Agenda> agendas;

    public Medico(
            Long crm,

            String nomeMedico,
            String telefoneMedico,
            Double percentual,

            Set<Agenda> agendas
    ) {
        this.crm = crm;
        this.nomeMedico = nomeMedico;
        this.telefoneMedico = telefoneMedico;
        this.percentual = percentual;
        this.agendas = agendas;
    }

    public Medico() {
        /* empty on purpose */
    }

    public Long getCrm() {
        return crm;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public String getTelefoneMedico() {
        return telefoneMedico;
    }

    public Double getPercentual() {
        return percentual;
    }

    public Set<Agenda> getAgendas() {
        return agendas;
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
