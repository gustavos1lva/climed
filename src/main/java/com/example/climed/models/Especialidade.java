package com.example.climed.models;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "especialidade")
@Builder
@Getter
@Setter
public final class Especialidade {
    //    @Column(name = "id_esp")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long idEsp;
    private String nomeEsp;
    private Integer indice;
    @OneToMany(mappedBy = "especialidade") private Set<Consulta> consultas;
    @ManyToMany(mappedBy = "medico") private Set<Medico> medicos;

    public Especialidade(final Long idEsp, final String nomeEsp, final Integer indice, final Set<Consulta> consultas, final Set<Medico> medicos) {
        this.idEsp = idEsp;
        this.nomeEsp = nomeEsp;
        this.indice = indice;
        this.consultas = consultas;
        this.medicos = medicos;
    }

    public Especialidade() {
        /* empty on purpose */
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(obj == null || obj.getClass() != this.getClass())
            return false;
        var that = (Especialidade)obj;
        return Objects.equals(this.idEsp, that.idEsp) &&
                Objects.equals(this.nomeEsp, that.nomeEsp) &&
                Objects.equals(this.indice, that.indice) &&
                Objects.equals(this.consultas, that.consultas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEsp, nomeEsp, indice, consultas);
    }

    @Override
    public String toString() {
        return "Especialidade[" +
                "idEsp=" + idEsp + ", " +
                "nomeE=" + nomeEsp + ", " +
                "indice=" + indice + ", " +
                "consultas=" + consultas + ']';
    }

}