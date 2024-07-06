package com.example.climed.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    private String indice;
    @JsonIgnore @OneToMany(mappedBy = "especialidade") private Set<Consulta> consultas;

    @JsonIgnore
    @ManyToMany(mappedBy = "especialidades") private Set<Medico> medicos;

    public Especialidade(final Long idEsp, final String nomeEsp, final String indice, final Set<Consulta> consultas, final Set<Medico> medicos) {
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
    public String toString() {
        return "Especialidade[" +
                "idEsp=" + idEsp + ", " +
                "nomeE=" + nomeEsp + ", " +
                "indice=" + indice + ", " +
                "consultas=" + consultas + ']';
    }

}